package piece;

import joueur.IPiece;

public abstract class Piece implements IPiece {
	private int x;
	private int y;
	private boolean vivante;
	private boolean couleur;
	private int premierPassage;
	public Piece(IPlateau p,int x, int y, boolean col) {
		this.x=x;
		this.y=y;
		this.couleur=col;
		this.vivante = true;
		this.premierPassage=0;
		p.setTab((IPiece) this);
		
	}
	
	/**@brief changer la valeur de "premierPassage"
	 * @param i[in] : cette nouvelle valeur
	 * @return VOID
	 */
	@Override
	public void setPassage(int i) {
		premierPassage=i;
	}
	
	/**@brief Dit si une pièce est vivante ou pas
	 * @return true ou false
	 */
	@Override
	public boolean EstVivante() {
		return this.vivante;
	}
	
	/**@brief passe une pièce de vivante à morte
	 * @return void
	 */
	@Override
	public void EteMange() {
		this.vivante=false;
	}
	
	/**@brief :Dit si une coordonnée est possible pour cette pièce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @param j[in] : le joueur qui peut être devant moi
	 * @return true ou false
	 */
	@Override
	public abstract boolean estPossible(int x, int y, IJoueur j);
	
	/**@brief : Change le X et le Y de cette pièce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return void
	 */
	@Override
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	/**@brief : Donne le nombre de possibilités d'une pièce de coordonnée donnée
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return un int etant le nombre de possibilités
	 */
	@Override
	public abstract int nbrPos(int x, int y);
	/**@brief : Donne le X d'une pièce
	 * @return  ce int 
	 */
	@Override
	public int getX() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.x;
	}
	/**@brief : vérifie
	 * @param tab[in]
	 * @param quiAppelle[in]
	 * @param j[in]
	 * @return boolean
	 */
	@Override
	public abstract boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);
	/**@brief : savoir si une pièce est le Roi
	 * @return boolean
	 */
	@Override
	public abstract boolean estRoi();
	/**@brief : permet d'obtenir la valeur couleur
	 * @return int : cette couleur
	 */
	@Override
	public boolean getCol() {
		return this.couleur;
	}
	/**@brief : Donne le Y d'une pièce
	 * @return  ce int 
	 */
	@Override
	public int getY() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.y;
	}
	/**@brief : permet de savoir si le roi d'un joueur a un chemin libre
	 * @param indexRoi[in]
	 * @param j[in] 
	 * @return true s'il a chemin libre
	 */
	@Override
	public abstract boolean ACheminLibre(IJoueur j, int Indexroi);
	/**@brief : permet de savoir si une piece du joueur j peut se mettre devant
	 * @param tab[][][in]
	 * @param j[in] 
	 * @return true si une pièce peut se mettre devant 
	 */
	@Override
	public abstract boolean peutSeMettreDev(boolean tab[][], IJoueur j);
	/**@brief : representation d'une pièce en texte
	 * @return String de la pièce
	 */
	@Override
	public abstract String toString();
	
	/**@brief : Dit si on rencontre une pièce (Du joueur opposé) dans une coordonnée donné
	 * @param x[in] : Coordonnée Y
	 * @param y[in] : coordonnée X
	 * @param j[in] : Le joueur oppsosés
	 * @return true si une pièce est recontré
	 */
	@Override
	public abstract boolean recontrepiece(int x, int y, IJoueur j);

}
