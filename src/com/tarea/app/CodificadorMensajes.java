package com.tarea.app;


import com.tarea.app.file.LectorArchivos;

import java.io.IOException;

import java.util.Scanner;

import static com.tarea.app.file.FileUtilities.*;

public class CodificadorMensajes {

    public static void main(String[] args) throws IOException {
        //se pide el nombre del archivo a leer
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo");
        String archivo = sc.nextLine();
        //se verifica si el archivo tiene la extensión txt, si no, se le añade.
        if (!archivo.contains(".")){
            archivo = archivo+".txt";
        }
        //se crea el objeto nuevoArchivo de la clase LectorArchivos para hacer la lectura de la información
        try {
            LectorArchivos nuevoArchivo = new LectorArchivos(archivo);
        //se imprime la codificación en consola
            System.out.println(nuevoArchivo.toString());
        //se le pregunta al usuario si quiere guardar un archivo con la información
            System.out.println("Deseas guardar la información en un archivo? Y/N");
            if(sc.nextLine().toLowerCase().equals("y")){
        //se le pide al usuario el nombre del archivo y se crea el archivo nuevo
                System.out.println("Escribe el nombre del archivo");
                String nombreArchivo = sc.nextLine();
                if (!nombreArchivo.contains(".")){
                    nombreArchivo = nombreArchivo+".txt";
                }
                escribirArchivo(nombreArchivo, nuevoArchivo.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
