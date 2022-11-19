package MillPackage;

public class Spielfeld {
    private static final int ANZAHL_POSITIONEN_AUF_SPIELFELD = 24;
    private static final int ANZAHL_MOEGLICHE_MUEHLEN = 16;

    private int anzahlSteineS1;
    private int anzahlSteineS2;
    private int anzahlSteineAufFeldGesamt;

    private Position[] positionen;
    private Position[][] muehlen;

    public Spielfeld(){
        positionen = new Position[Spielfeld.ANZAHL_POSITIONEN_AUF_SPIELFELD];
        anzahlSteineS1 = 0;
        anzahlSteineS2 = 0;
        anzahlSteineAufFeldGesamt = 0;
        spielfeldAnlegen();
        muehlenAnlegen();
    }

    public Position getPosition(int position){
        return positionen[position];
    }

    public boolean positionIstFrei(int position){
        return !positionen[position].istBesetzt();
    }

    public void positionBesetztVon(int position, WelcherSpieler spieler){
        if(spieler == WelcherSpieler.SPIELER_1 || spieler == WelcherSpieler.SPIELER_2){
            positionen[position].setAlsBesetzt(spieler);
        } else {
            System.out.println("Kein Player der diese Position besetzen vorhanden");
        }
    }

    public int anzahlSteineAufFeldErhoehen(){
        return ++anzahlSteineAufFeldGesamt;
    }

    //exceptions werfen?
    public int anzahlSteineVonSpielerErhoehen(WelcherSpieler spieler){
        if(spieler == WelcherSpieler.SPIELER_1){
            return ++anzahlSteineS1;
        } else if (spieler == WelcherSpieler.SPIELER_2){
            return ++anzahlSteineS2;
        } else {
            return -1;
        }
    }

    public int anzahlSteineVonSpielerVeringern(WelcherSpieler spieler){
        if(spieler == WelcherSpieler.SPIELER_1){
            return --anzahlSteineS1;
        } else if (spieler == WelcherSpieler.SPIELER_2){
            return --anzahlSteineS2;
        } else {
            return -1;
        }
    }

    public int getAnzahlSteineVonSpieler(WelcherSpieler spieler){
        if(spieler == WelcherSpieler.SPIELER_1){
            return anzahlSteineS1;
        } else if (spieler == WelcherSpieler.SPIELER_2) {
            return anzahlSteineS2;
        } else {
            return -1;
        }
    }

    public Position[] getMuehlen(int position){
        return muehlen[position];
    }

    public int getAnzahlSteineAufFeldGesamt(){
        return anzahlSteineAufFeldGesamt;
    }

    private void spielfeldAnlegen(){
        //die 24 setzbaren Positionen initialisieren
        for(int i = 0; i < Spielfeld.ANZAHL_POSITIONEN_AUF_SPIELFELD; i++){
           positionen[i] = new Position(i);
        }

        positionen[0].benachbartePositionen(1,9);
        positionen[1].benachbartePositionen(0,2,4);
        positionen[2].benachbartePositionen(1,5);
        positionen[3].benachbartePositionen(4,10);
        positionen[4].benachbartePositionen(1,3,5,7);
        positionen[5].benachbartePositionen(4,13);
        positionen[6].benachbartePositionen(7,11);
        positionen[7].benachbartePositionen(4,6,8);
        positionen[8].benachbartePositionen(7,12);
        positionen[9].benachbartePositionen(0,10,21);
        positionen[10].benachbartePositionen(3,9,11,18);
        positionen[11].benachbartePositionen(6,10,15);
        positionen[12].benachbartePositionen(8,13,17);
        positionen[13].benachbartePositionen(5,12,14,20);
        positionen[14].benachbartePositionen(2,13,23);
        positionen[15].benachbartePositionen(11,16);
        positionen[16].benachbartePositionen(15,17,19);
        positionen[17].benachbartePositionen(12,16);
        positionen[18].benachbartePositionen(10,19);
        positionen[19].benachbartePositionen(16,18,20,21);
        positionen[20].benachbartePositionen(13,19);
        positionen[21].benachbartePositionen(9,21);
        positionen[22].benachbartePositionen(19,21,23);
        positionen[23].benachbartePositionen(14,22);
    }

