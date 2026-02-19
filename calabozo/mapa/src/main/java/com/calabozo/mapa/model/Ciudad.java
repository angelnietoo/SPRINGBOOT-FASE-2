package com.calabozo.mapa.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

/**
 * Clase que representa una Ciudad en nuestro sistema de mazmorras.
 * 
 * @Entity - Indica que esta clase es una entidad JPA que se almacenará en la
 *         base de datos
 * @Data - Anotación de Lombok que genera automáticamente getters, setters,
 *       equals, hashCode y toString
 * 
 *       Esta clase es fundamental en nuestra aplicación ya que representa las
 *       ciudades
 *       donde se encuentran las mazmorras (calabozos) del juego.
 */
@Data
@Entity
public class Ciudad {

    /**
     * Identificador único de la ciudad.
     * 
     * @Id - Marca este campo como la clave primaria de la entidad
     * @GeneratedValue - Indica que el valor se generará automáticamente
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nombre de la ciudad. No puede ser nulo.
     * 
     * @Column(nullable = false) - Asegura que este campo no puede ser NULL en la
     *                  base de datos
     */
    @Column(nullable = false)
    private String nombre;

    /**
     * Número de habitantes de la ciudad
     */
    private int numHabitantes;

    /**
     * País donde se encuentra la ciudad
     */
    private String pais;

    /**
     * Extensión de la ciudad en kilómetros cuadrados
     */
    private double extension;

    /**
     * Fecha en que se fundó la ciudad
     * LocalDate es una clase de Java 8+ para manejar fechas sin tiempo
     */
    private LocalDate fechaFundacion;

    /**
     * Lista de calabozos que se encuentran en esta ciudad
     * 
     * @OneToMany - Establece una relación uno-a-muchos con la entidad Calabozo
     *            mappedBy = "ciudad" - Indica que la relación está mapeada por el
     *            campo ciudad en la clase Calabozo
     *            cascade = CascadeType.ALL - Las operaciones (crear, actualizar,
     *            eliminar) se propagan a los calabozos
     *            orphanRemoval = true - Si se elimina un calabozo de la lista,
     *            también se elimina de la base de datos
     */
    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    List<Calabozo> calabozos = new ArrayList<Calabozo>();

}
