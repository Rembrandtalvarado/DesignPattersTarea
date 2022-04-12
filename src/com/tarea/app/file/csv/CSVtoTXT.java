package com.tarea.app.file.csv;

import java.io.*;

public class CSVtoTXT {
    public static void convert(String filename) throws IOException {
        // Use File
        File file = new File(filename);
        // Use FileReader to red CSV file
        FileReader fr = new FileReader(file);
        // User BufferReader
        BufferedReader br = new BufferedReader(fr);
        String line;

        String[] tempArr;
        // User FileWriter to write content to text file
        FileWriter writer = new FileWriter("salida.txt");
        // Use while loop to check when file contains data
        while ((line = br.readLine()) != null) {
            tempArr = line.split(",");
            // User for loop to iterate String Array and write data to text file
                writer.write(tempArr[0]+'-'+tempArr[1]);

            // Write each line of CSV file to multiple lines
            writer.write("\n");
        }
        writer.close();
    }
}
