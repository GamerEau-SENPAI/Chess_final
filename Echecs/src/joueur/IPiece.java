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

	/**@brief : v�rifie
	 * @param tab[in]
	 * @param quiAppelle[in]
	 * @param j[in]
	 * @return boolean
	 */
	boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);

	/**@brief : savoir si une pi�ce est le Roi
	 * @return boolean
	 */
	boolean estRoi();

	/**@brief : permet d'obtenir la valeur couleur
	 * @return int : cette couleur
	 */
	boolean getCol();


	/**@brief : Donne le Y d'une pi�ce
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
	 * @return true si une pi�ce peut se mettre devant 
	 */
	boolean peutSeMettreDev(boolean tab[][], IJoueur j);

	
	/**@brief : representation d'une pi�ce en texte
	 * @return String de la pi�ce
	 */
	String toString();

	
	/**@brief : Dit si on rencontre une pi�ce (Du joueur oppos�) dans une coordonn�e donn�
	 * @param x[in] : Coordonn�e Y
	 * @param y[in] : coordonn�e X
	 * @param j[in] : Le joueur oppsos�s
	 * @return true si une pi�ce est recontr�
	 */
	boolean recontrepiece(int x, int y, IJoueur j);

}