package piece;

public class PieceFou extends Piece {

	public boolean ACheminLibre(IJoueur j, int Indexroi) {
		int ButX = j.getPiecea(Indexroi).getX();
		int ButY = j.getPiecea(Indexroi).getY();
		int MonX = this.getX();
		int MonY = this.getY();
		int test = ButY-MonY;

		test = Math.abs(test);
		if(MonX>ButX && MonY>ButY){
			for(int i=1;i<test;i++) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX-i, MonY-i, j) && j.getPiecea(k).estPossible(MonX-i, MonY-i, j)) {
						return false;
					}
				}
				
			}
		}
		if(MonX< ButX && MonY >ButY) {
			for(int i=0;i<test;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX+i, MonY-i, j) && j.getPiecea(k).estPossible(MonX+i, MonY-i, j)) {
						return false;
					}
				}
			}
		}if(MonY < ButY && MonX > ButX ) {
			for(int i=0;i<test;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX-i, MonY+i, j) && j.getPiecea(k).estPossible(MonX-i, MonY+i, j)) {
						return false;
					}
				}
			}
			
		}if(MonY < ButY && MonX < ButX) {
			for(int i=0;i<test;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX+i, MonY+i, j) && j.getPiecea(k).estPossible(MonX+i, MonY+i, j)) {
						return false;
					}
				}
			}
		}
		return true;
		
	}
	public PieceFou(IPlateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
	}
	@Override
	public boolean estPossible(int x, int y, IJoueur j) {
		if(x<9 && x>0 && y<9 && y>0 ) {
		for(int i=1;i<10;++i) {
			if(recontrepiece(super.getX()+i, super.getY()+i, j)) {
				return false;
			}else {
				if(x==super.getX()+i && y==super.getY()+i) {
					return true;
				}
					
			}
			if(recontrepiece(super.getX()-i, super.getY()+i, j)) {
				return false;
			}else {
				if(x==super.getX()-i && y==super.getY()+i) {
					return true;
				}
			}
			if(recontrepiece(super.getX()+i, super.getY()-i, j)) {
				return false;
			}else {
				if(x==super.getX()+i && y==super.getY()-i) {
					return true;
				}
			}
			if(recontrepiece(super.getX()-i, super.getY()-i, j)) {
				return false;
			}else {
				if(x==super.getX()-i && y==super.getY()-i) {
					return true;
				}
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
	public boolean recontrepiece(int x, int y, IJoueur j) {
		int x1 = x-1;
		int y1=y-1;
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
	@Override
	public boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j) {
		for(int i=0;i<tab.length;++i) {  // x
			for(int k=0;k<tab[0].length;++k) { //y
				if(tab[i][k]==true) {
					if(super.getX()>i && super.getY() >k){
						for(int a=0;a<k;++a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(super.getX()+i, super.getY()+a, j) && j.getPiecea(i).estPossible(i, a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							}
						}
					}
					if(super.getX() > i && super.getY() <k) { //gauche
						for(int a=0;a>k;++a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(super.getX()-i, super.getY()-a, j) && j.getPiecea(i).estPossible(i, a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							
							}
						}
					}			
					if(super.getY() > k && super.getX() < i ) {
									//haut
						for(int a=0;a>k;++a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(super.getX()-i, super.getY()-a, j) && j.getPiecea(i).estPossible(i, a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							
							}
						}
						
					}if(super.getY() < k && super.getX() < i) {
									//bas
						for(int a=i;a>i;--i) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(i, a, j) && j.getPiecea(i).estPossible(i, a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							
							}
						}
					}
				}
			}
		}
		return true;
		
	}
	@Override
	public boolean peutSeMettreDev(boolean[][] tab, IJoueur j) {

		return false;
	}



}