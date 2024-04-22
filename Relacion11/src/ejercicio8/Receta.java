package ejercicio8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Receta implements Comparable<Receta> {
	private String nombreReceta;
	private int minutosDePreparacion;
	private HashSet<Ingrediente> ingredientes;
	private LinkedList<String> pasos;

	public Receta(String nombreReceta, int minutosPreparacion) throws RecetaException {
		this.nombreReceta = nombreReceta.toUpperCase();
		setMinutosDePreparacion(minutosPreparacion);
		ingredientes = new HashSet<Ingrediente>();
		pasos = new LinkedList<String>();
	}

	public int getMinutosDePreparacion() {
		return minutosDePreparacion;
	}

	public void setMinutosDePreparacion(int minutosDePreparacion) throws RecetaException {
		if (minutosDePreparacion <= 0) {
			throw new RecetaException("Minutos incorrectos");
		}
		this.minutosDePreparacion = minutosDePreparacion;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void annadirPasoAlFinal(String paso) {
		pasos.add(paso.toUpperCase());
	}

	public void annadirIngrediente(Ingrediente ingredienteNuevo) {
		boolean encontrado = false;

		Iterator<Ingrediente> it = ingredientes.iterator();

		while (it.hasNext() && encontrado == false) {
			Ingrediente ingrediente = (Ingrediente) it.next();

			if (ingrediente.equals(ingredienteNuevo)) {
				ingrediente.setCantidad(ingrediente.getCantidad() + ingredienteNuevo.getCantidad());
				encontrado = true;
			}
		}
		
		if(encontrado==false) {
			ingredientes.add(ingredienteNuevo);
		}

	}

	public boolean necesitaIngrediente(String nombreIngrediente) {
		boolean necesita = false;

		if (ingredientes.contains(new Ingrediente(nombreIngrediente))) {
			necesita = true;
		}

		return necesita;
	}

	public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {

		if (ingredientes.remove(ingredienteABorrar) == false) {
			throw new RecetaException("No se ha encontrado el ingrediente");
		}
		Iterator<String> it=pasos.iterator();
		boolean encontrado=false;
		
		while (it.hasNext()&&encontrado==false) {
			String string = (String) it.next();
			
			if(string.contains(ingredienteABorrar.getNombreIngrediente())) {
				it.remove();
				encontrado=true;
			}
		}

	}

	public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
		int indice=pasos.indexOf(pasoExistente);
		if(indice==-1) {
			throw new RecetaException("No se ha encontrado el paso existente");
		}
		
		
		pasos.add(indice+1,pasoNuevo);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreReceta == null) ? 0 : nombreReceta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (nombreReceta == null) {
			if (other.nombreReceta != null)
				return false;
		} else if (!nombreReceta.equals(other.nombreReceta))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int contador = 1;
		sb.append("-" + this.getNombreReceta() + " " + this.getMinutosDePreparacion() + " minutos\n");
		sb.append("Ingredientes:\n");

		for (Ingrediente ingrediente : ingredientes) {
			sb.append(ingrediente + ", ");
		}

		sb.append("\nPasos:\n");
		for (String paso : pasos) {
			sb.append(contador + ". " + paso + "\n");
			contador++;
		}
		return sb.toString();
	}

	@Override
	public int compareTo(Receta o) {
		return this.getNombreReceta().compareTo(o.getNombreReceta());
	}

}
