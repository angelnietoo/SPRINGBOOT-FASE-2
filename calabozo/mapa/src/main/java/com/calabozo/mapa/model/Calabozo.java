package com.calabozo.mapa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Representa un calabozo en el juego.
 * Cada calabozo tiene un ID, nombre, dificultad y está asociado a una ciudad.
 */
@Entity
@Data
@Table(name = "calabozo")
public class Calabozo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Nombre del calabozo. */
    private String name;

    /** Dificultad del calabozo. */
    private int dificulty;

    /** La ciudad a la que pertenece este calabozo. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_ciudad", nullable = false) // Columna de clave foránea
    @JsonBackReference
    private Ciudad ciudad;
}
