package joueur;

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

	
	/**@brief : change la position de la pièce à afficher 
	 * @param a[in] : la pièce concernée
	 * @return void
	 */
	void setTab(IPiece a);

	
	/**@brief : affiche le plateau
	 * @return String
	 */
	String toString();

}