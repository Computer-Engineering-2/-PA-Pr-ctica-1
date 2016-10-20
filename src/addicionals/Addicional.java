package addicionals;

import empresa.Article;

public class Addicional extends Article {
	private String marcaComercial;
	private int proveidor;
	
	public Addicional(int codi, float preuCost, float preuPublic, String nom, String marcaComercial, int proveidor){
		super(codi, preuCost, preuPublic, nom);
		this.marcaComercial = marcaComercial;
		this.proveidor = proveidor;
	}
	public Addicional(int codi,float preuCost,float preuPublic, String marcaComercial, int proveidor){
		super(codi, preuCost, preuPublic);
		this.marcaComercial = marcaComercial;
		this.proveidor = proveidor;
	}
	public String toString(){
		return (super.toString()+"	Article addicional: Marca Comercial:"+marcaComercial+", Proveidor nº:"+proveidor+"\n");
	}
	
	//Mètodes get i set
	public String getMarcaComercial(){return marcaComercial;}
	public int getProveidor(){return proveidor;}
	public void setMarcaComercial(String marcaComercial){this.marcaComercial = marcaComercial;}
	public void setProveidor(int proveidor){this.proveidor = proveidor;}
}
