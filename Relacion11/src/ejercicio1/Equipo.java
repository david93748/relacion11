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
			throw new EquipoException("El alumno no ha podido ser añadido");
		}

	}

	public void borrarAlumno(Alumno alumnoABorrar) throws EquipoException {
		Iterator<Alumno> it=conjuntoAlumnos.iterator();
		boolean borrado=false;
		
		while (it.hasNext()&&borrado==false) {
			Alumno alumno = (Alumno) it.next();
			if(alumno.equals(alumnoABorrar)) {
				it.remove();
				borrado=true;
			}
		}
		
		if(borrado==false) {
			throw new EquipoException("El alumno no ha sido encontrado");
		}

	}

	public Alumno buscarAlumno(Alumno alumnoBuscado) {
		Iterator<Alumno> it=conjuntoAlumnos.iterator();
		boolean encontrado=false;
		Alumno alumnoEncontrado;
		
		while (it.hasNext()&&borrado==false) {
			alumnoEncontrado = (Alumno) it.next();
			if(alumnoEncontrado.equals(alumnoBuscado)) {
				encontrado==true;
			}
		}

	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro   Otro equipo que se va a unir
	 * @param nombre Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo fusionDeEquipos(Equipo otro, String nombre) {

	}

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this y
	 * otro)
	 * 
	 * @param otro   Otro equipo
	 * @param nombre Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 */
	public Equipo intersecionDeEquipos(Equipo otro, String nombre) {

	}

	@Override
	public String toString() {

	}

}
