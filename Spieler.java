public class Spieler {

    private String name = new String();
    private int nbrStones = 0;

    public Spieler(String name, int stones) {
        this.name = name;
        this.nbrStones = stones;
    }

    public String getName() {
        return (this.name);
    }

    public int getNumberOfStones() {
        return nbrStones;
    }

    public void removeStone() {
        nbrStones--;
    }

    public boolean isInJumpPhase() {
        return nbrStones<=3;
    }
}
