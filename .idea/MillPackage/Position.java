package MillPackage;

public class Position {

    private boolean istBesetzt;
    private int indexPosition;
    private WelcherSpieler spielerAufPosition;
    private int[] benachbartePositionenIndex; //Indices der benachbarten Positionen

    //Ausgangszustand des Spielfelds
    public Position(int position){
        istBesetzt = false;
        this.indexPosition = position;
        spielerAufPosition = WelcherSpieler.NIEMAND;
    }

    public boolean istBesetzt(){
        return istBesetzt;
    }

    public int getIndexPosition(){
        return indexPosition;
    }

    public WelcherSpieler getSpielerAufPosition(){
        return spielerAufPosition;
    }

    //Position als besetzt markieren
    public void setAlsBesetzt(WelcherSpieler spieler){
        istBesetzt = true;
        spielerAufPosition = spieler;
    }

    //Position als frei markieren
    public WelcherSpieler setIstFrei(){
        istBesetzt = false;
        WelcherSpieler oldPlayer = spielerAufPosition;
        spielerAufPosition = WelcherSpieler.NIEMAND;
        return oldPlayer;
    }

    public void benachbartePositionen(int pos1, int pos2){
        benachbartePositionenIndex = new int[2];
        benachbartePositionenIndex[0] = pos1;
        benachbartePositionenIndex[1] = pos2;
    }

    public void benachbartePositionen(int pos1, int pos2, int pos3){
        benachbartePositionenIndex = new int[3];
        benachbartePositionenIndex[0] = pos1;
        benachbartePositionenIndex[1] = pos2;
        benachbartePositionenIndex[2] = pos3;
    }

    public void benachbartePositionen(int pos1, int pos2, int pos3, int pos4){
        benachbartePositionenIndex = new int[4];
        benachbartePositionenIndex[0] = pos1;
        benachbartePositionenIndex[1] = pos2;
        benachbartePositionenIndex[2] = pos3;
        benachbartePositionenIndex[3] = pos4;
    }

    public int[] getBenachbartePositionenIndex(){
        return benachbartePositionenIndex;
    }

    //ueberpruefen, ob eine Position benachbart ist
    public boolean istBenachbart(int position){
        for(int i = 0; i < benachbartePositionenIndex.length; i++){
            if(benachbartePositionenIndex[i] == position){
                return true;
            }
        }
        return false;
    }
}
