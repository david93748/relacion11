package ejercicio4;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Mensaje  implements Comparable<Mensaje>{
	private Persona remitente;
	private String texto;
	private LocalDateTime hora;
	
	public Mensaje(Persona remitente, String texto) {
		
		this.remitente = remitente;
		this.texto = texto;
		hora=LocalDateTime.now();
	}

	public Persona getRemitente() {
		return remitente;
	}


	public String getTexto() {
		return texto;
	}


	public LocalDateTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-uuuu hh:mm");
		return "Mensaje De: " + remitente.getNombre() + " Texto: " + texto + ", Fecha " + df.format( hora );
	}

	@Override
	public int compareTo(Mensaje o) {
		return this.getRemitente().getNombre().compareTo(o.getRemitente().getNombre());
	}

	
	
	
	
}
