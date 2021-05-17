package piece;

import plateau.IPiece;

public interface IPlateau {

	void cls(int x, int y);

	void clsTotal();

	String toString();

	void setTab(joueur.IPiece iPiece);

}