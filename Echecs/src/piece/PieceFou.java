package piece;

import plateau.Plateau;

public class PieceFou extends Piece {

	
	public PieceFou(Plateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
	}
	@Override
	public boolean estPossible(int x, int y) {
		for(int i=1;i<10;++i) {
			if(x==super.getX()+i && y==super.getY()+i)
				return true;
			if(x==super.getX()-i && y==super.getY()+i)
				return true;
			if(x==super.getX()+i && y==super.getY()-i)
				return true;
			if(x==super.getX()-i && y==super.getY()-i)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		if(this.EstVivante()) {

		if(super.getCol()==false)
			return " f ";
		else
			return " F ";
		}
		return "   ";
	}
}