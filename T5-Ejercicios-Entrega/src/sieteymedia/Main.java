package sieteymedia;

import java.util.Scanner;

public class Main {

	static final double PUNTUACION = 7.5;

	public static void main(String[] args) {

		Scanner lectura = new Scanner(System.in);
		double puntosJugador1 = 0;
		double puntosJugador2 = 0;
		String carta;
		String respuesta;
		boolean turnoJug1 = true;
		boolean turnoJug2 = true;

		while (turnoJug1 == true) {
			System.out.println("Turno del jugador 1: ¿Quieres pedir una carta? (s/n)");
			respuesta = lectura.next();
			if (respuesta.equals("s")) {
				carta = OperacionesSieteymedia.robaCarta();
				System.out.println("El jugador 1 ha sacado la carta: " + carta);
				puntosJugador1 += OperacionesSieteymedia.valorCarta(carta);
				System.out.println("Puntuación actual del jugador 1: " + puntosJugador1);
				if (puntosJugador1 > PUNTUACION) {
					System.out.println("El jugador 1 se ha pasado.");
					break;
				}
			} else {
				turnoJug1 = false;
			}
		}
		while (turnoJug2 == true) {
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
		if (puntosJugador2 > puntosJugador1 && puntosJugador2 < PUNTUACION) {
			System.out.println("Gana el jugador 2");
		} if (puntosJugador1 > puntosJugador2 && puntosJugador1 < PUNTUACION) {
			System.out.println("Gana el jugador 1");
		} if (puntosJugador2 == puntosJugador1 && puntosJugador2 < PUNTUACION && puntosJugador2 < PUNTUACION) {
			System.out.println("Empate");
		}
		lectura.close();
	}
}
