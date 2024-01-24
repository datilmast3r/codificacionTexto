/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encriptacion;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Datil
 */
public class Encriptacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {//esto no es el main
        String INPUT = "texto de ejemplo";
        String INPUT2 = "texto de ejemplo con tíldes y ñ y 17521 números";
        encriptar(INPUT);
        System.out.println(desencriptar(encriptar(INPUT)));
    }

    private static final int DESPLAZAMIENTO = 5; // Número de posiciones a desplazar

    public static String encriptar(String texto) {
        StringBuilder textoEncriptado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                if (Character.isUpperCase(caracter)) {
                    textoEncriptado.append((char) ('A' + (caracter - 'A' + DESPLAZAMIENTO) % 26));
                } else {
                    textoEncriptado.append((char) ('a' + (caracter - 'a' + DESPLAZAMIENTO) % 26));
                }
            } else {
                textoEncriptado.append(caracter);
            }
        }
        return textoEncriptado.toString();
    }

    public static String desencriptar(String textoEncriptado) {
        StringBuilder textoDesencriptado = new StringBuilder();
        for (int i = 0; i < textoEncriptado.length(); i++) {
            char caracter = textoEncriptado.charAt(i);
            if (Character.isLetter(caracter)) {
                if (Character.isUpperCase(caracter)) {
                    textoDesencriptado.append((char) ('A' + (caracter - 'A' - DESPLAZAMIENTO + 26) % 26));
                } else {
                    textoDesencriptado.append((char) ('a' + (caracter - 'a' - DESPLAZAMIENTO + 26) % 26));
                }
            } else {
                textoDesencriptado.append(caracter);
            }
        }
        return textoDesencriptado.toString();
    }

}
