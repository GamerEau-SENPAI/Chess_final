package piece;

import plateau.Plateau;

public abstract class Piece {
	private int x;
	private int y;
	private boolean couleur;
	public Piece(Plateau p,int x, int y, boolean col) {
		this.x=x;
		this.y=y;
		this.couleur=col;
		p.setTab(this);
		
	}
	public abstract boolean estPossible(int x, int y);
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return this.x;
	}
	public boolean getCol() {
		return this.couleur;
	}
	public int getY() {
		return this.y;
	}
	public abstract String toString();
}