    private void muehlenAnlegen(){
        muehlen = new Position[Spielfeld.ANZAHL_MOEGLICHE_MUEHLEN][Spielfeld.ANZAHL_POSITIONEN_AUF_SPIELFELD];
        //alle moeglichen Muehlen horizontal
        muehlen[0][0] = positionen[0];
        muehlen[0][1] = positionen[1];
        muehlen[0][2] = positionen[2];
        muehlen[1][0] = positionen[3];
        muehlen[1][1] = positionen[4];
        muehlen[1][2] = positionen[5];
        muehlen[2][0] = positionen[6];
        muehlen[2][1] = positionen[7];
        muehlen[2][2] = positionen[8];
        muehlen[3][0] = positionen[9];
        muehlen[3][1] = positionen[10];
        muehlen[3][2] = positionen[11];
        muehlen[4][0] = positionen[12];
        muehlen[4][1] = positionen[13];
        muehlen[4][2] = positionen[14];
        muehlen[5][0] = positionen[15];
        muehlen[5][1] = positionen[16];
        muehlen[5][2] = positionen[17];
        muehlen[6][0] = positionen[18];
        muehlen[6][1] = positionen[19];
        muehlen[6][2] = positionen[20];
        muehlen[7][0] = positionen[21];
        muehlen[7][1] = positionen[22];
        muehlen[7][2] = positionen[23];
        //alle moeglichen Muehlen vertikal
        muehlen[8][0] = positionen[0];
        muehlen[8][1] = positionen[9];
        muehlen[8][2] = positionen[21];
        muehlen[9][0] = positionen[3];
        muehlen[9][1] = positionen[10];
        muehlen[9][2] = positionen[18];
        muehlen[10][0] = positionen[6];
        muehlen[10][1] = positionen[11];
        muehlen[10][2] = positionen[15];
        muehlen[11][0] = positionen[1];
        muehlen[11][1] = positionen[4];
        muehlen[11][2] = positionen[7];
        muehlen[12][0] = positionen[16];
        muehlen[12][1] = positionen[19];
        muehlen[12][2] = positionen[22];
        muehlen[13][0] = positionen[8];
        muehlen[13][1] = positionen[12];
        muehlen[13][2] = positionen[17];
        muehlen[14][0] = positionen[5];
        muehlen[14][1] = positionen[13];
        muehlen[14][2] = positionen[20];
        muehlen[15][0] = positionen[1];
        muehlen[15][1] = positionen[14];
        muehlen[15][2] = positionen[23];
    }

    public void spielfeldAusgabe(){
        /*
        System.out.println("21                   22                   23");
        System.out.println("                                            ");
        System.out.println("        18           19           20        ");
        System.out.println("                                            ");
        System.out.println("                15   16   17                ");
        System.out.println("                                            ");
        System.out.println("9       10      11        12      13      14");
        System.out.println("                                            ");
        System.out.println("                 6    7    8                ");
        System.out.println("                                            ");
        System.out.println("        3             4            5        ");
        System.out.println("                                            ");
        System.out.println("0                     1                    2");
     */

        System.out.println(positionAusgabeAufSpielfeld(21) + "                   " + positionAusgabeAufSpielfeld(22) + "                   " + positionAusgabeAufSpielfeld(23));
        System.out.println("                                            ");
        System.out.println("        " + positionAusgabeAufSpielfeld(18) + "           " + positionAusgabeAufSpielfeld(19) + "           " + positionAusgabeAufSpielfeld(20) + "        ");
        System.out.println("                                            ");
        System.out.println("                " + positionAusgabeAufSpielfeld(15) + "   " + positionAusgabeAufSpielfeld(16) + "   " + positionAusgabeAufSpielfeld(17) + "                ");
        System.out.println("                                            ");
        System.out.println(positionAusgabeAufSpielfeld(9) + "       " + positionAusgabeAufSpielfeld(10) + "       " + positionAusgabeAufSpielfeld(11) +"        " + positionAusgabeAufSpielfeld(12) + "       " + positionAusgabeAufSpielfeld(13) + "       " + positionAusgabeAufSpielfeld(14));
        System.out.println("                                            ");
        System.out.println("                " + positionAusgabeAufSpielfeld(6) + "   " + positionAusgabeAufSpielfeld(7) + "   " + positionAusgabeAufSpielfeld(8) + "                ");
        System.out.println("                                            ");
        System.out.println("        " + positionAusgabeAufSpielfeld(3) + "           " + positionAusgabeAufSpielfeld(4) + "           " + positionAusgabeAufSpielfeld(5) + "        ");
        System.out.println("                                            ");
        System.out.println(positionAusgabeAufSpielfeld(0) + "                   " + positionAusgabeAufSpielfeld(1) + "                   " + positionAusgabeAufSpielfeld(2));


    }

    public String positionAusgabeAufSpielfeld(int i){
        switch (positionen[i].getSpielerAufPosition()) {
            case SPIELER_1:
                return "O";
            case SPIELER_2:
                return "X";
            case NIEMAND:
                return "-";
            default:
                return null;
        }
    }

}
