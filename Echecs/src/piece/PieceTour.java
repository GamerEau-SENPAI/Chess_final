package piece;

import joueur.Joueur;
import plateau.Plateau;

public class PieceTour extends Piece {

	public PieceTour(Plateau p, int x, int y, boolean col) {
		super(p, x, y, col);
		
	}

	@Override
	public boolean estPossible(int x, int y, Joueur j) {
		this.setPassage(0);
		if(x<9 && x>0 && y<9 && y>0 ) {
		for(int i=1;i<10;++i) {
			if(super.recontrepiece(super.getX()+i, super.getY(), j)) { /*s'il y a une pi�ce*/
				return false; 
			}else {
				if(x==super.getX()+i && y==super.getY())
					return true;
			}
			if(super.recontrepiece(super.getX()-i, super.getY(), j)) {
				return false;
			}else {
				if(x==super.getX()-i && y==super.getY())
					return true;
			}
			if(super.recontrepiece(super.getX(), super.getY()+i, j)) {
				return false;
			}else {
				if(x==super.getX() && y==super.getY()+i)
					return true;
				
			}
			if(super.recontrepiece(super.getX(), super.getY()-i, j)) {
				return false;
			}else {
				if(x==super.getX() && y==super.getY()-i)
					return true;
			}
			}
		}
		return false;
	}

	@Override
	public int nbrPos(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estRoi() {
		return false;
	}

	@Override
	public String toString() {
		if(this.EstVivante()) {

			if(super.getCol()==false)
				return " t ";
			else
				return " T ";
			}
			return "   ";
	}

}
