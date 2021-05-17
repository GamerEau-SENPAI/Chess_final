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
	public int getCpt() {
		return cpt;
	}
	
	@Override
	public void incCpt() {
		if(this.cpt<5) {
			this.cpt+=1;
		}
		
	}
	public boolean[][] getTab(){
		return this.tab;
	}
	@Override
	public boolean getTab(int x, int y){
		return this.tab[x][y];
	}
	@Override
	public void setTab(int x, int y,boolean etat){
		this.tab[x][y] = etat;
	}
	@Override
	public IPiece getPiecea(int i) {
		return pieces[i];
	}
	@Override
	public void setPiece(int i, IPiece c) {
		if(i>4) {
			i=5;
		}
		pieces[i]=c;
	}
	@Override
	public boolean EstTour() {
		return this.monTour;
	}
	@Override
	public void setTour(boolean tour) {
		this.monTour = tour;
	}
	
	@Override
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
	public void setGagnant(boolean etat) {
		this.gagant = etat;
	}
	@Override
	public boolean getGagnant() {
		return this.gagant;
	}
	
	@Override
	public boolean roiEstEnVie() {
		int roi = chercheRoi(this);
		if(this.getPiecea(roi).EstVivante()) {
			return true;
		}
		this.setGagnant(true);
		return false;
	}
	@Override
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
	public boolean RestePiece() {
		for(int i=0;i<this.getPieces().length;++i) {
			if(this.getPiecea(i).EstVivante()) {
				return true;
			}
			
		}
		return false;
	}
	public boolean estOccupeParMoi(int x, int y) {
		for(int i=0; i< this.getPieces().length;++i) {
			if(x==this.getPiecea(i).getX() || y==this.getPiecea(i).getY())
				return true;
		}
		return false;
	}
	
}
