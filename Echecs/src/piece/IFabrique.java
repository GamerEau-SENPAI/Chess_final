package piece;

public interface IFabrique {
	/**@brief : initialise le plateau et les joueurs
	 * @param plat[in] : le plateau
	 * @param j1[in] : le joueur 1
	 * @param j1[in] : le joueur 2
	 * @return void
	 */
	public void initialisation(IPlateau plat, IJoueur j1, IJoueur j2);
	/**@brief : initialise
	 * @param veleur[in]
	 * @return void
	 */
	public void initialisationJoueurs(String veleur);
}
