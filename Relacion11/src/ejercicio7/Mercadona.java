package ejercicio7;

import java.util.ArrayList;
import java.util.Iterator;

public class Mercadona {

	private static final int NUMERO_CAJAS = 20;
	private ArrayList<Caja> cajasMercadona;

	public Mercadona() {
		cajasMercadona = new ArrayList<Caja>();
	}

	public void crearCajas(int numeroCajas) {
		for (int i = 0; i < numeroCajas; i++) {
			cajasMercadona.add(new Caja(i + 1));
		}
	}

	public void abrirCaja(int numeroCaja) throws CajaException {
		if(numeroCaja<1||numeroCaja>NUMERO_CAJAS) {
			throw new CajaException("Esa caja no existe");
		}
		cajasMercadona.get(numeroCaja - 1).abrirCaja();
	}

	public void cerrarCaja(int numeroCaja) throws CajaException {
		if(numeroCaja<1||numeroCaja>NUMERO_CAJAS) {
			throw new CajaException("Esa caja no existe");
		}
		cajasMercadona.get(numeroCaja - 1).cerrarCaja();
	}

	public String nuevoCliente() throws CajaException {
		Iterator<Caja> it = cajasMercadona.iterator();
		Caja cajaMasVacia = null;
		int numeroCliente;
		int numeroClientesCajaMasVacia=Integer.MAX_VALUE;
		
		while (it.hasNext()) {
			Caja caja = (Caja) it.next();
			if (caja.getNumeroClientes() < numeroClientesCajaMasVacia && caja.isAbierta()) {
				cajaMasVacia = caja;
				numeroClientesCajaMasVacia=cajaMasVacia.getNumeroClientes();
			}
		}
		
		if(cajaMasVacia == null) {
			throw new CajaException("Todos las cajas estan cerradas");
		}
		
		
		numeroCliente=cajaMasVacia.annadirCliente();

		return "Es usted el cliente "+numeroCliente+" y debe ir a la caja numero "+cajaMasVacia.getNumeroCaja();
	}

	public int atenderCliente(int numeroCaja) throws CajaException {
		Caja cajaAtender = cajasMercadona.get(numeroCaja - 1);

		return cajaAtender.atenderCliente();
	}
}
