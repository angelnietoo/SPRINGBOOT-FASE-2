package com.calabozo.mapa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

/**
 * Representa un ítem que puede ser recolectado y almacenado en el inventario de
 * un personaje.
 * Cada ítem tiene un ID, nombre, peso y tipo.
 */
@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Nombre del ítem. */
    private String name;

    /** Peso del ítem, afecta la capacidad del inventario. */
    private int weight;

    /** Tipo de ítem (e.g., arma, armadura, poción). */
    private String type;

    /** Lista de inventarios que contienen este ítem. */
    @ManyToMany(mappedBy = "items")
    private List<Inventario> inventarios = new ArrayList<Inventario>();

}
