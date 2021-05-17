package plateau;

import piece.IJoueur;

public interface IPiece {
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	void setPassage(int i);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean EstVivante();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	void EteMange();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean estPossible(int x, int y, IJoueur j);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	void setXY(int x, int y);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	int nbrPos(int x, int y);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	int getX();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean estRoi();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean getCol();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	int getY();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean ACheminLibre(IJoueur j, int Indexroi);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean peutSeMettreDev(boolean tab[][], IJoueur j);
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	String toString();
	/**@brief :a
	 * @param
	 * @param
	 * @return
	 */
	boolean recontrepiece(int x, int y, IJoueur j);

}