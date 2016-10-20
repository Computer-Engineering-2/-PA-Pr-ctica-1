package propis;


public class Pizza extends Propi {
	int tipusMassa;
	
	public Pizza(int codi,float preuCost,float preuPublic,String nom, int tipusMassa){
		super(codi,preuCost,preuPublic,nom);
		this.tipusMassa = tipusMassa;
	}
	
	public Pizza(int codi,float preuCost,float preuPublic, String nom, float q, int tipusMassa){	
		super(codi,preuCost,preuPublic);
		this.tipusMassa = tipusMassa;
	}
	public String toString(){
		return (super.toString()+" 	Pizza: Tipus massa:"+tipusMassa);
	}
	
	//Mètodes set i get
	public int getTipusMassa(){return tipusMassa;}
	public void setTipusMassa(int tipusMassa){this.tipusMassa=tipusMassa;}

}
