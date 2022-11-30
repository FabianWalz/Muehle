import java.util.Scanner;
//ackage com.company;
import java.util.concurrent.TimeUnit;

public class Spiel {

    private enum Phase {SETZEN, ZIEHEN, SPRINGEN}

    private Phase curPhase;
    private Spielfeld matrix;
    private Spieler spieler1;
    private Spieler spieler2;

    public Spiel() {
        //curPhase = Phase.SETZEN;
        matrix = new Spielfeld();
        //
    }

    public void run() throws InterruptedException {
        //setzphaseEcht();
        setzphaseFake();
        //setzphaseFake1();
        System.out.println("---");
        this.matrix.display();
        System.out.println("---");
        spielphase();
    }

    // fertige Setzphase zum Testen
    private void setzphaseFake() {
        this.spieler1 = new Spieler("Weiß", 9, 0);
        this.spieler2 = new Spieler("Schwarz", 9, 0);
        //
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 0);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 0, 3);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 6);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 1);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 1, 5);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 2, 2);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 2, 3);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 2, 4);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 3, 1);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 3, 2);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 3, 4);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 3, 5);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 3, 6);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 4, 3);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 5, 1);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 5, 5);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 6, 0);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 6, 6);
    }

    private void setzphaseFake1() {
        this.spieler1 = new Spieler("Weiß", 5, 0);
        this.spieler2 = new Spieler("Schwarz", 5, 0);
        //
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 0);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 6);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 5);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 1);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 1, 3);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 2, 2);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 2, 3);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 2, 4);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 3, 1);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 3, 2);
    }

    //selbstständige Setzphase
    private void setzphaseEcht() {
        int spalte;
        int zeile;
        int zug = 1;
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.print("Name Spieler 1: ");
        input = scanner.nextLine();
        this.spieler1 = new Spieler(input, 0, 0);
        //
        System.out.print("Name Spieler 2: ");
        input = scanner.nextLine();
        this.spieler2 = new Spieler(input, 0, 0);

        // abwechselnde Eingabe der Belegungen
        for (int i = 0; i < 9; i++) {
            // Spieler 1
            do {
                System.out.println("Zug Nr." + zug + ", bitte einen Stein setzen Spieler " + this.spieler1.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
                spieler1.addStone();
            } while (!this.matrix.putStone(Spielfeld.Belegung.WEISS, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.WEISS, zeile, spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von Spieler " + this.spieler2.getName() + ":");
                    System.out.print("    Zeile:  ");
                    zeile = scanner.nextInt();
                    System.out.print("    Spalte: ");
                    spalte = scanner.nextInt();
                    spieler2.removeStone();
                } while (!this.matrix.removeStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
            }
            this.matrix.display();
            // Spieler 2
            do {
                System.out.println("Zug Nr." + zug + ", bitte einen Stein setzen Spieler " + this.spieler2.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
                spieler2.addStone();
            } while (!this.matrix.putStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.SCHWZ, zeile, spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von Spieler " + this.spieler1.getName() + ":");
                    System.out.print("    Zeile:  ");
                    zeile = scanner.nextInt();
                    System.out.print("    Spalte: ");
                    spalte = scanner.nextInt();
                    spieler1.removeStone();
                } while (!this.matrix.removeStone(Spielfeld.Belegung.WEISS, zeile, spalte));
            }
            zug++;
            this.matrix.display();
            System.out.println(spieler1.getNumberOfStones());
            System.out.println(spieler2.getNumberOfStones());
        }
    }

    // Setzphase abgeschlossen, Zugphase beginnt
    private void spielphase() throws InterruptedException {

        boolean gameOver = false;
        int zeile, vonZeile, nachZeile;
        int spalte, vonSpalte, nachSpalte;
        int nbrOfMovesWithoutMill = 0;

        Scanner scanner = new Scanner(System.in);

        Spieler curPlayer = spieler1;
        Spieler otherPlayer = spieler2;
        Spielfeld.Belegung curColour = Spielfeld.Belegung.WEISS;
        Spielfeld.Belegung otherColour = Spielfeld.Belegung.SCHWZ;

        do {
            // Abfrage, ob ein Spieler in der Sprungphase ist
            if (curPlayer.getNumberOfStones() == 3) {   //curPlayer.isInJumpPhase() &&
                do {
                    curPlayer.stillTime();

                    System.out.println("Sprung von " + curPlayer.getName() + ":");
                    System.out.print("  von Zeile:   ");
                    vonZeile = scanner.nextInt();
                    System.out.print("  von Spalte:  ");
                    vonSpalte = scanner.nextInt();
                    System.out.print("  nach Zeile:  ");
                    nachZeile = scanner.nextInt();
                    System.out.print("  nach Spalte: ");
                    nachSpalte = scanner.nextInt();
                    curPlayer.nbrMoves();
                    System.out.println("Anzahl gespielter Züge von " + curPlayer.getName() + ": " + curPlayer.getNumberOfMoves());
                    nbrOfMovesWithoutMill++;
                    if (nbrOfMovesWithoutMill == 20) {
                        gameOver = true;
                        System.out.println("Das Spiel ist beendet. Ergebnis: Unentschieden");
                    }

                    if (curPlayer.stillTime == false) {
                        gameOver = true;
                        System.out.println("---Zeitüberschreitung---");
                        System.out.println("Glückwunsch " + otherPlayer.getName() + ". Du hast gewonnen");
                    }

                } while (!this.matrix.putStone(curColour, vonZeile, vonSpalte, nachZeile, nachSpalte));
                if (this.matrix.isMillComplete(curColour, nachZeile, nachSpalte)) {
                    do {

                        System.out.println("Stein wegnehmen von Spieler " + otherColour + ":");
                        System.out.print("  Zeile:  ");
                        zeile = scanner.nextInt();
                        System.out.print("  Spalte: ");
                        spalte = scanner.nextInt();
                        otherPlayer.removeStone();
                        nbrOfMovesWithoutMill = 0;

                        if (otherPlayer.getNumberOfStones() < 3) {
                            gameOver = true;
                            System.out.println("Das Spiel ist beendet. Glückwunsch " + curPlayer.getName() + ", du hast gewonnen.");
                        }

                    } while (!this.matrix.removeStone(otherColour, zeile, spalte));
                }
            } else if (matrix.isMovePossible(curColour)) {
                do {
                    while(curPlayer.stillTime == true) {

                        System.out.println("Zug von Spieler " + curPlayer.getName() + ":");
                        System.out.print("  von Zeile:   ");
                        //vonZeile = scanner.nextInt();
                        System.out.print("  von Spalte:  ");
                        //vonSpalte = scanner.nextInt();
                        System.out.print("  nach Zeile:  ");
                        //nachZeile = scanner.nextInt();
                        System.out.print("  nach Spalte: ");
                        //nachSpalte = scanner.nextInt();
                        curPlayer.nbrMoves();
                        System.out.println("Anzahl gespielter Züge von " + curPlayer.getName() + ": " + curPlayer.getNumberOfMoves());
                        nbrOfMovesWithoutMill++;

                        if (curPlayer.stillTime == false) {
                            gameOver = true;
                            System.out.println("--- Zeitüberschreitung von " + curPlayer.getName() + " ---");
                            System.out.println("Glückwunsch " + otherPlayer.getName() + ". Du hast gewonnen.");
                        } else{
                            gameOver = false;
                        }
                    }

                    if (nbrOfMovesWithoutMill == 20) {
                        gameOver = true;
                        System.out.println("Das Spiel ist beendet. Ergebnis: Unentschieden");
                    }

                    //if (curPlayer.stillTime == false) {
                    //    gameOver = true;
                    //    System.out.println("--- Zeitüberschreitung von " + curPlayer.getName() + " ---");
                    //    System.out.println("Glückwunsch " + otherPlayer.getName() + ". Du hast gewonnen.");
                    // }

                } while (!this.matrix.moveStone(curColour, vonZeile, vonSpalte, nachZeile, nachSpalte));
                if (this.matrix.isMillComplete(curColour, nachZeile, nachSpalte)) {
                    do {
                        System.out.println("Stein wegnehmen von " + otherColour + ":");
                        System.out.print("  Zeile:  ");
                        zeile = scanner.nextInt();
                        System.out.print("  Spalte: ");
                        spalte = scanner.nextInt();
                        otherPlayer.removeStone();
                        nbrOfMovesWithoutMill = 0;

                        if (otherPlayer.getNumberOfStones() < 3) {
                            gameOver = true;
                            System.out.println("Das Spiel ist beendet. Glückwunsch " + curPlayer.getName() + ", du hast gewonnen.");
                        }

                    } while (!this.matrix.removeStone(otherColour, zeile, spalte));
                }
            }

            if(gameOver == true){
               break;
            }

            if (curColour == Spielfeld.Belegung.WEISS) {
                System.out.println("---");
                System.out.println("Toggle WEISS  -->  SCHWARZ");
                curPlayer = this.spieler2;
                otherPlayer = this.spieler1;
                curColour = Spielfeld.Belegung.SCHWZ;
                otherColour = Spielfeld.Belegung.WEISS;
                this.matrix.display();

            } else {
                System.out.println("---");
                System.out.println("Toggle SCHWARZ  -->  WEISS");
                curPlayer = this.spieler1;
                otherPlayer = this.spieler2;
                curColour = Spielfeld.Belegung.WEISS;
                otherColour = Spielfeld.Belegung.SCHWZ;
                this.matrix.display();

            }
        } while (!gameOver);
    }
}
