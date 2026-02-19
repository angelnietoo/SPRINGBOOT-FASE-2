package com.ejemplos;

import java.util.HashMap;
import java.util.Iterator;

public class EjemploScrabbleConIteratoryHashMapSuperGuay {

    public static int valorLetra(String letra) {

        /*
         * HashMap es una estructura de datos que almacena una dupla de objetos en cada
         * posicion
         * Relacionados entre si
         * El primer objeto de un Hashmap se suele denominar clave, es cómo un indice
         * para acceder al segundo objeto que se denomina valor
         */
        HashMap<String, Integer> valores = new HashMap<>();
        int valorLetra = -1;

        // Para insertar valores en el hashmap usamos put, se insertan al final como una
        // cola
        valores.put("aeionrtlsu", 1);
        valores.put("dg", 2);
        valores.put("bcmp", 3);
        valores.put("fhvwy", 4);
        valores.put("k", 5);
        valores.put("jx", 8);
        valores.put("zq", 10);

        // Para sacar valores utilizamos get, se usa clave
        System.out.println("Valor asociado a la clave bcmp: " + valores.get("bcmp"));

        /*
         * Las estructuras de datos en java, List, Collection, Set, tienen la
         * posibilidad de ser
         * recorridas con un objeto denominado Iterator
         * Una vez usamos la funcion iterator() nos crea un objeto Iterator
         * con los datos listo para recorrer
         */
        Iterator it = valores.keySet().iterator();

        /*
         * Recorremos las claves usando el iterator it, mientras haya un elemento que
         * leer
         * (lo comprobamos con hasNext() leemos el siguiente elemento con la funcion
         * next())
         */
        // Mientras haya un elemento siguiente
        while (it.hasNext()) {
            // Leo en clave la siguiente clave del hashmap
            String clave = (String) it.next();

            // Si la letra esta en la clave
            if (clave.contains(letra))
                // Con get y usando la clave completa consigo el valor de la letra
                valorLetra = valores.get(clave);

        }

        return valorLetra;
    }

    public static void main(String[] args) {

        System.out.println("Valor de la Letra v: " + valorLetra("v"));
    }

}
