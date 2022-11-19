import java.util.Scanner;

public class BenachbarteZüge {
    public void possibleMoves() {   //Spieler 1...

        int[][] array = new int[7][7];  //nur damit es funktioniert

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welchen Stein möchtest du ziehen?");
        System.out.println("Zeile: ");
        int zeile = scanner.nextInt();
        System.out.println("Spalte: ");
        int spalte = scanner.nextInt();
        System.out.println("Stein: [" + zeile + "][" + spalte + "]");
        System.out.println("Auf welches Feld soll der ausgewählte Stein gezogen werden?");
        System.out.println("Zeile: ");
        int zeileNew = scanner.nextInt();
        System.out.println("Spalte: ");
        int spalteNew = scanner.nextInt();

        if (array[zeile][spalte] == array[0][0] && array[0][0] == 2) {
            if (array[zeileNew][spalteNew] == array[3][0] && array[3][0] == 1) {
                array[3][0] = 2;
                array[0][0] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[0][3] && array[0][3] == 1) {
                array[0][3] = 2;
                array[0][0] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[0][3] && array[0][3] == 2) {
            if (array[zeileNew][spalteNew] == array[0][0] && array[0][0] == 1) {
                array[0][0] = 2;
                array[0][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[0][6] && array[0][6] == 1) {
                array[0][6] = 2;
                array[0][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[1][3] && array[1][3] == 1) {
                array[1][3] = 2;
                array[0][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[0][6] && array[0][6] == 2) {
            if (array[zeileNew][spalteNew] == array[0][3] && array[0][3] == 1) {
                array[0][3] = 2;
                array[0][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][1] && array[3][1] == 1) {
                array[3][1] = 2;
                array[0][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[1][1] && array[1][1] == 2) {
            if (array[zeileNew][spalteNew] == array[3][1] && array[3][1] == 1) {
                array[3][1] = 2;
                array[1][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[1][3] && array[1][3] == 1) {
                array[1][3] = 2;
                array[1][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[1][3] && array[1][3] == 2) {
            if (array[zeileNew][spalteNew] == array[1][1] && array[1][1] == 1) {
                array[1][1] = 2;
                array[1][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[1][5] && array[1][5] == 1) {
                array[1][5] = 2;
                array[1][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[0][3] && array[0][3] == 1) {
                array[0][3] = 2;
                array[1][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[2][3] && array[2][3] == 1) {
                array[2][3] = 2;
                array[1][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[1][5] && array[1][5] == 2) {
            if (array[zeileNew][spalteNew] == array[1][3] && array[1][3] == 1) {
                array[1][3] = 2;
                array[1][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][5] && array[3][5] == 1) {
                array[3][5] = 2;
                array[1][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[2][2] && array[2][2] == 2) {
            if (array[zeileNew][spalteNew] == array[3][1] && array[3][1] == 1) {
                array[3][1] = 2;
                array[2][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[1][3] && array[1][3] == 1) {
                array[1][3] = 2;
                array[2][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[2][3] && array[2][3] == 2) {
            if (array[zeileNew][spalteNew] == array[2][2] && array[2][2] == 1) {
                array[2][2] = 2;
                array[2][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[2][4] && array[2][4] == 1) {
                array[2][4] = 2;
                array[2][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[1][3] && array[1][3] == 1) {
                array[1][3] = 2;
                array[2][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[2][4] && array[2][4] == 2) {
            if (array[zeileNew][spalteNew] == array[2][3] && array[2][3] == 1) {
                array[2][3] = 2;
                array[2][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][4] && array[3][4] == 1) {
                array[3][4] = 2;
                array[2][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[3][0] && array[3][0] == 2) {
            if (array[zeileNew][spalteNew] == array[0][0] && array[0][0] == 1) {
                array[0][0] = 2;
                array[3][0] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[6][0] && array[6][0] == 1) {
                array[6][0] = 2;
                array[3][0] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[3][1] && array[3][1] == 2) {
            if (array[zeileNew][spalteNew] == array[3][0] && array[3][0] == 1) {
                array[3][0] = 2;
                array[3][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][2] && array[3][2] == 1) {
                array[3][2] = 2;
                array[3][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[1][1] && array[1][1] == 1) {
                array[1][1] = 2;
                array[3][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[5][1] && array[5][1] == 1) {
                array[5][1] = 2;
                array[3][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[3][2] && array[3][2] == 2) {
            if (array[zeileNew][spalteNew] == array[3][1] && array[3][1] == 1) {
                array[3][1] = 2;
                array[3][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[2][2] && array[2][2] == 1) {
                array[2][2] = 2;
                array[3][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[4][2] && array[4][2] == 1) {
                array[4][2] = 2;
                array[3][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[3][4] && array[3][4] == 2) {
            if (array[zeileNew][spalteNew] == array[3][5] && array[3][5] == 1) {
                array[3][5] = 2;
                array[3][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[2][4] && array[2][4] == 1) {
                array[2][4] = 2;
                array[3][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[4][4] && array[4][4] == 1) {
                array[4][4] = 2;
                array[3][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[3][5] && array[3][5] == 2) {
            if (array[zeileNew][spalteNew] == array[3][4] && array[3][4] == 1) {
                array[3][4] = 2;
                array[3][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][6] && array[3][6] == 1) {
                array[3][6] = 2;
                array[3][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[2][5] && array[2][5] == 1) {
                array[2][5] = 2;
                array[3][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[5][5] && array[5][5] == 1) {
                array[5][5] = 2;
                array[3][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[3][6] && array[3][6] == 2) {
            if (array[zeileNew][spalteNew] == array[3][5] && array[3][5] == 1) {
                array[3][5] = 2;
                array[3][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[0][6] && array[0][6] == 1) {
                array[0][6] = 2;
                array[3][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[6][6] && array[6][6] == 1) {
                array[6][6] = 2;
                array[3][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[4][2] && array[4][2] == 2) {
            if (array[zeileNew][spalteNew] == array[4][3] && array[4][3] == 1) {
                array[4][3] = 2;
                array[4][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][2] && array[3][2] == 1) {
                array[3][2] = 2;
                array[4][2] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[4][3] && array[4][3] == 2) {
            if (array[zeileNew][spalteNew] == array[4][2] && array[4][2] == 1) {
                array[4][2] = 2;
                array[4][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[4][4] && array[4][4] == 1) {
                array[4][4] = 2;
                array[4][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[5][3] && array[5][3] == 1) {
                array[5][3] = 2;
                array[4][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[4][4] && array[4][4] == 2) {
            if (array[zeileNew][spalteNew] == array[4][3] && array[4][3] == 1) {
                array[4][3] = 2;
                array[4][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][4] && array[3][4] == 1) {
                array[3][4] = 2;
                array[4][4] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[5][1] && array[5][1] == 2) {
            if (array[zeileNew][spalteNew] == array[3][1] && array[3][1] == 1) {
                array[3][1] = 2;
                array[5][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[5][3] && array[5][3] == 1) {
                array[5][3] = 2;
                array[5][1] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[5][3] && array[5][3] == 2) {
            if (array[zeileNew][spalteNew] == array[5][1] && array[5][1] == 1) {
                array[5][1] = 2;
                array[5][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[5][5] && array[5][5] == 1) {
                array[5][5] = 2;
                array[5][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[4][3] && array[4][3] == 1) {
                array[4][3] = 2;
                array[5][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[6][3] && array[6][3] == 1) {
                array[6][3] = 2;
                array[5][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[5][5] && array[5][5] == 2) {
            if (array[zeileNew][spalteNew] == array[5][3] && array[5][3] == 1) {
                array[5][3] = 2;
                array[5][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][5] && array[3][5] == 1) {
                array[3][5] = 2;
                array[5][5] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[6][0] && array[6][0] == 2) {
            if (array[zeileNew][spalteNew] == array[3][0] && array[3][0] == 1) {
                array[3][0] = 2;
                array[6][0] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[6][3] && array[6][3] == 1) {
                array[6][3] = 2;
                array[6][0] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[6][3] && array[6][3] == 2) {
            if (array[zeileNew][spalteNew] == array[6][0] && array[6][0] == 1) {
                array[6][0] = 2;
                array[6][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[6][6] && array[6][6] == 1) {
                array[6][6] = 2;
                array[6][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[5][3] && array[5][3] == 1) {
                array[5][3] = 2;
                array[6][3] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
        if (array[zeile][spalte] == array[6][6] && array[6][6] == 2) {
            if (array[zeileNew][spalteNew] == array[6][3] && array[6][3] == 1) {
                array[6][3] = 2;
                array[6][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else if (array[zeileNew][spalteNew] == array[3][6] && array[3][6] == 1) {
                array[3][6] = 2;
                array[6][6] = 1;
                System.out.println("Neue Position: [" + zeileNew + "][" + spalteNew + "]");
            } else {
                System.out.println("ungültiges Feld");
            }
        }
    }
}


