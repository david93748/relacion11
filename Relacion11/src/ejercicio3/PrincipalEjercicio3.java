package ejercicio3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


public class PrincipalEjercicio3 {
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		Historial historial = new Historial();
		boolean salir;

		do {
			mostrarMenu();
			salir = solicitarYTratarOpcion(historial);
		} while (salir == false);

	}

	private static void mostrarMenu() {
		System.out.println(
				"1. Nueva Pagina Consultada \n2. Consultar Historial completo \n3. Consultar Historial de un dia \n4. Borrar Historial \n5. Borrar historial de un dia\n6. Numero de visitas a una pagina\n7. Borrar visitas a una pagina\n8. Salir");

	}

	private static boolean solicitarYTratarOpcion(Historial historial) {
		int opcion;
		boolean acabar = false;
	

		opcion = pedirInt("Introduzca la opcion");
		try {
			switch (opcion) {
			case 1: {
				VisitaPaginaWeb visita=crearPagina();
				historial.annadirNuevaVisitaPaginaWeb(visita);
				break;
			}
			case 2: {
				System.out.println(historial);
				break;
			}
			case 3: {
				LocalDate fecha=crearFecha();
				System.out.println(historial.consultarHistorialPorDia(fecha));
				break;
			}

			case 4: {
				historial.borrarHistorial();
				System.out.println("Historial destruido, puede irse tranquilo");
				break;

			}
			case 5: {
				LocalDate fecha=crearFecha();
				historial.borrarHistorialDeUnDia(fecha);
				System.out.println("Dia borrado del historial");
				break;
			}
			case 6: {
				String url=pedirCadena("Introduce la pagina a buscar");
				int  numeroVisitas=historial.numeroDeVisitasPagina(url);
				System.out.println("Has visitado la pagina "+url+" "+numeroVisitas+" veces");
				break;
			}
			case 7: {
				String url=pedirCadena("Introduce la pagina a borrar");
				historial.borrarVisitasPagina(url);
				System.out.println("Pagina borrada del historial");
				break;
			}
			case 8: {
				acabar = true;
				break;
			}

			}
		} catch (VisitaPaginaWebException e) {
			System.out.println(e.getMessage());
		}

		return acabar;

	}

	//TODO
	private static LocalDate crearFecha() {

		

		DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");

	
		
		return null;
	}
	
	
	private static VisitaPaginaWeb crearPagina() {
		String direccion;
		VisitaPaginaWeb nueva = null;

		boolean incorrecto = false;

		do {
			try {
				incorrecto = false;
				direccion = pedirCadena("Introduce la direccion");

				nueva = new VisitaPaginaWeb(direccion);
			} catch (VisitaPaginaWebException e) {
				incorrecto = true;
				System.out.println(e.getMessage());
			}
		} while (incorrecto == true);

		return nueva;
	}

	private static String pedirCadena(String msg) {
		String cadena;

		System.out.println(msg);
		cadena = teclado.nextLine();

		return cadena;

	}

	private static int pedirInt(String msg) {
		int dato = 0;
		boolean incorrecto = false;

		do {
			try {
				incorrecto = false;
				System.out.println(msg);
				dato = Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				incorrecto = true;
				System.out.println("Solo puedes introducir numeros");
			}
		} while (incorrecto == true);

		return dato;
	}

}
