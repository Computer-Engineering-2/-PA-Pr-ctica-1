package propis;

public class Entrepa extends Propi{
	int tipusPa;
	boolean esCalent;
	
	public Entrepa(int codi, float preuCost, float preuPublic, String nom, int tipusPa, boolean esCalent){
		super(codi,preuCost,preuPublic,nom);
		this.tipusPa=tipusPa;
		this.esCalent=esCalent;
	}
	
	public Entrepa(int codi, float preuCost, float preuPublic, float q, int tipusPa, boolean esCalent){	
		super(codi, preuCost, preuPublic);
		this.tipusPa=tipusPa;
		this.esCalent=esCalent;
	}
	public String toString(){
		return (super.toString()+" 	Entrepa: Tipus pa:"+tipusPa+", Es calent?:"+esCalent);
	}
	
	
	//Mètodes set i get
	public int getTipusMassa(){return tipusPa;}
	public boolean getEsCalent(){return esCalent;}
	public void setTipusMassa(int tipusPa){this.tipusPa=tipusPa;}
	public void setEsCalent(boolean esCalent){this.esCalent=esCalent;}
}
