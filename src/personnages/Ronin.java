package personnages;

public class Ronin extends Humain {
	private int honneur=1;
	public Ronin(String nom, String boissonfav, int argent) {
		super(nom, boissonfav, argent);
		
	}
	
	public void donner(Commerçant beneficiaire) {
		parler(beneficiaire.nom+" prend ces "+(0.1*argent)+" sous.");
		beneficiaire.argent+=(0.1*argent);
		parler((0.1*argent)+" sous ! Je te remercie généreux donateur");
		argent*=0.9;
	}
}
