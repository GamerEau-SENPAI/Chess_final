package appli;
import java.util.Scanner;

import joueur.Joueur;
import piece.IPlateau;
/*30/03/21*/
import plateau.Plateau;
/* NON */


/*Vérification*/
public class Application {
	/**@brief :Affiche la demande de mode de jeu et prends en compte la reponse du joueur
	 * @return la réponse du joueur
	 */
	private static String Demande() {
		System.out.println("=============================================");
		System.out.println("|| Quel mode de jeu souhaitez vous jouer ? ||");
		System.out.println("||    (1)-1 Contre 1                       ||");
		System.out.println("||    (2)-1 Contre Machine                 ||");
		System.out.println("||    (3)-Machine contre Machine           ||");
		System.out.println("=============================================");
		System.out.print(">");
		Scanner saisie = new Scanner(System.in);
		String entree = saisie.nextLine();
		char entre = entree.charAt(0);
		while(!(entre == '1' || entre == '2' || entre == '3')){
				System.out.print("#>");
				entree = saisie.nextLine();
				entre = entree.charAt(0);
		}
			
		return entree;
	}
	
	
	/**@brief : Le main
	 */
	public static void main(String[] args) {
		IPlateau plat = new Plateau();
		String mode = Demande();
		boolean gag=false;
		boolean finis =false;
		int cpt=0;
		do {
			if(cpt==0) {
				System.out.print(mode);
				cpt++;
			}else {
				mode = Demande();
				System.out.print(mode);
				gag=false;
				finis= false;
			}

		plat.clsTotal();
		Fabrique fab = new Fabrique();
		fab.initialisationJoueurs(mode);
		fab.initialisation(plat, Fabrique.j1, Fabrique.j2);
		
		
		
		do {
			 do{
				 if(!gag) {
					 System.out.println("C'est aux grandes lettres(BLANC)");
					 System.out.print(plat);
					 Fabrique.j1.jouer(plat,(Joueur) Fabrique.j2);
					if((Fabrique.j1.EstEchec(Fabrique.j2) && Fabrique.j1.EstMat(Fabrique.j2))|| (Fabrique.j2.EstEchec(Fabrique.j1) && Fabrique.j2.EstMat(Fabrique.j1))|| (!Fabrique.j1.roiEstEnVie()||!Fabrique.j2.roiEstEnVie())) {
						gag=true;
					}
				}
			}while(Fabrique.j1.EstTour());
			 
			do{
				if(!gag) {
					System.out.println("C'est aux petites lettres(NOIR)");
					System.out.print(plat);
					Fabrique.j2.jouer(plat, (Joueur) Fabrique.j1);
					if((Fabrique.j1.EstEchec(Fabrique.j2) && Fabrique.j1.EstMat(Fabrique.j2))|| (Fabrique.j2.EstEchec(Fabrique.j1) && Fabrique.j2.EstMat(Fabrique.j1)) || (!Fabrique.j1.roiEstEnVie()||!Fabrique.j2.roiEstEnVie())) {
						
						gag=true;
					};
				}else {
					Fabrique.j2.setTour(!gag);
					finis=true;
				}
			}while(Fabrique.j2.EstTour());			
		}while(!finis);
		System.out.println(plat);
		if(Fabrique.j1.getGagnant()==true) {
			System.out.println("Joueur des PETITES(NOIR) lettres a gagné");
		}else if(Fabrique.j2.getGagnant()==true) {
			System.out.println("Joueur des GRANDES(BLANCS) lettres a gagné");
		}

	}while(true);
	}
}