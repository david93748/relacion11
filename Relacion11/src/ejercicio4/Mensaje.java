package ejercicio4;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Mensaje  implements Comparable<Mensaje>{
	private Persona remitente;
	private String asunto;
	private String texto;
	private LocalDateTime hora;
	private boolean leido;
	
	public Mensaje(Persona remitente, String asunto,String texto) {
		
		this.remitente = remitente;
		this.texto = texto;
		this.asunto=asunto;
		hora=LocalDateTime.now();
		leido=false;
	}

	public Persona getRemitente() {
		return remitente;
	}


	public String getAsunto() {
		return asunto;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public boolean isLeido() {
		return leido;
	}


	public LocalDateTime getHora() {
		return hora;
	}

	@Override
	public String toString() {
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-uuuu hh:mm");
		leido=true;
		return "Remitente: " + remitente.getNombre() +"\nAsunto:"+asunto+ "\nTexto: " + texto + "\n Fecha: " + df.format( hora );
	}

	@Override
	public int compareTo(Mensaje o) {
		return this.getRemitente().getNombre().compareTo(o.getRemitente().getNombre());
	}

	
	
	
	
}
