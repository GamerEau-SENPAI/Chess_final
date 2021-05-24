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
	public static String Demande() {
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
				cpt++;
			}else {
				mode = Demande();
				gag=false;
				finis= false;
			}

		plat.clsTotal();
		Fabrique fab = new Fabrique();
		fab.initialisationJoueurs(mode);
		fab.initialisation(plat, Fabrique.getJ1(), Fabrique.getJ2());
		
		
		
		do {
			 do{
				 if(!gag) {
					 System.out.println("C'est aux grandes lettres(BLANC)");
					 System.out.print(plat);
					 Fabrique.getJ1().jouer(plat,(Joueur) Fabrique.getJ2());
					if((Fabrique.getJ1().EstEchec(Fabrique.getJ2()) && Fabrique.getJ1().EstMat(Fabrique.getJ2()))|| (Fabrique.getJ2().EstEchec(Fabrique.getJ1()) && Fabrique.getJ2().EstMat(Fabrique.getJ1()))|| (!Fabrique.getJ1().roiEstEnVie()||!Fabrique.getJ2().roiEstEnVie())) {
						gag=true;
					}
				}
			}while(Fabrique.getJ1().EstTour());
			 
			do{
				if(!gag) {
					System.out.println("C'est aux petites lettres(NOIR)");
					System.out.print(plat);
					Fabrique.getJ2().jouer(plat, (Joueur) Fabrique.getJ1());
					if((Fabrique.getJ1().EstEchec(Fabrique.getJ2()) && Fabrique.getJ1().EstMat(Fabrique.getJ2()))|| (Fabrique.getJ2().EstEchec(Fabrique.getJ1()) && Fabrique.getJ2().EstMat(Fabrique.getJ1())) || (!Fabrique.getJ1().roiEstEnVie()||!Fabrique.getJ2().roiEstEnVie())) {
						
						gag=true;
					};
				}else {
					Fabrique.getJ2().setTour(!gag);
					finis=true;
				}
			}while(Fabrique.getJ2().EstTour());			
		}while(!finis);
		System.out.println(plat);
		if(Fabrique.getJ1().getGagnant()==true) {
			System.out.println("Joueur des PETITES(NOIR) lettres a gagné");
		}else if(Fabrique.getJ2().getGagnant()==true) {
			System.out.println("Joueur des GRANDES(BLANCS) lettres a gagné");
		}

	}while(true);
	}
}