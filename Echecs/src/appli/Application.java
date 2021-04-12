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
		Joueur j1 = new Joueur(5, false);
		Joueur j2 = new Joueur(5, true);
		j1.ajoutRoi(plat, 2, 4, false);
		j1.ajoutFou(plat, 2, 3, false);
		j1.ajoutFou(plat, 2, 5, false);
		j1.ajoutTour(plat, 2, 2, false);
		j1.ajoutTour(plat, 2, 6, false);
		j2.ajoutRoi(plat, 7, 4, true);
		j2.ajoutFou(plat, 7, 3, true);
		j2.ajoutFou(plat, 7, 5, true);
		j2.ajoutTour(plat, 7, 2, true);
		j2.ajoutTour(plat, 7, 6, true);
		
		do {
			 do{
				 System.out.print(plat);
				j1.jouer(plat,j2);
				if(j1.EstEchecEtMat(j2)) {
					System.out.print("Echec !");
				};
				
			}while(j1.EstTour());
			do{
				System.out.print(plat);
				j2.jouer(plat, j1);
				if(j2.EstEchecEtMat(j1)) {
					System.out.print("Echec !");
				};
			}while(j2.EstTour());
		
		}while(EstFinie());
	}
}
