package piece;

import joueur.IPiece;
import joueur.Joueur;
import piece.IJoueur;
public interface IJoueur {
	/**@brief :setteur du temps d'attente pour une machine jouer
	 * @param a[in] le temps en ms
	 * @return void
	 */
	void setTemps(int a);
	/**@brief :Donne l'indice du compteur
	 * @return l'indice
	 */
	int getCpt();
	
	
	/**@brief :incrémente de 1 le compteur
	 * @return void
	 */
	void incCpt();
	
	
	/**@brief : Donne le tableau boolean des cases possi@Override
	bles autour du roi
	 * @return Un boolean 2d
	 */
	boolean[][] getTab();
	
	
	/**@brief :Donne une la valeur d'une case précise de ce tableau
	 * @param x [in]: la ligne
	 * @param y [in]: la colonne 
	 * @return vrai ou faux dependant de la valeur du tableau
	 */
	boolean getTab(int x, int y);
	
	
	/**@brief :change la valeur d'une coordonné du tableau
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param  etat [in]: l'état de cette coordonnée
	 * @return vvoid
	 */
	void setTab(int x, int y, boolean etat);
	
	
	/**@brief :Donne la pièce demandé
	 * @param [in] i : l'indice de la pièce
	 * @return une Pièce
	 */
	IPiece getPiecea(int i);
	
	
	/**@brief :Change la pièce demandé
	 * @param [in] i : l'indice de la pièce
	 * @param [in] c : La pièce
	 * @return void
	 */
	void setPiece(int i, IPiece c);
	
	
	/**@brief :Donne true si c'est au tour du joueur qui appelle 
	 * @return True ou false
	 */
	boolean EstTour();
	
	
	/**@brief :Change la valeur du tour
	 * @param [in] tour : La nouvelle valeur
	 * @return void
	 */
	void setTour(boolean tour);
	
	
	/**@brief :Donne la liste de pièces de celui qui l'appelle
	 * @return Tableau de type Pièce
	 */
	IPiece[] getPieces();
	
	
	/**@brief : Permets de changer la valeur de gagnant
	 * @param [in] etat : La nouvelle valeur
	 * @return void
	 */
	void setGagnant(boolean etat);
	
	
	/**@brief :Donne l'état de gagnant
	 * @return true ou false
	 */
	boolean getGagnant();
	
	

	/**@brief :Dit si le roi de celui qui l'appel est vivant
	 * @return true ou false
	 */
	boolean roiEstEnVie();
	
	
	/**@brief : Dit si Echec est Mat
	 * @param [in] joueur : le joueur concerné
	 * @return true ou false
	 */
	boolean EstMat(IJoueur j);
	
	
	/**@brief : Dit si il y a Echec
	 * @param [in] joueur : le joueur concerné
	 * @return true ou false
	 */
	boolean EstEchec(IJoueur j);
	
	
	/**@brief : Mange la pièce dans ces coordonnées
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param [in] joueur : le joueur concerné
	 * @return void
	 */
	void EtreMangé(int x, int y, IJoueur j);
	
	
	/**@brief : Dit s'il reste des pièces envie
	 * @return True ou false
	 */
	boolean RestePiece();
	
	
	/**@brief : Dit s'il dans ces coordonnées il y a une pièce a celui qui appelle la fonction
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @return True ou false
	 */
	boolean estOccupeParMoi(int x, int y);
	
	
	/**@brief : Permets a un joueur de jouer un coup
	 * @param  plat [in] : la ligne
	 * @param  j [in]: le joueur opposé
	 * @return void
	 */
	void jouer(IPlateau plat, Joueur j);

}