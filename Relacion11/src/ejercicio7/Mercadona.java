package ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;

public class Mercadona {

	private ArrayList<Caja> cajasMercadona;

	public Mercadona() {
		cajasMercadona = new ArrayList<Caja>();
	}
	
	public void crearCajas(int numeroCajas) {
		for (int i = 0; i < numeroCajas; i++) {
			cajasMercadona.add(new Caja(i+1));
		}
	}
	
	public String nuevoCliente() throws CajaException {
		Iterator<Caja> it=cajasMercadona.iterator();
		Caja cajaMasVacia=cajasMercadona.get(0);
		
		while (it.hasNext()) {
			Caja caja = (Caja) it.next();
			if(caja.getNumeroClientes()<cajaMasVacia.getNumeroClientes()) {
				cajaMasVacia=caja;
			}
		}
		
		return cajaMasVacia.annadirCliente();
	}
	
	public String atenderCliente(int numeroCaja) throws CajaException {
		Caja cajaAtender=cajasMercadona.get(numeroCaja-1);
		
		return cajaAtender.atenderCliente();
	}
}
