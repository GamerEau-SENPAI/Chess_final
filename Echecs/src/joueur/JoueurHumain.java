package joueur;

import java.util.Scanner;

import piece.Piece;
import piece.PieceFou;
import piece.PieceRoi;
import piece.PieceTour;
import plateau.Plateau;

public class JoueurHumain extends Joueur {
	
	
	public JoueurHumain(int qte, boolean monTour) {
		super(qte, monTour);
	}
	

	
	
	public void jouer(Plateau plat, Joueur j) {
		Scanner saisie = new Scanner(System.in);
		String entree = saisie.nextLine();
		int a = super.index(entree,0);
		int b = super.charToInt(entree,1);
		for(int i=0;i<getPieces().length;++i) {
			if(super.getPiecea(i).getY()==a && super.getPiecea(i).getX()==b) {
				if(super.getPiecea(i).estPossible(charToInt(entree,3),index(entree,2),j)) {
					plat.cls(b,a);
					super.EtreMangé(charToInt(entree,3), index(entree,2), j);
					super.getPiecea(i).setXY(charToInt(entree,3),index(entree,2));
					plat.setTab(super.getPiecea(i));
					if(j.RestePiece()) {
						super.setTour(false);
					}else {
						super.setTour(true);
						}
					
				}else {
					System.out.println("");
					System.out.print("n'est pas possible");
					System.out.println("");
					}
			}
		}	
	}
	
	
	
	
	
	
	
	
	
}