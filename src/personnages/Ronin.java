package personnages;

public class Ronin extends Humain {
	private int honneur=1;
	public Ronin(String nom, String boissonfav, int argent) {
		super(nom, boissonfav, argent);
		
	}
	
	public void donner(Commerçant beneficiaire) {
		parler(beneficiaire.nom+" prend ces "+(argent/10)+" sous.");
		beneficiaire.argent+=(argent/10);
		parler((argent/10)+" sous ! Je te remercie généreux donateur !");
		argent-=argent/10;
	}
	
	public void provoquer(Yakuza adversaire) {
		if (honneur*2 >= adversaire.getReputation()) {
			honneur++;
			parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
			parler("Je t'ai eu petit Yakuza !");
			argent+=adversaire.perdre();
			adversaire.argent=0;
		} else {
			honneur--;
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(argent);
			argent=0;
		}
	}
}
