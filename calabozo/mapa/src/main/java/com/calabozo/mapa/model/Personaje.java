package com.calabozo.mapa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 * Representa un personaje en el juego.
 * Cada personaje tiene un ID, nombre, nivel, puntos de vida (HP), raza y un
 * inventario.
 */
@Entity
@Data
public class Personaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Nombre del personaje. */
    private String name;
    /** Nivel del personaje. */
    private int level;
    /** Puntos de vida (HP) del personaje. */
    private int hp;
    /** Raza del personaje. */
    private String race;

    /** El inventario asociado a este personaje. */
    @OneToOne(mappedBy = "personaje")
    private Inventario inventario;

}
