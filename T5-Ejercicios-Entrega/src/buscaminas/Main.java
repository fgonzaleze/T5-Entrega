package buscaminas;

import java.util.Arrays;

public class Main {
	

	public static void main(String[] args) {

	 
	        int[] minas = new int[20];
	        char[] tablero = new char[20];

	        OperacionesBuscaminas.colocarMinas(minas, tablero);

	        System.out.println(Arrays.toString(minas));

	        OperacionesBuscaminas.pintarTablero(tablero);
	        System.out.println("Indique la casilla que desea ver (se empieza en 0):");

	        boolean gameOver = false;
	        do {
	            gameOver = OperacionesBuscaminas.jugar(minas, tablero);
	            if (gameOver == false){
	                //System.out.println(Arrays.toString(arrayMinas));
	            	OperacionesBuscaminas.pintarTablero(tablero);
	            }
	        }while (gameOver == false);
	    
	}

}
