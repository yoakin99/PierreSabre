package personnages;

public class Yakuza extends Humain {
	private int reputation;
	public Yakuza(String nom, String boissonfav, int argent, String clan) {
		super(nom, boissonfav, argent);
		int reputation=0;
	}
	
	public void extorquer(Commerçant victime) {
		reputation++;
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.nom+", si tu tiens à la vie donne moi ta bourse !");
		final int x =victime.seFaireExtorquer();
		argent+=x;
		parler("J’ai piqué les "+ x +" sous de "+victime.nom+", ce qui me fait "+super.argent+" sous dans ma poche. Hi ! Hi !");
	}
	
	public static void main (String[] args) {
		
	}

}
