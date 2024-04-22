package ejercicio2;

import java.util.*;

public class Equipo<T>{
	private String nombreEquipo;
	private HashSet<T> conjunto;

	public Equipo(String nombre) {

		setNombreEquipo(nombre);
		conjunto = new HashSet<T>();
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public void insertarObjeto(T nuevoObjeto) throws EquipoException {

		boolean insertado;

		insertado=conjunto.add(nuevoObjeto);
		if ( ! insertado)
			throw new EquipoException("No se puede insertar el objeto");
	}

	public void borrarObjeto(T objetoABorrar) throws EquipoException {

		if (!conjunto.contains(objetoABorrar))
			throw new EquipoException("No se puede borrar. Ese objeto no está en el equipo");
		conjunto.remove(objetoABorrar);
	}

	/**
	 * Devuelve una cadena con el listado de los Alumnos
	 * 
	 * @return Cadena con el listado de Alumnos
	 */
	public String listadoDeObjetos() {
		StringBuilder sb = new StringBuilder();

		for (T objeto : conjunto) {

			sb.append(objeto + "\n");
		}
		return sb.toString();
	}
	

	
	public Object buscarObjeto(T objetoBuscado){
		
		Object objetoEncontrado=null;
		boolean encontrado =false;
		Object objetoDeLaColeccion = null;
		
		Iterator<T> iterator= conjunto.iterator();
		while(iterator.hasNext() && !encontrado){
			
			objetoDeLaColeccion=iterator.next();
			
			if(objetoDeLaColeccion.equals(objetoBuscado)){
				objetoEncontrado=objetoDeLaColeccion;
				encontrado=true;
			}	
			
			
		}
		return objetoEncontrado;
	}

	/**
	 * Une mi equipo con otro, devolviendo el nuevo equipo creado
	 * 
	 * @param otro
	 *            Otro equipo que se va a unir
	 * @param nombre
	 *            Nombre del nuevo equipo
	 * @return nuevo equipo resultado de unir los dos anteriores
	 */
	public Equipo<T> fusionDeEquipos(Equipo<T> otro, String nombre) {
		Equipo<T> nuevoEquipo;

		nuevoEquipo = new Equipo<T>(nombre);

		for (T objeto : this.conjunto) {
			
			nuevoEquipo.conjunto.add(objeto);

		}
		for (T objeto : otro.conjunto) {
			
			nuevoEquipo.conjunto.add(objeto);
			
		}

		return nuevoEquipo;

	}

	/**
	 * Crea un nuevo equipo con los elementos que están en los dos equipos (this
	 * y otro)
	 * 
	 * @param otro
	 *            Otro equipo
	 * @param nombre
	 *            Nombre del nuevo equipo intersección
	 * @return Equipo resultado de la intersección
	 */
	public Equipo<T> intersecionDeEquipos(Equipo<T> otro, String nombre) {
		Equipo<T> nuevoEquipo;

		nuevoEquipo = new Equipo<T>(nombre);

		for (T objeto : this.conjunto) {

			if (otro.conjunto.contains(objeto)) {

				nuevoEquipo.conjunto.add(objeto);
				
			}
		}

		return nuevoEquipo;

	}

	@Override
	public String toString() {
		return "Nombre Equipo: " + nombreEquipo + 
				"\nAlumnos:\n" + listadoDeObjetos();
	}

}
