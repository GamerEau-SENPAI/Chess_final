package joueur;

import java.util.Random;

import plateau.Plateau;

public class JoueurMachine extends Joueur {
	private boolean reussi=true;
	private boolean dejajoue=false;
	public JoueurMachine(int qte, boolean monTour) {
		super(qte, monTour);
	}

	@Override
	public void jouer(Plateau plat, Joueur j) {
		
		if(roiEstEnDanger(j)) {
			System.out.println("Roi est en danger est appelé");
			jouerEvasion(plat, j);
			
		}else {
			
		
		int roi = chercheRoi(j);
		for(int a=0;a<super.getPieces().length;++a) {
			if(unePieceViseRoi(a,j)) {
				System.out.println("Jouer pour le roi est appelé : ");
				JouerPourLeRoi(roi,plat,j,a);
			}
		}

		if(!dejajoue) {
			System.out.println("Jouer pour Aleatoirement est appelé : ");
			jouerAleatoirement(plat,j);
		}
		}
        	try {
        		  Thread.sleep(500);
        		} catch (InterruptedException e) {e.printStackTrace();}
        //dejajoue=false;
        	reussi=true;
		
  }
	
	
	
	
	
	
	private boolean unePieceViseRoi(int a,Joueur j) {
		int roi = chercheRoi(j);
		return super.getPiecea(a).estPossible(j.getPiecea(roi).getX(), j.getPiecea(roi).getY(), j);
	}
	private void JouerPourLeRoi(int roi, Plateau plat, Joueur j, int a) {
		System.out.println("2-La pièce" + super.getPiecea(a).toString() + " a bougé en X : " + j.getPiecea(roi).getX() + " Et Y : " + j.getPiecea(roi).getY());
		int x = j.getPiecea(roi).getX();
		int y = j.getPiecea(roi).getY();
		
		plat.cls(super.getPiecea(a).getX(),super.getPiecea(a).getY());
		dejajoue=true;
		super.EtreMangé(x,y, j);
		super.getPiecea(a).setXY(x, y);
		plat.setTab(super.getPiecea(a));
		reussi=false;
		if(j.RestePiece()) {
			super.setTour(false);
		}else {
			super.setTour(true);
			}
	}
	
	private void jouerAleatoirement(Plateau plat, Joueur j) {
		Random rand = new Random();
        int i = rand.nextInt(super.getPieces().length);
        while (!super.getPiecea(i).EstVivante()) {
        	i = rand.nextInt(super.getPieces().length);
        }
        	
        	do {
            	int x = rand.nextInt(8);
                int y = rand.nextInt(8);
	    		if(super.getPiecea(i).estPossible(x,y,j)){
	    			System.out.println("1-La pièce" + super.getPiecea(i).toString() + " a bougé en X : " + x + " Et Y : " + y);
	    			plat.cls(super.getPiecea(i).getX(),super.getPiecea(i).getY());
	    			super.EtreMangé(x,y, j);
	    			super.getPiecea(i).setXY(x, y);
	    			plat.setTab(super.getPiecea(i));
	    			reussi=false;

	    			if(j.RestePiece()) {
	    				super.setTour(false);
	    			}else {
	    				super.setTour(true);
	    				}
	    			
	    		}
            }while(reussi);
	}
	private boolean roiEstEnDanger(Joueur j) {
		int roi = chercheRoi(this);
		for(int i=0;i<j.getPieces().length;++i) {
			if(j.getPiecea(i).estPossible(super.getPiecea(roi).getX(), super.getPiecea(roi).getY(), this)) {
				return true;
			}
		}
		return false;
		
	}
	private void jouerEvasion(Plateau plat, Joueur j) {
		System.out.println("JouerEvasion()");
		int roi = chercheRoi(this);
		for(int i=0;i<j.getPieces().length;++i) {
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX()+1, super.getPiecea(roi).getY(), this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX()+1, super.getPiecea(roi).getY(), j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX(), super.getPiecea(roi).getY()+1, this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX(), super.getPiecea(roi).getY()+1, j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX()-1, super.getPiecea(roi).getY(), this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX()-1, super.getPiecea(roi).getY(), j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX(), super.getPiecea(roi).getY()-1, this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX(), super.getPiecea(roi).getY()-1, j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX()+1, super.getPiecea(roi).getY()+1, this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX()+1, super.getPiecea(roi).getY()+1, j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX()-1, super.getPiecea(roi).getY()+1, this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX()-1, super.getPiecea(roi).getY()+1, j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX()-1, super.getPiecea(roi).getY()-1, this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX()-1, super.getPiecea(roi).getY()-1, j, plat);
				break;
			}
			if(!j.getPiecea(i).estPossible(super.getPiecea(roi).getX()+1, super.getPiecea(roi).getY()-1, this)) {
				this.jouerAutrePart(super.getPiecea(roi).getX()+1, super.getPiecea(roi).getY()-1, j, plat);
				break;
			}
		}
	}
	private void jouerAutrePart(int x, int y, Joueur j, Plateau plat) {
		Random rand = new Random();
		int roi = chercheRoi(this);
		int x1 = x;
        int y1 = y;
		while(x1==x && y1==y) {
			do {
				x1 = rand.nextInt(8);
	            y1 = rand.nextInt(8);
				if(super.getPiecea(roi).estPossible(x1,y1,j)) {
					System.out.println("1-La pièce" + super.getPiecea(roi).toString() + " a bougé en X : " + x1 + " Et Y : " + y1);
					
					plat.cls(super.getPiecea(roi).getX(),super.getPiecea(roi).getY());
					super.EtreMangé(x1,y1, j);
					super.getPiecea(roi).setXY(x1, y1);
					plat.setTab(super.getPiecea(roi));
					reussi=false;
					if(j.RestePiece()) {
						super.setTour(false);
					}else {
						super.setTour(true);
						}
					
				}
			}while(reussi);
        }
	}
        	

        
}

