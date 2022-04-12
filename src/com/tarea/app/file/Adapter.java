package com.tarea.app.file;

import java.io.IOException;

import static com.tarea.app.file.csv.CSVtoTXT.convert;

public class Adapter {
    public static String adapterCSV(String filename) throws IOException {
        String[] separado = filename.split("[.]");
        String extension = separado[1];
        switch (extension) {
            case "csv":
                convert(filename);
                return "salida.txt";
        }
        return filename;
    }


}
