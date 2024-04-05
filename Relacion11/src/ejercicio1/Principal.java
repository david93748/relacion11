package ejercicio1;

public class Principal {

	public static void main(String[] args) {
		Equipo equipo1;
		Equipo equipo2;
		Equipo equipo3;
		Equipo equipo4;
		
		equipo1=new Equipo("CD Alcalá");
		equipo2=new Equipo("Estrella San Agustín");
		
		try {
		equipo1.insertarAlumno(new Alumno("1","Pedro"));
		equipo1.insertarAlumno(new Alumno("2","Pato"));
		equipo1.insertarAlumno(new Alumno("3","Samu"));
		
		equipo2.insertarAlumno(new Alumno("4","Saul"));
		equipo2.insertarAlumno(new Alumno("5","Axel"));
		equipo2.insertarAlumno(new Alumno("6","Chino"));
		equipo2.insertarAlumno(new Alumno("7","Josue"));
		
		System.out.println(equipo1);
		System.out.println(equipo2);
		
		
		equipo2.borrarAlumno(new Alumno("7",null));
		
		System.out.println(equipo2);
		
		System.out.println(equipo1.buscarAlumno(new Alumno("1",null)));
		
		equipo2.insertarAlumno(new Alumno("3","Samu"));
		
		equipo3=equipo1.intersecionDeEquipos(equipo2, "Jugadores Alcala y Estrella");
		
		System.out.println(equipo3);
		
		equipo4=equipo1.fusionDeEquipos(equipo2, "CD Estrella-Alcalá San Agustín");
		
		System.out.println(equipo4);
		
		}catch(EquipoException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
