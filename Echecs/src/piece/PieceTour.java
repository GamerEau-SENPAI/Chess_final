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
			if(recontrepiece(super.getX()+i, super.getY(), j)) { /*s'il y a une pièce*/
				return false; 
			}else {
				if(x==super.getX()+i && y==super.getY())
					return true;
			}
			if(recontrepiece(super.getX()-i, super.getY(), j)) {
				return false;
			}else {
				if(x==super.getX()-i && y==super.getY())
					return true;
			}
			if(recontrepiece(super.getX(), super.getY()+i, j)) {
				return false;
			}else {
				if(x==super.getX() && y==super.getY()+i)
					return true;
				
			}
			if(recontrepiece(super.getX(), super.getY()-i, j)) {
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
	public boolean recontrepiece(int x, int y, Joueur j) {
		int x1 = x;
		int y1=y;
		if(super.getX()>x){
			x1 = x+1;
		}
		if(super.getX() < x) {
			x1 = x-1;
		}if(super.getY() >y) {
			y1= y+1;
		}if(super.getY() < y) {
			y1 = y-1;
		}
		for(int i=0; i<j.getPieces().length;++i) {
			if((x1==j.getPiecea(i).getX() && y1==j.getPiecea(i).getY())) {
				return true; /*j.getPiecea(i).EstVivante()*/
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
