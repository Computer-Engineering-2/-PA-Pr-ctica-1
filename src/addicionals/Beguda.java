package addicionals;

public class Beguda extends Addicional {
	private boolean teGas;
	private boolean teAlcohol;
	
	public Beguda(int codi, float preuCost, float preuPublic, String nom, String marcaComercial, int proveidor, boolean teGas, boolean teAlcohol){
		super(codi, preuCost, preuPublic, nom, marcaComercial, proveidor);
		this.teGas = teGas;
		this.teAlcohol = teAlcohol;
	}
	public Beguda(int codi, float preuCost, float preuPublic, String marcaComercial, int proveidor, boolean teGas, boolean teAlcohol){
		super(codi, preuCost, preuPublic, marcaComercial, proveidor);
		this.teGas = teGas;
		this.teAlcohol = teAlcohol;
	}
	public String toString(){
		return (super.toString()+"		Beguda: Te Gas?:"+teGas+", Te Alcohol?:"+teAlcohol);
	}
	
	//Mètodes get i set
	public boolean getTeGas(){return teGas;}
	public boolean teTeAlcohol(){return teAlcohol;}
	public void setTeGas(boolean teGas){this.teGas = teGas;}
	public void setTeAlcohol(boolean teAlcohol){this.teAlcohol = teAlcohol;}
}
