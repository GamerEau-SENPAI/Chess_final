package joueur;

import plateau.Plateau;

public class JoueurMachine extends Joueur {

	public JoueurMachine(int qte, boolean monTour) {
		super(qte, monTour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void jouer(Plateau plat, Joueur j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean EstEchec(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean EstMat(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}

}
