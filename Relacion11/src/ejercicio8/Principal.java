package ejercicio8;

public class Principal {

	public static void main(String[] args) {
		Recetario recetario1=new Recetario();
		Ingrediente ingrediente1 = new Ingrediente("Sal");
		Ingrediente ingrediente2 = new Ingrediente("Agua");
		Receta receta1;
		
		try {
		receta1= new Receta("Aguasal", 1);
		receta1.annadirIngrediente(ingrediente1);
		receta1.annadirIngrediente(ingrediente2);
		receta1.annadirPasoAlFinal("Echar la sal al agua");
		receta1.annadirPasoAlFinal("Remover");
		recetario1.annadirReceta(receta1);
		System.out.println(recetario1.listadoRecetasOrdenadasAlfabeticamente());
		}catch(RecetaException e) {
			System.out.println(e.getMessage());
		}
	}

}
