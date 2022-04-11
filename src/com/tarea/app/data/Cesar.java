package com.tarea.app.data;

public class Cesar extends Encript{
    public int codigo;

    public Cesar(String cadena, int codigo) {
        super(cadena);
        this.codigo = codigo;
    }

    public String encriptar() {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < this.cadena.length(); i++) {
            if (cadena.charAt(i) == ' ' || cadena.charAt(i) == ',' || cadena.charAt(i) == '.' || cadena.charAt(i) == ';' || cadena.charAt(i) == ':'){
                cifrado.append(cadena.charAt(i));
            } else if (cadena.charAt(i) >= 'a' && cadena.charAt(i) <= 'z') {
                if ((cadena.charAt(i) - codigo) < 'a') {
                    cifrado.append((char) (cadena.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (cadena.charAt(i) - codigo));
                }
            } else if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z') {
                if ((cadena.charAt(i) - codigo) < 'A') {
                    cifrado.append((char) (cadena.charAt(i) - codigo + 26));
                } else {
                    cifrado.append((char) (cadena.charAt(i) - codigo));
                }
            }
        }
        return cifrado.toString();
    }


}
