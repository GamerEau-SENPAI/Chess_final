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
	private boolean gagant;
	public Joueur(int qte, boolean monTour) {
		this.pieces= new Piece[qte];
		this.nbrpos = new int[qte];
		this.cpt=0;
		this.monTour=monTour;
		this.gagant=false;
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
	private int IndexRoiEstVisé(Joueur j) {
		for(int i=0;i<getPieces().length;++i) { // Pour toute mes pièces
			if(getPiecea(i).estPossible(j.getPiecea(chercheRoi(j)).getX(), j.getPiecea(chercheRoi(j)).getY(), j )) {
				return i;
			}
		}
		return -1;
	}
	public void setGagnant(boolean etat) {
		this.gagant = etat;
	}
	public boolean getGagnant() {
		return this.gagant;
	}
	public abstract void jouer(Plateau plat, Joueur j);
	public boolean roiEstEnVie() {
		int roi = chercheRoi(this);
		if(this.getPiecea(roi).EstVivante()) {
			return true;
		}
		this.setGagnant(true);
		return false;
	}
	public boolean EstMat(Joueur j) {
			int Viseur = IndexRoiEstVisé(j);
			int Roi= chercheRoi(this);
			if(this.roiEstVisé(j) && this.getPiecea(Viseur).ACheminLibre(j, Roi))
				return true;
		
		return false;
	}
	private boolean roiEstVisé(Joueur j) {
		for(int i=0;i<getPieces().length;++i) { // Pour toute mes pièces
			if(getPiecea(i).estPossible(j.getPiecea(chercheRoi(j)).getX(), j.getPiecea(chercheRoi(j)).getY(), j )) {
				return true;
			}
		}
		return false;
	}
	private boolean pasDoublons(int x, int y) {
		if(getTab(x, y)==false) { // Si la case n'est pas visité
			setTab(x, y, true);	//bah mtn si 
			return true;
		}
		return false;
	}
	private boolean peutMeManger(Joueur j) {
		for(int i=0;i<j.getPieces().length;++i) {
			for(int k=0;k<getPieces().length;++k) {
				if(j.getPiecea(i).estPossible(getPiecea(k).getX(), getPiecea(k).getY(), this)) {
					return true;
				}
			}
		}
		return false;
		
	}
	public boolean EstEchec(Joueur j) {
		//int verif=0;
		int Roi= chercheRoi(j);
		int coincidence=0;
		for(int x=0;x<8;++x){
			for(int y=0;y<8;++y){
				for(int i=0; i<getPieces().length;i++) {
						if(getPiecea(i).estPossible(x, y, j) && j.getPiecea(Roi).estPossible(x, y,this) ) {
							if(this.pasDoublons(x, y) && !peutMeManger(j)) {
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
				System.out.println("Une pièce peut se mettre devant");
			}
		}*/
		
		//System.out.println("Verification " + verif);
		//System.out.println("coin " + coincidence);
		if(coincidence==j.getPiecea(Roi).nbrPos(j.getPiecea(Roi).getX(),j.getPiecea(Roi).getY())) {
			return true;
		}
	return false;
		
	}
	public void EtreMangé(int x, int y, Joueur j) {
		for(int i=0;i<j.getPieces().length;++i) {
			if(j.getPiecea(i).getX()==x && j.getPiecea(i).getY()==y) {
				if(j.getPiecea(i).getCol()!=getPiecea(i).getCol()) {
				j.getPiecea(i).EteMange();
				}
			}
		}
	}
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
