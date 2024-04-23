package ejercicio7;

import java.util.LinkedList;

public class Caja {

	private int numeroCaja;
	private boolean abierta;
	private LinkedList<Integer> cola;
	
	private static int ultimoNumero=0; 
	
	public Caja(int numeroCaja)  {
		this.numeroCaja=numeroCaja;
		this.abierta=false;
		cola= new LinkedList<Integer>();
		
	}
	
	
	public int getNumeroCaja() {
		return numeroCaja;
	}
	
	public int getNumeroClientes() {
		return cola.size();
	}


	public boolean isAbierta() {
		return abierta;
	}


	public void abrirCaja() throws CajaException {
		if(this.abierta==true) {
			throw new CajaException("La caja ya esta abierta");
		}
		
		this.abierta=true;
	}
	
	public void cerrarCaja() throws CajaException {
		if(this.abierta==false) {
			throw new CajaException("La caja ya esta cerrada");
		}
		if(cola.size()>0) {
			throw new CajaException("La caja aun tiene clientes esperando");
		}
		
		this.abierta=false;
	}
	
	public String annadirCliente() throws CajaException {
		if(this.abierta==false) {
			throw new CajaException("La caja esta cerrada");
		}
		
		cola.add(ultimoNumero+1);
		ultimoNumero=ultimoNumero+1;
		
		return "Es usted el cliente número "+ultimoNumero+" y debe ir a la caja número "+this.numeroCaja;
	}
	
	public String atenderCliente() throws CajaException {
		if(this.abierta==false) {
			throw new CajaException("La caja esta cerrada");
		}
		if(cola.size()==0) {
			throw new CajaException("No hay clientes en la cola");
		}
		
		Integer clienteAtendido=cola.remove(0);
		
		return "Se ha atendido al cliente con número "+clienteAtendido;
	}
	
	
}
