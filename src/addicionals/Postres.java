package addicionals;

public class Postres extends Addicional{
	private boolean cullera;
	private boolean esFred;
	
	public Postres(int codi, float preuCost, float preuPublic, String nom, String marcaComercial, int proveidor, boolean cullera, boolean esFred){
		super(codi, preuCost, preuPublic, nom, marcaComercial, proveidor);
		this.cullera = cullera;
		this.esFred = esFred;
	}
	public Postres(int codi, float preuCost, float preuPublic, String marcaComercial, int proveidor, boolean cullera, boolean esFred){
		super(codi, preuCost, preuPublic, marcaComercial, proveidor);
		this.cullera = cullera;
		this.esFred = esFred;
	}
	public String toString(){
		return (super.toString()+"		Postre: Cullera:"+cullera+", Es fred?:"+esFred);
	}
	
	//Mètodes get i set
	public boolean getcullera(){return cullera;}
	public boolean teesFred(){return esFred;}
	public void setcullera(boolean cullera){this.cullera = cullera;}
	public void setesFred(boolean esFred){this.esFred = esFred;}
}
