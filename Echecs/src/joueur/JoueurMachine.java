package joueur;

import java.util.Random;

import plateau.Plateau;

public class JoueurMachine extends Joueur {

	public JoueurMachine(int qte, boolean monTour) {
		super(qte, monTour);
	}

	@Override
	public void jouer(Plateau plat, Joueur j) {
		boolean dejajoue=false;
		boolean reussi=false;
		boolean reussi2=false;
		int roi = chercheRoi(j);
		for(int a=0;a<super.getPieces().length;++a) {
			if(super.getPiecea(a).estPossible(j.getPiecea(roi).getX(), j.getPiecea(roi).getY(), j)) {
				System.out.println("La pièce" + super.getPiecea(a).toString() + " a bougé en X : " + j.getPiecea(roi).getX() + " Et Y : " + j.getPiecea(roi).getY());
				int x = j.getPiecea(roi).getX();
				int y = j.getPiecea(roi).getY();
    			
    			plat.cls(super.getPiecea(a).getX(),super.getPiecea(a).getY());
    			dejajoue=true;
    			super.EtreMangé(x,y, j);
    			super.getPiecea(a).setXY(x, y);
    			plat.setTab(super.getPiecea(a));
    			reussi=true;
    			if(j.RestePiece()) {
    				super.setTour(false);
    			}else {
    				super.setTour(true);
    				}
			}
		}
		if(!dejajoue) {
			Random rand = new Random();
	        int i = rand.nextInt(super.getPieces().length);
	        while (!super.getPiecea(i).EstVivante()) {
	        	i = rand.nextInt(super.getPieces().length);
	        }
	        	
	        	do {
	            	int x = rand.nextInt(8);
	                int y = rand.nextInt(8);
	    		if(super.getPiecea(i).estPossible(x,y,j)) {
	    			System.out.println("La pièce" + super.getPiecea(i).toString() + " a bougé en X : " + x + " Et Y : " + y);
	    			
	    			plat.cls(super.getPiecea(i).getX(),super.getPiecea(i).getY());
	    			super.EtreMangé(x,y, j);
	    			super.getPiecea(i).setXY(x, y);
	    			plat.setTab(super.getPiecea(i));
	    			reussi=true;
	    			if(j.RestePiece()) {
	    				super.setTour(false);
	    			}else {
	    				super.setTour(true);
	    				}
	    			
	    		}
	            }while(!reussi);
		}
		
        	try {
        		  Thread.sleep(500);
        		} catch (InterruptedException e) {e.printStackTrace();}
        }
        
        
}

