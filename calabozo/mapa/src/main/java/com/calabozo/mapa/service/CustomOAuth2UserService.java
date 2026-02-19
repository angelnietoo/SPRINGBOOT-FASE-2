package com.calabozo.mapa.service;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.calabozo.mapa.model.AuthProvider;
import com.calabozo.mapa.model.User;
import com.calabozo.mapa.repository.UserRepository;

/**
 * Servicio personalizado para manejar la autenticación OAuth2 con Google.
 * 
 * @Service - Indica que esta clase es un servicio de Spring
 * 
 *          Esta clase extiende DefaultOAuth2UserService para personalizar el
 *          proceso de
 *          carga de usuarios cuando se autentican a través de Google.
 * 
 *          Funcionalidades principales:
 *          - Carga de información del usuario desde Google
 *          - Procesamiento y validación de datos del usuario
 *          - Creación o actualización de usuarios en nuestra base de datos
 */
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    /**
     * Logger para registrar eventos del proceso de autenticación
     */
    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    /**
     * Repositorio para gestionar los usuarios en nuestra base de datos
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Sobrescribe el método de carga de usuarios de OAuth2
     * 
     * @param userRequest Contiene información sobre la solicitud de autenticación
     * @return OAuth2User Usuario autenticado con sus atributos
     * @throws OAuth2AuthenticationException Si hay errores en la autenticación
     * 
     *                                       Este método:
     *                                       1. Recibe la solicitud de autenticación
     *                                       de Google
     *                                       2. Carga los datos del usuario usando
     *                                       el servicio por defecto
     *                                       3. Procesa los datos para nuestra
     *                                       aplicación
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // Registra el proveedor de autenticación que se está utilizando (Google)
        logger.info("Loading user for provider: {}", userRequest.getClientRegistration().getRegistrationId());

        try {
            // Carga el usuario usando el servicio OAuth2 por defecto
            OAuth2User oauth2User = super.loadUser(userRequest);
            logger.info("Successfully loaded user attributes: {}", oauth2User.getAttributes().keySet());
            return processOAuth2User(userRequest, oauth2User);
        } catch (Exception e) {
            logger.error("Error loading OAuth2 user", e);
            throw new OAuth2AuthenticationException("Error loading OAuth2 user");
        }
    }

    /**
     * Procesa los datos del usuario recibidos de Google
     * 
     * @param userRequest Solicitud original de OAuth2
     * @param oauth2User  Usuario cargado desde Google
     * @return OAuth2User Usuario procesado
     * 
     *         Este método:
     *         1. Extrae los atributos del usuario de Google
     *         2. Obtiene información importante como ID, email y nombre
     *         3. Crea o actualiza el usuario en nuestra base de datos
     */
    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oauth2User) {
        // Obtiene todos los atributos del usuario de Google
        Map<String, Object> attributes = oauth2User.getAttributes();

        // Registra los atributos recibidos para depuración
        logger.info("All OAuth2 attributes: {}", attributes);

        // Extrae la información relevante del usuario
        String googleId = (String) attributes.get("sub"); // ID único de Google
        String email = (String) attributes.get("email"); // Email del usuario
        String name = (String) attributes.get("name"); // Nombre completo
        String picture = (String) attributes.get("picture");

        // Validaciones
        if (email == null) {
            throw new OAuth2AuthenticationException("Email not found from OAuth2 provider");
        }

        if (googleId == null) {
            throw new OAuth2AuthenticationException("Google ID (sub) not found from OAuth2 provider");
        }

        Optional<User> userOptional = userRepository.findByGoogleId(googleId);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();
            user.setName(name);
            user.setPicture(picture);
            logger.info("Updating existing user: {}", email);
        } else {
            Optional<User> existingUserByEmail = userRepository.findByEmail(email);

            if (existingUserByEmail.isPresent()) {
                user = existingUserByEmail.get();
                user.setGoogleId(googleId);
                user.setProvider(AuthProvider.GOOGLE);
                user.setPicture(picture);
                logger.info("Linking existing email to Google: {}", email);
            } else {
                user = new User();
                user.setEmail(email);
                user.setName(name);
                user.setGoogleId(googleId);
                user.setPicture(picture);
                user.setProvider(AuthProvider.GOOGLE);
                logger.info("Creating new user: {}", email);
            }
        }

        userRepository.save(user);
        logger.info("User saved successfully: {}", email);

        return new DefaultOAuth2User(
                oauth2User.getAuthorities(),
                attributes,
                "sub"); // name attribute key
    }
}