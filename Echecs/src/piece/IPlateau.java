package piece;


public interface IPlateau {
	/**@brief :nettoie une case donn�
	 * @param x[in] : le x
	 * @param y[in] : le y 
	 * @return void
	 */
	void cls(int x, int y);
	
	
	/**@brief :Vide toute les cases du tableau
	 * @return void
	 */
	void clsTotal();

	/**@brief : affiche le plateau
	 * @return String
	 */
	String toString();

	
	/**@brief : change la position de la pi�ce � afficher 
	 * @param iPiece[in] : la pi�ce concern�e
	 * @return void
	 */
	void setTab(joueur.IPiece iPiece);

}