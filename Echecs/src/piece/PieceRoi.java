package piece;

public class PieceRoi extends Piece {

	public PieceRoi(IPlateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
	}
	public boolean ACheminLibre(IJoueur j, int Indexroi) {
		return true;
		
	}
	public boolean estPossible(int x, int y, IJoueur j) {
		if(x<9 && x>0 && y<9 && y>0 ) {
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
		}
		
		
		
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
	public boolean estRoi() {
		return true;
	}
	
	private static boolean verif(int x) {
		if(x<9 && x>0) {
			return true;
		}
		return false;
		
	}
	@Override
	public int nbrPos(int x, int y) {
		int te=0;
		if(x<9 && x>0 && y<9 && y>0 ) {
			if(x+1==super.getX()+1 && y==super.getY()) {
				if(verif(x+1))
					te++;
			}
				
			if(x-1==super.getX()-1 && y==super.getY()) {
				if(verif(x-1))
					te++;
			}
			if(x==super.getX() && y+1==super.getY()+1) {
				if(verif(y+1))
					te++;
			}
			if(x==super.getX() && y-1==super.getY()-1) {
				if(verif(y-1))
					te++;
			}
			if(x+1==super.getX()+1 && y+1==super.getY()+1) {
				if(verif(x+1) && verif(y+1))
					te++;
			}
			if(x+1==super.getX()+1 && y-1==super.getY()-1) {
				if(verif(x+1) && verif(y-1))
					te++;
			}
			if(x-1==super.getX()-1 && y-1==super.getY()-1) {
				if(verif(x-1) && verif(y-1))
					te++;
			}
			if(x-1==super.getX()-1 && y+1==super.getY()+1) {
				if(verif(x-1) && verif(y+1))
					te++;
			}
		}
		return te;
	}
	@Override
	public boolean recontrepiece(int x, int y, IJoueur j) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean peutSeMettreDev(boolean[][] tab, IJoueur j) {
		// TODO Auto-generated method stub
		return false;
	}



}
