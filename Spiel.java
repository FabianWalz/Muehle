import java.util.Scanner;

public class Spiel {

    private enum Phase { SETZEN, ZIEHEN, SPRINGEN }

    private Phase curPhase;
    private Spielfeld matrix;

    private Spieler spieler1;
    private Spieler spieler2;


    public Spiel() {
        curPhase = Phase.SETZEN;
        matrix = new Spielfeld();
        //
    }

    public void run() {
        //setzphaseEcht();
        setzphaseFake();
        this.matrix.display();
        System.out.println("----------");
        spielphase();
    }


    private void setzphaseFake() {
        this.spieler1 = new Spieler("Weiß", 9);
        this.spieler2 = new Spieler("Schwarz", 9);
        //
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 0);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 5);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 6);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 1);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 3);
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

    private void setzphaseEcht() {
        int spalte;
        int zeile;
        int zug = 1;
        Scanner scanner = new Scanner(System.in);
        String input;

       /* Step: Eingabe Spieler
         * --- -- */
        System.out.print("Name Spieler 1: ");
        input = scanner.nextLine();
        this.spieler1 = new Spieler(input, 9);
        //
        System.out.print("Name Spieler 2: ");
        input = scanner.nextLine();
        this.spieler2 = new Spieler(input, 9);
        //

        /* Step: Eingabe Belegung
         * ----- */
        for (int i=0 ; i<9 ; i++) {
            // Spieler 1
            do {
                System.out.println("Zug Nr." + zug + ",setzen Spieler  " + this.spieler1.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
            } while (!this.matrix.putStone(Spielfeld.Belegung.WEISS, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.WEISS, zeile,spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von Spieler  " + this.spieler2.getName() + ":");
                    System.out.print("    Zeile:  ");
                    zeile = scanner.nextInt();
                    System.out.print("    Spalte: ");
                    spalte = scanner.nextInt();
                } while (!this.matrix.removeStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
            }
            //
            // Spieler 2
            do {
                System.out.println("Zug Nr." + zug + ",setzen Spieler  " + this.spieler2.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
            } while (!this.matrix.putStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.SCHWZ,zeile,spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von Spieler  " + this.spieler1.getName() + ":");
                    System.out.print("    Zeile:  ");
                    zeile = scanner.nextInt();
                    System.out.print("    Spalte: ");
                    spalte = scanner.nextInt();
                } while (!this.matrix.removeStone(Spielfeld.Belegung.WEISS, zeile, spalte));
            }
            zug++;
        }
    }

    private void spielphase() {

        boolean gameOver = false;
        int zeile, vonZeile, nachZeile;
        int spalte, vonSpalte, nachSpalte;

        Scanner scanner = new Scanner(System.in);

        Spieler curPlayer = spieler1;
        Spielfeld.Belegung curColour = Spielfeld.Belegung.WEISS;
        Spielfeld.Belegung otherColour = Spielfeld.Belegung.SCHWZ;

        do {

            /* Step: Eingabe Zug
             * ----- */
            if (curPlayer.isInJumpPhase()) {
                do {
                    System.out.println("Sprung Spieler " + curPlayer.getName() + "; __von__  :");
                    System.out.print("    von Zeile:   ");
                    vonZeile = scanner.nextInt();
                    System.out.print("    von Spalte:  ");
                    vonSpalte = scanner.nextInt();
                    System.out.print("    nach Zeile:  ");
                    nachZeile = scanner.nextInt();
                    System.out.print("    nach Spalte: ");
                    nachSpalte = scanner.nextInt();
                } while (!this.matrix.putStone(curColour, vonZeile, vonSpalte, nachZeile, nachSpalte));
                if (this.matrix.isMillComplete(curColour, nachZeile, nachSpalte)) {
                    do {
                        System.out.println("Stein wegnehmen von Spieler  " + otherColour + ":");
                        System.out.print("    Zeile:  ");
                        zeile = scanner.nextInt();
                        System.out.print("    Spalte: ");
                        spalte = scanner.nextInt();
                    } while (!this.matrix.removeStone(otherColour, zeile, spalte));
                }
            } else if (matrix.isMovePossible(curColour)) {
                do {
                    System.out.println("Zug Spieler " + curPlayer.getName() + "; __von__  :");
                    System.out.print("    von Zeile:   ");
                    vonZeile = scanner.nextInt();
                    System.out.print("    von Spalte:  ");
                    vonSpalte = scanner.nextInt();
                    System.out.print("    nach Zeile:  ");
                    nachZeile = scanner.nextInt();
                    System.out.print("    nach Spalte: ");
                    nachSpalte = scanner.nextInt();
                } while (!this.matrix.moveStone(curColour, vonZeile, vonSpalte, nachZeile, nachSpalte));
                if (this.matrix.isMillComplete(curColour, nachZeile, nachSpalte)) {
                    do {
                        System.out.println("Stein wegnehmen von Spieler  " + otherColour + ":");
                        System.out.print("    Zeile:  ");
                        zeile = scanner.nextInt();
                        System.out.print("    Spalte: ");
                        spalte = scanner.nextInt();
                    } while (!this.matrix.removeStone(otherColour, zeile, spalte));
                }
            }
            else { gameOver = true; }

            // anderer Spieler
            if (curColour == Spielfeld.Belegung.WEISS) {
                System.out.println("Toggle WEISS  -->  SCHWARZ");
                curPlayer = this.spieler2;
                curColour = Spielfeld.Belegung.SCHWZ;
                otherColour = Spielfeld.Belegung.WEISS;
            } else {
                System.out.println("Toggle SCHWARZ  -->  WEISS");
                curPlayer = this.spieler1;
                curColour = Spielfeld.Belegung.WEISS;
                otherColour = Spielfeld.Belegung.SCHWZ;
            }
        } while (!gameOver);
        System.out.println("Anzahl gespielte Züge:" + this.matrix.getMoveCounter());
    }

}
