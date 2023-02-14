package buscaminas;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// Declaramos las funciones
		int casilla = 0;
		boolean ganado = false;
		char tablero[] = new char[20];
		char arrayDeMinas[] = new char[20];
		
		Scanner lectura = new Scanner(System.in);
		
		// Recorrer y rellenar el array
		for (int j = 0; j < arrayDeMinas.length; j++) {
			arrayDeMinas[j] = 'X';
		}
		
		// Llamamos las funciones para mostrarlas
		tablero = OperacionesBuscaminas.tablaLlena(tablero);
		tablero = OperacionesBuscaminas.arrayNumerosPistas(tablero);
		System.out.println(Arrays.toString(tablero));
		// Mientras no hayas pisado una mina y ganado sea falso
		
		while (tablero[casilla] != '*' && ganado == false) {
			System.out.println("La mina que quieres descubrir (del 0 al 19): ");
			casilla = lectura.nextInt();
			arrayDeMinas = OperacionesBuscaminas.enseñaTablero(tablero, arrayDeMinas, casilla);
			ganado = OperacionesBuscaminas.partidaGanada(arrayDeMinas);
		} if (ganado == true) {
			System.out.println("Enhorabuena, has desactivado todas las minas");

		}
		// Cerramos el escaner
		lectura.close();
	}
}
