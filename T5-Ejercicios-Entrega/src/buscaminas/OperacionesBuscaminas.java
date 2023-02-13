package buscaminas;



public class OperacionesBuscaminas {
	 static final int TABLERO_SIZE = 20;
	    static final int MINAS = 6;
	    static int[] tablero = new int[TABLERO_SIZE];
	    static boolean[] destapado = new boolean[TABLERO_SIZE];
	    static Scanner scan = new Scanner(System.in);

	    public static void main(String[] args) {
	        inicializarTablero();
	        mostrarTableroOculto();

	        while (!juegoTerminado()) {
	            System.out.println("Elige una posición (0-" + (TABLERO_SIZE - 1) + "):");
	            int posicion = scan.nextInt();

	            if (tablero[posicion] == -1) {
	                System.out.println("Lo siento, has perdido.");
	                break;
	            }

	            destapado[posicion] = true;
	            mostrarTableroDestapado();
	        }

	        if (juegoGanado()) {
	            System.out.println("Felicidades, has ganado.");
	        }
	    }

	    static void inicializarTablero() {
	        for (int i = 0; i < TABLERO_SIZE; i++) {
	            tablero[i] = 0;
	            destapado[i] = false;
	        }

	        int minasColocadas = 0;
	        while (minasColocadas < MINAS) {
	            int posicionMina = (int) (Math.random() * TABLERO_SIZE);
	            if (tablero[posicionMina] == 0) {
	                tablero[posicionMina] = -1;
	                minasColocadas++;

	                for (int i = Math.max(posicionMina - 1, 0); i <= Math.min(posicionMina + 1, TABLERO_SIZE - 1); i++) {
	                    if (tablero[i] != -1) {
	                        tablero[i]++;
	                    }
	                }
	            }
	        }
	    }

	    static boolean juegoTerminado() {
	        for (int i = 0; i < TABLERO_SIZE; i++) {
	            if (destapado[i] == false && tablero[i] != -1) {
	                return false;
	            }
	        }
	        return true;
	    }

	    static boolean juegoGanado() {
	        for (int i = 0; i < TABLERO_SIZE; i++) {
	            if (destapado[i] == false && tablero[i] == -1) {
	                return false;
	            }
	        }
	        return true;
	    }

	    static void mostrarTableroOculto() {
	        for (int i = 0; i < TABLERO_SIZE; i++) {
	            System.out.print("X ");
	        }
	        System.out.println();
	    }
}
