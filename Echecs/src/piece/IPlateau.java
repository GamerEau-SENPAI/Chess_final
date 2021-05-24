package piece;


public interface IPlateau {
	/**@brief :nettoie une case donné
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

	
	/**@brief : change la position de la pièce à afficher 
	 * @param iPiece[in] : la pièce concernée
	 * @return void
	 */
	void setTab(joueur.IPiece iPiece);

}