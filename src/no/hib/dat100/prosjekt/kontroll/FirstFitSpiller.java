package no.hib.dat100.prosjekt.kontroll;

import java.util.ArrayList;

import no.hib.dat100.prosjekt.modell.Kort;

/**
 * Klasse som for Â representere en vriÂtter spiller. Strategien er Â lete
 * gjennom kortene man har pÂ hand og spille det f¯rste som er lovlig.
 *
 */
public class FirstFitSpiller extends Spiller {

	/**
	 * Konstrukt¯r.
	 * 
	 * @param spiller
	 *            posisjon for spilleren (nord eller syd).
	 */
	public FirstFitSpiller(Spillere spiller) {
		super(spiller);
	}

	/**
	 * Metode for Â implementere strategi. Strategien er Â spille det f¯rste
	 * kortet som er lovlig (ogsÂ en Âtter selv om man har andre kort som ogsÂ
	 * kan spilles). Dersom man ikke har lovlige kort Â spille, trekker man om
	 * man ikke allerede har trukket maks antall ganger. I sÂ fall sier man
	 * forbi.
	 * 
	 * @param topp
	 *            kort som ligg ¯verst pÂ til-bunken.
	 */
	@Override
	public Handling nesteHandling(Kort topp) {

		// kort som spilleren har (FirstFitSpiller arver fra Spiller)
		ArrayList<Kort> h = getHand().toArrayList();
		
		// lister til å samle opp lovlige kort og åttere for spilleren
		
		ArrayList<Kort> lovlige = new ArrayList<Kort>();

		// itererer over handen h og legg til lovlige kort i åttere eller lovlige
		for (Kort k : h) {
			if (Regler.kanLeggeNed(k, topp)) {
				lovlige.add(k);
			}
		}
		
		// kort som kan spilles
		Kort kort = null;
		
		/* first-fit strategi */
		
		// finn det forste kort p� handen som kan spilles (legges ned)
		// Hint: klassen Regler har en metode som gitt en kort sjekker om det kan legges ned
		
		// TODO
		Handling handling = null;
		
		if (!lovlige.isEmpty()) {
			
			kort = lovlige.get(0);	//Hent første lovlige kort
			handling = new Handling(HandlingsType.LEGGNED, kort);
			setAntallTrekk(0); //Nullstill antall trekk
		} else if (getAntallTrekk() < Regler.maksTrekk()) {
			// trekk fra bunken hvis vi ikker nådd grensen for å trekke
			handling = new Handling(HandlingsType.TREKK, null);
		} else {
			
			// ikke noe kort spiller og kan ikke trekk mer
			// da må vi si forbi og nullstille antall trekk.
			
			handling = new Handling(HandlingsType.FORBI, null);
			setAntallTrekk(0);
		}
		
		//throw new RuntimeException("Metode nesteHandling ikke implementert");
		return handling;
	}
}
