package appli;
import piece.Piece;
/*30/03/21*/
import plateau.Plateau;

public class Application {
	public static void main(String[] args) {
		Plateau plat = new Plateau();
		Piece c = new Piece(plat,1,2);
		System.out.print(plat);
	}
}
