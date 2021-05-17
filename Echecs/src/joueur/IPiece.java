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

	boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);

	boolean estRoi();

	boolean getCol();


	/**@brief : Donne le Y d'une pièce
	 * @return  ce int 
	 */
	int getY();

	boolean ACheminLibre(IJoueur j, int Indexroi);

	boolean peutSeMettreDev(boolean tab[][], IJoueur j);

	String toString();

	boolean recontrepiece(int x, int y, IJoueur j);

}