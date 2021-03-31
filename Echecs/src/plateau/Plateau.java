package plateau;

import java.util.Arrays;

import piece.Piece;

public class Plateau {
	private String plateau[][];
	private final int SIZE=10;
	private String[] alp = new String[SIZE];
	private int taille[]=new int[SIZE];
	
	
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
	public void cls(int x, int y) {
		this.plateau[x][y]="   ";
		
	}
	public void setTab(Piece a) {
		this.plateau[a.getX()][a.getY()] = a.toString();
		
		
	}
	private Boolean PeutAfficher(int i, int j) {
		if(i==0) {
			return false;
		}
		if(i==9)
			return false;
		else
			return true;

	}
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