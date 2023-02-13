package buscaminas;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static int[] tablero = new int[20];
    static boolean[] descubiertas = new boolean[20];
    static boolean perdido = false;

    public static void main(String[] args) {
        inicializarTablero();
        while (!perdido && !todasDescubiertas()) {
            mostrarTablero();
            System.out.println("Qué posición del buscaminas deseas revelar (del 0 al 20):");
            Scanner lectura = new Scanner(System.in);
            int pos = lectura.nextInt();
            descubrirCasilla(pos);
        }
        if (perdido) {
            System.out.println("Has perdido :(");
        } else {
            System.out.println("¡Has ganado!");
        }
    }

    static void inicializarTablero() {
        int minasColocadas = 0;
        while (minasColocadas < 6) {
            int pos = (int) (Math.random() * 20);
            if (tablero[pos] != -1) {
                tablero[pos] = -1;
                minasColocadas++;
                actualizarPistas(pos);
            }
        }
    }

    static void actualizarPistas(int pos) {
        int[] vecinos = {-1, 1, -2, 2, -3, 3, -4, 4};
        for (int i = 0; i < vecinos.length; i++) {
            int vecino = pos + vecinos[i];
            if (vecino >= 0 && vecino < 20 && tablero[vecino] != -1) {
                tablero[vecino]++;
            }
        }
    }

    static void descubrirCasilla(int pos) {
        descubiertas[pos] = true;
        if (tablero[pos] == -1) {
            perdido = true;
        }
    }

    static boolean todasDescubiertas() {
        for (int i = 0; i < 20; i++) {
            if (!descubiertas[i] && tablero[i] != -1) {
                return false;
            }
        }
        return true;
    }

    static void mostrarTablero() {
        System.out.println("Tablero buscaminas:");
        for (int i = 0; i < 20; i++) {
            if (descubiertas[i]) {
                System.out.print(tablero[i] + " ");
            } else {
                System.out.print(" X ");
            }
        }
        System.out.println();
     
    }
}