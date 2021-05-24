package joueur;

import java.util.Scanner;






public class JoueurHumain extends Joueur {
	
	
	public JoueurHumain(int qte, boolean monTour) {
		super(qte, monTour);
	}
	/**@brief : nécessaire que dans humainMachine
	 * @param a[in] : le temps en ms
	 * @return void
	 */
	public void setTemps(int a) {
	}
	/**@brief : Vérification d'une saisi clavier et correction
	 * @return Le input régularisé
	 */
	private String creationEntree() {
		char[] lettres = {'a','b','c','d','e','f','g','h'};
		char[] nums = {'1','2','3','4','5','6','7','8'};
		boolean valide=false;
		Scanner saisie = new Scanner(System.in);
		String entree = null;
		System.out.print(">");
		while(valide==false) {
			entree = saisie.nextLine();
			entree  = entree.replaceAll(" ","");
			entree = entree.toLowerCase();
			for(int i = 0; i < lettres.length;++i) {
				if(entree.charAt(0)==lettres[i]) {
					for(int j = 0; j < nums.length;++j) {
						if(entree.charAt(1)==nums[j]) {
							for(int k = 0; k < lettres.length;++k) {
								if(entree.charAt(2)==lettres[k]) {
									for(int l = 0; l < nums.length;++l) {
										if(entree.charAt(3)==nums[l]) {
											valide=true;
										}
									}
								}
							}
						}
					}
				}
			}
		if(valide==false) {
			System.out.print("#>");
		}
		}
		return entree;
		
	}
	@Override
	/**@brief : Permets a un joueur de jouer un coup
	 * @param  plat [in] : la ligne
	 * @param  j [in]: le joueur opposé
	 * @return void
	 */
	public void jouer(piece.IPlateau plat, Joueur j) {
		String entree = this.creationEntree();
		int a = super.index(entree,0);
		int b = super.charToInt(entree,1);
		for(int i=0;i<getPieces().length;++i) {
			if(super.getPiecea(i).getY()==a && super.getPiecea(i).getX()==b) {
				if(super.getPiecea(i).estPossible(charToInt(entree,3),index(entree,2),j)) {
					plat.cls(b,a);
					super.EtreMangé(charToInt(entree,3), index(entree,2), j);
					super.getPiecea(i).setXY(charToInt(entree,3),index(entree,2));
					plat.setTab((joueur.IPiece)super.getPiecea(i));
					if(j.RestePiece()) {
						super.setTour(false);
					}else {
						super.setTour(true);
						}
					
				}else {
					System.out.println("");
					System.out.print("n'est pas possible");
					System.out.println("");
					}
			}
		}	
		
		
	}











	







}