package com.tarea.app.data;

public class ordenVocales extends Encript{

    public ordenVocales(String cadena) {
        super(cadena);
    }


    public static boolean isVowel(char c)
    {
        if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U')
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String encriptar() {
        StringBuilder vocalInvertida = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            if(!isVowel(cadena.charAt(i)) || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'I'){
                vocalInvertida.append(cadena.charAt(i));
            } else if (cadena.charAt(i) == 'a'){
                vocalInvertida.append('u');
            } else if (cadena.charAt(i) == 'e'){
                vocalInvertida.append('o');
            } else if (cadena.charAt(i) == 'o'){
                vocalInvertida.append('e');
            } else if (cadena.charAt(i) == 'u') {
                vocalInvertida.append('a');
            } else if (cadena.charAt(i) == 'A'){
                vocalInvertida.append('U');
            } else if (cadena.charAt(i) == 'E'){
                vocalInvertida.append('O');
            } else if (cadena.charAt(i) == 'O'){
                vocalInvertida.append('E');
            } else if (cadena.charAt(i) == 'U') {
                vocalInvertida.append('A');
            }
        }
        return vocalInvertida.toString();
    }
}

