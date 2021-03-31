package piece;

import plateau.Plateau;

public class PieceRoi extends Piece {

	public PieceRoi(Plateau p, int x, int y, boolean couleur) {
		super(p, x, y, couleur);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		if(super.getCol()==false)
			return " r ";
		else
			return " R ";
		
	}

}
