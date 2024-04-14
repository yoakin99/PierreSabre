package personnages;
import java.util.Random;


public class Traitre extends Samourai {
	int niveauTraitrise = 0;
	public Traitre(String seigneur, String nom,String boissonfav,int argent ){
		super(nom,boissonfav,argent,seigneur);
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : "+niveauTraitrise+". Chut !");
		
	}
	
	public void ranconner(Commerçant commercant) {
		if (niveauTraitrise<3) {
		int argentRanconner = commercant.getArgent()*2/10 ;
		commercant.perdreArgent(argentRanconner);
		gagnerArgent(argentRanconner);
		parler("Si tu veux ma protection contre les yakuzas, il va falloir payer ! Donne-moi " + argentRanconner +" sous ou gare à toi ! ");
		commercant.parler("Tout de suite grand "+ getNom()+".");
		niveauTraitrise++;
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
		parler("Je ne peux faire ami ami avec personne car je connais personne ! Snif.");
		} else {
			int don = argent * 1/20 ;
			Random rand = new Random();
			int random = rand.nextInt(nbConnaissance);
			String nomAmi = memoire[random].getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec "+ nomAmi+ ".");
			parler("Bonjour l'ami! Je voudrais vous aider en vous donnant "+don+" sous.");
			memoire[random].gagnerArgent(don);
			perdreArgent(don);
			memoire[random].parler("Merci "+getNom()+". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise>0) {
				niveauTraitrise--;
			};
		}
		
	}
}
