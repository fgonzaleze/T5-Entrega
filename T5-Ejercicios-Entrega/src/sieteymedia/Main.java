package sieteymedia;

import java.util.Scanner;

public class Main {

	static final double PUNTUACION = 7.5;

	public static void main(String[] args) {
		Scanner lectura = new Scanner(System.in);
		
		// Declaramos las variables
		double puntosJugador1 = 0;
		double puntosJugador2 = 0;
		String carta;
		String respuesta;
		boolean turnoJug1 = true;
		boolean turnoJug2 = true;

		// Bucle while que repite el turno del jugador 1
		while (turnoJug1) {
			System.out.println("Turno del jugador 1: ¿Quieres pedir una carta? (s/n)");
			respuesta = lectura.next();
			// Bucle if en caso de que pida carta
			if (respuesta.equals("s")) {
				// Funcion roba carta, que será la carta asignada
				carta = OperacionesSieteymedia.robaCarta();
				System.out.println("El jugador 1 ha sacado la carta: " + carta);
				// Vamos sumando la puntuacion del jugador con la funcion que devolverá el switch de la funcion valorCarta
				puntosJugador1 += OperacionesSieteymedia.valorCarta(carta);
				System.out.println("Puntuación actual del jugador 1: " + puntosJugador1);
				// Para cuando el jugador se pase o diga que no
				if (puntosJugador1 > PUNTUACION) {
					System.out.println("El jugador 1 se ha pasado.");
					break;
				}
			// Si no se cumple el if, el turno pasará a false y continuaremos con el siguiente jgador
			} else {
				turnoJug1 = false;
			}
		}
		// El turno del jugador 2 es igual que el del jugador 1
		while (turnoJug2) {
			System.out.println("Turno del jugador 2: ¿Quieres pedir una carta? (s/n)");
			respuesta = lectura.next();
			if (respuesta.equals("s")) {
				carta = OperacionesSieteymedia.robaCarta();
				System.out.println("El jugador 2 ha sacado la carta: " + carta);
				puntosJugador2 += OperacionesSieteymedia.valorCarta(carta);
				System.out.println("Puntuación actual del jugador 2: " + puntosJugador2);
				if (puntosJugador2 > PUNTUACION) {
					System.out.println("El jugador 2 se ha pasado.");
					break;
				}

			} else {
				turnoJug2 = false;
			}
			//	Arreglar las condiciones
		}
		// Condiciones según el resultdo de la partida. 
		if (puntosJugador2 > puntosJugador1 && puntosJugador2 <= PUNTUACION) {
			System.out.println("Gana el jugador 2");
		} if (puntosJugador2 <= PUNTUACION && puntosJugador1 > PUNTUACION) {
			System.out.println("Gana el jugador 2");
		} if (puntosJugador1 > puntosJugador2 && puntosJugador1 <= PUNTUACION) {
			System.out.println("Gana el jugador 1");
		} if (puntosJugador1 <= PUNTUACION && puntosJugador2 > PUNTUACION) {
			System.out.println("Gana el jugador 1");
		} if (puntosJugador2 == puntosJugador1 && puntosJugador2 < PUNTUACION && puntosJugador1 < PUNTUACION) {
			System.out.println("Empate");
		} if (puntosJugador2 > PUNTUACION && puntosJugador1 > PUNTUACION) {
			System.out.println("No ha ganado nadie");
		}
		lectura.close();
	}
}
