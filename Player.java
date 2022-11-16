public abstract class Player {

    protected String name;
    protected int numGamesWon;
    protected int numPieces;
    protected int numPiecesOnBoard;
    protected WhichPlayer whichPlayer;
    protected boolean canJump; //in Sprungphase

    protected Player(){
        numGamesWon = 0;
        numPiecesOnBoard = 0;
        canJump = false;
    }

    public void reset(){
        numPiecesOnBoard = 0;
        canJump = false;
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

    public int getNumPiecesOnBoard(){
        return numPiecesOnBoard;
    }

}
