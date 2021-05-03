package joueur;

import java.util.Random;

import plateau.Plateau;

public class JoueurMachine extends Joueur {

	public JoueurMachine(int qte, boolean monTour) {
		super(qte, monTour);
	}

	@Override
	public void jouer(Plateau plat, Joueur j) {
		boolean reussi=false;
		boolean reussi2=false;
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
        	try {
        		  Thread.sleep(500);
        		} catch (InterruptedException e) {e.printStackTrace();}
        }
        
        
}

