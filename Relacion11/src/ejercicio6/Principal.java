package ejercicio6;

import java.util.Scanner;

public class Principal {

	private static Scanner teclado = new Scanner(System.in);
	private static final int OPCION_SALIR = 5;

	public static void main(String[] args) {

		Diccionario diccionario = new Diccionario();
		int opc;

		do {
			opc = mostrarMenu();
			tratarOpciones(opc, diccionario);
		} while (opc != OPCION_SALIR);
	}

	private static void tratarOpciones(int opc, Diccionario diccionario) {

		String palabra, significado, lista;
		EntradaDiccionario entradaBuscada;

		switch (opc) {
		case 1:
			palabra = pedirString("¿Que palabra quieres añadir/añadirle un significado?").toUpperCase();
			significado = pedirString("¿Que signifcado quieres añadir?");
			diccionario.annadirEntrada(palabra, significado);
			break;
		case 2:
			palabra = pedirString("¿Que palabra quieres buscar?").toUpperCase();
			entradaBuscada = diccionario.buscarPalabra(palabra);
			if (entradaBuscada == null) {
				System.out.println("No se ha encontrado la palabra");
			} else {
				System.out.println(entradaBuscada);
			}
			break;
		case 3:
			palabra = pedirString("¿Que palabra quieres borrar?").toUpperCase();
			entradaBuscada = diccionario.borrarPalabra(palabra);
			if (entradaBuscada == null) {
				System.out.println("No se ha encontrado la palabra");
			} else {
				System.out.println("La palabra ha sido borrada");
			}
			break;
		case 4:
			palabra = pedirString("¿Que comienzo de palabra quieres buscar?").toUpperCase();
			lista = diccionario.buscarPalabraPorComienzo(palabra);
			if (lista == "") {
				System.out.println("No se ha encontrado ninguna palabra con ese comienzo");
			} else {
				System.out.println(lista);
				break;
			}
		case 5:
			System.out.println("Adios");
			break;
		}
	}

	private static int mostrarMenu() {
		int opc;
		do {
			System.out.println("1.Añadir palabra");
			System.out.println("2.Buscar palabra en el diccionario");
			System.out.println("3.Borrar palabra en el diccionario");
			System.out.println("4.Listado de palabras que empiecen por..");
			System.out.println("5.Salir");
			
			opc = Integer.parseInt(teclado.nextLine());
		} while (opc < 1 || opc > OPCION_SALIR);
		return opc;
	}

	public static String pedirString(String msg) {
		String palabra;

		System.out.println(msg);
		palabra = teclado.nextLine();

		return palabra;
	}

}
