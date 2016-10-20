package prova;

import addicionals.Addicional;
import empresa.Empresa;
import empresa.Ingredient;
import propis.Propi;

public class Prova {

	public static void main(String[] args) {
		//Articles addicionals proveidor nº100
		System.out.println("Articles addicionals amb proveidor nº100");
		Addicional[] addicionals = new Addicional[5];
		
		for(int i=0;i<5;i++) {
			addicionals[i] = new Addicional(i, 20, 30, "hacendado", 100);
			System.out.println(addicionals[i].toString());
		}
		System.out.println("-------------------------------------");
		
		//Articles propi proveidor nº200
		System.out.println("Articles addicionals amb (ingredients) proveits nº200");
		Propi[] propis = new Propi[5];
		for(int i=0;i<5;i++) {
			propis[i] = new Propi(i, 20, 30, "pizzahut");
			try{propis[i].addIngredients(new Ingredient(i, 200), 10);}
			catch(Exception e){e.printStackTrace();}
			System.out.println(propis[i].toString());
		}
		System.out.println("-------------------------------------");		
		System.out.println("Empresa: ");
		
		//Empresa amb els addicionals
		
		Empresa empresa = new Empresa(5);
		
		try{
			empresa.addArticle(addicionals[0]);
			empresa.llistatTotsArticles();
		}catch(Exception e){System.out.println(e);
		e.printStackTrace();
		}
	}

}
