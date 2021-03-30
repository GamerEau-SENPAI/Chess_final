package piece;

import plateau.Plateau;

public class Piece {
	private int x;
	private int y;
	public Piece(Plateau p,int x, int y) {
		this.x=x;
		this.y=y;
		p.setTab(this);
		
	}
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public String toString() {
		return " P ";
		
	}
}
