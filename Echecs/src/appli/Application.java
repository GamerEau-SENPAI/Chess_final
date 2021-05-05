package appli;
import java.util.Scanner;

import joueur.Joueur;
import joueur.JoueurHumain;
import joueur.JoueurMachine;
/*30/03/21*/
import plateau.Plateau;
/* NON */


/*Vérification*/
public class Application {
	static Joueur j1;
	static Joueur j2;
	

	public static boolean EstFinie() {
		return true;
	}

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
	private static void HumainVShumain() {
		j1=null;
		j2=null;
		j1 = new JoueurHumain(5, true);
		j2 = new JoueurHumain(5, true);
	}
	private static void HumainVSMachine() {
		j1=null;
		j2=null;
		j1 = new JoueurHumain(5, true);
		j2 = new JoueurMachine(5, true);
	}
	private static void MachineVSMachine() {
		j1=null;
		j2=null;
		j1 = new JoueurMachine(5, true);
		j2 = new JoueurMachine(5, true);
	}
	public static void main(String[] args) {
		Plateau plat = new Plateau();
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
		
		
		if(mode.equals("1"))
			HumainVShumain();
		else if(mode.equals("2"))
			HumainVSMachine();
		else if(mode.equals("3"))
			MachineVSMachine();
		
		
		plat.clsTotal();
		j1.ajoutRoi(plat, 1, 2, true);
		j1.ajoutFou(plat, 6, 7, true);
		j1.ajoutFou(plat, 8, 5, true);
		j1.ajoutTour(plat, 4, 5, true);
		j1.ajoutTour(plat, 3, 5, true);
		j2.ajoutRoi(plat, 1, 4, false);
		j2.ajoutFou(plat, 7, 6, false);
		j2.ajoutFou(plat, 5, 1, false);
		j2.ajoutTour(plat, 8, 8, false);
		j2.ajoutTour(plat, 8, 6, false);
		
		
		do {
			 do{
				 if(!gag) {
					 System.out.println("C'est aux grandes lettres(BLANC)");
					 System.out.print(plat);
					j1.jouer(plat,j2);
					if((j1.EstEchec(j2) && j1.EstMat(j2))|| (j2.EstEchec(j1) && j2.EstMat(j1))|| (!j1.roiEstEnVie()||!j2.roiEstEnVie())) {
						gag=true;
					}
				}
			}while(j1.EstTour());
			 
			do{
				if(!gag) {
					System.out.println("C'est aux petites lettres(NOIR)");
					System.out.print(plat);
					j2.jouer(plat, j1);
					if((j1.EstEchec(j2) && j1.EstMat(j2))|| (j2.EstEchec(j1) && j2.EstMat(j1)) || (!j1.roiEstEnVie()||!j2.roiEstEnVie())) {
						
						gag=true;
					};
				}else {
					j2.setTour(!gag);
					finis=true;
				}
			}while(j2.EstTour());			
		}while(!finis);
		System.out.println(plat);
		if(j1.getGagnant()==true) {
			System.out.println("Joueur des PETITES lettres a gagné");
		}else if(j2.getGagnant()==true) {
			System.out.println("Joueur des GRANDES lettres a gagné");
		}

	}while(true);
	}
}