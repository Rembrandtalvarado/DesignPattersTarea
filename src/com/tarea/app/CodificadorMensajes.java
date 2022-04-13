package com.tarea.app;


import com.tarea.app.file.LectorArchivos;

import java.io.IOException;

import java.util.Scanner;

import static com.tarea.app.file.FileUtilities.*;

public class CodificadorMensajes {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo");
        String archivo = sc.nextLine();
        if (!archivo.contains(".")){
            archivo = archivo+".txt";
        }
        try {
            LectorArchivos nuevoArchivo = new LectorArchivos(archivo);
            System.out.println(nuevoArchivo.toString());
            System.out.println("Deseas guardar la información en un archivo? Y/N");
            if(sc.nextLine().toLowerCase().equals("y")){
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
