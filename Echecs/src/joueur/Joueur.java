package joueur;


import piece.IJoueur;



public abstract class Joueur implements IJoueur {
	private IPiece[] pieces;
	private int[] nbrpos;
	private boolean monTour;
	private boolean tab[][];
	private boolean gagant;
	private int cpt;
	public Joueur(int qte, boolean monTour) {
		this.pieces= new IPiece[qte];
		this.nbrpos = new int[qte];
		this.monTour=monTour;
		this.gagant=false;
		cpt=0;
		tab = new boolean[8][8];
		for(int i=0;i<8;++i) {
			for(int k=0;k<8;++k) {
				this.tab[i][k]=false;
			}
		}
	}
	
	@Override
	/**@brief :Donne l'indice du compteur
	 * @return l'indice
	 */
	public int getCpt() {
		return cpt;
	}
	/**@brief :setteur du temps d'attente pour une machine jouer
	 * @param a[in] le temps en ms
	 * @return void
	 */
	public abstract void setTemps(int a);
	
	
	@Override
	/**@brief :incrémente de 1 le compteur
	 * @return void
	 */
	public void incCpt() {
		if(this.cpt<5) {
			this.cpt+=1;
		}
		
	}
	/**@brief : Donne le tableau boolean des cases possi@Override
	bles autour du roi
	 * @return Un boolean 2d
	 */
	public boolean[][] getTab(){
		return this.tab;
	}
	@Override
	/**@brief :Donne une la valeur d'une case précise de ce tableau
	 * @param x [in]: la ligne
	 * @param y [in]: la colonne 
	 * @return vrai ou faux dependant de la valeur du tableau
	 */
	public boolean getTab(int x, int y){
		return this.tab[x][y];
	}
	@Override
	/**@brief :change la valeur d'une coordonné du tableau
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param  etat [in]: l'état de cette coordonnée
	 * @return vvoid
	 */
	public void setTab(int x, int y,boolean etat){
		this.tab[x][y] = etat;
	}
	@Override
	/**@brief :Donne la pièce demandé
	 * @param [in] i : l'indice de la pièce
	 * @return une Pièce
	 */
	public IPiece getPiecea(int i) {
		return pieces[i];
	}
	@Override
	/**@brief :change la valeur d'une coordonné du tableau
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param  etat [in]: l'état de cette coordonnée
	 * @return vvoid
	 */
	public void setPiece(int i, IPiece c) {
		if(i>4) {
			i=5;
		}
		pieces[i]=c;
	}
	@Override
	/**@brief :Donne true si c'est au tour du joueur qui appelle 
	 * @return True ou false
	 */
	public boolean EstTour() {
		return this.monTour;
	}
	@Override
	/**@brief :Change la valeur du tour
	 * @param [in] tour : La nouvelle valeur
	 * @return void
	 */
	public void setTour(boolean tour) {
		this.monTour = tour;
	}
	
	@Override
	/**@brief :Donne la liste de pièces de celui qui l'appelle
	 * @return Tableau de type Pièce
	 */
	public IPiece[] getPieces() {
		return this.pieces;
	}
	
	/**@brief :Créé un alphabet de 'a' jusqu'à 'h'
	 * @return un char[]
	 */
	private static char[] CreationAlp() {
		char[] alphabet = new char[10];
		for(char ch = 'a'; ch <= 'h'; ++ch){
            alphabet[ch-'a']=ch;
        }
		return alphabet;
	}
	/**@brief :Créé tableau allant de '8' à '1'
	 * @return un char[]
	 */
	private static char[] CreationVal() {
		char[] val = new char[9];
		int cpt=1;
		for(char i='8';i>'0';--i) {
			val[cpt]=i;
			cpt++;
		}
		return val;
	}
	
	/**@brief : transforme une lettre de l'alphabet en valeur numérique
	 * @param a [in]: la chaine a convertir en int
	 * @param x [in]: l'indice de la case de la chaine a convertir
	 * @return un int
	 */
	protected static int index(String a,int x) { // x=0 ou x=2
		char[] alphabet = CreationAlp();
		for(int i=0;i<10;++i) {
			if(a.charAt(x)==alphabet[i]) {
				return i+1;
			}
		}
		return 0;
	}
	
	/**@brief : transforme un numéro 'char' en valeur numérique
	 * @param a [in] : la chaine a convertir en int
	 * @param x [in] : l'indice de la case de la chaine a convertir
	 * @return un int
	 */
	public static int charToInt(String a, int x) { // x=1 ou 3
		char[] val = CreationVal();
		for(int i=0;i<9;++i) {
			if(a.charAt(x)==val[i]) {
				return i;
			}
		}
		return 0;
	}
	
