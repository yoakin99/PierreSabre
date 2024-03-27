package personnages;

public class Commerçant extends Humain {
	public Commerçant(String nom, int argent) {
		super(nom, "thè" , argent);
	}

	public int seFaireExtorquer() {
		super.parler("J'ai tout perdu! Le monde est injuste... ");
		final int x=super.argent;
		super.argent=0;
		return x;
	}
	
	public void recevoir(int argent) {
		this.argent=argent;
		parler(argent+" sous! Je te remercie généreux donateur !");
	}
	
	public static void main(String[] args) {
		Commerçant marco = new Commerçant ("Marco",20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire("thé");
		
	}
}
