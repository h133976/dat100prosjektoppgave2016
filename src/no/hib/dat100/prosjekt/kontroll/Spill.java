package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hib.dat100.prosjekt.modell.Bunke;
import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klassen har objektvariaber som er referanser til de spillerne, nord og syd
 * (type ISpiller). Den har ogsÂ en bunke man deler/trekker fra og en bunke man
 * spiller til.
 * 
 */
public class Spill {

	// objektvariable for et spill
	
	// de to spillere
	private ISpiller nord;
	private ISpiller syd;
	
	// de to bunker 
	private Bunke bunkeFra;
	private Bunke bunkeTil;

	/**
	 * Gir referanse/peker til syd.
	 * 
	 * @return referanse/peker til syd.
	 */
	public ISpiller getSyd() {
		
		// TODO
		return syd;	//Legg merke til at vi kan retunere syd bare hvis objektet syd og metoden getSyd har samme data type, altså ISpiller
		
		//throw new RuntimeException("Metode getSyd ikke implementert");
	}

	/**
	 * Gir referanse/peker til nord.
	 * 
	 * @return referanse/peker til nord.
	 */
	public ISpiller getNord() {
		
		// TODO
		return nord;	//Se getSyd-kommentar
		
		//throw new RuntimeException("Metode getNord ikke implementert");
	}

	/**
	 * Gir peker/referanse til til-bunken.
	 * 
	 * @return referanse/peker til til-bunken.
	 */
	public Bunke getBunkeTil() {
		
		// TODO
		return bunkeTil; //Se getSyd-kommentar
		//throw new RuntimeException("Metode getBunkeTil ikke implementert");
	}

	public Bunke getBunkeFra() {
		
		// TODO
		return bunkeFra; //Se getSyd-kommentar
		
		//throw new RuntimeException("Metode getBunkeFra ikke implementert");
	}

	/**
	 * Metoden oppretter to spillere, nord og syd. Det opprettes to bunker, fra
	 * og til. Alle kortene legges til fra. Bunken fra stokkes. Deretter deles
	 * det ut kort fra fra-bunken til nord og syd i henhold til regler. Til
	 * slutt tas ¯verste kortet fra fra-bunken og legges til til-bunken.
	 * 
	 * Nord har type RandomSpiller (som er forhÂndefinert). Syd vil til slutt vÊre spiller
	 * av en klasse laget av gruppen i oppgave 3.
	 */
	public void start() {
		
		// Hint: vurder om andre private metoder i klassen kan brukes her
        // i tilegg til metoder på bunker
		
		// TODO
		
		//TIPS: deklarer alle objekter først (obj = new Object) før en begynner med metodekalling og slikt
		
		nord = new RandomSpiller(Spillere.NORD);
		syd = new FirstFitSpiller(Spillere.SYD);
		
		bunkeFra = new Bunke();
		bunkeTil = new Bunke();
		
		bunkeFra.leggTilAlle();	//Legg til alle kort i bunken
		bunkeFra.stokk();	//stokk om
		
		delutKort();	//Se metode
		
		vendOverste();	//Se metode
		
		//throw new RuntimeException("Metode start ikke implementert");
	}

	/**
	 * Deler ut kort til nord og syd.
	 * 
	 */
	private void delutKort() {

		// Husk: Klassen Regler angir hvor mange kort hver spiller skal ha
		
		// TODO
		
		//Bruker den statiske regler-klassen for å bestemme antall kort ved start.
		//Legg merke til at statiske metoder ikke trenger å bli deklarert slikt som f.eks Kort-klassen
		//en bare bruker den direkte (neat!)
		
		for (int i = 0; i < Regler.antallKortVedStart(); i++){
			nord.leggTilKort(bunkeFra.trekk());
			syd.leggTilKort(bunkeFra.trekk());
		}
		
		//throw new RuntimeException("Metode delutKort ikke implementert");
	}

	/**
	 * Tar ¯verste kortet fra fra-bunken og legger dettte til til-bunken (med
	 * billedsiden opp, men det trenger ikke gruppen tenke pÂ).
	 */
	private void vendOverste() {
		
		// TODO
		
		bunkeTil.leggTil(bunkeFra.trekk());	//Gjør som beskrevet over metoden
		//Legg til kort i til-bunken det kortet som trekk-metoden i fra-bunken returnerer (metode-seption)
		
		//throw new RuntimeException("Metode vendOverste ikke implementert");
	}

