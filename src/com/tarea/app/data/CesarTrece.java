package com.tarea.app.data;

//Extiende la clase abstracta Encript
public class CesarTrece extends Encript{
    //en este caso particular se usa la codificación cesar de 13 posiciones, pero se puede modificar para que sea tantos como el usuario quiera.
    public int codigo = 13;

    public CesarTrece(String cadena) {
        super(cadena);
    }

    //codifica el string de tal forma que se el caracter se reemplaza por el caracter que está 13 posiciones adelante del seleccionado.
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
