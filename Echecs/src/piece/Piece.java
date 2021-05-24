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
	
	/**@brief Dit si une pi�ce est vivante ou pas
	 * @return true ou false
	 */
	@Override
	public boolean EstVivante() {
		return this.vivante;
	}
	
	/**@brief passe une pi�ce de vivante � morte
	 * @return void
	 */
	@Override
	public void EteMange() {
		this.vivante=false;
	}
	
	/**@brief :Dit si une coordonn�e est possible pour cette pi�ce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @param j[in] : le joueur qui peut �tre devant moi
	 * @return true ou false
	 */
	@Override
	public abstract boolean estPossible(int x, int y, IJoueur j);
	
	/**@brief : Change le X et le Y de cette pi�ce
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return void
	 */
	@Override
	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
	}
	/**@brief : Donne le nombre de possibilit�s d'une pi�ce de coordonn�e donn�e
	 * @param x[in] : la ligne
	 * @param y[in] : la colonne
	 * @return un int etant le nombre de possibilit�s
	 */
	@Override
	public abstract int nbrPos(int x, int y);
	/**@brief : Donne le X d'une pi�ce
	 * @return  ce int 
	 */
	@Override
	public int getX() {
		if(!this.EstVivante()) {
			return 10;
		}
		return this.x;
	}
	/**@brief : v�rifie
	 * @param tab[in]
	 * @param quiAppelle[in]
	 * @param j[in]
	 * @return boolean
	 */
	@Override
	public abstract boolean verificationMat(boolean[][] tab, IJoueur quiApelle, IJoueur j);
	/**@brief : savoir si une pi�ce est le Roi
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
	/**@brief : Donne le Y d'une pi�ce
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
	 * @return true si une pi�ce peut se mettre devant 
	 */
	@Override
	public abstract boolean peutSeMettreDev(boolean tab[][], IJoueur j);
	/**@brief : representation d'une pi�ce en texte
	 * @return String de la pi�ce
	 */
	@Override
	public abstract String toString();
	
	/**@brief : Dit si on rencontre une pi�ce (Du joueur oppos�) dans une coordonn�e donn�
	 * @param x[in] : Coordonn�e Y
	 * @param y[in] : coordonn�e X
	 * @param j[in] : Le joueur oppsos�s
	 * @return true si une pi�ce est recontr�
	 */
	@Override
	public abstract boolean recontrepiece(int x, int y, IJoueur j);

}
