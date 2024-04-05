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

		for (int i = historial.size()-1; i <= 0; i--) {
			sb.append(historial.get(i)+"\n");
		}
		return sb.toString();
	}

}
