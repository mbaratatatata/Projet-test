
public class Capital {
	private String nom;
	private int nbhab;
	private int superficie;
	public Capital(String unNom, int unNbhab, int uneSuperficie){
		this.nom = unNom;
		this.nbhab = unNbhab;
		this.superficie = uneSuperficie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNbhab() {
		return nbhab;
	}
	public void setNbhab(int nbhab) {
		this.nbhab = nbhab;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	public String toString(){
		String chaine="\n";
		chaine+="nom: "+this.nom+"\n";
		chaine+="nombre habitants: "+this.nbhab+"\n";
		chaine+="superficie: "+this.superficie+"\n";
		return chaine;
	}
}
