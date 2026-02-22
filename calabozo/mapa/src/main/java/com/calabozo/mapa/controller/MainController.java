package com.calabozo.mapa.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.calabozo.mapa.model.User;
import com.calabozo.mapa.repository.UserRepository;

@Controller
public class MainController {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        logger.info("Cargando la web principal");
        System.out.println("Entra en la ruta principal");
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        logger.info("Mostrando página de login");
        return "login";
    }

    /**
     * Dashboard SIN OAuth:
     * - Principal.getName() devuelve el usuario autenticado (username).
     * - Si tu username es un email, puedes buscar el usuario en BD por email.
     */
    @GetMapping("/dashboard")
    public String dashboard(Principal principal, Model model) {
        if (principal != null) {
            String username = principal.getName(); // normalmente el "username"
            User user = userRepository.findByEmail(username).orElse(null);

            model.addAttribute("username", username);
            model.addAttribute("user", user);
        }
        return "dashboard";
    }

    /**
     * Profile SIN OAuth:
     * - Muestra nombre + roles (authorities)
     */
    @GetMapping("/profile")
    public String profile(Authentication authentication, Model model) {
        if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("roles", authentication.getAuthorities());
        }
        return "profile";
    }

    @GetMapping("/error")
    public String error(Model model, @RequestParam(required = false) String message) {
        logger.error("Error page accessed: {}", message);
        model.addAttribute("errorMessage", message);
        return "error";
    }
}