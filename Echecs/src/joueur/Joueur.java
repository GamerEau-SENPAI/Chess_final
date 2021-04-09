package joueur;

import java.util.Scanner;

import piece.Piece;
import piece.PieceFou;
import piece.PieceRoi;
import plateau.Plateau;

public class Joueur {
	private Piece[] pieces;
	private int[] nbrpos;
	private int cpt;
	private boolean monTour;
	public Joueur(int qte, boolean monTour) {
		this.pieces= new Piece[qte];
		this.nbrpos = new int[qte];
		this.cpt=0;
		this.monTour=monTour;
	}
	/*@Brief return true si au min 1 piece est vivante
	 * 
	 * 
	 */
	public boolean RestePiece() {
		for(int i=0;i<pieces.length;++i) {
			if(pieces[i].EstVivante()) {
				return true;
			}
			
		}
		return false;
	}
	public boolean EstTour() {
		return this.monTour;
	}
	public Piece getPiecea(int i) {
		return pieces[i];
	}
	public void EtreMangé(int x, int y, Joueur j) {
		
		for(int i=0;i<j.getPieces().length;++i) {
			if(j.getPiecea(i).getX()==x && j.getPiecea(i).getY()==y) {
				if(j.getPiecea(i).getCol()!=this.pieces[i].getCol()) {
				j.getPiecea(i).EteMange();
				}
			}
		}
		
		
	}
	public void ajoutRoi(Plateau plat, int x, int y, boolean couleur) {
		this.pieces[cpt]= new PieceRoi(plat,x,y,couleur);
		cpt++;
	}
	public void ajoutFou(Plateau plat, int x, int y, boolean couleur) {
		this.pieces[cpt]= new PieceFou(plat,x,y,couleur);
		cpt++;
	}
	public Piece[] getPieces() {
		return this.pieces;
	}
	private static char[] CreationAlp() {
		char[] alphabet = new char[10];
		for(char ch = 'a'; ch <= 'h'; ++ch){
            alphabet[ch-'a']=ch;
        }
		return alphabet;
	}
	private static char[] CreationVal() {
		char[] val = new char[9];
		int cpt=1;
		for(char i='8';i>'0';--i) {
			val[cpt]=i;
			cpt++;
		}
		return val;
	}
	private static int index(String a,int x) { // x=0 ou x=2
		char[] alphabet = CreationAlp();
		for(int i=0;i<10;++i) {
			if(a.charAt(x)==alphabet[i]) {
				return i+1;
			}
		}
		return 0;
	}
	private static int charToInt(String a, int x) { // x=1 ou 3
		char[] val = CreationVal();
		for(int i=0;i<9;++i) {
			if(a.charAt(x)==val[i]) {
				return i;
			}
		}
		return 0;
	}
	
	public void jouer(Plateau plat, Joueur j) {
		Scanner saisie = new Scanner(System.in);
		String entree = saisie.nextLine();
		int a = index(entree,0);
		int b = charToInt(entree,1);
		for(int i=0;i<pieces.length;++i) {
			if(pieces[i].getY()==a && pieces[i].getX()==b) {
				if(pieces[i].estPossible(charToInt(entree,3),index(entree,2))) {
					plat.cls(b,a);
					this.EtreMangé(charToInt(entree,3), index(entree,2), j);
					pieces[i].setXY(charToInt(entree,3),index(entree,2));
					plat.setTab(pieces[i]);
					if(j.RestePiece()) {
						monTour=false;
					}else
						monTour=true;
					
				}else {
					System.out.println("");
					System.out.print("n'est pas possible");
					System.out.println("");
					}
			}
		}	
	}
	private static int chercheRoi(Joueur j) {
		for(int i=0; i<j.pieces.length;++i) {
			if(j.pieces[i].toString().equals("r") || j.pieces[i].toString().equals("R")) {
				return i;
			}
		}
		return -1;
	}
	public boolean EstEchecEtMat(Joueur j) {
		int Roi= chercheRoi(j);
		int test=0;
		for(int x=0;x<8;++x){
			for(int y=0;y<8;++y){
				for(int i=0; i<this.pieces.length;++i) {
					this.nbrpos[i] = pieces[i].nbrPos(x, y);
					for(int k=0; k<this.nbrpos[i];++k) {
						if(this.pieces[i].estPossible(x, y) && j.pieces[Roi].estPossible(x, y) ) {
							test++;
						}
					}
						
				}
			}
		}
		if(test==j.pieces[Roi].nbrPos(x,y) {
			return true;
		}
	return false;
		
	}
}
