package ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Historial {

	private ArrayList<VisitaPaginaWeb> historial;

	public Historial() {
		this.historial = new ArrayList<VisitaPaginaWeb>();
	}

	public void annadirNuevaVisitaPaginaWeb(VisitaPaginaWeb pagina) throws VisitaPaginaWebException {
		if (historial.size() >= 1) {
			if (pagina.getFecha().isBefore(historial.get(historial.size() - 1).getFecha())) {
				throw new VisitaPaginaWebException(
						"La fecha de la nueva pagina no puede ser anterior a la fecha de la ultima apgina visitada");
			}
		}

		historial.add(pagina);

	}

	public void borrarHistorial() {
		historial.clear();
	}

	public void borrarHistorialDeUnDia(LocalDate fecha) {
		Iterator<VisitaPaginaWeb> it = historial.iterator();
		VisitaPaginaWeb paginaActual;
		
		while(it.hasNext()) {
			paginaActual=it.next();
			if(paginaActual.getFecha().toLocalDate().equals(fecha)) {
				it.remove();
			}
		}
	}

	public void borrarVisitasPagina(String url) {
		Iterator<VisitaPaginaWeb> it = historial.iterator();
		VisitaPaginaWeb paginaActual;
		
		while(it.hasNext()) {
			paginaActual=it.next();
			if(paginaActual.getUrl().equals(url)) {
				it.remove();
			}
		}
	}

	public int numeroDeVisitasPagina(String url) {
		int visitasTotales=0;
		Iterator<VisitaPaginaWeb> it = historial.iterator();
		VisitaPaginaWeb paginaActual;
		
		while(it.hasNext()) {
			paginaActual=it.next();
			if(paginaActual.getUrl().equals(url)) {
				visitasTotales++;
			}
		}
		
		return visitasTotales;
	}

	public String consultarHistorialPorDia(LocalDate fecha) {
		StringBuilder sb = new StringBuilder();
		Iterator<VisitaPaginaWeb> it = historial.iterator();
		VisitaPaginaWeb paginaActual;

		sb.append("Historial " + fecha + ": \n");

		while (it.hasNext()) {
			paginaActual = it.next();
			if (paginaActual.getFecha().toLocalDate().equals(fecha)) {
				sb.append(paginaActual + "\n");
			}
		}

		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Historial: \n");

		for (int i = historial.size() - 1; i >= 0; i--) {
			sb.append(historial.get(i) + "\n");
		}
		return sb.toString();
	}

}
