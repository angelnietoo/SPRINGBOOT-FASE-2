package com.ejemplos;

public class Condicionales {
    public static void main(String[] args) throws Exception {

        int edad = 18;
        String marca = "Peugeout";
        float potencia = 135.4f;

        // Solo podrá conducir si es mayor de edad y
        // el coche es de menos de 140cv de potencia
        if (edad >= 18 || marca.equalsIgnoreCase("peugeout") && potencia < 140) {
            System.out.println("Enhorabuena conduces un " + marca);
        } else
            System.out.println("No tienes permiso para conducir");

        int dia = 3;

        switch (dia) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
                break;
            default:
                System.out.println("Fiestaaaa");
        }

    }
}
