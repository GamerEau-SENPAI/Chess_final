package appli;

import java.util.Random;

import joueur.JoueurHumain;
import joueur.JoueurMachine;
import piece.IJoueur;
import piece.IPlateau;
import piece.PieceFou;
import piece.PieceRoi;
import piece.PieceTour;


public class Fabrique implements piece.IFabrique {
	private static IJoueur j1;
	private static IJoueur j2;
	private final static int TAILLE =8;
	private final static int NBRP =10;
	private final static int QTEPIECE =5;
	
	/**@brief :Ajoute un roi
	 * @param j [in] :Le joueur concerné
	 * @param plat [in] : Le plateau de jeu concerné
	 * @param x [in] : Sa ligne
	 * @param y [in] : Sa colonne
	 * @param couleur [in] : et sa couleur
	 * @return void
	 */
	private void ajoutRoi(IJoueur j,IPlateau plat, int x, int y, boolean couleur) {
		j.setPiece(j.getCpt(), new PieceRoi(plat,x,y,couleur));
		j.incCpt();
	}
	
	/**@brief :Ajoute une tour
	 * @param j [in] :Le joueur concerné
	 * @param plat [in] : Le plateau de jeu concerné
	 * @param x [in] : Sa ligne
	 * @param y [in] : Sa colonne
	 * @param couleur [in] : et sa couleur
	 * @return void
	 */
	private void ajoutTour(IJoueur j,IPlateau plat, int x, int y, boolean couleur) {
		j.setPiece(j.getCpt(), new PieceTour(plat,x,y,couleur));
		j.incCpt();
	}
	
	/**@brief :Ajoute un Fou
	 * @param j [in] :Le joueur concerné
	 * @param plat [in] : Le plateau de jeu concerné
	 * @param x [in] : Sa ligne
	 * @param y [in] : Sa colonne
	 * @param couleur [in] : et sa couleur
	 * @return void
	 */
	private void ajoutFou(IJoueur j,IPlateau plat, int x, int y, boolean couleur) {
		j.setPiece(j.getCpt(), new PieceFou(plat,x,y,couleur));
		j.incCpt();
	}
	
	/**@brief :Vérifie si une pièce n'est pas deja placé dans un x et y donn
	 * @param LesY [in] : Les y qui ont deja été jouées
	 * @param LesX [in] : Les x qui ont deja été jouées
	 * @param x [in] : Sa ligne
	 * @param y [in] : Sa colonne
	 * @return boolean true or false
	 */
	private static boolean existe(int x, int y, int lesx[], int lesy[]) {
		for(int x1=0;x1<TAILLE;++x1) {
			for(int y1=0;y1<TAILLE;++y1) {
				if(lesx[x1]==x && lesy[y1]==y) {
					return true;
				}
			}
		}
		return false;
	}


	/**@brief : Initialise le jeu
	 * @param plat [in] : Le plateau
	 * @param j1 [in] : le premier joueur
	 * @param j2 [in] : le 2ème joueur
	 * @return void
	 */
	public void initialisation(IPlateau plat, IJoueur j1, IJoueur j2) {
		int nbr=0;
		int LesX[] = new int[NBRP];
		int LesY[] = new int[NBRP];
		int compteur=0;
		int x=0;
		int y=0;
		Random rand = new Random();
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutRoi(j1,plat, x+1, y+1, true);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutFou(j1,plat, x+1, y+1, true);
	        	nbr++;
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutFou(j1,plat, x+1, y+1, true);
	        	nbr++;
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutTour(j1,plat, x+1, y+1, true);
	        	nbr++;
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutTour(j1,plat, x+1, y+1, true);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutRoi(j2,plat, x+1, y+1, false);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutFou(j2,plat, x+1, y+1, false);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutFou(j2,plat, x+1, y+1, false);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        	int a=0;
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
		        a++;
		        if(a>20) {
		        }
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutTour(j2,plat, x+1, y+1, false);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	        
	        do{
	        	x = rand.nextInt(TAILLE-1);
		        y = rand.nextInt(TAILLE-1);
	        }while(existe(x,y,LesX,LesY));
	        	this.ajoutTour(j2,plat, x+1, y+1, false);
	        	LesX[compteur]=x;
	        	LesY[compteur]=y;
	        	compteur++;
	}
	/**@brief : Initialise le jeu, un humain contre un autre humain
	 * @return void
	 */
	private static void HumainVShumain() {
		setJ1(null);
		setJ2(null);
		setJ1(new JoueurHumain(QTEPIECE, true));
		setJ2(new JoueurHumain(QTEPIECE, true));
	}
	
	/**@brief : Initialise le jeu, un humain contre une machine
	 * @return void
	 */
	private static void HumainVSMachine() {
		setJ1(null);
		setJ2(null);
		setJ1(new JoueurHumain(QTEPIECE, true));
		setJ2(new JoueurMachine(QTEPIECE, true));
	}
	
	
	/**@brief : Initialise le jeu, une machine contre une machine
	 * @return void
	 */
	private static void MachineVSMachine() {
		setJ1(null);
		setJ2(null);
		setJ1(new JoueurMachine(QTEPIECE, true));
		setJ2(new JoueurMachine(QTEPIECE, true));
	}
	
	
	/**@brief : Initialise les joueurs
	 * @param mode [in] : le mode 
	 * @return void
	 */
	@Override
	public void initialisationJoueurs(String mode) {
		if(mode.equals("1"))
			HumainVShumain();
		else if(mode.equals("2"))
			HumainVSMachine();
		else if(mode.equals("3"))
			MachineVSMachine();
		
	}
	/**@brief : getteur de j1 pour les test junit
	 * @return Le joueur j1
	 */
	public static IJoueur getJ1() {
		return j1;
	}
	/**@brief : setteur de j1 pour les test junit
	 * @param j1 La valeur a etre donné au joueur de la fabrique
	 * @return void
	 */
	public static void setJ1(IJoueur j1) {
		Fabrique.j1 = j1;
	}
	
	/**@brief : getteur de j2 pour les test junit
	 * @return Le joueur j2
	 */
	public static IJoueur getJ2() {
		return j2;
	}
	/**@brief : setteur de j2 pour les test junit
	 * @param j2La valeur a etre donné au joueur de la fabrique
	 * @return void
	 */
	public static void setJ2(IJoueur j2) {
		Fabrique.j2 = j2;
	}
}
