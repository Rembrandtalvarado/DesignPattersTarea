package com.tarea.app.file;

import java.io.IOException;
import java.util.Locale;

import static com.tarea.app.file.FileUtilities.escribirArchivo;
import static com.tarea.app.file.csv.CSVtoTXT.readCSV;

// NON FUNCTIONAL
// NON FUNCTIONAL
// NON FUNCTIONAL
// NON FUNCTIONAL
// NON FUNCTIONAL
public class Adapter {
    public static String adapterCSV(String filename) throws IOException {
        String[] separado = filename.split("[.]");
        String extension = separado[1];
        switch (extension) {
            case "csv":
                String plainText = readCSV(filename).replace(",","-");

                return "salida.txt";
        }
        return filename;
    }


}
