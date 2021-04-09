package piece;

import plateau.Plateau;

public class PieceFou extends Piece {

	
	public PieceFou(Plateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
	}
	@Override
	public boolean estPossible(int x, int y) {
		if(x<9 && x>0 && y<9 && y>0 ) {
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
		}
		return false;
	}
	public int nbrPos(int x, int y) {
		int nbr=0;
	if(x<9 && x>0 && y<9 && y>0 ) {
		for(int i=1;i<10;++i) {
			if(x==super.getX()+i && y==super.getY()+i)
				nbr++;
			if(x==super.getX()-i && y==super.getY()+i)
				nbr++;
			if(x==super.getX()+i && y==super.getY()-i)
				nbr++;
			if(x==super.getX()-i && y==super.getY()-i)
				nbr++;
				}
			}
		return nbr;
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
	@Override
	public boolean estRoi() {
		return false;
	}
}