	/**
	 * NÂr fra-bunken blir tom, tar man vare pÂ kortet pÂ toppen av til-bunken.
	 * Deretter legges alle den andre kortene i til-bunken over i fra-bunken.
	 * Denne stokkes og kortet som man har tatt vare pÂ legges tilbake i
	 * til-bunken. Det vil nÂr vÊre det eneste kortet i til-bunken.
	 */
	public void snuTilBunken() {

		if (bunkeFra.getAntalKort() > 0) return; //Vil kun snu bunken hvis fra-bunken er tom for kort
		// TODO
		
		Kort tempKort = bunkeTil.trekk();	//Trekk ut og ta vare på øverste kort i til-bunken
		
		while(bunkeTil.getAntalKort() > 0) bunkeFra.leggTil(bunkeTil.trekk()); // trekk alle kort fra til-bunken og legg til i fra-bunken 
		
		bunkeFra.stokk();	//stokk om etter at alle kort er lagt til
		
		bunkeTil.leggTil(tempKort);	//Legg til kortet som ble tatt vare på i begynnelsen av metoden
		
		//throw new RuntimeException("Metode snuTilBunken ikke implementert");
	}

	/**
	 * Trekker et kort fra fra-bunken til spilleren gitt som parameter. Om
	 * fra-bunken er tom, mÂ man "snu" til-bunken. Se info om metoden
	 * snuTilBunken().
	 * 
	 * @param spiller
	 *            spilleren som trekker.
	 * 
	 * @return kortet som trekkes.
	 */
	public Kort trekkFraBunke(ISpiller spiller) {

		// TODO
		
		if (bunkeFra.getAntalKort() == 0) snuTilBunken(); //Hvis fra-bunke er tom, snu tilbunken og legg til alle kortene i fra-bunken (se over)
		
		Kort kort = bunkeFra.trekk();
		spiller.trekker(kort); //Viktig å kalle denne metoden når spilleren trekker et kort
		
		return kort; 
		
		//throw new RuntimeException("Metode trekkFraBunke ikke implementert");
	}

	/**
	 * Sjekker om til-bunken er tom.
	 * 
	 * @return true om til-bunken er tom, false ellers.
	 */
	public boolean bunketilTom() {
		
		// TODO
		return (bunkeTil.erTom());
		//throw new RuntimeException("Metode bunkeTilTom ikke implementert");
	}

	/**
	 * Sjekker om fra-bunken er tom.
	 * 
	 * @return true om fra-bunken er tom, false ellers.
	 */
	public boolean bunkefraTom() {
		
		// TODO
		return (bunkeFra.erTom());
		//throw new RuntimeException("Metode bunkefraTom ikke implementert");
	}

	/**
	 * Gir antall kort nord har pÂ hÂnden.
	 * 
	 * @return antall kort nord har pÂ hÂnden.
	 */
	public int antallNord() {
		
		// TODO
		return (nord.getAntallKort());
		//throw new RuntimeException("Metode antallNord ikke implementert");
	}

	/**
	 * Gir antall kort i fra-bunken.
	 * 
	 * @return antall kort i fra-bunken.
	 */
	public int antallBunkeFra() {
		
		// TODO
		
		return (bunkeFra.getAntalKort());
		//throw new RuntimeException("Metode antallBunkeFra ikke implementert");
	}

	/**
	 * Gir antall kort i til-bunken.
	 * 
	 * @return antall kort i til-bunken.
	 */
	public int antallBunkeTil() {
		
		// TODO
		return (bunkeTil.getAntalKort());
		//throw new RuntimeException("Metode antallBunkeTil ikke implementert");
	}

	/**
	 * Metode som leser ¯verste kortet i til-bunken. Kortet vil fremdeles vÊre
	 * ¯verst i til-bunken etter at metoden er utf¯rt.
	 * 
	 * @return ¯verste kortet i til-bunken.
	 */
	public Kort seOverste() {
		
		// TODO
		return (bunkeTil.seSiste()); //Potato, potato
		//throw new RuntimeException("Metode seOverste ikke implementert");
	}