	/**@brief : Cherche et donne l'index de MA pièce qui peut attaquer le roi
	 * @param j [in] : Le joueur inverse
	 * @return L'index de ce roi
	 */
	private int IndexRoiEstVisé(IJoueur j) {
		for(int i=0;i<getPieces().length;++i) { // Pour toute mes pièces
			if(getPiecea(i).estPossible(j.getPiecea(chercheRoi(j)).getX(), j.getPiecea(chercheRoi(j)).getY(), j )) {
				return i;
			}
		}
		return -1;
	}
	@Override
	/**@brief : Permets de changer la valeur de gagnant
	 * @param [in] etat : La nouvelle valeur
	 * @return void
	 */
	public void setGagnant(boolean etat) {
		this.gagant = etat;
	}
	@Override
	/**@brief :Donne l'état de gagnant
	 * @return true ou false
	 */
	public boolean getGagnant() {
		return this.gagant;
	}
	
	@Override
	/**@brief :Dit si le roi de celui qui l'appel est vivant
	 * @return true ou false
	 */
	public boolean roiEstEnVie() {
		int roi = chercheRoi(this);
		if(this.getPiecea(roi).EstVivante()) {
			return true;
		}
		this.setGagnant(true);
		return false;
	}
	@Override
	/**@brief : Dit si Echec est Mat
	 * @param [in] joueur : le joueur concerné
	 * @return true ou false
	 */
	public boolean EstMat(IJoueur j) {
			int Viseur = IndexRoiEstVisé(j);
			int Roi= chercheRoi(this);
			if(this.roiEstVisé(j) && this.getPiecea(Viseur).ACheminLibre(j, Roi))
				return true;
		
		return false;
	}
	private boolean roiEstVisé(IJoueur j) {
		for(int i=0;i<getPieces().length;++i) { // Pour toute mes pièces
			if(getPiecea(i).estPossible(j.getPiecea(chercheRoi(j)).getX(), j.getPiecea(chercheRoi(j)).getY(), j )) {
				return true;
			}
		}
		return false;
	}
	private boolean pasDoublons(int x, int y) {
		if(getTab(x, y)==false) { // Si la case n'est pas visité
			setTab(x, y, true);	//bah mtn si 
			return true;
		}
		return false;
	}
	private boolean peutMeManger(IJoueur j) {
		for(int i=0;i<j.getPieces().length;++i) {
			for(int k=0;k<getPieces().length;++k) {
				if(j.getPiecea(i).estPossible(getPiecea(k).getX(), getPiecea(k).getY(), this)) {
					return true;
				}
			}
		}
		return false;
		
	}
	@Override
	/**@brief : Dit si il y a Echec
	 * @param [in] joueur : le joueur concerné
	 * @return true ou false
	 */
	public boolean EstEchec(IJoueur j) {
		//int verif=0;
		int Roi= chercheRoi(j);
		int coincidence=0;
		for(int x=0;x<8;++x){
			for(int y=0;y<8;++y){
				for(int i=0; i<getPieces().length;i++) {
						if(getPiecea(i).estPossible(x, y, j) && j.getPiecea(Roi).estPossible(x, y,this) ) {
							if(this.pasDoublons(x, y) && !peutMeManger(j)) {
								coincidence++;
							}
								
						}
				}
			}
		}
		if(coincidence==j.getPiecea(Roi).nbrPos(j.getPiecea(Roi).getX(),j.getPiecea(Roi).getY())) {
			return true;
		}
	return false;
		
	}
	@Override
	/**@brief : Mange la pièce dans ces coordonnées
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @param [in] joueur : le joueur concerné
	 * @return void
	 */
	public void EtreMangé(int x, int y, IJoueur j) {
		for(int i=0;i<j.getPieces().length;++i) {
			if(j.getPiecea(i).getX()==x && j.getPiecea(i).getY()==y) {
				if(j.getPiecea(i).getCol()!=getPiecea(i).getCol()) {
				j.getPiecea(i).EteMange();
				}
			}
		}
	}
	protected static int chercheRoi(IJoueur j) {
		for(int i=0; i<j.getPieces().length;++i) {
			if(j.getPiecea(i).estRoi()) {
				return i;
			}
		}
		return -1;
	}
	/**@brief : Dit s'il reste des pièces envie
	 * @return True ou false
	 */
	public boolean RestePiece() {
		for(int i=0;i<this.getPieces().length;++i) {
			if(this.getPiecea(i).EstVivante()) {
				return true;
			}
			
		}
		return false;
	}
	/**@brief : Dit s'il dans ces coordonnées il y a une pièce a celui qui appelle la fonction
	 * @param  x [in] : la ligne
	 * @param  y [in]: la colonne 
	 * @return True ou false
	 */
	public boolean estOccupeParMoi(int x, int y) {
		for(int i=0; i< this.getPieces().length;++i) {
			if(x==this.getPiecea(i).getX() || y==this.getPiecea(i).getY())
				return true;
		}
		return false;
	}
	
}
