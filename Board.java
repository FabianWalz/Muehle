public class Board {
    private static final int POSITIONS_ON_BOARD = 24;
    private final int POSSIBLE_MILLS = 16;
    private final int POSITIONS_IN_MILL = 3;

    private int numOfPiecesP1;
    private int numOfPiecesP2;
    private int totalNumOfPiecesOnBoard;

    private Position[] boardPositions;
    private Position[][] millCombinations;

    //Board initialisieren
    public Board(){
        boardPositions = new Position[Board.POSITIONS_ON_BOARD];
        numOfPiecesP1 = 0;
        numOfPiecesP2 = 2;
        totalNumOfPiecesOnBoard = 0;
        initializeBoard();
        initializeMillCombinations();
    }

    public Position getPosition(int posIndex){
            return boardPositions[posIndex];
    }

    public boolean posIsAvailable(int posIndex){
        return !boardPositions[posIndex].isOccupied();
    }

    public void setPositionOccByP(int posIndex, WhichPlayer player){
        if(player == WhichPlayer.PLAYER_1 || player == WhichPlayer.PLAYER_2){
            boardPositions[posIndex].setAsOccupied(player);
        } else {
            System.out.println("Kein Player der diese Position besetzen vorhanden");
        }
    }

    public int incTotalNumOfPiecesOnBoard(){
        return ++totalNumOfPiecesOnBoard;
    }

    //exceptions werfen?
    public int incNumPiecesOfP(WhichPlayer player){
        if(player == WhichPlayer.PLAYER_1){
            return ++numOfPiecesP1;
        } else if (player == WhichPlayer.PLAYER_2){
            return ++numOfPiecesP2;
        } else {
           return -1;
        }
    }

    public int decNumPiecesOfP(WhichPlayer player){
        if(player == WhichPlayer.PLAYER_1){
            return --numOfPiecesP1;
        } else if (player == WhichPlayer.PLAYER_2){
            return --numOfPiecesP2;
        } else {
            return -1;
        }
    }

    public int getNumOfPiecesOfP(WhichPlayer player){
        if(player == WhichPlayer.PLAYER_1){
            return numOfPiecesP1;
        } else if (player == WhichPlayer.PLAYER_2) {
            return numOfPiecesP2;
        } else {
            return -1;
        }
    }

    private int initializeBoard(){
        return 0;
    }

    public Position[] getMillCOmbination(int index){
            return millCombinations[index];
    }

    private void initializeMillCombinations(){

    }

    public void printBoard(){

    }

}
