package ejercicio4;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import ejercicio3.VisitaPaginaWeb;

public abstract class Persona {

	private static final int EDAD_MINIMA = 12;

	// Atributos
	private String dni;
	private String nombre;
	private int edad;

	private LinkedList<Mensaje> buzonEntrada;

	// Constructor
	public Persona(String dni, String nombre, int edad) throws IESException {
		this.dni = dni;
		this.nombre = nombre;
		buzonEntrada = new LinkedList<Mensaje>();

		setEdad(edad);
	}

	// Métodos get y set
	public int getEdad() {
		return edad;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setEdad(int edad) throws IESException {
		if (edad < EDAD_MINIMA)
			throw new IESException("La edad minima es de" + EDAD_MINIMA);
		this.edad = edad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	public void enviarMensaje(Persona destinatario,String asunto, String msg) throws IESException {

		destinatario.buzonEntrada.addFirst(new Mensaje(this,asunto, msg));
	}

	public String mostrarMensajes() throws IESException {
		Iterator<Mensaje> it = buzonEntrada.iterator();
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm");
		int contador = 1;
		String leido;

		if (buzonEntrada.isEmpty()) {
			throw new IESException("No tienes mensajes");
		}

		sb.append("BUZON DE ENTRADA:");

		while (it.hasNext()) {
			Mensaje mensaje = (Mensaje) it.next();
			if(mensaje.isLeido()) {
				sb.append("\n📭");
			}else {
				sb.append("\n📬");
			}
			sb.append(" Mensaje " + contador + ": De: " + mensaje.getRemitente().getNombre() + " Asunto: \n"
					+ mensaje.getAsunto() + "\n Fecha y Hora: " + df.format(mensaje.getHora()));
			contador++;
		}

		sb.append("\n NO HAY MAS MENSAJES");

		return sb.toString();
	}

	public String mostrarMensajesOrdenadosRemitente() throws IESException {
		StringBuilder sb = new StringBuilder();
		LinkedList<Mensaje> mensajes = new LinkedList<Mensaje>(buzonEntrada);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm");
		int contador = 1;

		if (buzonEntrada.isEmpty()) {
			throw new IESException("No tienes mensajes");
		}

		Collections.sort(mensajes);

		sb.append("BUZON DE ENTRADA ORDENADO ALFABETICAMENTE:");

		for (Mensaje mensaje : mensajes) {
			sb.append("\nMensaje " + contador + ": De: " + mensaje.getRemitente().getNombre() + " Texto: \n"
					+ mensaje.getTexto() + "\n Fecha y Hora: " + df.format(mensaje.getHora()));
			contador++;
		}
		sb.append("\n NO HAY MAS MENSAJES");

		return sb.toString();
	}

	public void borrarMensaje(int num) throws IESException {
		if (num > buzonEntrada.size()||num<1) {
			throw new IESException("No se ha encontrado ese mensaje");

		}
		buzonEntrada.remove(num - 1);

	}

	public String buscarFrase(String frase) throws IESException {
		Iterator<Mensaje> it = buzonEntrada.iterator();
		StringBuilder sb = new StringBuilder();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/uuuu hh:mm");
		int contador = 1;

		if (buzonEntrada.isEmpty()) {
			throw new IESException("No tienes mensajes");
		}

		sb.append("MENSAJES ENCONTRADOS CON LA FRASE " + frase + ":");
		while (it.hasNext()) {
			Mensaje mensaje = (Mensaje) it.next();
			if (mensaje.getTexto().contains(frase)) {
				sb.append("\nMensaje " + contador + ": De: " + mensaje.getRemitente().getNombre() + " Texto: \n"
						+ mensaje.getTexto() + "\n Fecha y Hora: " + df.format(mensaje.getHora()));
				contador++;
			}
		}
		if (contador <= 1) {
			throw new IESException("No se ha encontrado ningun mensaje con esa frase");
		}

		sb.append("\n NO HAY MAS MENSAJES");

		return sb.toString();
	}
	
	public String leerMensaje(int num) throws IESException {
		if (num > buzonEntrada.size()||num<1) {
			throw new IESException("No se ha encontrado ese mensaje");

		}
		return buzonEntrada.get(num-1).toString();

	}

}
