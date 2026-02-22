package com.calabozo.mapa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuración de seguridad de la aplicación Spring Boot.
 *
 * OAuth2 ELIMINADO.
 * - Se mantienen rutas públicas.
 * - El resto requiere autenticación con login normal (formLogin).
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF: si tienes endpoints /api/**, se ignora CSRF solo ahí
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/api/**")
            )

            // Autorización de rutas
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(
                    "/api/ciudades/**",
                    "/ciudades/**",
                    "/",
                    "/login",
                    "/error",
                    "/webjars/**",
                    "/css/**",
                    "/js/**"
                ).permitAll()
                .anyRequest().authenticated()
            )

            // Login normal (sin OAuth)
            .formLogin(form -> form
                .loginPage("/login")   // si tienes una vista /login personalizada
                .permitAll()
            )

            // Logout
            .logout(logout -> logout
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }
}