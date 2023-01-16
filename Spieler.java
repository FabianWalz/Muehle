public class Spieler {

    private String name = new String();
    private int nbrStones = 0;
    private int nbrMoves = 0;

    public Spieler(String name, int stones, int moves) {
        this.name = name;
        this.nbrStones = stones;
        this.nbrMoves = moves;
    }

    public String getName() {
        return this.name;
    }

    public void removeStone() {
        nbrStones--;
    }

    public void addStone() {
        nbrStones++;
    }
    public int getNumberOfStones() {
        return this.nbrStones;
    }

    public void nbrMoves() {
        nbrMoves++;
    }

    public int getNumberOfMoves() {
        return this.nbrMoves;
    }

}