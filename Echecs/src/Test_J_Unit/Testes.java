package Test_J_Unit;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import appli.Application;
import appli.Fabrique;
import joueur.IPiece;
import joueur.Joueur;
import piece.IJoueur;
import piece.IPlateau;
import plateau.Plateau;

class Testes {

	@Test
	void test_Demande() {
		String test[] = {"1","2","3"};
		String mode = Application.Demande();
		for(int i=0;i<3;i++) {
			if(test[i].equals(mode)) {
				assertEquals(test[i],mode);
			}
		}
		
	}
	
	@Test
	void test_fab() {
		String test[] = {"1","2","3"};
		String nomPiece[] = {" r "," t "," f "," R "," T "," F "};
		int nbrPiece =0;
		Random rand = new Random();
		int n = rand.nextInt(3);
		Fabrique fab = new Fabrique();
		fab.initialisationJoueurs(test[n]);
		IPlateau plat = new Plateau();
		fab.initialisation(plat, Fabrique.getJ1(), Fabrique.getJ2());
		IJoueur[] j = {Fabrique.getJ1(),Fabrique.getJ2()};
		for(int i=0;i<j.length; i++) {
			for(int k=0;k<j[i].getPieces().length;++k) {
				for(int a=0;a<nomPiece.length;++a) {
					if(j[i].getPiecea(k).toString().equals(nomPiece[a])) {
						nbrPiece++;
					}
				}
				
			}
		}
		assertEquals(nbrPiece,10);
	}
	
	@Test
	void test_jouer_un_coup() {
		String test[] = {"1","2","3"};
		IPiece testPiece[] = new IPiece[5];
		boolean PieceAbougé = false;
		Random rand = new Random();
		int n = rand.nextInt(3);
		Fabrique fab = new Fabrique();
		fab.initialisationJoueurs("1");
		IPlateau plat = new Plateau();
		fab.initialisation(plat, Fabrique.getJ1(), Fabrique.getJ2());
		testPiece = Fabrique.getJ1().getPieces();
		System.out.println(plat);
		Fabrique.getJ1().jouer(plat,(Joueur) Fabrique.getJ2());
		System.out.println(plat);
		for(int i=0;i<Fabrique.getJ1().getPieces().length;++i) {
			for(int j=0;j<testPiece.length;++j) {
				if(Fabrique.getJ1().getPiecea(i).getX() != testPiece[j].getX()) {
					if ((Fabrique.getJ1().getPiecea(i).getY() != testPiece[j].getY())) {
						PieceAbougé = true; // Si les anciennes coordonnées sont differentes des nouvelles pour une piece, alors cela veut dire qu'elle a bougé
					}
				}
				
			}
		}
		System.out.println(plat);
		assertTrue(PieceAbougé);
	}
	@Test
	void test_FinDePartie() {
		boolean gag =false;
		boolean finis =false;
		Fabrique fab = new Fabrique();
		fab.initialisationJoueurs("3");
		IPlateau plat = new Plateau();
		Fabrique.getJ1().setTemps(1);
		Fabrique.getJ2().setTemps(1);
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
		assertTrue(gag);

	}
	

}
