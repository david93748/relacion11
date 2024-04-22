package ejercicio6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class EntradaDiccionario implements Comparable<EntradaDiccionario>{

	private String palabra;
	private HashSet<String> listaSignificados;

	public EntradaDiccionario(String palabra, String significado) {

		this.palabra = palabra;
		listaSignificados = new HashSet<String>();
		listaSignificados.add(significado);

	}

	public String getPalabra() {
		return palabra;
	}

	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}

	public void annadirSignificado(String significado) {

		listaSignificados.add(significado);

	}

	@Override
	public int hashCode() {
		return Objects.hash(palabra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaDiccionario other = (EntradaDiccionario) obj;
		return Objects.equals(palabra, other.palabra);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> it = listaSignificados.iterator();
		sb.append(palabra + "\n");

		while (it.hasNext()) {
			String string = (String) it.next();
			sb.append("-" + string + "\n");
		}

		return sb.toString();
	}

	@Override
	public int compareTo(EntradaDiccionario o) {
		return this.palabra.compareTo(o.palabra);
	}

}
