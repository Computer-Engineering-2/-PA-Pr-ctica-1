package empresa;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import addicionals.Addicional;
import propis.Propi;

public class Empresa {
	public Article [][]articles; 
	private int qPropis;
	private int qAddicionals;
	private List<Integer> proveidors;
	public Empresa(int numColumnes){
		qPropis = 0;
		qAddicionals = 0;
		articles = new Article [2][numColumnes]; //Propis fila 0, Addicionals fila 1
		proveidors = new LinkedList<Integer>();
	}
	
	public boolean addArticle(Article article) throws Exception {
		
		if (article == null)
			throw new IllegalArgumentException("l'article no pot ser null");
		
		if (article instanceof Propi) {
			for (int i = 0; i < qPropis; i++) {
				if (articles[0][i].equals(article))
					throw new Exception("article repetit");
			}

			if (qPropis >= articles[0].length)
				throw new Exception("Superat el limit de articles");
			articles[0][qPropis] = article;		
			qPropis++;
			Ingredient[] ingArticle = ((Propi) article).getIngredients();
			for (int i = 0; i < ingArticle.length; i++) {
				if (!(proveidors.contains(ingArticle[i].getProveidor())))
					proveidors.add(ingArticle[i].getProveidor());
			}
			return true;
		}
		
		if(article instanceof Addicional){

			for(int i=0;i<qAddicionals;i++){
				if(articles[1][i].equals(article))throw new Exception("article repetit");
			}
			if(qAddicionals>=articles[1].length)throw new Exception("Superat el limit de articles");
			articles[1][qAddicionals] = article;
		  	qAddicionals++;
		  	int proveidor = ((Addicional) article).getProveidor();
		  	if(!(proveidors.contains(proveidor)))proveidors.add(proveidor);
		  
		  	return true;
		}
		return false;
	}
	public boolean remArticle(Article article) throws Exception{
		if(article==null) throw new IllegalArgumentException("l'article no pot ser null");
		if(article instanceof Propi){
			for(int i=0;i<qPropis;i++){
				if(articles[0][i].equals(article)){
					articles[0][i]=null;
					return true;
				}
			}
			throw new Exception("L'article no s'ha trobat en el magatzem");
		}
		else if(article instanceof Addicional){
			for(int i=0;i<qAddicionals;i++){
				if(articles[1][i].equals(article)){
					articles[0][i]=null;
					return true;
				}
			}
			throw new Exception("L'article no s'ha trobat en el magatzem");
		}
		else return false;
	}
	public void llistatTotsArticles(){
		for(int i=0;i<qPropis;i++)System.out.println(articles[0][i].toString());
		for(int i=0;i<qAddicionals;i++)System.out.println(articles[1][i].toString());
	}
	public void millorBenefici(){
		Article[] millors = new Article[5];
		int[] millorsNum = new int[5];
		for(int i=0;i<5;i++) millorsNum[i] = 0;
		for(int i=0;i<qPropis;i++){
			for(int j=0;j<5;j++){
				if(articles[0][i].percentatgeGanancia()>millorsNum[j]) millors[j] = articles[0][i];
			}
		}
		for(int i=0;i<5;i++)System.out.println(millors[i]);
	}
	public boolean teArticle(int codi){
		for(int i=0;i<qPropis;i++){
			if(articles[0][i].equals(codi)) return true;
		}
		for(int i=0;i<qAddicionals;i++){
			if(articles[1][i].equals(codi)) return true;
		}
		return false;
	}
	public int quantsPropis(Ingredient ing){
		int quants = 0;
		for(int i=0;i<qPropis;i++){
			if(articles[0][i].equals(ing)) quants++;
		}
		return quants;
	}
	public void addProveidor(int codi) throws Exception{
		if(proveidors.contains(codi)) throw new Exception("El proveidor ja esta registrat");
		proveidors.add(codi);
	}
	public void remProveidor(int codi) throws Exception{
		if(proveidors.contains(codi)) proveidors.remove(codi); 
		else throw new Exception("El codi no coincideix amb cap proveidor");
	}
	public Map<Integer,Integer> productesProveidors(){
		Map<Integer,Integer> productes = new HashMap<Integer,Integer>();
		Iterator<Integer> it=proveidors.iterator();
		while(it.hasNext()){
			int numProv = 0;
			for(int i=0;i<qAddicionals;i++){
				if(((Addicional) articles[1][i]).getProveidor()==it.next()) numProv++;
			}
			productes.put(it.next(),numProv);
		}
		return productes;
	}
	
	//Mètodes Get
	public int getqPropis(){return qPropis;}
	public int getqAddicionals(){return qAddicionals;}
	public List<Integer> getProveidors(){return proveidors;}
}