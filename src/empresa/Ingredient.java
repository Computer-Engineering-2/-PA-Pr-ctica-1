package empresa;

public class Ingredient {
	int codi;
	String nom;
	int proveidor;
	public Ingredient(int codi, int proveidor, String nom){
		this.codi = codi;
		this.nom = nom;
		this.proveidor = proveidor;
	}
	public Ingredient(int codi, int proveidor){
		this(codi, proveidor,"");
	}
	
	public String toString(){
		return "Ingredient nº "+this.codi+": Nom:"+this.nom+", nº proveidor: "+proveidor;
	}
	public boolean equals(Object o){
		if(!(o instanceof Ingredient)) throw new IllegalArgumentException("S'ha intentat comparar un Ingredient amb un objecte incompatible");
		return ((Ingredient)o).codi==this.codi;
	}
	//Mètodes get i set
	public int getCodi(){return codi;}
	public String getNom(){return nom;}
	public int getProveidor(){return proveidor;}
	public void setCodi(int codi){this.codi = codi;}
	public void setNom(String nom){
		if(nom==null) throw new IllegalArgumentException("Nom d'ingredient nul");
		this.nom=nom;
	}
	public void setProveidor(int proveidor){this.proveidor = proveidor;}
}
