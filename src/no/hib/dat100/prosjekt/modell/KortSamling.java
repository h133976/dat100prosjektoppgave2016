package no.hib.dat100.prosjekt.modell; 
 
import java.util.ArrayList; 
import java.util.Random; 
 
/* 
 * 
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes 
 * konstanter i klassen som angir antall kort i hver av de 4 fargene. NÂr 
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan 
 * det vÊre praktisk Â ha denne mindre. 
 *  
 */ 
public abstract class KortSamling { 
 
    public static final int MAKS_KORT_FARGE = 3; 	//Kort per farge (13 maks, 3 for test)
    private final int MAKS_KORT = 4 * MAKS_KORT_FARGE; //(4 * 13 = 52)
     
   // private final int MAKS_KORTSTOKK = 51; 
     
 
    // tabell for representasjon av samling av kort 
    private Kort[] samling; 
 
    // index på forste ledige plass 
    private int forsteledig; 
 
    /** 
     * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken). 
     */ 
    public KortSamling() { 
         
        samling = new Kort[MAKS_KORT]; //Ny tabell av kortobjekter (MAKS_KORT stort, med indeks fra 0 til MAKS_KORT-1)
        forsteledig = 0; //første ledige kortplass er i plass 0
                            
        // TODO 
        //throw new RuntimeException("Metode KortSamling ikke implementert"); 
    } 
 
    /** 
     * Sjekker om samlinga er tom. 
     *  
     * @return true om samlinga er tom, false ellers. 
     */ 
    public boolean erTom() { 
         
        return (forsteledig == 0); // Hvis forste ledige plass er i posisjon 0, betyr det at vi ikke har kort i samlingen.
        // TODO 
        //throw new RuntimeException("Metode erTom ikke implementert"); 
    } 
 
    /** 
     * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke vÊre 
     * full. Kortene ligger sammenhengende fra starten av tabellen. Kan fÂ 
     * tilgang til antallet ved Â bruke metoden getAntallKort(). Metoden er 
     * f¯rst og fremst ment Â brukes i eventuelle subklasser. Om man trenger 
     * kortene utenfor arvehierarkiet, anbefales metoden toArrayList(). 
     *  
     * @return tabell av kort. 
     */ 
    public Kort[] getSamling() { 
       // Her kunne vi også bare returnert samling, 
       // men selv om samling er MAKS_KORT element stor, har vi ikke nødvendigvis like mange kort som MAKS_KORT plasseringer.
       // Derfor returnerer vi istedet en ny tabell med like mange plasseringer som det finns kort i samling.
    	
    	Kort[] kort = new Kort[forsteledig]; 
        for(int i = 0; i < forsteledig; i++){ 
            kort[i] = samling[i];//new Kort(samling[i].getFarge(), samling[i].getVerdi()); 
        } 
         
        return kort; 
         
        // TODO 
        //throw new RuntimeException("Metode getSamling ikke implementert"); 
    } 
 
    /** 
     * Antall kort i samlingen. 
     *  
     * @return antall kort i samlinga. 
     */ 
    public int getAntalKort() { 
         
        // TODO 
        return forsteledig; //forsteledig indikerer også antall kort vi har! Magical, or logical?! Jamfør "The Logical Song" av bandet "Supertramp"
        //throw new RuntimeException("Metode getAntalKort ikke implementert"); 
    } 
 
    /** 
     * Legger alle korta (hele kortstokken) til samlnga. Korta vil vÊre sortert 
     * slik at de normalt mÂ stokkes f¯r bruk. 
     */ 
    public void leggTilAlle() { 
        // Hint: Kortfarge.values() gir en tabell med alle kortfarger     
        // TODO 
    	forsteledig = 0;	// Dette for å legge til kort fra starten av tabellen 
    						// og evt. overskrive kort som er lagt til fra før av
    	
        for(int j = 0; j < Kortfarge.values().length; j++){ //fra 0 til 3 (4 farger)
            for(int i = 1; i <= MAKS_KORT_FARGE; i++){	// Fra 1 (ess) til og med 13 (Kong??) (eller 3 i vårt tilfelle) 
                Kortfarge f = Kortfarge.values()[j]; 	// Returnerer kortfargen med j som index (j = 0 -> hjerter; j = 1 -> Ruter)
                //samling[forsteledig] = new Kort(f, i); 
                samling[forsteledig].setFarge(f);	//Sett ny farge til kortet som finnes i tabellen med forsteledig-index
                samling[forsteledig].setVerdi(i);	//Sett ny verdi til kortet som finnes i tabellen med forsteledig-index
                forsteledig++; //Øk index og gjenta loop
            } 
        } 
        //throw new RuntimeException("Metode leggTilAlle ikke implementert"); 
    } 
 
    /** 
     * Fjerner alle korta fra samlinga slik at den blir tom. 
     */ 
    public void fjernAlle() { 
         
        // TODO 
        forsteledig = 0; //Setter bare index til 0, slik at når en legger til nye kort, vil de overskrive de gamle
        //throw new RuntimeException("Metode fjernAlle ikke implementert"); 
    } 
 
    /** 
     * Legg et kort til samlinga. 
     *  
     * @param kort 
     *            er kortet som skal leggast til. 
     */ 
    public void leggTil(Kort kort) { 
         
        // TODO 
        samling[forsteledig++] = kort; //Sett element i tabell lik kort og øk forsteledig indeksen.
        //throw new RuntimeException("Metode leggTil ikke implementert"); 
    } 
 
