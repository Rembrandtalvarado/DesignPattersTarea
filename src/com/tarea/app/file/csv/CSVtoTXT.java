package com.tarea.app.file.csv;

import java.io.*;

// NON FUNCTIONAL
// NON FUNCTIONAL
// NON FUNCTIONAL
// NON FUNCTIONAL
// NON FUNCTIONAL
public class CSVtoTXT {
    public static String readCSV(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            System.out.println(sb.toString());
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
