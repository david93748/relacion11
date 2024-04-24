package ejercicio7;

import java.util.Scanner;

public class Principal {

	private static final int NUMERO_CAJAS = 20;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion = 0;
		Mercadona mercadona = new Mercadona();
		mercadona.crearCajas(NUMERO_CAJAS);

		while (opcion != 5) {
			try {
				mostarMenu();
				opcion = pedirNumero("Elije una opcion:");
				tratarMenu(opcion, mercadona);
			} catch (CajaException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void mostarMenu() {
		System.out.println("1. Abrir Caja");
		System.out.println("2. Cerrar Caja");
		System.out.println("3. Nuevo Cliente");
		System.out.println("4. Atender Cliente");
		System.out.println("5. Salir");
	}

	public static int pedirNumero(String msg) {
		int numero;
		System.out.println(msg);
		numero = Integer.parseInt(teclado.nextLine());

		return numero;
	}

	public static void tratarMenu(int opcion, Mercadona mercadona) throws CajaException {
		int numero;
		switch (opcion) {
		case 1:
			numero = pedirNumero("¿Que caja quieres abrir?");
			mercadona.abrirCaja(numero);
			System.out.println("Caja  "+numero+" abierta");
			break;
		case 2:
			numero = pedirNumero("¿Que caja quieres cerrar?");
			mercadona.cerrarCaja(numero);
			System.out.println("Caja  "+numero+" cerrada");
			break;
		case 3:
			System.out.println(mercadona.nuevoCliente());
			break;
		case 4:
			numero = pedirNumero("¿De que caja quieres que se atienda un cliente?");
			numero=mercadona.atenderCliente(numero);
			System.out.println("Se ha atendido al cliente con número "+numero);
			break;
		case 5:
			System.out.println("Adios");
			break;

		default:
			System.out.println("opcion incorrecta");
			break;
		}
	}

}
