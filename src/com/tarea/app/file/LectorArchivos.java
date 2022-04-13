package com.tarea.app.file;

import com.tarea.app.data.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


//se utiliza el patrón builder para el lector de archivos.

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
    //Lee toda la información del archivo y retorna un string con todo el texto
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
            System.out.println(sb.toString());
            return sb.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    //separa el string en los casos a encriptar
    private ArrayList<String[]> separar(){
        String[] textoSeparado = plainText.split(System.lineSeparator());
        ArrayList<String[]> casosEncriptar = new ArrayList<String[]>();
        for (String s : textoSeparado) {
            casosEncriptar.add(s.split("-"));
        }
        return casosEncriptar;
    }
    //encripta las strings de acuerdo a la codificación deseada
    private ArrayList<String> encriptar(){
        ArrayList<String> encriptados = new ArrayList<String>();
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

    //getters
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

    //setters
    public void setPlainText(String plainText) {
        this.plainText = plainText;
        setEncriptados();
        setEncryptCases();

    }

    private void setEncriptados() {
        this.encriptados = encriptar();
    }

    private void setEncryptCases() {
        this.encryptCases = separar();
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

