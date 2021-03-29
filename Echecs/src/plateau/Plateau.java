package plateau;

import java.util.Arrays;

public class Plateau {
	private String plateau[][];
	private final int SIZE=8;
	private String[] alp = new String[SIZE];
	private int taille[]=new int[SIZE];
	
	
	public Plateau() {
		char[] alphabet = new char[SIZE];
		int cpt=0;
        for(char ch = 'a'; ch <= 'h'; ++ch){
            alphabet[ch-'a']=ch;
            this.alp[cpt] = String.valueOf(alphabet[cpt]);
            cpt++;
        } 
        
		int ligne=SIZE;
		int colonne=SIZE;
		this.plateau=new String[ligne][colonne];
		for (String[] lign: plateau)
		    Arrays.fill(lign, " ");
	}
	
	public void affichage() {
		for(int i=0;i<SIZE;++i) {
			System.out.print(" ");
			System.out.print(alp[i]);
			System.out.print(" ");
			
		}
		
	}
}
