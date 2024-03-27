package personnages;

public class Yakuza extends Humain {
	private int reputation=0;
	String clan;
	public Yakuza(String nom, String boissonfav, int argent, String clan) {
		super(nom, boissonfav, argent);
		this.clan=clan;
	}
	
	public int getReputation() {
		return reputation;
	}
	
	public void extorquer(Commerçant victime) {
		reputation++;
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.nom+", si tu tiens à la vie donne moi ta bourse !");
		final int x =victime.seFaireExtorquer();
		argent+=x;
		parler("J’ai piqué les "+ x +" sous de "+victime.nom+", ce qui me fait "+super.argent+" sous dans ma poche. Hi ! Hi !");
	}

	
	public int perdre() {
		reputation-=1;
		parler("J’ai perdu mon duel et mes "+argent+" sous, snif... J'ai déshonoré le clan de " + this.clan);
		return argent;
	}
	
	public void gagner(int gain) {
		reputation+=1;
		argent+=gain;
		parler("Ce ronin pensait vraiment battre "+nom+" du "+clan+" de Warsong ?");
		parler("Je l'ai dépouillé de ses "+gain+" sous.");
	}
	
	public static void main (String[] args) {

	}

}
