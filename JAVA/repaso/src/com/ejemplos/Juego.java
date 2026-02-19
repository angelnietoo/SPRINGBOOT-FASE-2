package com.ejemplos;

public class Juego {

    private String nombre;
    private int edadRecomendada;
    private int duracion = 0;
    private float precio = 0;

    public Juego() {
        this.nombre = "";
        this.edadRecomendada = 0;
        this.duracion = 0;
        this.precio = 0;
    }

    /**
     * Constructor que recibe todos los valores de las variables miembro de esta
     * clase
     * Y se las asigna
     * 
     * @param nombre          El nombre del juego
     * @param edadRecomendada
     * @param duracion
     * @param precio
     */
    public Juego(String nombre, int edadRecomendada, int duracion, float precio) {

        if (nombre.length() < 511 && !nombre.startsWith("!"))
            this.nombre = nombre;

        this.edadRecomendada = edadRecomendada;
        this.duracion = duracion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * 
     */

    @Override
    public String toString() {
        return "Juego [nombre=" + nombre + ", edadRecomendada=" + edadRecomendada + ", duracion=" + duracion
                + ", precio=" + precio + "]";
    }

}
