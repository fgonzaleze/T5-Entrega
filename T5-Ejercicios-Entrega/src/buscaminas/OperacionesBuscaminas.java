package buscaminas;

import java.util.Arrays;

public class OperacionesBuscaminas {
	
	static int TAM_TABLERO = 20;
	static int MINAS = 6;
	
	/**
	 * Metodo para llevar la cuenta de las partidas ganadas
	 * @param ganada llevará la cuenta de cuantos intentos se llevan
	 * @return Devuelve un booleano siendo true cuando haya llegado a 0 los movimientos
	 */
	public static boolean partidaGanada (char ganada[]) {
		// Cuando sea 
		int contGanador=14;
		boolean ganaste=false;
		
		for(int i=0;i<ganada.length;i++) {
			if (ganada[i]=='0' || ganada[i]=='1' || ganada[i]=='2' ) {
				contGanador--;
			}
		}
		if(contGanador ==0) {
			ganaste = true; 
		}
		return ganaste;
	}
	/**
	 * Metodo que llena la tabla de bombas, representados con *
	 * @param bombita Va a contener 
	 * @return Devolvemos el array con las minas colocadas aleatoriamente
	 */
	public static char[] tablaLlena(char bombita[]) {
		int posicion;
		// Bendecido gracias Paco Y Carmen por explicarme el array.fill
		Arrays.fill(bombita, '0'); 
		// Colocamos las seis minas
		for (int i = 0; i < MINAS; i++) {
			do {
				posicion = (int) (Math.random() * 20);
			} while (bombita[posicion] == '*');
			bombita[posicion] = '*';
		}
		return bombita;
	}
	/**
	 * Metodo que muestra las pistas de donde se encuentran las minas con un valor de 0, 1 y 2 según las que haya adyacentes
	 * @param movimiento Array que será recorrido para ir modificando el movimiento, planteado para evitar errores en los bordes del tablero
	 * @return devuelve el movimiento que se haya realizado, pudiendo ser un *, un 0, un 1 o un 2
	 */
	public static char[] arrayNumerosPistas(char movimiento[]) {
		// For para recorrer el array
		for (int i = 0; i < movimiento.length; i++) {
			// For para comprobar si es mayor que 0 o menor que la ultima posicion del array
			if (i > 0 && i < movimiento.length - 1 && movimiento[i] == '0') {
				// Si esto ocurre, lo que mostremos tendrá que ser un 2
				if (movimiento[i - 1] == '*' && movimiento[i + 1] == '*') {
					movimiento[i] = '2';
				} else if (movimiento[i - 1] == '*' && movimiento[i + 1] != '*') { 
					// Sino, la posicion anterior y la siguiente tendrán un 1
					movimiento[i] = '1';
					// Else if para el mismo caso pero si fuese al revés
				} else if (movimiento[i + 1] == '*' && movimiento[i - 1] != '*') {
					movimiento[i] = '1';
				}
			} // if grande

			// Else if para el inicio del tablero, si hay una bomba se pone un 1
			else if (movimiento[i] == '0' && i == 0) {
				if (movimiento[i + 1] == '*') {
					movimiento[i] = '1';
				}
			}
			// Este sería igual pero para el final de la tabla
			else if (movimiento[i] == '0' && i == movimiento.length - 1) { 
				if (movimiento[i - 1] == '*') {
					movimiento[i] = '1';
				}
			}
		} 
		return movimiento;
	}
	
	public static char[] enseñaTablero(char tab[], char arrayMinas[], int cas) {
		// Si toca bomba
		if(tab[cas]=='*') {
			System.out.println(Arrays.toString(tab));
			System.out.println("Has perdido");
		}
		else {
			arrayMinas[cas] = tab[cas];
			System.out.println(Arrays.toString(arrayMinas));
		}
		return arrayMinas;
	}
}
