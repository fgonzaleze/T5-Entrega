package sieteymedia;

import java.util.Scanner;

public class OperacionesSieteymedia {

		    Scanner scanner = new Scanner(System.in);
		    
		    // Dos arrays en String que contienen: el primero las cartas del 1 al 7 y sota, caballo y rey; y el segundo los 4 palos de la baraja. 
		    static final String[] carta = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};
		    static final String[] palo = { "Oros", "Copas", "Espadas", "Bastos" };
		   
		    /**
		     * Metodo que roba carta generada aleatoriamente con Math.random
		     * @return Devuelve em este caso un String con el nombre de la carta y el palo
		     */
		    static String robaCarta() {
		      int nombreCarta = (int) (Math.random() * (carta.length));
		      int nombrePalo = (int) (Math.random() * (palo.length));
		      return carta[nombreCarta] + " de " + palo[nombrePalo];
		    }
		    
		    /**
		     * Metodo con un switch que devolverá el valor asignado que le corresponda a la carta sacada segun el juego de las siete y media
		     * @param carta carta que ha salido en el metodo robaCarta
		     * @return Devuelve un valor numerico asignado en el switch 
		     */
		    static double valorCarta(String carta) {
		    
		    	switch(carta.charAt(0)) { // Toma el caracter de la cadena en la posicion 0, al ser 1 - 7 hace el caso del switch y cuando sea una letra, va a ser el default.
		            case '1':
		                return 1;
		            case '2':
		                return 2;
		            case '3':
		                return 3;
		            case '4':
		                return 4;
		            case '5':
		                return 5;
		            case '6':
		                return 6;
		            case '7':
		                return 7;
		            default:
		                return 0.5;
		        }
		    }
		    
}
