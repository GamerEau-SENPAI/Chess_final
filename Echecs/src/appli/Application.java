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
		Joueur j1 = new Joueur(2, false);
		Joueur j2 = new Joueur(1, true);
		j1.ajoutRoi(plat, 2, 7, false);
		j1.ajoutFou(plat, 2, 2, false);
		j2.ajoutRoi(plat, 3, 6, true);
		
		do {
			 do{
				 System.out.print(plat);
				j1.jouer(plat,j2);
				
			}while(j1.EstTour());
			do{
				System.out.print(plat);
				j2.jouer(plat, j1);
			}while(j2.EstTour());
		
		}while(EstFinie());
	}
}
