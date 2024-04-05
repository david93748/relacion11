package ejercicio3;

import java.time.LocalDateTime;
import java.util.Objects;

public class VisitaPaginaWeb {
	
	private String url;
	private LocalDateTime fecha;
	
	
	public VisitaPaginaWeb(String url) throws VisitaPaginaWebException{
		this.url = url;
		this.fecha = LocalDateTime.now();
	}


	public String getUrl() {
		return url;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	@Override
	public String toString() {
		return url + "\t \t" + fecha;
	}


	@Override
	public int hashCode() {
		return Objects.hash(url);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VisitaPaginaWeb other = (VisitaPaginaWeb) obj;
		return Objects.equals(url, other.url);
	}
	
	
	
	

}
