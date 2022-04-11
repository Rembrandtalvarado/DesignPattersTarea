package com.tarea.app.data;

public abstract class Encript {
    public String cadena;

    public Encript(String cadena){
        this.cadena = cadena;

    }

    public abstract String encriptar();
}
