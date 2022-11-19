package MillPackage;

public class Spieler {

    protected String name;
    protected int anzahlSteine;
    protected int anzahlSteineAufFeld;
    protected int anzahlSteineZuPlatzieren;
    protected WelcherSpieler welcherSpieler;
    protected boolean kannSpringen; //in Sprungphase

    protected Spieler(){
        anzahlSteineAufFeld = 0;
        kannSpringen = false;
    }

    //gibt den aktuellen Spieler zurueck
    public WelcherSpieler getWelcherSpieler(){
        return welcherSpieler;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAnzahlSteine(){
        return anzahlSteine;
    }

    /*
    public int setNumPieces(){
        this.numPieces = numPieces;
        return numPieces;
    }
    */

    public int getAnzahlSteineAufFeld(){
        return anzahlSteineAufFeld;
    }


    public int getAnzahlSteineZuPlatzieren(){
        return (anzahlSteine - anzahlSteineAufFeld);
    }

    //waehrend der Setzphase
    public int anzahlSteineAufFeldErhoehen(){
        kannSpringen = false;
        return ++anzahlSteineAufFeld;
    }

    //Sprungphase beginnt
    public int anzahlSteineAufFeldVerringern(){
        if(--anzahlSteineAufFeld == 3){
            kannSpringen = true;
        }
        return --anzahlSteineAufFeld;
    }

    public boolean isKannSpringen(){
        return kannSpringen;
    }

    public void reset(){
        anzahlSteineAufFeld = 0;
        kannSpringen = false;
    }
}

