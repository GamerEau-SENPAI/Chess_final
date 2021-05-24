package joueur;

import piece.IJoueur;

public interface IPiece {
	
	/**@brief changer la valeur de "premierPassage"
	 * @param i[in] : cette nouvelle valeur
	 * @return VOID
	 */
	void setPassage(int i);
	
	/**@brief Dit si une pièce est vivante ou pas
	 * @return true ou false
	 */
	boolean EstVivante();

	/**@brief passe une pièce de vivante à morte
	 * @return void
	 */
	void EteMange();
	
	/**@brief :Dit si une coordonnée est possible pour cette pièce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @param j[in] : le joueur qui peut être devant moi
	 * @return true ou false
	 */
	boolean estPossible(int x, int y, IJoueur j);

	
	/**@brief : Change le X et le Y de cette pièce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return void
	 */
	void setXY(int x, int y);

	/**@brief : Donne le nombre de possibilités d'une pièce de coordonnée donnée
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return un int etant le nombre de possibilités
	 */
	int nbrPos(int x, int y);
	
	/**@brief : Donne le X d'une pièce
	 * @return  ce int 
	 */
	int getX();

	/**@brief : vérifie
	 * @param tab[in]
	 * @param quiAppelle[in]
	 * @param j[in]
	 * @return boolean
	 */
	boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);

	/**@brief : savoir si une pièce est le Roi
	 * @return boolean
	 */
	boolean estRoi();

	/**@brief : permet d'obtenir la valeur couleur
	 * @return int : cette couleur
	 */
	boolean getCol();


	/**@brief : Donne le Y d'une pièce
	 * @return  ce int 
	 */
	int getY();

	/**@brief : permet de savoir si le roi d'un joueur a un chemin libre
	 * @param indexRoi[in]
	 * @param j[in] 
	 * @return true s'il a chemin libre
	 */
	boolean ACheminLibre(IJoueur j, int Indexroi);

	
	/**@brief : permet de savoir si une piece du joueur j peut se mettre devant
	 * @param tab[][][in]
	 * @param j[in] 
	 * @return true si une pièce peut se mettre devant 
	 */
	boolean peutSeMettreDev(boolean tab[][], IJoueur j);

	
	/**@brief : representation d'une pièce en texte
	 * @return String de la pièce
	 */
	String toString();

	
	/**@brief : Dit si on rencontre une pièce (Du joueur opposé) dans une coordonnée donné
	 * @param x[in] : Coordonnée Y
	 * @param y[in] : coordonnée X
	 * @param j[in] : Le joueur oppsosés
	 * @return true si une pièce est recontré
	 */
	boolean recontrepiece(int x, int y, IJoueur j);

}