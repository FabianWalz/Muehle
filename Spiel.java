import java.util.Scanner;


public class Spiel {

    private enum Phase {SETZEN, ZIEHEN, SPRINGEN}

    private Phase curPhase;
    private Spielfeld matrix;
    private Spieler spieler1;
    private Spieler spieler2;

    public Spiel() {
        matrix = new Spielfeld();
    }

    public void run() throws InterruptedException {
        //setzphaseFake();
        //setzphaseFake1();
        //setzphaseFake2();
        //setzphaseEcht();
        //setzphaseSpielerComputer();
        System.out.println("---");
        this.matrix.display();
        System.out.println("---");
        //spielphase();
        //spielphaseSpielerComputer();
    }

    // fertige Setzphase zum Testen
    private void setzphaseFake() {
        this.spieler1 = new Spieler("Peter", 9, 0);
        this.spieler2 = new Spieler("Terence", 9, 0);
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

    private void setzphaseFake2() {
        this.spieler1 = new Spieler("Peter", 9, 0);
        this.spieler2 = new Spieler("Terence", 4, 0);
        //
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 0, 3);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 2, 3);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 1);
        this.matrix.putStone(Spielfeld.Belegung.SCHWZ, 1, 5);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 0);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 0, 6);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 3, 1);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 3, 5);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 2, 2);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 2, 4);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 6, 0);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 4, 3);
        this.matrix.putStone(Spielfeld.Belegung.WEISS, 6, 6);

    }

    //selbstständige Setzphase; Modus: Spieler vs Computer
    private void setzphaseSpielerComputer() {

        int zeile;
        int spalte;
        int zug = 1;

        //Name Spieler1
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.print("Name Spieler: ");
        input = scanner.nextLine();
        this.spieler1 = new Spieler(input, 0, 0);

        //Name Computer
        String nameComputer = "Terence";
        System.out.println("Hallo " + spieler1.getName() + ", du spielst gegen " + nameComputer + ".");
        System.out.println();
        this.spieler2 = new Spieler(nameComputer, 0, 0);
        this.matrix.display();

        for (int i = 0; i < 9; i++) {
            // Spieler 1
            do {
                System.out.println();
                System.out.println("Zug Nr." + zug + ", bitte einen Stein setzen " + this.spieler1.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
                spieler1.addStone();
            } while (!this.matrix.putStone(Spielfeld.Belegung.WEISS, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.WEISS, zeile, spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von " + this.spieler2.getName() + ":");
                    System.out.print("    Zeile:  ");
                    zeile = scanner.nextInt();
                    System.out.print("    Spalte: ");
                    spalte = scanner.nextInt();
                    spieler2.removeStone();
                } while (!this.matrix.removeStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
            }

            //Computer
            if (this.matrix.cleverMove() == true) {
                System.out.println(spieler2.getName() + " hat einen Stein gesetzt.");
                System.out.println("---");
                zug++;
                this.matrix.display();
            } else if (this.matrix.createMill() == true) {
                do {
                    zeile = (int) (Math.random() * ((6 - 0) + 1));
                    spalte = (int) (Math.random() * ((6 - 0) + 1));
                    spieler1.removeStone();
                } while (!this.matrix.removeStone(Spielfeld.Belegung.WEISS, zeile, spalte));
                System.out.println("Der Computer hat eine Mühle.");
                System.out.println("Der Computer hat deinen Stein von Feld " + "[" + zeile + "][" + spalte + "] entfernt.");
                System.out.println("---");
                zug++;
                this.matrix.display();
            } else if (this.matrix.preventMill() == true) {
                System.out.println("Der Computer hat einen Stein gesetzt und eine Mühle erfolgreich verhindert.");
                System.out.println("---");
                zug++;
                this.matrix.display();
            } else {
                do {
                    zeile = (int) (Math.random() * ((6 - 0) + 1));
                    spalte = (int) (Math.random() * ((6 - 0) + 1));
                    spieler2.addStone();
                } while (!this.matrix.putStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
                System.out.println("Der Computer hat seinen " + zug + ". Stein auf das Feld " + "[" + zeile + "][" + spalte + "] gesetzt.");
                System.out.println("---");
                if (this.matrix.isMillComplete(Spielfeld.Belegung.SCHWZ, zeile, spalte)) {
                    do {
                        zeile = (int) (Math.random() * ((6 - 0) + 1));
                        spalte = (int) (Math.random() * ((6 - 0) + 1));
                        spieler1.removeStone();
                    } while (!this.matrix.removeStone(Spielfeld.Belegung.WEISS, zeile, spalte));
                    System.out.println("Der Computer hat deinen Stein von Feld " + "[" + zeile + "][" + spalte + "] entfernt.");
                }
                zug++;
                this.matrix.display();
            }
        }
    }

    //selbstständige Setzphase; Modus: Spieler vs Spieler
    private void setzphaseEcht() {

        int zeile;
        int spalte;
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

        // abwechselnde Eingabe der Belegungen von den Spielern
        for (int i = 0; i < 9; i++) {
            // Spieler 1
            do {
                System.out.println("Zug Nr." + zug + ", bitte einen Stein setzen " + this.spieler1.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
                spieler1.addStone();
            } while (!this.matrix.putStone(Spielfeld.Belegung.WEISS, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.WEISS, zeile, spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von " + this.spieler2.getName() + ":");
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
                System.out.println("Zug Nr." + zug + ", bitte einen Stein setzen " + this.spieler2.getName() + ":");
                System.out.print("    Zeile:  ");
                zeile = scanner.nextInt();
                System.out.print("    Spalte: ");
                spalte = scanner.nextInt();
                spieler2.addStone();
            } while (!this.matrix.putStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
            if (this.matrix.isMillComplete(Spielfeld.Belegung.SCHWZ, zeile, spalte)) {
                do {
                    System.out.println("Zug Nr." + zug + ", Stein wegnehmen von " + this.spieler1.getName() + ":");
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


    private void spielphaseSpielerComputer() throws InterruptedException {

        boolean gameOver = false;
        int zeile, vonZeile, nachZeile;
        int spalte, vonSpalte, nachSpalte;
        int nbrOfMovesWithoutMill = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            // Abfrage, ob ein Spieler in der Sprungphase ist
            if (spieler1.getNumberOfStones() == 3) {   //curPlayer.isInJumpPhase() &&
                do {
                    System.out.println("Sprung von " + spieler1.getName() + ":");
                    System.out.print("  von Zeile:   ");
                    vonZeile = scanner.nextInt();
                    System.out.print("  von Spalte:  ");
                    vonSpalte = scanner.nextInt();
                    System.out.print("  nach Zeile:  ");
                    nachZeile = scanner.nextInt();
                    System.out.print("  nach Spalte: ");
                    nachSpalte = scanner.nextInt();
                } while (!this.matrix.putStone(Spielfeld.Belegung.WEISS, vonZeile, vonSpalte, nachZeile, nachSpalte));
                spieler1.nbrMoves();
                //System.out.println("Anzahl gespielter Züge von " + spieler1.getName() + ": " + spieler1.getNumberOfMoves());
                nbrOfMovesWithoutMill++;

                if (nbrOfMovesWithoutMill == 20) {
                    gameOver = true;
                    System.out.println("Das Spiel ist beendet. Ergebnis: Unentschieden");
                }
                if (this.matrix.isMillComplete(Spielfeld.Belegung.WEISS, nachZeile, nachSpalte)) {
                    do {

                        System.out.println("Stein wegnehmen von " + spieler2.getName() + ":");
                        System.out.print("  Zeile:  ");
                        zeile = scanner.nextInt();
                        System.out.print("  Spalte: ");
                        spalte = scanner.nextInt();
                    } while (!this.matrix.removeStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
                    spieler2.removeStone();
                    nbrOfMovesWithoutMill = 0;

                    if (spieler2.getNumberOfStones() < 3) {
                        gameOver = true;
                        System.out.println("Das Spiel ist beendet. Glückwunsch " + spieler1.getName() + ", du hast gewonnen.");
                    }
                }
            } else if (matrix.isMovePossible(Spielfeld.Belegung.WEISS)) {
                do {
                    System.out.println("Zug von " + spieler1.getName() + ":");
                    System.out.print("  von Zeile:   ");
                    vonZeile = scanner.nextInt();
                    System.out.print("  von Spalte:  ");
                    vonSpalte = scanner.nextInt();
                    System.out.print("  nach Zeile:  ");
                    nachZeile = scanner.nextInt();
                    System.out.print("  nach Spalte: ");
                    nachSpalte = scanner.nextInt();
                } while (!this.matrix.moveStone(Spielfeld.Belegung.WEISS, vonZeile, vonSpalte, nachZeile, nachSpalte));
                spieler1.nbrMoves();
                //System.out.println("Anzahl gespielter Züge von " + spieler1.getName() + ": " + spieler1.getNumberOfMoves());
                nbrOfMovesWithoutMill++;

                if (nbrOfMovesWithoutMill == 20) {
                    gameOver = true;
                    System.out.println("Das Spiel ist beendet. Ergebnis: Unentschieden");
                }

                if (this.matrix.isMillComplete(Spielfeld.Belegung.WEISS, nachZeile, nachSpalte)) {
                    do {
                        System.out.println("Stein wegnehmen von " + spieler2.getName() + ":");
                        System.out.print("  Zeile:  ");
                        zeile = scanner.nextInt();
                        System.out.print("  Spalte: ");
                        spalte = scanner.nextInt();
                    } while (!this.matrix.removeStone(Spielfeld.Belegung.SCHWZ, zeile, spalte));
                    spieler2.removeStone();
                    nbrOfMovesWithoutMill = 0;

                    if (spieler2.getNumberOfStones() < 3) {
                        gameOver = true;
                        System.out.println("Das Spiel ist beendet. Glückwunsch " + spieler1.getName() + ", du hast gewonnen.");
                    }
                }

                if (gameOver == true) {
                    break;
                }

                System.out.println();

                //Computer ist an der Reihe
                //Abfrage, ob der Computer in der Sprungphase ist
                if (spieler2.getNumberOfStones() == 3) {
                    do {
                        vonZeile = (int) (Math.random() * ((6 - 0) + 1));
                        vonSpalte = (int) (Math.random() * ((6 - 0) + 1));
                        nachZeile = (int) (Math.random() * ((6 - 0) + 1));
                        nachSpalte = (int) (Math.random() * ((6 - 0) + 1));

                    } while (!this.matrix.putStone(Spielfeld.Belegung.SCHWZ, vonZeile, vonSpalte, nachZeile, nachSpalte));
                    System.out.println(spieler2.getName() + " ist mit dem Stein von Feld [" + vonZeile + "][" + vonSpalte + "] nach Feld [" + nachZeile + "][" + nachSpalte + "] gesprungen.");
                    spieler2.nbrMoves();
                    //System.out.println("Anzahl gespielter Züge von " + spieler2.getName() + ": " + spieler2.getNumberOfMoves());
                    nbrOfMovesWithoutMill++;

                    if (nbrOfMovesWithoutMill == 20) {
                        gameOver = true;
                        System.out.println("Das Spiel ist beendet. Ergebnis: Unentschieden");
                    }

                    if (this.matrix.isMillComplete(Spielfeld.Belegung.SCHWZ, nachZeile, nachSpalte)) {
                        do {
                            zeile = (int) (Math.random() * ((6 - 0) + 1));
                            spalte = (int) (Math.random() * ((6 - 0) + 1));

                        } while (!this.matrix.removeStone(Spielfeld.Belegung.WEISS, zeile, spalte));
                        System.out.println(spieler2.getName() + " hat deinen Stein von Feld " + "[" + zeile + "][" + spalte + "] entfernt.");
                        spieler1.removeStone();
                        nbrOfMovesWithoutMill = 0;

                        if (spieler1.getNumberOfStones() < 3) {
                            gameOver = true;
                            System.out.println("Du hast das Spiel leider verloren " + spieler1.getName() + ".");
                        }

                    }
                } else if (matrix.isMovePossible(Spielfeld.Belegung.SCHWZ)) {
                    do {
                        vonZeile = (int) (Math.random() * ((6 - 0) + 1));
                        vonSpalte = (int) (Math.random() * ((6 - 0) + 1));
                        nachZeile = (int) (Math.random() * ((6 - 0) + 1));
                        nachSpalte = (int) (Math.random() * ((6 - 0) + 1));

                    } while (!this.matrix.moveStone(Spielfeld.Belegung.SCHWZ, vonZeile, vonSpalte, nachZeile, nachSpalte));
                    System.out.println(spieler2.getName() + " hat seinen Stein von Feld [" + vonZeile + "][" + vonSpalte + "] nach Feld [" + nachZeile + "][" + nachSpalte + "] bewegt.");
                    spieler2.nbrMoves();
                    //System.out.println("Anzahl gespielter Züge von " + spieler2.getName() + ": " + spieler2.getNumberOfMoves());

                    nbrOfMovesWithoutMill++;

                    if (nbrOfMovesWithoutMill == 20) {
                        gameOver = true;
                        System.out.println("Das Spiel ist beendet. Ergebnis: Unentschieden");
                    }

                    if (this.matrix.isMillComplete(Spielfeld.Belegung.SCHWZ, nachZeile, nachSpalte)) {
                        do {
                            zeile = (int) (Math.random() * ((6 - 0) + 1));
                            spalte = (int) (Math.random() * ((6 - 0) + 1));
                        } while (!this.matrix.removeStone(Spielfeld.Belegung.WEISS, zeile, spalte));

                        System.out.println(spieler2.getName() + " hat deinen Stein von Feld " + "[" + zeile + "][" + spalte + "] entfernt.");
                        spieler1.removeStone();
                        nbrOfMovesWithoutMill = 0;

                        if (spieler1.getNumberOfStones() < 3) {
                            gameOver = true;
                            System.out.println("Du hast das Spiel leider verloren " + spieler1.getName() + ".");
                        }
                    }
                }

                System.out.println("---");
                this.matrix.display();
                System.out.println("---");

                if (gameOver == true) {
                    break;
                }
            }
        } while (!gameOver);
    }

    private void spielphase() throws InterruptedException {

        boolean gameOver = false;
        int zeile, vonZeile = 0, nachZeile;
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
                    System.out.println("Zug von Spieler " + curPlayer.getName() + ":");
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

            if (gameOver == true) {
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




