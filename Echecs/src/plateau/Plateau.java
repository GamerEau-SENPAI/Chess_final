package plateau;

import java.util.Arrays;

public class Plateau {
	private String plateau[][];
	private final int SIZE=10;
	private String[] alp = new String[SIZE];
	private int taille[]=new int[SIZE];
	
	
	public Plateau() {
		char[] alphabet = new char[SIZE];
		int cpt=0;
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
			this.plateau[i][0]=String.valueOf(i);
			this.plateau[i][SIZE-1]=String.valueOf(i);
		}
        

	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(int i=0;i<SIZE;++i) {
			for(int j=0;j<SIZE;++j) {
				if(i==0 || i>8) {
					s.append("  ");
				}
				s.append(plateau[i][j]);
			}
			s.append(System.lineSeparator());
		}
	return s.toString();
	}
}

