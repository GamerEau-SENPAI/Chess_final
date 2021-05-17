package joueur;

import piece.IJoueur;

public interface IPiece {
	
	/**@brief changer la valeur de "premierPassage"
	 * @param i[in] : cette nouvelle valeur
	 * @return VOID
	 */
	void setPassage(int i);
	
	/**@brief Dit si une pi�ce est vivante ou pas
	 * @return true ou false
	 */
	boolean EstVivante();

	/**@brief passe une pi�ce de vivante � morte
	 * @return void
	 */
	void EteMange();
	
	/**@brief :Dit si une coordonn�e est possible pour cette pi�ce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @param j[in] : le joueur qui peut �tre devant moi
	 * @return true ou false
	 */
	boolean estPossible(int x, int y, IJoueur j);

	
	/**@brief : Change le X et le Y de cette pi�ce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return void
	 */
	void setXY(int x, int y);

	/**@brief : Donne le nombre de possibilit�s d'une pi�ce de coordonn�e donn�e
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return un int etant le nombre de possibilit�s
	 */
	int nbrPos(int x, int y);
	
	/**@brief : Donne le X d'une pi�ce
	 * @return  ce int 
	 */
	int getX();

	boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);

	boolean estRoi();

	boolean getCol();


	/**@brief : Donne le Y d'une pi�ce
	 * @return  ce int 
	 */
	int getY();

	boolean ACheminLibre(IJoueur j, int Indexroi);

	boolean peutSeMettreDev(boolean tab[][], IJoueur j);

	String toString();

	boolean recontrepiece(int x, int y, IJoueur j);

}