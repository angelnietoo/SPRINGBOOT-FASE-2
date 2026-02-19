package com.calabozo.mapa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un usuario en el sistema.
 * Contiene información como ID, email, nombre, imagen, Google ID, proveedor de
 * autenticación,
 * y fechas de creación y actualización.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Email único del usuario. */
    @Column(unique = true, nullable = false)
    private String email;

    /** Nombre del usuario. */
    @Column(nullable = false, unique = false)
    private String name;

    /** URL de la imagen de perfil del usuario. */
    private String picture;

    /** ID de Google si el usuario se autenticó con Google. */
    @Column(unique = true)
    private String googleId;

    /** Proveedor de autenticación del usuario (LOCAL, GOOGLE, FACEBOOK, GITHUB). */
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    /** Fecha y hora de creación del registro del usuario. */
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;

    /** Fecha y hora de la última actualización del registro del usuario. */
    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    /**
     * Método que se ejecuta antes de persistir la entidad para establecer las
     * fechas de creación y actualización.
     */
    @PrePersist
    protected void onCreate() {
        createdAt = java.time.LocalDateTime.now();
        updatedAt = java.time.LocalDateTime.now();
    }

    /**
     * Método que se ejecuta antes de actualizar la entidad para establecer la fecha
     * de última actualización.
     */
    @PreUpdate
    protected void onUpdate() {
        updatedAt = java.time.LocalDateTime.now();
    }

    /**
     * Establece el proveedor de autenticación del usuario.
     * 
     * @param google El proveedor de autenticación.
     */
    public void setProvider(com.calabozo.mapa.model.AuthProvider google) {
        // TODO Auto-generated method stub
        this.provider = google;
    }

}