	/**
	 * Gir syds hand som en ArrayList av Kort.
	 * 
	 * @return syds hand som en ArrayList av Kort.
	 */
	public ArrayList<Kort> getSydHand() {
		
		// TODO
		return (syd.getHand().toArrayList()); //Neat! returner handen og lag en liste
		//throw new RuntimeException("Metode getSydHand ikke implementert");
	}

	/**
	 * Bestemmer neste handling for en spiller (spilt et kort, trekker et kort, forbi)
	 * 
	 * @param spiller
	 *            spiller som handle.
	 * 
	 * @return handlingen som skal utf¯res av spillet.
	 */
	public Handling nesteHandling(ISpiller spiller) {
		
		// TODO
		// Hint: bruk nesteHandling metoden på en spiller
		return (spiller.nesteHandling(seOverste()));
		//throw new RuntimeException("Metode nesteHandling ikke implementert");
	}

	/**
	 * Metoden spiller et kort. Den sjekker at spiller har kortet. Dersom det er
	 * tilfelle, fjernes kortet fra spilleren og legges til til-bunken. Metoden
	 * nulltiller ogsÂ antall ganger spilleren har trukket kort.
	 * 
	 * @param spiller
	 *            den som spiller.
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom spilleren har kortet, false ellers.
	 */
	public boolean leggnedKort(ISpiller spiller, Kort kort) {
		
		// TODO
		boolean harKort = false;
		if (spiller.getHand().har(kort)) {
			harKort = true;
			bunkeTil.leggTil(kort);
			spiller.fjernKort(kort);	//Viktig å legge til før en fjerner
			spiller.setAntallTrekk(0);
		}
		return harKort;
		//throw new RuntimeException("Metode leggnedKort ikke implementert");
	}

	/**
	 * Metode for Â si forbi. MÂ nullstille antall ganger spilleren har trukket
	 * kort.
	 * 
	 * @param spiller
	 *            spilleren som er i tur.
	 */
	public void forbiSpiller(ISpiller spiller) {
		
		// TODO
		spiller.setAntallTrekk(0);
		//throw new RuntimeException("Metode forbiSpiller ikke implementert");
	}

	/**
	 * Metode for Â utf¯re en handling (trekke, spille, forbi). Dersom hanling
	 * er kort, blir kortet ogsÂ spilt.
	 * 
	 * @param spiller
	 *            spiller som utf¯rer handlingen.
	 * @param handling
	 *            handling som utf¯res.
	 * 
	 * @return kort som trekkes, kort som spilles eller null ved forbi.
	 */
	public Kort utforHandling(ISpiller spiller, Handling handling) {

		Kort kort = null;
		kort = handling.getKort();

		// TODO
		// Hint: del opp i de tre mulige handlinger og vurder 
		// om noen andre private metoder i klassen kan brukes
		// til å implementere denne metoden
		
		switch (handling.getType()){
			case TREKK:	//TREKK
				trekkFraBunke(spiller);
			break;
			case FORBI:	//FORBI
				forbiSpiller(spiller);
			break;
			case LEGGNED: //LEGGNED
				leggnedKort(spiller, kort);
			break;
		}
		
		return kort;
		//throw new RuntimeException("Metode utforHandling ikke implementert");
	}

	/**
	 * Spiller et kort fra syd.
	 * 
	 * @param kort
	 *            kort som spilles.
	 * 
	 * @return true dersom kortet er lovlig Â spille, false ellers.
	 */
	public boolean nedkortSyd(Kort kort) {
		
		// TODO
		if (syd.getHand().har(kort) == false) return false; //Sjekk om syd har kort på handen
		
		boolean success = Regler.kanLeggeNed(kort, seOverste()); //sjekk om kortet kan legges ned iforhold til regler
		
		if (success) { //Hvis det kan legges ned, legg til i til-bunke og fjern fra hand
			bunkeTil.leggTil(kort);
			syd.fjernKort(kort);
		}
		
		return success; //Returner hvordan det gikk!
		//throw new RuntimeException("Metode nedkortSyd ikke implementert");
	}

	/**
	 * ForeslÂr hva syd skal spille.
	 * 
	 * @return kort som blir foreslÂtt.
	 */
	public Kort foreslaaKortSyd() {
		
		// TODO
		// Hint: bruk nesteHandling metoden for en spiller
		
		Handling handling = syd.nesteHandling(seOverste());
		
		return handling.getKort();
		
		//throw new RuntimeException("Metode foreslqqKortSyd ikke implementert");
	}
}