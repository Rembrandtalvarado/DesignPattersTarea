package com.tarea.app;

import com.tarea.app.data.Cesar;
import com.tarea.app.data.Encript;
import com.tarea.app.data.ordenVocales;

import java.io.IOException;
import java.util.Scanner;

import static com.tarea.app.file.FileUtilities.*;

public class CodificadorMensajes {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Se crean las variables que se utilizarán.
        String texto, salida = null;
        int codigo;
        char opcion;
        char archivo;
        String nombreArchivo;
        String inputSalida;

        //Se pide el texto a encriptar al usuario.
        do {
            System.out.println("Escribe un texto ");
            texto = sc.nextLine();
        } while (texto.isEmpty());

        //se pide el tipo de encriptación
        do {
            System.out.println("Elige el tipo de encriptación\n'C': Cifrado César\n'V': invertir vocales ");
            opcion = (char) System.in.read();
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'V');

        //se encripta el texto según el código césar
        if(Character.toUpperCase(opcion) == 'C'){
            System.out.println("Escribe el valor del desplazamiento: ");
            codigo = sc.nextInt();
            Encript textoEncriptado = new Cesar(texto, codigo);
            salida = textoEncriptado.encriptar();
            System.out.println(salida);

        //Se encripta el texto cambiando el orden de las vocales
        } else if(Character.toUpperCase(opcion) == 'V'){
            Encript textoEncriptado = new ordenVocales(texto);
            salida = textoEncriptado.encriptar();
            System.out.println(salida);
        }
        inputSalida = texto + " : " + salida;

        //se pide al usuario si quiere guardar un archivo con la información
        do {
            System.out.println("Quieres guardar un archivo con tu encriptación? Y/N: ");
            archivo = (char) System.in.read();
        } while (Character.toUpperCase(archivo) != 'Y' && Character.toUpperCase(archivo) != 'N');
        if(Character.toUpperCase(archivo) == 'Y') {
            do {
                System.out.println("Escribe el nombre del archivo que quieres crear: ");
                nombreArchivo = sc.nextLine();
            }while (nombreArchivo.isEmpty());
            crearArchivo(nombreArchivo+".txt");
            escribirArchivo(nombreArchivo+".txt", inputSalida);

        } else {
            System.out.println(inputSalida);
        }
    }

}
