package personnages;

import java.util.Iterator;

public class Humain {
	protected String nom;
	protected String boissonfav;
	protected int argent;
	protected int nbConnaissance=0;
	protected Humain[] memoire = new Humain[30];
	
	public Humain(String nom,String boissonfav,int argent) {
		this.nom=nom;
		this.boissonfav=boissonfav;
		this.argent=argent;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println("("+nom+") - " + texte);
	}
	
	public int getArgent() {
		return argent;
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonfav) ;
	}
	
	public void boire(String boisson) {
		parler("Mmmm , un bon verre de "+ boisson+" ! GLOUPS !");
	}
	
	public void acheter(String bien , int prix) {
		if (argent<prix) {
			parler("Je n'ai plus que "+argent+" sous en poche. Je ne peux même pas m'offrir "+bien+" à "+prix+" sous.");
		} else {
			parler("J'ai "+argent+" sous en poche. Je vais pouvoir m'offrir "  + bien+ " à "+ prix+ " sous");
			argent=--prix;
		}
	}
	protected void perdreArgent(int perte) {
		argent=--perte;
	}
	
	protected void gagnerArgent(int gain) {
		argent=++gain;
	}
	
	public void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void memoriser (Humain humain) {
		if (nbConnaissance<memoire.length) {
			memoire[nbConnaissance]=humain;
		} else {
			for (int i = 0; i<memoire.length-1;i++) {
				memoire[i]=memoire[i+1];
			}
		}
		if (memoire.length-1<=nbConnaissance) {
			memoire[memoire.length-1]=humain;
		}
			nbConnaissance++;
		
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String x = "Je connais beaucoup de monde dont : " + memoire[0].getNom();
	//	System.out.println(memoire.length);
		for (int i = 1; i<nbConnaissance && i<memoire.length;i++) {
			x+=", ";
			x+=(memoire[i].getNom());	
		}
		
		parler(x);
	}
	
	public static void main(String[] args) {
		Humain prof = new Humain ("prof","kombuacha",54);
		Humain prof1 = new Humain ("prof1","kombuacha1",54);
		Humain prof2 = new Humain ("prof2","kombuacha1",54);
		Humain prof3 = new Humain ("prof3","kombuacha1",54);

		Humain prof4 = new Humain ("prof4","kombuacha1",54);
		prof.acheter("une boisson" , 12);
		prof.boire("kombuacha");
		prof.acheter("un jeu" , 2);
		
		prof.faireConnaissanceAvec(prof1);
		prof.faireConnaissanceAvec(prof2);
		prof.faireConnaissanceAvec(prof3);
		prof.faireConnaissanceAvec(prof4);
		prof.listerConnaissance();
		
	}
}
