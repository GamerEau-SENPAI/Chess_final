package joueur;

import joueur.IPiece;

public interface IPlateau {

	void cls(int x, int y);

	void clsTotal();

	void setTab(IPiece a);

	String toString();

}