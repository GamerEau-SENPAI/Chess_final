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
	
	
	
	
	
	public void EtreMang�(int x, int y, Joueur j) {
		for(int i=0;i<j.getPieces().length;++i) {
			if(j.getPiecea(i).getX()==x && j.getPiecea(i).getY()==y) {
				if(j.getPiecea(i).getCol()!=super.getPiecea(i).getCol()) {
				j.getPiecea(i).EteMange();
				}
			}
		}
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
					this.EtreMang�(charToInt(entree,3), index(entree,2), j);
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
	
	
	private boolean peutMeManger(Joueur j) {
		for(int i=0;i<j.getPieces().length;++i) {
			for(int k=0;k<super.getPieces().length;++k) {
				if(j.getPiecea(i).estPossible(super.getPiecea(k).getX(), super.getPiecea(k).getY(), this)) {
					return true;
				}
			}
		}
		return false;
		
	}
	public boolean EstMat(Joueur j) {
		int Viseur = this.IndexRoiEstVis�(j);
		int Roi= super.chercheRoi(this);
		if(this.roiEstVis�(j) && this.getPiecea(Viseur).ACheminLibre(j, Roi))
			return true;
		return false;
	}
	public boolean EstEchec(Joueur j) {
		//int verif=0;
		int Roi= super.chercheRoi(j);
		int coincidence=0;
		for(int x=0;x<8;++x){
			for(int y=0;y<8;++y){
				for(int i=0; i<super.getPieces().length;i++) {
						if(super.getPiecea(i).estPossible(x, y, j) && j.getPiecea(Roi).estPossible(x, y,this) ) {
							if(this.pasDoublons(x, y) && !this.peutMeManger(j)) {
								coincidence++;
							}
								
						}
				}
			}
		}
		/*for(int i=0;i<super.getPieces().length;++i) {
			if(super.getPiecea(i).verificationMat(super.getTab(), this, j)) {
				verif++;
			}
			
			if(super.getPiecea(i).peutSeMettreDev(super.getTab(), j)) {
				System.out.println("Une pi�ce peut se mettre devant");
			}
		}*/
		
		//System.out.println("Verification " + verif);
		//System.out.println("coin " + coincidence);
		if(coincidence==j.getPiecea(Roi).nbrPos(j.getPiecea(Roi).getX(),j.getPiecea(Roi).getY())) {
			return true;
		}
	return false;
		
	}
	private boolean pasDoublons(int x, int y) {
		if(super.getTab(x, y)==false) { // Si la case n'est pas visit�
			super.setTab(x, y, true);	//bah mtn si 
			return true;
		}
		return false;
	}
	private boolean roiEstVis�(Joueur j) {
		for(int i=0;i<super.getPieces().length;++i) { // Pour toute mes pi�ces
			if(super.getPiecea(i).estPossible(j.getPiecea(chercheRoi(j)).getX(), j.getPiecea(chercheRoi(j)).getY(), j )) {
				return true;
			}
		}
		return false;
	}
	private int IndexRoiEstVis�(Joueur j) {
		for(int i=0;i<super.getPieces().length;++i) { // Pour toute mes pi�ces
			if(super.getPiecea(i).estPossible(j.getPiecea(chercheRoi(j)).getX(), j.getPiecea(chercheRoi(j)).getY(), j )) {
				return i;
			}
		}
		return -1;
	}
	
	
}