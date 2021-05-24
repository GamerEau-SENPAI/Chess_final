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
	
	
	/**@brief :incr�mente de 1 le compteur
	 * @return void
	 */
	void incCpt();
	
	
	/**@brief : Donne le tableau boolean des cases possi@Override
	bles autour du roi
	 * @return Un boolean 2d
	 */
	boolean[][] getTab();
	
	
	/**@brief :Donne une la valeur d'une case pr�cise de ce tableau
	 * @param x [in]: la ligne
	 * @param y [in]: la colonne 
	 * @return vrai ou faux dependant de la valeur du tableau
	 */
	boolean getTab(int x, int y);
	
	
	/**@brief :change la valeur d'une coordonn� du tableau
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param  etat [in]: l'�tat de cette coordonn�e
	 * @return vvoid
	 */
	void setTab(int x, int y, boolean etat);
	
	
	/**@brief :Donne la pi�ce demand�
	 * @param [in] i : l'indice de la pi�ce
	 * @return une Pi�ce
	 */
	IPiece getPiecea(int i);
	
	
	/**@brief :Change la pi�ce demand�
	 * @param [in] i : l'indice de la pi�ce
	 * @param [in] c : La pi�ce
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
	
	
	/**@brief :Donne la liste de pi�ces de celui qui l'appelle
	 * @return Tableau de type Pi�ce
	 */
	IPiece[] getPieces();
	
	
	/**@brief : Permets de changer la valeur de gagnant
	 * @param [in] etat : La nouvelle valeur
	 * @return void
	 */
	void setGagnant(boolean etat);
	
	
	/**@brief :Donne l'�tat de gagnant
	 * @return true ou false
	 */
	boolean getGagnant();
	
	

	/**@brief :Dit si le roi de celui qui l'appel est vivant
	 * @return true ou false
	 */
	boolean roiEstEnVie();
	
	
	/**@brief : Dit si Echec est Mat
	 * @param [in] joueur : le joueur concern�
	 * @return true ou false
	 */
	boolean EstMat(IJoueur j);
	
	
	/**@brief : Dit si il y a Echec
	 * @param [in] joueur : le joueur concern�
	 * @return true ou false
	 */
	boolean EstEchec(IJoueur j);
	
	
	/**@brief : Mange la pi�ce dans ces coordonn�es
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param [in] joueur : le joueur concern�
	 * @return void
	 */
	void EtreMang�(int x, int y, IJoueur j);
	
	
	/**@brief : Dit s'il reste des pi�ces envie
	 * @return True ou false
	 */
	boolean RestePiece();
	
	
	/**@brief : Dit s'il dans ces coordonn�es il y a une pi�ce a celui qui appelle la fonction
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @return True ou false
	 */
	boolean estOccupeParMoi(int x, int y);
	
	
	/**@brief : Permets a un joueur de jouer un coup
	 * @param  plat [in] : la ligne
	 * @param  j [in]: le joueur oppos�
	 * @return void
	 */
	void jouer(IPlateau plat, Joueur j);

}