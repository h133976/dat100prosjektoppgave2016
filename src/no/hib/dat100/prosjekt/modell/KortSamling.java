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
 
    public static final int MAKS_KORT_FARGE = 3; 
    private final int MAKS_KORT = 4 * MAKS_KORT_FARGE; 
     
    private final int MAKS_KORTSTOKK = 51; 
     
 
    // tabell for representasjon av samling av kort 
    private Kort[] samling; 
 
    // index på forste ledige plass 
    private int forsteledig; 
 
    /** 
     * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken). 
     */ 
    public KortSamling() { 
         
        samling = new Kort[MAKS_KORTSTOKK+1]; 
        forsteledig = 0; 
                            
        // TODO 
        //throw new RuntimeException("Metode KortSamling ikke implementert"); 
    } 
 
    /** 
     * Sjekker om samlinga er tom. 
     *  
     * @return true om samlinga er tom, false ellers. 
     */ 
    public boolean erTom() { 
         
        return (forsteledig == 0); 
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
        Kort[] kort = new Kort[forsteledig]; 
        for(int i = 0; i < forsteledig; i++){ 
            kort[i] = new Kort(samling[i].getFarge(), samling[i].getVerdi()); 
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
        return forsteledig;
        //throw new RuntimeException("Metode getAntalKort ikke implementert"); 
    } 
 
    /** 
     * Legger alle korta (hele kortstokken) til samlnga. Korta vil vÊre sortert 
     * slik at de normalt mÂ stokkes f¯r bruk. 
     */ 
    public void leggTilAlle() { 
        // Hint: Kortfarge.values() gir en tabell med alle kortfarger     
        if (forsteledig < 1) return;
        // TODO 
        int k = 0; 
        for(int j = 0; j < MAKS_KORT_FARGE+1; j++){ 
            for(int i = 0; i < MAKS_KORT+1; i++){ 
                Kortfarge f = Kortfarge.values()[j]; 
                samling[k] = new Kort(f, i); 
                //samling[k].setFarge(f); 
                //samling[k].setVerdi(i); 
                k++; 
            } 
        } 
        forsteledig = k; 
        //throw new RuntimeException("Metode leggTilAlle ikke implementert"); 
    } 
 
    /** 
     * Fjerner alle korta fra samlinga slik at den blir tom. 
     */ 
    public void fjernAlle() { 
         
        // TODO 
        forsteledig = 0; 
        for(int i = 0; i < forsteledig; i++){  
            samling[i] = null;
        } 
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
        samling[forsteledig++] = new Kort(kort.getFarge(),kort.getVerdi()); 
        //throw new RuntimeException("Metode leggTil ikke implementert"); 
    } 
 
    /** 
     * Ser pÂ siste kortet i samlinga. 
     *  
     * @return siste kortet i samlinga, men det blir ikke fjernet. 
     */ 
    public Kort seSiste() { 
        if (forsteledig > 0){ 
            //Kort kort = new Kort(samling[forsteledig-1].getFarge(), samling[forsteledig-1].getVerdi()); 
            Kort kort = samling[forsteledig-1]; 
            return kort; 
 
        } 
        else return null; 
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
        	int i = forsteledig - 1;
            Kort kort = samling[i]; 
            samling[i] = null;
            forsteledig--; 
            return kort; 
 
        } 
        else return null; 
         
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
         
        if (forsteledig < 1) return false;
        if (kort == null) return false;
        // TODO 
        for(int i = 0; i < forsteledig; i++){ 
            if (samling[i].compareTo(kort) == 0) return true; 
        } 
        return false; 
        //throw new RuntimeException("Metode har ikke implementert"); 
    } 
    
    public int harIndex(Kort kort) { 
        
        if (forsteledig < 1) return -1; 
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
        if (index == -1) return;
        
        ArrayList<Kort> list = toArrayList();	//Lag ny liste med elementer fra samling
        list.remove(index);	//Fjern element i rett index
        
       // fjernAlle(); //Fjern alt innhold i samling
        forsteledig--;
        for(int i = 0; i < forsteledig; i++){  //Legg til nytt innhold i samling
        	samling[i] = list.get(i);
        }
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
	   for (int i = forsteledig; i > 0; i--)
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
        ArrayList<Kort> list = new ArrayList<Kort>(); 
        for (int i = 0; i < forsteledig; i++){
        	list.add(i,samling[i]);
        }
        // Hint: legg hvert kort fra samling over i arraylisten list 
         
        // TODO 
        return list;
        //throw new RuntimeException("Metode ArrayList ikke implementert"); 
    } 
}