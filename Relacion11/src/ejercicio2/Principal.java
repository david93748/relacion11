package ejercicio2;

public class Principal {

	public static void main(String[] args) {
		Equipo<Alumno> equipo1, equipo2, equipo3, equipoFusionado, equipoInterseccion;
		Equipo<String> equipo4;

		equipo1 = new Equipo<Alumno>("Equipo 1");
		equipo2 = new Equipo<Alumno>("Equipo 2");
		equipo3 = new Equipo<Alumno>("Equipo 3");
		equipo4 = new Equipo<String>("Equipo 4");

		try {

			crearEquipo1(equipo1);
			crearEquipo2(equipo2);
			crearEquipo3(equipo3);
			equipo4.insertarObjeto("Alcalá");

			// Borramos el 2 del equipo 1

			equipo1.borrarObjeto(new Alumno("2", "Cualquiera"));

			System.out.println(equipo1);
			System.out.println(equipo2);
			System.out.println(equipo3);

			equipoFusionado = equipo1.fusionDeEquipos(equipo2, "Equipo 1 unido 2");

			equipoInterseccion = equipo3.intersecionDeEquipos(equipo2, "Equipo 3 intersecci�n 2");

			System.out.println(equipoFusionado);
			System.out.println(equipoInterseccion);
		} catch (EquipoException e) {
			System.out.println(e.getMessage());
		}

	}

	private static void crearEquipo1(Equipo<Alumno> equipo1) {
		Alumno nuevoAlumno;

		try {
			nuevoAlumno = new Alumno("1", "a");
			equipo1.insertarObjeto(nuevoAlumno);

			nuevoAlumno = new Alumno("2", "b");
			equipo1.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("3", "c");
			equipo1.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("4", "d");
			equipo1.insertarObjeto(nuevoAlumno);

			// Este no va a entrar
			nuevoAlumno = new Alumno("1", "Otro a");
			equipo1.insertarObjeto(nuevoAlumno);
		} catch (EquipoException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static void crearEquipo2(Equipo<Alumno> equipo2) throws EquipoException {
		Alumno nuevoAlumno;
		try {
			nuevoAlumno = new Alumno("5", "Alumno 5");
			equipo2.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("6", "Alumno 6");
			equipo2.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("4", "d");
			equipo2.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("3", "c");
			equipo2.insertarObjeto(nuevoAlumno);
		} catch (EquipoException ex) {
			System.out.println(ex.getMessage());
		}

	}

	private static void crearEquipo3(Equipo<Alumno> equipo3) throws EquipoException {
		Alumno nuevoAlumno;
		try {
			nuevoAlumno = new Alumno("6", "Alumno 6");
			equipo3.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("12", "Alumno 12");
			equipo3.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("13", "Alumno 13");
			equipo3.insertarObjeto(nuevoAlumno);
			nuevoAlumno = new Alumno("4", "d");
			equipo3.insertarObjeto(nuevoAlumno);
		} catch (EquipoException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
