package com.ejemplos;

import java.util.List;
import java.util.stream.Collectors;

public class ScapeRoom extends Juego {

    int tiempoMaxTotal;
    int intentosTotales;
    List<Puzzle> listaPuzles;

    /**
     * Recorre todos los puzles y comprueba que no se haya
     * pasado de tiempo ni de intentos y esten todos resueltos
     * 
     * @return true si esta resuelto y false en caso contrario
     */
    public boolean comprobarSolucion() {

        /*
         * for (int i=0;i<listaPuzles.size();i++)
         * {
         * listaPuzles.get(i).
         * }
         */
        boolean resuelto = false;
        int sumaTiempos = 0;

        for (Puzzle puzzle : listaPuzles) {

            // Comprobamos que todos los puzles estan resueltos
            // Con que uno de los puzzles no este resuelto ya
            // el scaperoom no lo esta
            // Si se ha pasado de intentos tampoco
            if (!puzzle.isResuelto() || puzzle.getIntentos() < 0)
                return false;

            // Vamos sumando todos los tiempos
            sumaTiempos = sumaTiempos + puzzle.getTiempoTardado();

        }

        /*
         * Una vez fuera del bucle, con la suma de todos los tiempos de los puzzles
         * calculada
         * comprobamos si se ha pasado comparandolo con el tiempo maximo que hay para
         * resolver el scaperoom
         */
        if (sumaTiempos > this.tiempoMaxTotal)
            return false;

        // Si llega aquí es que se ha resuelto
        return true;

    }

    public boolean comprobarSolucionStream() {
        // Podemos utilizando las funciones de stream comprobar facilmente Si estan
        // resueltos
        boolean todosResueltos = listaPuzles.stream().allMatch(p -> p.isResuelto() && p.getIntentos() >= 0);

        boolean NoResuelto = listaPuzles.stream().anyMatch(p -> !p.isResuelto() || p.getIntentos() < 0);

    }

}
