package histoire;

import personnages.Commerçant;
import personnages.Yakuza;

public class HistoireTP4 {
	
	public static void main (String[] args) {
		Yakuza yaku = new Yakuza ("Yaku Le noir","whisky",30,"clan");
		Commerçant marco = new Commerçant ("Marco",15);
		yaku.direBonjour();
		yaku.extorquer(marco);
	}
}
