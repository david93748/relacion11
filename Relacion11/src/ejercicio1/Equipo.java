package ejercicio1;

import java.util.*;

public class Equipo {
	private String nombreEquipo;
	private HashSet<Alumno> conjuntoAlumnos;

	public Equipo(String nombre) {
		this.nombreEquipo = nombre;
		conjuntoAlumnos = new HashSet<Alumno>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarAlumno(Alumno nuevoAlumno) throws EquipoException {
		boolean insertado = false;

		insertado = conjuntoAlumnos.add(nuevoAlumno);

		if (insertado == false) {
			throw new EquipoException("El alumno no ha podido ser añadido porque hay otro dni igual");
		}

	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {
		Iterator<Alumno> it = conjuntoAlumnos.iterator();
		boolean borrado = false;

		while (it.hasNext() && borrado == false) {
			Alumno alumno = (Alumno) it.next();
			if (alumno.equals(alumnoABorrar)) {
				it.remove();
				borrado = true;
			}
		}

		if (borrado == false) {
			throw new EquipoException("El alumno no ha sido encontrado");
		}

	}

	public Alumno buscarAlumno(Alumno alumnoBuscado) {
		Iterator<Alumno> it = conjuntoAlumnos.iterator();
		boolean encontrado = false;
		Alumno alumnoEncontrado = null;

		while (it.hasNext() && encontrado == false) {
			alumnoEncontrado = (Alumno) it.next();
			if (alumnoEncontrado.equals(alumnoBuscado)) {
				encontrado = true;
			}
		}
		if(encontrado==false) {
			alumnoEncontrado=null;
		}

		return alumnoEncontrado;
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro   Otro equipo que se va a unir
	 * @param nombre Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 * @throws EquipoException
	 */
	public Equipo fusionDeEquipos(Equipo otro, String nombre) {
		Equipo nuevoEquipo = new Equipo(nombre);

		for (Alumno alumno : conjuntoAlumnos) {
				nuevoEquipo.conjuntoAlumnos.add(alumno);
		}

		for (Alumno alumno : otro.conjuntoAlumnos) {
				nuevoEquipo.conjuntoAlumnos.add(alumno);
		}

		return nuevoEquipo;

	}

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this y
	 * otro)
	 * 
	 * @param otro   Otro equipo
	 * @param nombre Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 * @throws EquipoException
	 */
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) throws EquipoException {
		Equipo nuevoEquipo = new Equipo(nombre);

		for (Alumno alumno : conjuntoAlumnos) {
			for (Alumno alumno2 : otro.conjuntoAlumnos) {
				if (alumno.equals(alumno2)) {
					nuevoEquipo.conjuntoAlumnos.add(alumno);
				}
			}
		}
		return nuevoEquipo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(nombreEquipo + ". Jugadores: ");

		for (Alumno alumno : conjuntoAlumnos) {
			sb.append(alumno.getNombre() + " ");
		}

		return sb.toString();
	}

}
