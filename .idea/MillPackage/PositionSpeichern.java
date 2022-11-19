package MillPackage;


public class PositionSpeichern {
    static public final int PLACING = 1;
    static public final int MOVING = 1;
    static public final int REMOVING = 3;

    public int vonIndex, nachIndex, steinEntfernen;
    public final int typeOfMove;
    public int score;

    //exception werfen?
    public PositionSpeichern(int von, int nach, int entfernen, int type){
        this.vonIndex = von;
        this.nachIndex = nach;
        this.steinEntfernen = entfernen;
        this.typeOfMove = type;
    }

}

