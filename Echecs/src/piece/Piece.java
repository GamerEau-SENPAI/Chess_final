package piece;

import joueur.Joueur;
import plateau.Plateau;

public abstract class Piece {
	private int x;
	private int y;
	private boolean vivante;
	private boolean couleur;
	public Piece(Plateau p,int x, int y, boolean col) {
		this.x=x;
		this.y=y;
		this.couleur=col;
		this.vivante = true;
		p.setTab(this);
		
	}
	public boolean EstVivante() {
		return this.vivante;
	}
	public void EteMange() {
		this.vivante=false;
	}
	public abstract boolean estPossible(int x, int y, Joueur j);
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public abstract int nbrPos(int x, int y);
	public int getX() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.x;
	}
	public abstract boolean estRoi();
	public boolean getCol() {
		return this.couleur;
	}
	public int getY() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.y;
	}
	public abstract String toString();
	
	
	public boolean recontrepiece(int x, int y, Joueur j) {
		for(int i=0; i<j.getPieces().length;++i) {
			if(x==j.getPiecea(i).getX() && y==j.getPiecea(i).getY()) {
				return j.getPiecea(i).EstVivante();
			}
		}
		return false;
	}
}
