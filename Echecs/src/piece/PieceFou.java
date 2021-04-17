package piece;

import joueur.Joueur;
import plateau.Plateau;

public class PieceFou extends Piece {

	
	public PieceFou(Plateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
	}
	@Override
	public boolean estPossible(int x, int y, Joueur j) {
		if(x<9 && x>0 && y<9 && y>0 ) {
		for(int i=1;i<10;++i) {
			if(this.recontrepiece(super.getX()+i, super.getY()+i, j)) {
				return false;
			}else {
				if(x==super.getX()+i && y==super.getY()+i)
					return true;
			}
			if(this.recontrepiece(super.getX()-i, super.getY()+i, j)) {
				return false;
			}else {
				if(x==super.getX()-i && y==super.getY()+i)
					return true;
			}
			if(this.recontrepiece(super.getX()+i, super.getY()-i, j)) {
				return false;
			}else {
				if(x==super.getX()+i && y==super.getY()-i)
					return true;
			}
			if(this.recontrepiece(super.getX()-i, super.getY()-i, j)) {
				return false;
			}else {
				if(x==super.getX()-i && y==super.getY()-i)
					return true;
			}
				
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
	@Override
	public boolean recontrepiece(int x, int y, Joueur j) {
		int x1 = x;
		int y1=y;
		if(super.getX()>x && super.getY() >y){
			x1 = x+1;
			y1= y+1;
		}
		if(super.getX() < x && super.getY() >y) {
			x1 = x-1;
			y1= y+1;
		}if(super.getY() < y && super.getX() > x ) {
			y1= y-1;
			x1 = x+1;
			
		}if(super.getY() < y && super.getX() < x) {
			y1 = y-1;
			x1 = x-1;
		}
		for(int i=0; i<j.getPieces().length;++i) {
			if((x1==j.getPiecea(i).getX() && y1==j.getPiecea(i).getY())) {
				return true; /*j.getPiecea(i).EstVivante()*/
			}
		}
		return false;
	}


}