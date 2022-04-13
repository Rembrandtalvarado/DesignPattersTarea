package com.tarea.app.file;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtilities {

    public static void crearArchivo(String fileName){
        File newFile = new File(fileName);
        try {
            if(!newFile.createNewFile()){
                System.out.println("El archivo ya existe");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //se utiliza para crear un archivo y escribir en el.
    public static void escribirArchivo(String fileName, String data) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(data);
            writer.close();
            System.out.println("Se creó el archivo " + fileName + " correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }
}
