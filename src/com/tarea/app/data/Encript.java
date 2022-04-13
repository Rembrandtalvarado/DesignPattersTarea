package com.tarea.app.data;

//se utiliza el patrón template para crear las clases de encriptación
public abstract class Encript {
    public String cadena;

    public Encript(String cadena){
        this.cadena = cadena;

    }

    public abstract String encriptar();
}
