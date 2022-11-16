public abstract class Player {

    protected String name;
    protected int numGamesWon;
    protected int numPieces;
    protected int numPiecesOnBoard;
    //protected int numPiecesToPlace;
    protected WhichPlayer whichPlayer;
    protected boolean canJump; //in Sprungphase

    protected Player(){
        numGamesWon = 0;
        numPiecesOnBoard = 0;
        canJump = false;
    }

    //gibt den aktuellen Spieler zurueck
    public WhichPlayer getWhichPlayer(){
        return whichPlayer;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getNumPieces(){
        return numPieces;
    }

    /*
    public int setNumPieces(){
        this.numPieces = numPieces;
        return numPieces;
    }
    */

    public int getNumPiecesOnBoard(){
        return numPiecesOnBoard;
    }


    public int getNumPiecesToPlace(){
        return (numPieces - numPiecesOnBoard);
    }

    //waehrend der Setzphase
    public int raiseNumPiecesOnBoard(){
        canJump = false;
        return ++numPiecesOnBoard;
    }

    //Sprungphase beginnt
    public int lowerNumPiecesOnBoard(){
        if(--numPiecesOnBoard == 3){
            canJump = true;
        }
        return --numPiecesOnBoard;
    }

    public boolean canJump(){
        return canJump;
    }

    public void reset(){
        numPiecesOnBoard = 0;
        canJump = false;
    }
}
