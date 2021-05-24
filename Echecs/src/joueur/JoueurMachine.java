package joueur;

import java.util.Random;





public class JoueurMachine extends Joueur {
	private boolean reussi=true;
	public int tempsattenteTest = 500;
	private boolean dejajoue=false;
	public JoueurMachine(int qte, boolean monTour) {
		super(qte, monTour);
	}
	/**@brief : Permets de changer le temps que prends une machine a jouer
	 * @param a[in] : le temps en ms
	 * @return void
	 */
	public void setTemps(int a) {
		tempsattenteTest = a;
	}
	@Override
	/**@brief : Permets a un joueur de jouer un coup
	 * @param  plat [in] : la ligne
	 * @param  j [in]: le joueur opposé
	 * @return void
	 */
	public void jouer(piece.IPlateau plat, Joueur j) {
		if(roiEstEnDanger(j)) {
			jouerEvasion(plat, j);
			
		}else {
			
		
		int roi = chercheRoi(j);
		for(int a=0;a<super.getPieces().length;++a) {
			if(unePieceViseRoi(a,j)) {
				JouerPourLeRoi(roi,plat,j,a);
			}
		}

		if(!dejajoue) {
			jouerAleatoirement(plat,j);
		}
		}
        	try {
        		  Thread.sleep(tempsattenteTest);
        		} catch (InterruptedException e) {e.printStackTrace();}
        //dejajoue=false;
        	reussi=true;
		
		
	}

	
	
	
	
	
	/**@brief : Me dit si une piece donné vise le roi
	 * @param  a[in] : indice de la piece
	 * @param  j [in]: le joueur opposé
	 * @return true si une pièce est visé
	 */
	private boolean unePieceViseRoi(int a,Joueur j) {
		int roi = chercheRoi(j);
		return super.getPiecea(a).estPossible(j.getPiecea(roi).getX(), j.getPiecea(roi).getY(), j);
	}
	
	/**@brief : Joue pour le roi ennemi
	 * @param  roi[in] : indice du roi
	 * @param  plat[in]: Le plateau concerné
	 * @param  j[in]: Le jouer ennemi
	 * @param  a[in] : indice de la piece
	 * @return void
	 */
	private void JouerPourLeRoi(int roi, piece.IPlateau plat, Joueur j, int a) {
		System.out.println("2-La pièce" + super.getPiecea(a).toString() + " a bougé en X : " + j.getPiecea(roi).getX() + " Et Y : " + j.getPiecea(roi).getY());
		int x = j.getPiecea(roi).getX();
		int y = j.getPiecea(roi).getY();
		
		plat.cls(super.getPiecea(a).getX(),super.getPiecea(a).getY());
		dejajoue=true;
		super.EtreMangé(x,y, j);
		super.getPiecea(a).setXY(x, y);
		plat.setTab((joueur.IPiece) super.getPiecea(a));
		reussi=false;
		if(j.RestePiece()) {
			super.setTour(false);
		}else {
			super.setTour(true);
			}
	}
	/**@brief : Joue Aleatoirement
	 * @param  plat[in]: Le plateau concerné
	 * @param  j[in]: Le jouer ennemi
	 * @return void
	 */
	private void jouerAleatoirement(piece.IPlateau plat, Joueur j) {
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
	    			plat.setTab((joueur.IPiece) super.getPiecea(i));
	    			reussi=false;

	    			if(j.RestePiece()) {
	    				super.setTour(false);
	    			}else {
	    				super.setTour(true);
	    				}
	    			
	    		}
            }while(reussi);
	}
	
	/**@brief : Me dit si mon roi est en danger
	 * @param  j[in]: Le jouer ennemi
	 * @return true si c'est le cas
	 */
	private boolean roiEstEnDanger(Joueur j) {
		int roi = chercheRoi(this);
		for(int i=0;i<j.getPieces().length;++i) {
			if(j.getPiecea(i).estPossible(super.getPiecea(roi).getX(), super.getPiecea(roi).getY(), this)) {
				return true;
			}
		}
		return false;
		
	}
	
	/**@brief : Joue un coup ou ses pieces ne peuvent pas m'attaquer
	 * @param  plat[in]: Le plateau concerné
	 * @param  j[in]: Le jouer ennemi
	 * @return void
	 */
	private void jouerEvasion(piece.IPlateau plat, Joueur j) {
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
	
	/**@brief : Complement a jouerEvasion (Joue un coup pour fuir) 
	 * @param  plat[in]: Le plateau concerné
	 * @param  j[in]: Le jouer ennemi
	 * @param  x[in]: la coordonné X de mon roi
	 * @param  y[in]: la coordonné Y de mon roi
	 * @return void
	 */
	private void jouerAutrePart(int x, int y, Joueur j, piece.IPlateau plat) {
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
					plat.setTab((joueur.IPiece) super.getPiecea(roi));
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

