package sieteymedia;

import java.util.Scanner;

public class OperacionesSieteymedia {

		    Scanner scanner = new Scanner(System.in);


		    static final String[] carta = { "1", "2", "3", "4", "5", "6", "7", "Sota", "Caballo", "Rey"};
		    static final String[] palo = { "Oros", "Copas", "Espadas", "Bastos" };
		    String CartaSacada = "";
		   
		    static String robaCarta() {
		      int nombreCarta = (int) (Math.random() * (carta.length));
		      int nombrePalo = (int) (Math.random() * (palo.length));
		      return carta[nombreCarta] + " de " + palo[nombrePalo];
		    }
		    
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
