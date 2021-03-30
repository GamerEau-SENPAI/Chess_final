package appli;
import java.util.Scanner;

import piece.Piece;
/*30/03/21*/
import plateau.Plateau;




public class Application {
	
	
	private static char[] CreationAlp() {
		char[] alphabet = new char[10];
		for(char ch = 'a'; ch <= 'h'; ++ch){
            alphabet[ch-'a']=ch;
        }
		return alphabet;
	}
	private static int index(String a,int x) { // x=0 ou x=2
		char[] alphabet = CreationAlp();
		for(int i=0;i<10;++i) {
			if(a.charAt(x)==alphabet[i]) {
				return i+1;
			}
		}
		return 0;
	}
	private static void jouer(Piece x) {
		Scanner saisie = new Scanner(System.in);
		String entree = saisie.nextLine();
		int a = index(entree,0);
		int b = Integer.parseInt(entree.charAt(1));
	
		if(a==x.getX() && b==x.getY()) {
			x.setXY(index(entree,2), Integer.parseInt(entree, entree.charAt(1)));
			
		}
		
	}
	
	
	public static void main(String[] args) {
		Plateau plat = new Plateau();
		Piece d = new Piece(plat,1,2);
		
		do{
			System.out.print(plat);
			jouer(d);
		}while(true);
		
	}
}
