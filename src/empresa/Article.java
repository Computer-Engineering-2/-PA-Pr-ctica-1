package empresa;

public class Article {
	private int codi;
	private float preuCost;
	private float preuPublic;
	private String nom;
	
	public Article(int codi, float preuCost, float preuPublic, String nom){
		this.codi = codi;
		this.preuCost = preuCost;
		this.preuPublic = preuPublic;
		this.nom = nom;
	}
	public Article(int codi,float preuCost,float preuPublic){
		this.codi=codi;
		this.preuCost=preuCost;
		this.preuPublic=preuPublic;
		this.nom="Indefinit";
	}
	public String toString(){
		return "Article nº "+this.codi+": Nom:"+this.nom+", preuCost: "+preuCost+", preuPublic: "+preuPublic+"\n";
	}
	public boolean equals(Object o){
		if(!(o instanceof Article)) return false;
		return this.codi==((Article)o).codi;
	}
	public float percentatgeGanancia(){
		return preuPublic/preuCost*100;
	}
	
	//Mètodes get i set
	public int getCodi(){return codi;}
	public float getPreuCost(){return preuCost;}
	public float getPreuPublic(){return preuPublic;}
	public String getNom(){return nom;}
	public void setCodi(int codi){this.codi = codi;}
	public void setPreuCost(float preuCost){this.preuCost = preuCost;}
	public void setPreuPublic(float preuPublic){this.preuCost = preuPublic;}
	public void setNom(String nom){this.nom = nom;}
}
