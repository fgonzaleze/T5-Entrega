package buscaminas;

import java.util.Arrays;
import java.util.Scanner;

public class OperacionesBuscaminas {
	
    public static Scanner sc = new Scanner(System.in);


    public static final int MINAS = 6;

    public static void colocarMinas(int[] arrayMinas, char[] pintarArray) {
        int indice;             
        int contadorMinas = 0;  

        Arrays.fill(pintarArray, ' ');

        while (contadorMinas < MINAS){
            indice = (int) (Math.random() * (20 + 1) - 1); 
            if (arrayMinas[indice]==1){
                contadorMinas--;
            }else {
                arrayMinas[indice]=1;
            }
            contadorMinas++;
        }
    }


    public static void pintarTablero(char[] arrayPintar) {
        for (int casilla = 0; casilla < arrayPintar.length; casilla++) {
            System.out.print("[" + (char) arrayPintar[casilla] + "]");
        }
        System.out.println();
    }

  
    public static boolean jugar(int[] minas, char[] pintar) {

        boolean gameOver = false;

        int casilla = sc.nextInt();

        if (minas[casilla] == 1){ 
        	
            System.out.println("Has perdido :(");
            gameOver = true;                  

        } else {                                
            pintar[casilla] = (contarMinas(minas, casilla) + "").charAt(0);
            minas[casilla] = -1;           

            if (usuarioGanaJuego(minas)){
                System.out.println("Enhorabuena, has ganado");
                gameOver = true;             
            }
        }
        return gameOver;
    }

   
    public static int contarMinas(int[] arrayMinas, int casilla) {
        int izquierdaCasilla = casilla - 1;
        int derechaCasilla = casilla + 1;
        int contadorMinas = 0;

        if (casilla == 0) {
            izquierdaCasilla = 0;
        }


        if (casilla == arrayMinas.length - 1) {
            derechaCasilla = arrayMinas.length - 1;
        }

      
        for (int i = izquierdaCasilla; i <= derechaCasilla; i++) {
            if (arrayMinas[i] == 1 && i != casilla) {  
                contadorMinas++;                       
            }
        }
        return contadorMinas;
    }

    public static boolean usuarioGanaJuego(int[] arrayMinas) {
        int contador = 0;
        boolean ganador = false;

        for (int casilla = 0; casilla < arrayMinas.length; casilla++) {
            if (arrayMinas[casilla] == 1 || arrayMinas[casilla] == -1) {
                contador++;
            }

            if (contador == arrayMinas.length) {
                ganador = true;
            }
        }
        return ganador;
    }

}
