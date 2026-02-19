package com.ejemplos;

public class Puzzle {

    private int dificultad;
    private String instrucciones;
    private boolean resuelto;
    private String solucion;
    private int tiempoTardado;
    private int intentos;

    public Puzzle() {

    }

    public Puzzle(int dificultad, String instrucciones, boolean resuelto, String solucion, int intentos,
            int tiempoTardado) {
        this.dificultad = dificultad;
        this.instrucciones = instrucciones;
        this.resuelto = resuelto;
        this.solucion = solucion;
        this.intentos = intentos;
        this.tiempoTardado = tiempoTardado;
    }

    @Override
    public String toString() {
        return "Puzzles [dificultad=" + dificultad + ", instrucciones=" + instrucciones + ", resuelto=" + resuelto
                + ", solucion=" + solucion + "]";
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public String getInstrucciones() {
        return instrucciones;
    }

    public void setInstrucciones(String instrucciones) {
        this.instrucciones = instrucciones;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    public void setResuelto(boolean resuelto) {
        this.resuelto = resuelto;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public int getTiempoTardado() {
        return tiempoTardado;
    }

    public void setTiempoTardado(int tiempoTardado) {
        this.tiempoTardado = tiempoTardado;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public boolean intentoSolucion(String solucion, int tiempo) {

        boolean solucionado = this.solucion.equalsIgnoreCase(solucion);

        // Si falla al intentar solucionarlo le quitamos un intento
        if (!solucionado)
            this.intentos--;
        else
            this.tiempoTardado = tiempo;

        return solucionado;
    }

}
