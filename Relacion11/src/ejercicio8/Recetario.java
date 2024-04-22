package ejercicio8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Recetario {

	private HashMap<String, Receta> recetas;

	public Recetario() {
		recetas = new HashMap<String, Receta>();

	}

	public void annadirReceta(Receta nuevaReceta) throws RecetaException {
		if (recetas.containsValue(nuevaReceta)) {
			throw new RecetaException("Ya existe esa receta");
		}
		recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);

	}

	public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
		ArrayList<Receta> array = new ArrayList<Receta>(recetas.values());
		Collections.sort(array);
		StringBuilder sb = new StringBuilder();
		
		for (Receta receta : array) {
			sb.append(receta);
		}

		return sb.toString();
	}

	public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {

	}
}
