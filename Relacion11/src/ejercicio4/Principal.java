package ejercicio4;

public class Principal {

	public static void main(String[] args) {
		try {
			Alumno alumno1 = new Alumno("11", "Joan", 15, TipoEnsennanza.ESO, 3);
			Alumno alumno2 = new Alumno("22", "Pepe", 16, TipoEnsennanza.ESO, 3);
			Profesor profesor1 = new Profesor("111", "Pedro", 26);
			Profesor profesor2 = new Profesor("111", "Manuel", 31, 2);

			alumno1.enviarMensaje(profesor2,"Saludo", "Buen dia");
			alumno2.enviarMensaje(profesor2,"Peticion", "Subeme la nota");
			//alumno1.enviarMensaje(alumno1, "Que pasa");
			alumno2.enviarMensaje(profesor2,"Enfado", "eres un notas");
			System.out.println(profesor2.mostrarMensajes());
			System.out.println("--------------------");
			System.out.println(profesor2.leerMensaje(2));
			System.out.println("--------------------");
			System.out.println(profesor2.mostrarMensajes());
			//System.out.println(profesor2.buscarFrase("nota"));
			//System.out.println(profesor2.mostrarMensajesOrdenadosRemitente());
			//profesor2.borrarMensaje(1);
			//System.out.println(profesor2.mostrarMensajes());
		} catch (IESException e) {
			System.out.println(e.getMessage());
		}
	}

}
