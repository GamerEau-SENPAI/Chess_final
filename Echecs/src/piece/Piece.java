package piece;

import joueur.IPiece;

public abstract class Piece implements IPiece {
	private int x;
	private int y;
	private boolean vivante;
	private boolean couleur;
	private int premierPassage;
	public Piece(IPlateau p,int x, int y, boolean col) {
		this.x=x;
		this.y=y;
		this.couleur=col;
		this.vivante = true;
		this.premierPassage=0;
		p.setTab((IPiece) this);
		
	}
	@Override
	public void setPassage(int i) {
		premierPassage=i;
	}
	@Override
	public boolean EstVivante() {
		return this.vivante;
	}
	@Override
	public void EteMange() {
		this.vivante=false;
	}
	@Override
	public abstract boolean estPossible(int x, int y, IJoueur j);
	@Override
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	@Override
	public abstract int nbrPos(int x, int y);
	@Override
	public int getX() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.x;
	}
	@Override
	public abstract boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);
	@Override
	public abstract boolean estRoi();
	@Override
	public boolean getCol() {
		return this.couleur;
	}
	@Override
	public int getY() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.y;
	}
	@Override
	public abstract boolean ACheminLibre(IJoueur j, int Indexroi);
	@Override
	public abstract boolean peutSeMettreDev(boolean tab[][], IJoueur j);
	@Override
	public abstract String toString();
	
	
	@Override
	public abstract boolean recontrepiece(int x, int y, IJoueur j);

}
