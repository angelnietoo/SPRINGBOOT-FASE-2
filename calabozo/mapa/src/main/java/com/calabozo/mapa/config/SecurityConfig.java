package com.calabozo.mapa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.calabozo.mapa.service.CustomOAuth2UserService;

/**
 * Configuración de seguridad de la aplicación Spring Boot.
 * 
 * @Configuration - Indica que esta clase contiene configuraciones de Spring
 * @EnableWebSecurity - Habilita la seguridad web de Spring Security
 * 
 *                    Esta clase es fundamental para la seguridad de la
 *                    aplicación, configurando:
 *                    - Autenticación OAuth2 con Google
 *                    - Protección CSRF
 *                    - Rutas públicas y privadas
 *                    - Gestión de login y logout
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

        /**
         * Servicio personalizado para gestionar usuarios OAuth2
         */
        @Autowired
        private CustomOAuth2UserService customOAuth2UserService;

        /**
         * Manejador de éxito de autenticación OAuth2
         */
        @Autowired
        private AuthenticationSuccessHandler oAuth2LoginSuccessHandler;

        /**
         * Configura la cadena de filtros de seguridad de la aplicación.
         * 
         * @param http Objeto HttpSecurity para configurar la seguridad
         * @return SecurityFilterChain configurada
         * @throws Exception si hay errores en la configuración
         * 
         *                   Este método configura:
         *                   1. CSRF (Cross-Site Request Forgery) - Deshabilitado para
         *                   API
         *                   2. Rutas públicas y privadas
         *                   3. Configuración de OAuth2 con Google
         *                   4. Configuración de logout
         */
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http
                                // Configuración CSRF
                                .csrf(csrf -> csrf
                                                .ignoringRequestMatchers("/api/**") // Deshabilita CSRF solo para
                                                                                    // endpoints API
                                )
                                // Configuración de autorización de rutas
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers("/api/ciudades/**", "/ciudades/**", "/", "/login",
                                                                "/error",
                                                                "/webjars/**", "/css/**", "/js/**")
                                                .permitAll() // Rutas públicas
                                                .anyRequest().authenticated()) // Resto de rutas requieren autenticación
                                // Configuración de OAuth2
                                .oauth2Login(oauth2 -> oauth2
                                                .loginPage("/login") // Página de login personalizada
                                                .userInfoEndpoint(userInfo -> userInfo
                                                                .userService(customOAuth2UserService))
                                                .successHandler(oAuth2LoginSuccessHandler)
                                                .failureUrl("/error"))
                                // Configuración de logout
                                .logout(logout -> logout
                                                .logoutSuccessUrl("/") // Redirección tras logout
                                                .permitAll());

                return http.build();
        }
}