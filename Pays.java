
public class Pays {
	private String nom;
	private String langue;
	private String monnaie;
	private String capitale;
	private static int compteurPays=0;
	private Capital maCapital;
	/**
	 * @see
	 */
	private Ville[] mesVilles;
	private int MaxNbrVille=3; //nombre de case
	
	private int compteurVille; //compteur de case


	public Pays(){
		this.mesVilles = new Ville[this.MaxNbrVille];
		this.compteurVille = 0;
		this.compteurPays++;
	}
	
	public Pays(String unNom, String uneLangue, String uneMonnaie, String uneCapitale, Capital maCapital){
		this.nom = unNom;
		this.langue = uneLangue;
		this.monnaie = uneMonnaie;
		this.capitale = uneCapitale;
		this.mesVilles = new Ville[this.MaxNbrVille];
		this.compteurVille = 0;
		this.compteurPays++;
		this.maCapital = maCapital;
	}
	public Pays(String unNom, String uneLangue, String uneMonnaie, String uneCapitale){
		this.nom = unNom;
		this.langue = uneLangue;
		this.monnaie = uneMonnaie;
		this.capitale = uneCapitale;
		this.mesVilles = new Ville[this.MaxNbrVille];
		this.compteurVille = 0;
		this.compteurPays++;
		this.maCapital = null;
	}
	public int getMaxNbrVille() {
		return MaxNbrVille;
	}

	public void setMaxNbrVille(int maxNbrVille) {
		MaxNbrVille = maxNbrVille;
	}
	public Ville[] getMesVilles() {
		return mesVilles;
	}
	public void setMesVilles(Ville[] mesVilles) {
		this.mesVilles = mesVilles;
	}
	public int getCompteurVille() {
		return compteurVille;
	}
	public void setCompteurVille(int compteurVille) {
		this.compteurVille = compteurVille;
	}
	public Capital getMaCapital() {
		return maCapital;
	}
	public void setMaCapital(Capital maCapital) {
		this.maCapital = maCapital;
	}
	//eclipse ->source ->generate getters setteer
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getMonnaie() {
		return monnaie;
	}

	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}

	public String getCapitale() {
		return capitale;
	}

	public void setCapitale(String capitale) {
		this.capitale = capitale;
	}
	//affiche toute les ville dans le tableau
	/**

     * 

     * 

     * @return Une instance de Vile, qui correspond à une ville.

     */
	public Ville afficheUneVille(int i){
		Ville val = null;
		if(i<this.compteurVille && i>=0){
			val = mesVilles[i];
		}
		return val;
	}
	/**
	 * @param level
	 */
	public void ajoutVille(Ville uneVille){
		if(this.compteurVille<this.MaxNbrVille){//verification que le compteur na dépace pas le nombre de case 
			this.mesVilles[this.compteurVille] = uneVille;
			this.compteurVille++;
		}
	}
	public String majNom(){
		return this.nom.toUpperCase();
	}
	private String changeNom(){
		return this.nom.substring(0,1).toUpperCase()+this.nom.substring(1).toLowerCase(); //trnsformation la premiere lettre en majuscule le reste en minuscule
	}
	public static int getCompteurPays(){
		return compteurPays;
	}
	public String toString(){
		String chaine="________________________________________________\n";
		chaine+="nom: "+this.getNom()+"\n";
		chaine+="langue: "+this.getLangue()+"\n";
		chaine+="monnaie: "+this.getMonnaie()+"\n";
		chaine+="capital: "+this.getCapitale()+"\n";
		if(this.maCapital!=null){
			chaine+="<--Capital-->\n";
			chaine+=this.maCapital.toString()+"\n";
		}else{
			chaine+="<--Capital-->\n";
			chaine+="===>inconnue\n\n";
		}
		for(int i=0;i<this.compteurVille;i++){
			chaine+="<--Ville-->\n";
			chaine+=this.afficheUneVille(i).toString()+"\n";
		}
		
		return chaine+"\n";
	}
}
