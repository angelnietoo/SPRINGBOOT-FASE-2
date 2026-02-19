package com.calabozo.mapa.model;

/**
 * Enumeración que representa los diferentes proveedores de autenticación.
 */
public enum AuthProvider {
    /** Autenticación local mediante usuario y contraseña. */
    LOCAL,
    /** Autenticación a través de Google. */
    GOOGLE,
    /** Autenticación a través de Facebook. */
    FACEBOOK,
    /** Autenticación a través de GitHub. */
    GITHUB
}
