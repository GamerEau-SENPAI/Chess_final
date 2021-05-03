package joueur;

import piece.Piece;
import piece.PieceFou;
import piece.PieceRoi;
import piece.PieceTour;
import plateau.Plateau;

public abstract class Joueur {
	private Piece[] pieces;
	private int[] nbrpos;
	private int cpt;
	private boolean monTour;
	private boolean tab[][];
	public Joueur(int qte, boolean monTour) {
		this.pieces= new Piece[qte];
		this.nbrpos = new int[qte];
		this.cpt=0;
		this.monTour=monTour;
		tab = new boolean[8][8];
		for(int i=0;i<8;++i) {
			for(int k=0;k<8;++k) {
				this.tab[i][k]=false;
			}
		}
	}
	public boolean[][] getTab(){
		return this.tab;
	}
	public boolean getTab(int x, int y){
		return this.tab[x][y];
	}
	public void setTab(int x, int y,boolean etat){
		this.tab[x][y] = etat;
	}
	public Piece getPiecea(int i) {
		return pieces[i];
	}
	public boolean EstTour() {
		return this.monTour;
	}
	public void setTour(boolean tour) {
		this.monTour = tour;
	}
	public void ajoutRoi(Plateau plat, int x, int y, boolean couleur) {
		this.pieces[cpt]= new PieceRoi(plat,x,y,couleur);
		cpt++;
	}
	public void ajoutTour(Plateau plat, int x, int y, boolean couleur) {
		this.pieces[cpt]= new PieceTour(plat,x,y,couleur);
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
	protected static int index(String a,int x) { // x=0 ou x=2
		char[] alphabet = CreationAlp();
		for(int i=0;i<10;++i) {
			if(a.charAt(x)==alphabet[i]) {
				return i+1;
			}
		}
		return 0;
	}
	public static int charToInt(String a, int x) { // x=1 ou 3
		char[] val = CreationVal();
		for(int i=0;i<9;++i) {
			if(a.charAt(x)==val[i]) {
				return i;
			}
		}
		return 0;
	}
	
	public abstract void jouer(Plateau plat, Joueur j);
	
	public abstract boolean EstEchec(Joueur j);
	public abstract boolean EstMat(Joueur j);
	
	protected static int chercheRoi(Joueur j) {
		for(int i=0; i<j.getPieces().length;++i) {
			if(j.getPiecea(i).estRoi()) {
				return i;
			}
		}
		return -1;
	}
	public boolean RestePiece() {
		for(int i=0;i<this.getPieces().length;++i) {
			if(this.getPiecea(i).EstVivante()) {
				return true;
			}
			
		}
		return false;
	}
	public boolean estOccupeParMoi(int x, int y) {
		for(int i=0; i< this.getPieces().length;++i) {
			if(x==this.getPiecea(i).getX() || y==this.getPiecea(i).getY())
				return true;
		}
		return false;
	}
	
}
