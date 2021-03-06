package no.hib.dat100.prosjekt.modell;

/**
 * Klasse for Â representere en bunke kort. Kan om n¯dvendig inneholde hele
 * kortstokken. Man kan bare ta ut / trekke fra toppen av bunken.
 *
 */
public class Bunke extends KortSamling {

	/**
	 * Lager en tom bunke.
	 * 
	 */

	public Bunke() {
		super();	//Konstruktør lik den i kortsamling (med samme input parametre, altså ingen).
	}

	/**
	 * Fjerner kortet som ligger pÂ toppen av bunken.
	 * 
	 * @return Kortet pÂ toppen av bunken. Kortet blir fjernet fra bunken.
	 * 
	 */
	public Kort trekk() {
		// Hint: se p� metoder i superklassen
		return taSiste();	//Samme metode med annet navn.
		//throw new RuntimeException("Metode trekk ikke implementert");
	}

	/**
	 * "Ser" pÂ kortet som ligger pÂ toppen av bunken.
	 * 
	 * @return referanse til kortet pÂ toppen av bunken. Kortet blir ikke
	 *         fjernet.
	 * 
	 */
	public Kort topp() {
		
		// TODO
		return seSiste(); //Samme metode med annet navn.
		//throw new RuntimeException("Metode topp ikke implementert");
	}
}
