package plateau;

import piece.IJoueur;

public interface IPiece {
	
	/**@brief changer la valeur de "premierPassage"
	 * @param i[in] : cette nouvelle valeur
	 * @return VOID
	 */
	void setPassage(int i);
	
	/**@brief : permet de savoir si une pièce est vivante
	 * @return boolean
	 */
	boolean EstVivante();
	
	/**@brief : permet de savoir si une pièce a été mangée par une autre
	 * @return void
	 */
	void EteMange();
	
	/**@brief : permet de savoir si un coup est possible
	 * @param x[in] 
	 * @param y[in]
	 * @param j[in] le joueur qui joue
	 * @return boolean
	 */
	boolean estPossible(int x, int y, IJoueur j);
	
	/**@brief : changer la valeur de X et de Y
	 * @param x[in] la nouvelle valeur de x
	 * @param y[in] la nouvelle valeur de y
	 * @return void
	 */
	void setXY(int x, int y);
	
	
	/**@brief : Donne le nbr de positions possibles pour cette pièce
	 * @param x[in] :X de la coordonné
	 * @param y[in] :Y de la coordonnée
	 * @return int : ce nombre
	 */
	int nbrPos(int x, int y);
	
	
	/**@brief : permet d'obtenir la valeur x
	 * @return int : la valeur de x
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
	
	/**@brief : permet d'obtenir la colonne
	 * @return boolean
	 */
	boolean getCol();
	
	/**@brief : permet d'obtenir la valeur y
	 * @return int : la valeur de y
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