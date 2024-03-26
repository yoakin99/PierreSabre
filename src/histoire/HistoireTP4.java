package histoire;

import personnages.*;

public class HistoireTP4 {
	
	public static void main (String[] args) {
		Yakuza yaku = new Yakuza ("Yaku Le noir","whisky",30,"clan");
		Commerçant marco = new Commerçant ("Marco",15);
		yaku.direBonjour();
		yaku.extorquer(marco);
		Ronin roro = new Ronin ("Roro","shochu",60);
		roro.direBonjour();
		roro.donner(marco);
	}
}
