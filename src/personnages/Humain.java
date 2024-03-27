package personnages;

public class Humain {
	protected String nom;
	protected String boissonfav;
	protected int argent;
	
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
	
	private void perdreArgent(int perte) {
		argent=--perte;
	}
	
	private void gagnerArgent(int gain) {
		argent=++gain;
	}
	
	public static void main(String[] args) {
		Humain prof = new Humain ("prof","kombuacha",54);
		prof.acheter("une boisson" , 12);
		prof.boire("kombuacha");
		prof.acheter("un jeu" , 2);

		
	}
}
