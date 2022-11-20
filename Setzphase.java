import java.util.Scanner;

public class Setzphase{

    public void setzphaseSpieler1() {

        int[][] array = new int[7][7];

        array[0][0] = 1;
        array[0][3] = 1;
        array[0][6] = 1;

        array[1][1] = 1;
        array[1][3] = 1;
        array[1][5] = 1;

        array[2][2] = 1;
        array[2][3] = 1;
        array[2][4] = 1;

        array[3][0] = 1;
        array[3][1] = 1;
        array[3][2] = 1;
        array[3][4] = 1;
        array[3][5] = 1;
        array[3][6] = 1;

        array[4][2] = 1;
        array[4][3] = 1;
        array[4][4] = 1;

        array[5][1] = 1;
        array[5][3] = 1;
        array[5][5] = 1;

        array[6][0] = 1;
        array[6][3] = 1;
        array[6][6] = 1;

        int anzahlSteineSpieler1 = 0;

        do {
            System.out.println("Spieler 1, du bist an der Reihe.");
            System.out.println("Setze deinen " + anzahlSteineSpieler1 + ". Stein.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zeile:");
            int zeile1 = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte1 = scanner.nextInt();
            System.out.println("Gewaehlte Position: [" + zeile1 + "][" + spalte1 + "]");
            if (array[zeile1][spalte1] == 1) {
                array[zeile1][spalte1] = 2;
                anzahlSteineSpieler1 += 1;
                setzphaseSpieler2();
            } else if ((array[zeile1][spalte1] == 0) || (array[zeile1][spalte1] == 2) || (array[zeile1][spalte1] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                System.out.println("Zeile:");
                int zeile1New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte1New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position: [" + zeile1New + "][" + spalte1New + "]");
                anzahlSteineSpieler1 += 1;
                setzphaseSpieler2();
            }
        } while (anzahlSteineSpieler1 != 9);
    }

    public void setzphaseSpieler2() {

        int[][] array = new int[7][7];

        array[0][0] = 1;
        array[0][3] = 1;
        array[0][6] = 1;

        array[1][1] = 1;
        array[1][3] = 1;
        array[1][5] = 1;

        array[2][2] = 1;
        array[2][3] = 1;
        array[2][4] = 1;

        array[3][0] = 1;
        array[3][1] = 1;
        array[3][2] = 1;
        array[3][4] = 1;
        array[3][5] = 1;
        array[3][6] = 1;

        array[4][2] = 1;
        array[4][3] = 1;
        array[4][4] = 1;

        array[5][1] = 1;
        array[5][3] = 1;
        array[5][5] = 1;

        array[6][0] = 1;
        array[6][3] = 1;
        array[6][6] = 1;

        int anzahlSteineSpieler2 = 0;

        do {
            System.out.println("Spieler 2, du bist an der Reihe.");
            System.out.println("Setze deinen " + anzahlSteineSpieler2 + ". Stein.");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zeile:");
            int zeile2 = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte2 = scanner.nextInt();
            System.out.println("Gewaehlte Position: [" + zeile2 + "][" + spalte2 + "]");
            if (array[zeile2][spalte2] == 1) {
                array[zeile2][spalte2] = 3;
                anzahlSteineSpieler2 += 1;
                setzphaseSpieler1();
            } else if ((array[zeile2][spalte2] == 0) || (array[zeile2][spalte2] == 2) || (array[zeile2][spalte2] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                System.out.println("Zeile:");
                int zeile2New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte2New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position: [" + zeile2New + "][" + spalte2New + "]");
                anzahlSteineSpieler2 += 1;
                setzphaseSpieler1();
            }
        } while (anzahlSteineSpieler2 != 9);
    }
}




