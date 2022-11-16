public class Move {
    static public final int PLACING = 1;
    static public final int MOVING = 1;
    static public final int REMOVING = 3;

    public int scrIndex, destIdex, rmvPieceOnIndex;
    public final int typeOfMove;
    public int score;

    //exception werfen?
    public Move(int scr, int dest, int rmv, int type){
        this.scrIndex = scr;
        this.destIdex = dest;
        this.rmvPieceOnIndex = rmv;
        this.typeOfMove = type;
    }

}
