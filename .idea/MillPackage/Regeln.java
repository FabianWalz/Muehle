package MillPackage;


//implementierung von spielregeln
public class Regeln {

    protected Spielfeld spielfeld;
    protected int phase;

    //spielphasen
    public static final int SETZEN = 1;
    public static final int SCHIEBEN = 2;
    public static final int SPRINGEN = 3;

    //return statements
    public static final int GUELTIGER_ZUG = 0;
    public static final int UNGUELTIGER_ZUG = -1;
    public static final int POSITION_BESETZT = -2;
    public static final int FALSCHER_STEIN = -4;


    public Regeln(){
        spielfeld = new Spielfeld();
        phase = Regeln.SETZEN;
    }

    public Spielfeld getSpielfeld() {
        return spielfeld;
    }

    public int getPhase() {
        return phase;
    }

    public WelcherSpieler getSpielerAufPosition(int position){
        if(!spielfeld.getPosition(position).istBesetzt()){
            return spielfeld.getPosition(position).getSpielerAufPosition();
        } else {
            return WelcherSpieler.NIEMAND;
        }
    }

    public boolean positionIstFrei(int position){
        return spielfeld.positionIstFrei(position);
    }

    public boolean positionBesetztVon(int position, WelcherSpieler spieler){
        if(spielfeld.positionIstFrei(position)){
            spielfeld.getPosition(position).setAlsBesetzt(spieler);
            spielfeld.anzahlSteineVonSpielerErhoehen(spieler);
            if(spielfeld.anzahlSteineAufFeldErhoehen() == 18){
                phase = Regeln.SCHIEBEN;
            } return true;
        } return false;
    }

    public boolean gueltigerZug(int aktuellePosition, int gewaehltePosition){
        Position aktuellePositionDesSteins = spielfeld.getPosition(aktuellePosition);
        if(aktuellePositionDesSteins.istBenachbart(gewaehltePosition)){
            return true;
        } else {
            return false;
        }
    }

    public int bewegeSteinVonNach(int von, int nach, WelcherSpieler spieler){
        if(positionBesetztVon(von, spieler)){
            if(positionIstFrei(nach)){
                if(gueltigerZug(von, nach) || (spielfeld.getAnzahlSteineVonSpieler(spieler) == 3)){
                    spielfeld.getPosition(von).setIstFrei();
                    spielfeld.getPosition(nach).setAlsBesetzt(spieler);
                    return Regeln.GUELTIGER_ZUG;
                } else {
                    return Regeln.UNGUELTIGER_ZUG;
                }
            } else {
                return Regeln.POSITION_BESETZT;
            }
        } else {
            return Regeln.FALSCHER_STEIN;
        }
    }

    public boolean setzeStein(int position, WelcherSpieler spieler){
        if(spielfeld.positionIstFrei(position)){
            spielfeld.getPosition(position).setAlsBesetzt(spieler);
            spielfeld.anzahlSteineVonSpielerErhoehen(spieler);
            if(spielfeld.anzahlSteineAufFeldErhoehen() == 18){
                phase = Regeln.SCHIEBEN;
            } return true;
        } return false;
    }

    private int anzahlSteineInReihe(Position[] position, WelcherSpieler spieler){
        int anzahl = 0;
        for(int i = 0; i < position.length; i++){
            if(position[i].getSpielerAufPosition() == spieler){

            }
        } return anzahl;
    }

    //geht ueber das Array mit den gespeicherten Muehlen ([0][0] bis [15][2])
    public boolean gueltigeMuehle(int nach, WelcherSpieler spieler){
        int max = 0;
        for(int i = 0; i < 16; i++){
            Position[] reihe = spielfeld.getMuehlen(i);
            for(int j = 0; j < 3; j++){
                if(reihe[j].getIndexPosition() == nach){
                    int anzahlSteineInReihe = anzahlSteineInReihe(reihe, spieler);
                    if (anzahlSteineInReihe > max){
                        max = anzahlSteineInReihe;
                    }
                }
            }
        } return (max == 3);
    }

    public void spielfeldAusgeben(){
        spielfeld.spielfeldAusgabe();
    }

    public boolean entferneStein(int position, WelcherSpieler spieler){
        if(!spielfeld.positionIstFrei(position) && positionBesetztVon(position, spieler)){
            spielfeld.getPosition(position).setIstFrei();
            spielfeld.anzahlSteineVonSpielerVeringern(spieler);
            if(phase == Regeln.SCHIEBEN && spielfeld.getAnzahlSteineVonSpieler(spieler) == 3){
                phase = Regeln.SPRINGEN;
            } return true;
        } return false;
    }

    public Spieler getSpieler() {
        return null;
    }


}
