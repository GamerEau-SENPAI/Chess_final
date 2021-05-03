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
				if(x==super.getX()+i && y==super.getY()){
					return true;
				}
			}
			if(recontrepiece(super.getX()-i, super.getY(), j)) {

				return false;
			}else {
				if(x==super.getX()-i && y==super.getY()){
					return true;
				}
			}
			if(recontrepiece(super.getX(), super.getY()+i, j)) {

				return false;
			}else {
				if(x==super.getX() && y==super.getY()+i){
					return true;
				}
				
			}
			if(recontrepiece(super.getX(), super.getY()-i, j)) {

				return false;
			}else {
				if(x==super.getX() && y==super.getY()-i) {
					return true;
				}
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
	
	public boolean ACheminLibre(Joueur j, int Indexroi) {
		int ButX = j.getPiecea(Indexroi).getX();
		int ButY = j.getPiecea(Indexroi).getY();
		int MonX = this.getX();
		int MonY = this.getY();
		int SurY = Math.abs(MonY-MonY);
		int SurX = Math.abs(ButX-MonX);
		if(MonX == ButX && MonY > ButY) {
			for(int i=1;i<SurY;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX, MonY+i, j) && j.getPiecea(k).estPossible(MonX, MonY+i, j)) {
						return false;
					}
				}
			}
		}
		if(MonX == ButX && MonY < ButY) {
			for(int i=1;i<SurY;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX, MonY-i, j) && j.getPiecea(k).estPossible(MonX, MonY-i, j)) {
						return false;
					}
				}
			}
		}
		if(MonX < ButX && MonY == ButY) {
			for(int i=1;i<SurX;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX+i, MonY, j) && j.getPiecea(k).estPossible(MonX+i, MonY, j)) {
						return false;
					}
				}
			}
		}
		if(MonX > ButX && MonY == ButY) {
			for(int i=1;i<SurX;++i) {
				for(int k=0;k<j.getPieces().length;k++) {
					if(k==Indexroi)
						k++;
					if(this.estPossible(MonX-i, MonY, j) && j.getPiecea(k).estPossible(MonX-i, MonY, j)) {
						return false;
					}
				}
			}
		}
		return true;
		
	}
	public boolean peutSeMettreDev(boolean tab[][], Joueur j) {
		//System.out.println("Verification d'une tour");
		int x1 = super.getX();
		int y1=super.getY();
		for(int i=0;i<tab.length;++i) {
			for(int k=0;k<tab[0].length;++k) {
				if(tab[i][k]==true) {
					//System.out.println("		Pour x : " + i + " Pour y : " + k);
					//System.out.println("resultat du 1er if :");
					if( x1==i && y1<k) {
						for(int a=y1;a<k;++a) {
							//System.out.println(true);
							for(int b=0;b<j.getPieces().length;++b) {
								//System.out.print("X1 et Y1 : ");
								//System.out.println(x1 + " " + a);
								if(this.estPossible(x1, a, j) && j.getPiecea(b).estPossible(x1, a, j)) {
									//System.out.println(true);
									return true;
									
								}
							}
						}
					}
					//System.out.println("resultat du 2eme if :");
					if(x1==i && y1>k) {
						for(int a=y1;a<k;++a) {
							//System.out.println(true);
							for(int b=0;b<j.getPieces().length;++b) {
								//System.out.print("X1 et Y1 : ");
								//System.out.println(x1 + " "+ a);
								if(this.estPossible(x1, a, j) && j.getPiecea(b).estPossible(x1, a, j) ) {
									//System.out.println(true);
									return true;
									
								}
							}
						}
					}
					//System.out.println("resultat du 3eme if :");
					if(x1<i && y1==k) {
						for(int a=x1;a<i;++a) {
							//System.out.println(true);
							for(int b=0;b<j.getPieces().length;++b) {
								//System.out.print("X1 et Y1 : ");
								//System.out.println(a + " " + y1);
								if(this.estPossible(a, y1, j) && j.getPiecea(b).estPossible(a, y1, j) ) {
									//System.out.println(true);
									return true;
									
								}
							}
						}
					}
					//System.out.println("resultat du 4eme if :");
					if(x1>i && y1==k) {
						//System.out.println(true);
						for(int a=x1;a>i;--a) {
							for(int b=0;b<j.getPieces().length;++b) {
								//System.out.print("X1 et Y1 : ");
								//System.out.println(a + " " + y1);
								if(this.estPossible(a, y1, j) && j.getPiecea(b).estPossible(a, y1, j) ) {
									//System.out.println(true);
									return true;
								}
							}
						}
					}
					
				}
			}
		}
		//System.out.println(false);
		return false;
		
	}
	@Override
	public boolean verificationMat(boolean[][] tab, Joueur quiApelle, Joueur j) {
		
		for(int i=0;i<tab.length;++i) {  // x
			for(int k=0;k<tab[0].length;++k) { //y
				if(tab[i][k]==true) {
					
					if(super.getX()==i && super.getY() <k){
						for(int a=1;a<k;++a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(i, super.getY()+a, j) && j.getPiecea(i).estPossible(i, super.getY()+a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							}
						}
					}
					if(super.getX() == i && super.getY() >k) { //gauche
						for(int a=k;a>k;--a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(i, super.getY()-a, j) && j.getPiecea(i).estPossible(i, super.getY()-a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							
							}
						}
					}			
					if(super.getY() == k && super.getX() > i ) {
									//haut
						for(int a=i;a<i;++a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(i, super.getX()+a, j) && j.getPiecea(i).estPossible(i, super.getX()+a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
									return false;
								}
							
							}
						}
						
					}if(super.getY() == k && super.getX() < i) {
									//bas
						for(int a=i;a>i;--a) {	//Pour toutes les cases jusqu'au roi possibles
							for(int p=0;p<j.getPieces().length;++p){
								if(this.estPossible(i, super.getX()-a, j) && j.getPiecea(i).estPossible(i, super.getX()-a, quiApelle)) { // Si moi je peux, et lui aussi : c'est pas bon
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

}
