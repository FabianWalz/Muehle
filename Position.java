public class Position {

    private boolean isOccupied;
    private int posIndex;
    private WhichPlayer playerOccupyingPos;
    private int[] adjPosIndexes; //Indices der benachbarten Positionen

    //Ausgangszustand des Spielfelds
    public Position(int position){
        isOccupied = false;
        this.posIndex = position;
        playerOccupyingPos = WhichPlayer.NO_PLAYER;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public int getPosIndex(){
        return posIndex;
    }

    public WhichPlayer getPlayerOccupyingPos(){
        return playerOccupyingPos;
    }

    //Position als besetzt markieren
    public void setAsOccupied(WhichPlayer player){
        isOccupied = true;
        playerOccupyingPos = player;
    }

    //Position als frei markieren
    public WhichPlayer setAsUnoccupied(){
        isOccupied = false;
        WhichPlayer oldPlayer = playerOccupyingPos;
        playerOccupyingPos = WhichPlayer.NO_PLAYER;
        return oldPlayer;
    }

    public void addAdjPosIndexes(int pos1, int pos2){
        adjPosIndexes = new int[2];
        adjPosIndexes[0] = pos1;
        adjPosIndexes[1] = pos2;
    }

    public void addAdjPosIndexes(int pos1, int pos2, int pos3){
        adjPosIndexes = new int[3];
        adjPosIndexes[0] = pos1;
        adjPosIndexes[1] = pos2;
        adjPosIndexes[2] = pos3;
    }

    public void addAdjPosIndexes(int pos1, int pos2, int pos3, int pos4){
        adjPosIndexes = new int[4];
        adjPosIndexes[0] = pos1;
        adjPosIndexes[1] = pos2;
        adjPosIndexes[2] = pos3;
        adjPosIndexes[3] = pos4;
    }

    public int[] getAdjPosIndexes(){
        return adjPosIndexes;
    }

    //ueberpruefen, ob eine Position benachbart ist
    public boolean isAdjToThis(int posIndex){
        for(int i = 0; i < adjPosIndexes.length; i++){
            if(adjPosIndexes[i] == posIndex){
                return true;
            }
        }
        return false;
    }
}
