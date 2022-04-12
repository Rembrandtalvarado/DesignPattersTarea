package com.tarea.app.file;

import com.tarea.app.data.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorArchivos {
    public String fileName;
    private String plainText;
    private ArrayList<String[]> encryptCases;
    private ArrayList<String> encriptados;

    public LectorArchivos(String f) throws IOException {
        fileName = f;
        plainText = leer();
        encryptCases = separar();
        encriptados = encriptar();

    }

    private String leer() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null){
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();

            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<String[]> separar(){
        String[] textoSeparado = plainText.split(System.lineSeparator());
        ArrayList<String[]> casosEncriptar = new ArrayList<String[]>();
        for (String s : textoSeparado) {
            casosEncriptar.add(s.split("-"));
        }
        return casosEncriptar;
    }

    private ArrayList<String> encriptar(){
        ArrayList<String> encriptados = new ArrayList<>();
        for (String[] s : encryptCases) {
            if (s[0].toUpperCase().equals("CESAR")){
                Encript cesar = new CesarTrece(s[1]);
                encriptados.add(cesar.encriptar());
            }
            if (s[0].toUpperCase().equals("VOCALES")){
                Encript vocales = new OrdenVocales(s[1]);
                encriptados.add(vocales.encriptar());
            }
        }
        return encriptados;
    }


    public String getFileName() {
        return fileName;
    }

    public ArrayList<String> getEncriptados() {
        return encriptados;
    }

    public String getPlainText() {
        return plainText;
    }

    public ArrayList<String[]> getEncryptCases() {
        return encryptCases;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<encryptCases.size(); i++) {
            sb.append(encryptCases.get(i)[1]);
            sb.append(" - ");
            sb.append(encriptados.get(i));
            sb.append(System.lineSeparator());

        }
        return sb.toString();
    }

}
