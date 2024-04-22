package ejercicio6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Diccionario {

	private HashMap<String, EntradaDiccionario> mapDic;

	public Diccionario() {

		mapDic = new HashMap<String, EntradaDiccionario>();

	}

	public void annadirEntrada(String palabra, String significado) {

		EntradaDiccionario entradaNueva = new EntradaDiccionario(palabra, significado);

		if (mapDic.containsKey(palabra)) {
			mapDic.get(palabra).annadirSignificado(significado);

		} else {
			mapDic.put(palabra, entradaNueva);
		}

	}

	public EntradaDiccionario buscarPalabra(String palabra) {
		return mapDic.get(palabra);
	}

	public EntradaDiccionario borrarPalabra(String palabra) {
		return mapDic.remove(palabra);
	}

	public String buscarPalabraPorComienzo(String comienzo) {
		ArrayList<EntradaDiccionario> palabrasOrdenadas = new ArrayList<EntradaDiccionario>();
		
		for (EntradaDiccionario entradaDiccionario : palabrasOrdenadas) {
			if(entradaDiccionario.getPalabra().startsWith(comienzo)) {
				palabrasOrdenadas.add(entradaDiccionario);
			}
		}
		Collections.sort(palabrasOrdenadas);

		return palabrasOrdenadas.toString();
	}

}
