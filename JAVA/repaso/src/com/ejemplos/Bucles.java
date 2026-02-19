package com.ejemplos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bucles {
    public static void main(String[] args) {
        

        //Bucle que lee x palabras y muestra solo las que tengan mas 
        //de 6 letras y empiecen o acaben por a, acaba cuando lee todas las palabras o lea fin
        Scanner teclado = new Scanner(System.in);
        int numPal=0;
        String palabra="";
        
        System.out.print("Numero de palabras a leer:");
        numPal = teclado.nextInt();

        //Leemos el enter extra
        teclado.nextLine();

        System.out.println("Palabra 1:");
        palabra= teclado.nextLine();
        int i=2;

        //El bucle acaba cuando no quedan palabras por leer o la palabra es fin
        while (numPal!=0 && !palabra.equalsIgnoreCase("fin"))
        {
            //Si tiene mas de 6 letras y empieza o acaba por a la mostramos
            //Para divertirnos usamos charat para el primer caracter
            //y endswith para el último 
            if (palabra.length() >=6 && (palabra.toUpperCase().charAt(0)=='A' ||  
            palabra.toUpperCase().endsWith("A"))) 
            {
                System.out.println(palabra);
            }

            //leemos la siguiente palabra
            System.out.println("Palabra " + i +":");
            palabra= teclado.nextLine();
            i++;
            numPal--;

        }

        teclado.close();

        //Ahora con un bucle for recorremos un arraylist de String
        //y mostramos las que contengan la letra p y tengan alguna 
        //letra en posicion simetrica 
        List<String> listaPalabras = new ArrayList<String>();

        listaPalabras.add("pepito");
        listaPalabras.add("aseso");
        listaPalabras.add("perrit");
        listaPalabras.add("peñato");
        listaPalabras.add("apalabrado");

        //Recorremos con un bucle for todos los elementos
        for(int j=0;j<listaPalabras.size();j++)
        {
            //Guardo la palabra en la posicion j del arrayList
            palabra = listaPalabras.get(j);

            //Primero comprobamos si contiene una p
            if (palabra.toLowerCase().contains("p"))
            {
                //Vamos a comprobar si tiene letras simetricas
                boolean letraSimetrica=false;
                int mitad= palabra.length()/2;
                //Recorremos la primera mitad de los caracteres
                //de la palabra y los comparamos si son iguales
                //que los caracteres en su posicion simetrica
                for (int z=0;z<mitad;z++)
                {
                    //Comprobamos si la letra en la posicion z actual
                    //tiene una simetrica igual
                    if (palabra.charAt(z)==palabra.charAt(palabra.length()-(z+1)))
                    {
                        System.out.println(palabra);
                        break;
                    }
                }

            }

         



        }


    }
}
