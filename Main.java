import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pays[] mesPays;
		int entrer, choix;
		mesPays = new Pays[3];
		Scanner clavier = new Scanner(System.in);
		
		mesPays[0] = new Pays("france", "français", "paris", "euro", new Capital("Paris", 2000000, 105));
		mesPays[1] = new Pays("portugal", "portugais", "lisbonne", "euro");
		mesPays[2] =  new Pays("Allemagne", "allemand", "berlin", "euro", new Capital("berlin", 3452911, 891));
		
		mesPays[0].ajoutVille(new Ville("Paris", 2000000, 105));
		mesPays[0].ajoutVille(new Ville("vigneux-sur-seine", 20000, 50));
		mesPays[0].ajoutVille(new Ville("Evry", 80, 8));
		
		mesPays[1].ajoutVille(new Ville("Cambas", 200, 10));
		mesPays[1].setMaCapital(new Capital("lisbonne", 530847, 84));
		
		mesPays[2].ajoutVille(new Ville("Hambourg", 1746342, 755));
		
		
		do{
			menu(mesPays);
			entrer = clavier.nextInt();
			while(entrer<0 || entrer>mesPays.length){
				System.out.println("--erreur");
				menu(mesPays);
				entrer = clavier.nextInt();
			}
			if(entrer!=0){
				choix = entrer-1;
				do{
					sousMenu(mesPays[choix]);
					entrer = clavier.nextInt();
					while(entrer<0 || entrer>3){
						System.out.println("===>--erreur");
						sousMenu(mesPays[choix]);
						entrer = clavier.nextInt();
					}
					switch(entrer){
						case 1:
							ajoutVille(mesPays[choix]);
							break;
						case 2:
							recherche(mesPays[choix]);
							break;
						case 3:
							supprimer(mesPays[choix]);
							break;
					}
				}while(entrer!=0);
				entrer=1;
			}
		}while(entrer!=0);
		System.out.print(mesPays[0].toString());
		System.out.print(mesPays[1].toString());
		System.out.print(mesPays[2].toString());
		System.out.print(Pays.getCompteurPays()+" Pays");
	}
	public static void menu(Pays[] mesPays){
		System.out.println("Veuillez choisir un pays.");
		System.out.println("taper(0) pour quitter");
		for(int i=0;i<mesPays.length;i++){
			System.out.println("taper("+(1+i)+") "+mesPays[i].getNom());
		}	
	}
	public static void sousMenu(Pays monPays){
		System.out.println("===>Vous avez choisie "+monPays.getNom()+" avec ses "+monPays.getCompteurVille()+" ville(s)");
		System.out.println("===>taper(0) pour quitter");
		System.out.println("===>taper(1) pour ajouter une ville");
		System.out.println("===>taper(2) pour rechercher une ville");
		System.out.println("===>taper(3) pour supprimer une ville");
		
	}
	public static void ajoutVille(Pays monPays){
		Scanner clavier = new Scanner(System.in);
	
		String nomVille;
		int hab, sup;
		if(monPays.getCompteurVille()<monPays.getMaxNbrVille()){
			System.out.print("======>nom: ");
			nomVille = clavier.nextLine();
			while(nomVille.equals("")){
				System.out.println("======>erreur");
				System.out.print("======>nom: ");
				nomVille = clavier.nextLine();
			}
			System.out.print("======>habitant: ");
			hab = clavier.nextInt();
			while(hab==0){
				System.out.println("======>erreur");
				System.out.print("======>habitant: ");
				hab = clavier.nextInt();
			}
			System.out.print("======>supperficie: ");
			sup = clavier.nextInt();
			while(sup==0){
				System.out.println("======>erreur");
				System.out.print("======>supperficie: ");
				sup = clavier.nextInt();
			}
			monPays.ajoutVille(new Ville(nomVille, hab, sup));
			System.out.println("ville ajouter");
		}else{
			System.out.println("plus place");
		}
	}
	
	public static void recherche(Pays monPays){
		Scanner clavier = new Scanner(System.in);
		String nomVille;
		int i;
		System.out.print("======>nom: ");
		nomVille = clavier.nextLine();
		i=0;
		while(i<monPays.getCompteurVille() && !nomVille.equals(monPays.getMesVilles()[i].getNom())){
			i++;
		}
		if(i<monPays.getCompteurVille()){
			System.out.println("======>nom=> "+monPays.getMesVilles()[i].getNom());
			System.out.println("======>habitant=> "+monPays.getMesVilles()[i].getNbhab());
			System.out.println("======>supperficie=> "+monPays.getMesVilles()[i].getSuperficie());
		}else{
			System.out.println("not found");
		}
	}
	public static void supprimer(Pays monPays){
		Scanner clavier = new Scanner(System.in);
		String nomVille;
		int i,y;
		Ville[] mesVille;
		
		System.out.print("======>nom: ");
		nomVille = clavier.nextLine();
		i=0;
		while(i<monPays.getCompteurVille() && !nomVille.equals(monPays.getMesVilles()[i].getNom())){
			i++;
		}
		if(i<monPays.getCompteurVille()){
			mesVille = 	monPays.getMesVilles();
			for(y=i;y<(monPays.getCompteurVille()-1);y++){
				mesVille[y] = monPays.getMesVilles()[y+1];
			}
			monPays.setCompteurVille((monPays.getCompteurVille()-1));
		}else{
			System.out.println("not found");
		}
	}
}
