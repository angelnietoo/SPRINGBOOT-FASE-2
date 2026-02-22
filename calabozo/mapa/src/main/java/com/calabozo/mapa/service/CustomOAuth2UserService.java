package com.calabozo.mapa.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calabozo.mapa.model.User;
import com.calabozo.mapa.repository.UserRepository;

/**
 * Servicio normal para gestionar usuarios (sin OAuth).
 * 
 * Aquí puedes centralizar lógica de usuarios:
 * - buscar por email
 * - crear / actualizar usuario en BD
 */
@Service
public class CustomOAuth2UserService {

    private static final Logger logger = LoggerFactory.getLogger(CustomOAuth2UserService.class);

    @Autowired
    private UserRepository userRepository;

    /**
     * Buscar usuario por email
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Crear o actualizar usuario local (sin Google/OAuth)
     */
    public User saveOrUpdate(String email, String name, String picture) {
        User user = userRepository.findByEmail(email).orElseGet(User::new);

        user.setEmail(email);

        // Si no quieres guardar name/picture, puedes borrar estas 2 líneas
        user.setName(name);
        user.setPicture(picture);

        userRepository.save(user);
        logger.info("Usuario guardado/actualizado: {}", email);

        return user;
    }
}