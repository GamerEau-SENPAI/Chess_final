package piece;

import plateau.Plateau;

public class PieceRoi extends Piece {

	public PieceRoi(Plateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
		// TODO Auto-generated constructor stub
	}
	public boolean estPossible(int x, int y) {
		super.getX();
		super.getY();
		if(x==super.getX()+1 && y==super.getY())
			return true;
		if(x==super.getX()-1 && y==super.getY())
			return true;
		if(x==super.getX() && y==super.getY()+1)
			return true;
		if(x==super.getX() && y==super.getY()-1)
			return true;
		if(x==super.getX()+1 && y==super.getY()+1) /**/
			return true;
		if(x==super.getX()+1 && y==super.getY()-1)
			return true;
		if(x==super.getX()-1 && y==super.getY()-1)
			return true;
		if(x==super.getX()-1 && y==super.getY()+1)
			return true;
		
		
		
		return false;
	}
	@Override
	public String toString() {
		if(this.EstVivante()) {
			
		
		if(super.getCol()==false)
			return " r ";
		else
			return " R ";
		}
		return "   ";
	}

}
