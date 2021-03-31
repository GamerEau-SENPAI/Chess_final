package appli;
import java.util.Scanner;

import piece.Piece;
import piece.PieceRoi;
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
	private static char[] CreationVal() {
		char[] val = new char[9];
		for(char i='1';i<'9';++i) {
			val[i-'1']=i;
		}
		return val;
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
	private static int charToInt(String a, int x) { // x=1 ou 3
		char[] val = CreationVal();
		for(int i=0;i<10;++i) {
			if(a.charAt(x)==val[i]) {
				return i+1;
			}
		}
		return 0;
	}
	private static void jouer(Plateau plat, Piece[] pieces) {
		Scanner saisie = new Scanner(System.in);
		String entree = saisie.nextLine();
		int a = index(entree,0);
		int b = charToInt(entree,1);
		for(int i=0;i<pieces.length;++i) {
			if(pieces[i].getY()==a && pieces[i].getX()==b) {
				plat.cls(b,a);
				pieces[i].setXY(charToInt(entree,3),index(entree,2));
				plat.setTab(pieces[i]);
			}
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		Plateau plat = new Plateau();
		Piece[] pieces = new Piece[2];
		pieces[0] = new PieceRoi(plat,1,2,false);
		pieces[1] = new PieceRoi(plat,7,4,true);
		
		do{
			System.out.print(plat);
			jouer(plat,pieces);
			
		}while(true);
		
	}
}
