package com.calabozo.mapa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

/**
 * Representa el inventario de un personaje en el juego.
 * Contiene la capacidad, apariencia y una lista de ítems.
 */
@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Capacidad máxima del inventario. */
    private int capacidad;
    /** Apariencia o descripción visual del inventario. */
    private String apariencia;

    /** El personaje al que pertenece este inventario. */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "personaje_id", referencedColumnName = "id")
    private Personaje personaje;

    /** Lista de ítems en el inventario. */
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "inventario_item", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "inventario_id"), // Clave foránea de esta entidad
            inverseJoinColumns = @JoinColumn(name = "item_id") // Clave foránea de la otra entidad
    )
    List<Item> items = new ArrayList<Item>();
}