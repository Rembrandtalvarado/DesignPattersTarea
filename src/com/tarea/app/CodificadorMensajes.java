package com.tarea.app;

// TODO: 11/04/2022 corregir el csv to txt y añadir la creación del archivo nuevo. 
import com.tarea.app.file.LectorArchivos;

import java.io.IOException;
import java.util.Scanner;

import static com.tarea.app.file.Adapter.adapterCSV;
import static com.tarea.app.file.FileUtilities.*;

public class CodificadorMensajes {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del archivo");
        String archivo = sc.nextLine();
        archivo = adapterCSV(archivo);
        try {
            LectorArchivos nuevoArchivo = new LectorArchivos(archivo);
            System.out.println(nuevoArchivo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
