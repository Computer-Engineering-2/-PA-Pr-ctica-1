package propis;

import empresa.Article;
import empresa.Ingredient;


public class Propi extends Article{
	private Node ingredients;
	public Propi (int codi, float preuCost, float preuPublic, String nom){
		super(codi, preuCost, preuPublic, nom);
	}
	
	public Propi (int codi, float preuCost, float preuPublic){
		super(codi, preuCost, preuPublic);
	}
		
	class Node { //linial i sense capçalera
		private Ingredient ing;
		private float quantitat;
		private Node seg;
		public Node(Ingredient ing, float q, Node seg){
			this.ing = ing;
			this.quantitat = q;
			this.seg = seg;
		}
		public Node(Ingredient ing, float q){
			this(ing, q, null);
		}
	}
	
	public void visualitzarIngredients(){
		Node aux=ingredients;
		while(aux!=null){
			System.out.println(" > " + aux.ing.toString());
			aux=aux.seg;
		}
	}
	public void addIngredients(Ingredient ing,float q) throws Exception{
		if(ing==null) throw new NullPointerException("L'ingredient no està definit");
		if(this.teIngredient(ing)) throw new Exception("L'ingredent ja existeix en el propi");
		
		if(ingredients==null) ingredients=new Node(ing,q);
		else{
		Node aux=ingredients;
		while(aux.seg!=null){
			aux=aux.seg;
		}
		aux.seg=new Node(ing,q);
		}
	}

	public void remIngredient(Ingredient ing) {
		if (ing == null)
			throw new NullPointerException("L'ingredient no està definit");

		if (ingredients.equals(ing))
			ingredients.seg = ingredients.seg;
		else {
			Node aux = ingredients;
			while (aux.seg != null) {
				if (aux.seg.ing.equals(ing)) {
					if (aux.seg.seg != null)
						aux.seg = aux.seg.seg;
					else
						aux.seg = null;
				}
				aux = aux.seg;
			}
		}
		 
	}
	
	public boolean teIngredient(Ingredient ing){
		if(ing==null) throw new NullPointerException("L'ingredient no està definit");
		Node aux=ingredients;
			while(aux!=null){
				if(aux.ing.equals(ing)) return true;
				aux=aux.seg;
			}
		 return false;
    }
	
	public void augmentarQuantitat(int unitats){
		Node aux=ingredients;
		while(aux!=null){
			if(aux.quantitat<10) aux.quantitat+=unitats;
			aux=aux.seg;
		}
	}

	public void eliminarIngredients() throws Exception{
		Node aux=ingredients;
		Node a,b;	
		if(aux.seg==null&&aux.seg.seg==null) throw new Exception("Hi han menys de 2 Ingredients");	
			a=aux;
			b=aux.seg;
			aux=aux.seg.seg;
			
			while(aux.seg!=null){
				if(aux.seg.quantitat<a.seg.quantitat && aux.seg.quantitat<b.seg.quantitat)a=aux; // Es guarda l'anterior al que es vol eliminar. S'ha de vigilar que no s'elimini un valor de a inferior al valor b.
				else if(aux.seg.quantitat<b.seg.quantitat) b=aux;
				aux=aux.seg;
			}
		
			if(a.seg.seg!=null) a.seg=a.seg.seg; // Si després del qual es vol eliminar hi ha un altre, s'uneix l'anterior amb aquest. En cas contrari es posa null (final de la seqüencia)
			else a.seg=null;
			if(b.seg.seg!=null) b.seg=b.seg.seg;
			else b.seg=null;
	}

	public void ingredientsMesQuantitat() throws Exception{
		Node aux=ingredients;
		Node a,b,c;
		
		if(aux==null || aux.seg==null || aux.seg.seg==null) throw new Exception("Hi han menys de 3 Ingredients");
			
			a=aux;
			b=aux.seg;
			c=aux.seg.seg;
			aux=aux.seg.seg.seg;
			
			while(aux!=null){
				if(aux.quantitat>a.quantitat && aux.quantitat>b.quantitat && aux.quantitat>c.quantitat)a=aux; // Ara es guarda el node amb l'ingredient objectiu
				else if(aux.quantitat>b.quantitat && aux.quantitat>b.quantitat) b=aux;
				else if(aux.quantitat>c.quantitat)c=aux;
				aux=aux.seg;
				
			}
		
			System.out.println(a.ing + " | Quantitat= "+a.quantitat);
			System.out.println(b.ing + " | Quantitat= "+b.quantitat);
			System.out.println(c.ing + " | Quantitat= "+c.quantitat);
	}
	
	public String toString(){
		String output = super.toString()+"	Article Propi: Ingredients: \n";
		Node aux=ingredients;
		while(aux!=null){
			output += "			Nom:"+aux.ing+", Q:"+aux.quantitat+"\n";
			aux=aux.seg;
		}
		return output;
	}
	
	
	//Mètodes set i get
	public Ingredient[] getIngredients(){
		int cont=0;
		Node aux=ingredients;
		while(aux.seg!=null){
			cont++;
			aux=aux.seg;
		}
		
		Ingredient[] ings = new Ingredient[cont];
		aux=ingredients;
		int i=0;
		while(aux.seg!=null){
			ings[i] = aux.ing;
			aux=aux.seg;
			i++;
		}
		return ings;
	}
}