    /** 
     * Ser pÂ siste kortet i samlinga. 
     *  
     * @return siste kortet i samlinga, men det blir ikke fjernet. 
     */ 
    public Kort seSiste() { 
        if (forsteledig > 0){  
            return samling[forsteledig-1]; //forsteledig-1 er siste kort lagt til. forsteledig angir hvor neste kort plasseres
        } 
        else return null; //Ingen kort i samlingen hvis forsteledig == 0;
        // TODO 
        //throw new RuntimeException("Metode seSiste ikke implementert"); 
    } 
 
    /** 
     * Tek ut siste kort fra samlinga. 
     *  
     * @return siste kortet i samlinga. Dersom samalinga er tom, returneres 
     *         null. 
     */ 
    public Kort taSiste() { 
         
        // TODO 
        if (forsteledig > 0){ 
            //Kort kort = new Kort(samling[forsteledig-1].getFarge(), samling[forsteledig-1].getVerdi()); 
            Kort kort = samling[forsteledig - 1]; 
            forsteledig--; //Vi fjerner øverste kort ved å dekrementere indeksen
            return kort; //Returnér først etter at vi har dekrementert indeksen 
 
        } 
        else return null; //Ingen kort i samlingen hvis forsteledig == 0;
         
        //throw new RuntimeException("Metode taSiste ikke implementert"); 
    } 
 
    /** 
     * Unders¯ker om et kort finst i samlinga. 
     *  
     * @param kort. 
     *  
     * @return true om kortet finst i samlinga, false ellers. 
     */ 
    public boolean har(Kort kort) { 
         
        if (forsteledig < 1) return false; //Ingen kort i samling
        else if (kort == null) return false; //input kort er ikke definert (= null)
        else{
	        // TODO 
	        for(int i = 0; i < forsteledig; i++){ //Sammenlign alle kort fra indeks 0 til (og ikke med) forsteledig 
	            if (samling[i].compareTo(kort) == 0) return true; //Hvis vi finner en match, trenger vi ikke gå gjennom resten. Derfor returnerer vi
	        } 
	        return false; //Ingen match, har gått gjennom alle kort
        }
        //throw new RuntimeException("Metode har ikke implementert"); 
    } 
    
    private int harIndex(Kort kort) { //Denne baseres på den over, bare at den returnerer en integer (indeksen til det matchede kortet)
        
        if (forsteledig < 1) return -1; //JEG har bestemt at metoden skal returnere -1 om den ikke finner noen match.
        // TODO 
        for(int i = 0; i < forsteledig; i++){ 
            if (samling[i].compareTo(kort) == 0) return i; 
        } 
        return -1; 
        //throw new RuntimeException("Metode har ikke implementert"); 
    } 
 
    /** 
     * Fjernar et kort frÂ samlinga. Dersom kortet ikke finnest i samlinga, 
     * skjer ingenting. 
     *  
     * @param kort 
     *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer 
     *            ingenting. 
     */ 
    public void fjern(Kort kort) { 
        // Hint: finn forst ut hvor kortet er i samlingen hvis det finnes  
         
        if (forsteledig < 1) return; //Sjekk om det finnes kort i samlingen
        
        int index = harIndex(kort); //sjekk om kortet eksisterer og evt returner index
        if (index == -1) return; //-1 er kode for "fant ingen match"
        
        samling[index] = samling[forsteledig-1]; //Setter siste kort i samlinga til index (kortet som skal fjernes).
        forsteledig--; //På denne måten overskriver vi det kortet som skal vekk med siste kort i samlinga,
        //slik at vi samtidig kan dekrementere samlinga (altså ett kort mindre i samling, som skjer når en fjerner et kort (duh?)).
        
        //Det som er kommentert vekk under, e min såkalte "fancy" måte å fjerne et kort på. 
        //Dette kan ignoreres, men jeg velger å la det stå for å demonstrere mitt fantastiske intellektuellialitet (hæ?!)
        
        //ArrayList<Kort> list = toArrayList();	//Lag ny liste med elementer fra samling
        //list.remove(index);	//Fjern element i rett index
        
        //fjernAlle(); //Fjern alt innhold i samling
        //forsteledig--;
        //for(int i = 0; i < forsteledig; i++){  //Legg til nytt innhold i samling
        //	samling[i] = list.get(i);
        //}
        
        // Hint: fjern kortet - men husk kortet kan sitte p� en plass i midten 
         
        // TODO 
         
        //throw new RuntimeException("Metode fjernKort ikke implementert"); 
    } 
 
    /** 
     * Stokkar en kortsamling ved å bytte rundt på kort  
     */ 
    public void stokk() { 
        // Hint: en mulighet er bruk av klassen Random for � generere tilfeldige index 
         
    	// Fisher–Yates shuffle (http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array)
 	   int index;
 	   Kort temp;
 	   Random random = new Random();
 	   for (int i = forsteledig-1; i >= 0; i--)
 	   {
 	       index = random.nextInt(i + 1);
 	       temp = samling[index];
 	       samling[index] = samling[i];
 	       samling[i] = temp;
 	   }

        //throw new RuntimeException("Metode stokk ikke implementert"); 
    } 
 
    /** 
     * Gir kortene som en ArrayList. 
     *  
     * @return samlinga av kort som en ArrayList. Korta vil ha samme rekkef¯lge 
     *         som i kortsamlinga. 
     */ 
    public ArrayList<Kort> toArrayList() { 
        ArrayList<Kort> list = new ArrayList<Kort>(); //Lag ny liste
        for (int i = 0; i < forsteledig; i++){ //Legg til alle element fra samling i listen
        	list.add(i,samling[i]);
        }
        // Hint: legg hvert kort fra samling over i arraylisten list 
         
        // TODO 
        return list;
        //throw new RuntimeException("Metode ArrayList ikke implementert"); 
    } 
}