package appli;
import joueur.Joueur;
/*30/03/21*/
import plateau.Plateau;
/* NON */


/*Vérification*/
public class Application {
	
	

	public static boolean EstFinie() {
		return true;
	}
	
	public static void main(String[] args) {
		Plateau plat = new Plateau();
		Joueur j1 = new Joueur(1, true);
		Joueur j2 = new Joueur(5, true);
		j1.ajoutRoi(plat, 2, 4, false);
		/*j1.ajoutFou(plat, 3, 3, false);
		j1.ajoutFou(plat, 3, 5, false);
		j1.ajoutTour(plat, 3, 2, false);
		j1.ajoutTour(plat, 3, 6, false);*/
		j2.ajoutRoi(plat, 5, 6, true);
		j2.ajoutFou(plat, 6, 6, true);
		j2.ajoutFou(plat, 6, 8, true);
		j2.ajoutTour(plat, 2, 1, true);
		j2.ajoutTour(plat, 5, 3, true);
		
		do {
			 do{
				 System.out.println("C'est aux petites lettres");
				 System.out.print(plat);
				j1.jouer(plat,j2);
				if(j2.EstEchecEtMat(j1)) {
					System.out.print("Echec !");
				}
			}while(j1.EstTour());
			do{
				System.out.println("C'est aux grandes lettres");
				System.out.print(plat);
				j2.jouer(plat, j1);
				if(j1.EstEchecEtMat(j2) || j2.EstEchecEtMat(j1)) {
					System.out.print("Echec !");
				};
			}while(j2.EstTour());
		
		}while(EstFinie());
	}
}
