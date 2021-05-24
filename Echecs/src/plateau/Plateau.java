package plateau;

import java.util.Arrays;


import piece.IPlateau;

public class Plateau implements IPlateau {
	private String plateau[][];
	private final int SIZE=10;

	
	/**@brief : créer le plateau d'échecs
	 * @return void
	 */
	public Plateau() {
		char[] alphabet = new char[SIZE];
		int cpt=0;
		int cptInv=8;
		int ligne=SIZE;
		int colonne=SIZE;
		this.plateau=new String[ligne][colonne];
		for (String[] lign: plateau)
		    Arrays.fill(lign, "   ");
        for(char ch = 'a'; ch <= 'h'; ++ch){
            alphabet[ch-'a']=ch;
            this.plateau[0][cpt] = String.valueOf(alphabet[cpt]);
            this.plateau[SIZE-1][cpt] = String.valueOf(alphabet[cpt]);
            cpt++;
        }
		for(int i=1;i<SIZE-1;++i) {
			this.plateau[i][0]=String.valueOf(cptInv);
			this.plateau[i][SIZE-1]=String.valueOf(cptInv);
			cptInv--;
		}
        

	}
	@Override
	/**@brief :nettoie une case donné
	 * @param x[in] : le x
	 * @param y[in] : le y 
	 * @return void
	 */
	public void cls(int x, int y) {
		this.plateau[x][y]="   ";
		
	}
	@Override
	/**@brief :Vide toute les cases du tableau
	 * @return void
	 */
	public void clsTotal() {
		for(int i=1;i<SIZE-1;++i) {
			for(int j=1;j<SIZE-1;++j) {
				this.cls(i, j);
			}
		}
	}
	@Override
	/**@brief : change la position de la pièce à afficher 
	 * @param a[in] : la pièce concernée
	 * @return void
	 */
	public void setTab(joueur.IPiece a) {
		this.plateau[a.getX()][a.getY()] = a.toString();
		
		
	}
	/**@brief : savoir si la pièce est hors du plateau
	 * @param i[in] : position de la pièce sur la hauteur
	 * @param j [in] : position de la pièce sur la largeur
	 * @return boolean
	 */
	private Boolean PeutAfficher(int i, int j) {
		if(i==0) {
			return false;
		}
		if(i==9)
			return false;
		else
			return true;

	}
	@Override
	/**@brief : affiche le plateau
	 * @return String
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int i=0;i<SIZE;++i) {
			for(int j=0;j<SIZE;++j) {
				if(i==0 || i>8) {
					s.append("   ");
				}
				if(PeutAfficher(i,j))
					if(j>0)
						s.append("|");
				s.append(plateau[i][j]);
			}
			s.append(System.lineSeparator());
			s.append("  ");
			for(int a=0;a<SIZE-2;++a)
				if(i<9) {
				s.append("---");
				s.append(" ");
				}
			s.append(System.lineSeparator());
		}
	return s.toString();
	}
}