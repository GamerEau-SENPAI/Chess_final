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
	/**@brief : permet de savoir si le joueur peut jouer
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
	/**@brief : 
	 * @param x[in]
	 * @param y[in]
	 * @return int 
	 */
	int nbrPos(int x, int y);
	/**@brief : permet d'obtenir la valeur x
	 * @return int : la valeur de x
	 */
	int getX();
	/**@brief : permet d'obtenir la valeur x
	 * @return int : la valeur de x
	 */
	boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);
	/**@brief : vérifie
	 * @param tab[in]
	 * @param quiAppelle[in]
	 * @param j[in]
	 * @return boolean
	 */
	boolean estRoi();
	/**@brief : savoir si une pièce est le Roi
	 * @return boolean
	 */
	boolean getCol();
	/**@brief : permet d'obtenir la colonne
	 * @return boolean
	 */
	int getY();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean ACheminLibre(IJoueur j, int Indexroi);
	/**@brief : permet de savoir si le roi d'un joueur a un chemin libre
	 * @param j[in] le joueur qui joue
	 * @param Indexroi[in] 
	 * @return boolean
	 */
	boolean peutSeMettreDev(boolean tab[][], IJoueur j);
	/**@brief : 
	 * @param tab[in]
	 * @param j[in] joueur qui joue
	 * @return boolean
	 */
	String toString();
	/**@brief :a
	 * @return String
	 */
	boolean recontrepiece(int x, int y, IJoueur j);

}