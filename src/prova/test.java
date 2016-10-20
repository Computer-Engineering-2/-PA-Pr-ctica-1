package prova;
import propis.*;
import empresa.*;

public class test{
	public static void main(String[] args) {
			
		Propi bocadillo=new Entrepa(102,(float)5.2,(float)8.0,"Bocadillo de Albondigas",1,true);
		
		try{
		bocadillo.addIngredients(new Ingredient(1,1,"Pa"),(float)1.0);
		bocadillo.addIngredients(new Ingredient(2,1,"Formatge"),(float)3.0);
		bocadillo.addIngredients(new Ingredient(3,1,"Albondigas"),(float)4.0);
		bocadillo.addIngredients(new Ingredient(4,1,"Lechuga"),(float)2.0);
		bocadillo.addIngredients(new Ingredient(5,1,"Arroz"),(float)2.0);
		bocadillo.addIngredients(new Ingredient(6,1,"Patatas"),(float)12.0);
		bocadillo.addIngredients(new Ingredient(7,1,"Jamon"),(float)1.0);
		bocadillo.addIngredients(new Ingredient(8,1,"Bacon"),(float)5.0);
		
		}
		catch(Exception e){e.printStackTrace();}
		
		bocadillo.visualitzarIngredients();
		
		System.out.println("");
		
		try{bocadillo.ingredientsMesQuantitat();
		}
		catch(Exception e) {e.printStackTrace();}
		
		System.out.println("");
		
		Ingredient arroz=new Ingredient(5,1,"Arroz");
		
		if(bocadillo.teIngredient(new Ingredient(5,1,"Arroz"))){ // Si hay arroz, lo eliminamos
			bocadillo.remIngredient(arroz);
			if(!(bocadillo.teIngredient(new Ingredient(5,1,"Arroz"))))System.out.println("Arroz Eliminado"); // Volvemos a comprobar si hay arroz y se ha eliminado con éxito
		}
		
	}

}
