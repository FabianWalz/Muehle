import java.util.Scanner;

public class Setzphase {

    String spieler1 = "Peter"; // nur damit funktioniert
    String spieler2 = "Olaf";   // nur damit funktioniert
    int anzahlSteineSpieler1 = 0;   // nur damit funktioniert
    int anzahlSteineSpieler2 = 0;   // nur damit funktioniert
    int[][] array = new int[7][7];  // nur damit funktioniert

    public void setzphaseSpieler1() {

        do {
            System.out.println(spieler1 + ", du bist an der Reihe.");
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
            } else if ((array[zeile1][spalte1] == 0) || (array[zeile1][spalte1] == 2) || (array[zeile1][spalte1] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                System.out.println("Zeile:");
                int zeile1New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte1New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position: [" + zeile1New + "][" + spalte1New + "]");
                anzahlSteineSpieler1 += 1;
            }
        } while(anzahlSteineSpieler1 != 9);
        setzphaseSpieler2();
    }

    public void setzphaseSpieler2() {

        do {
            System.out.println(spieler2 + ", du bist an der Reihe.");
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
            } else if ((array[zeile2][spalte2] == 0) || (array[zeile2][spalte2] == 2) || (array[zeile2][spalte2] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                System.out.println("Zeile:");
                int zeile2New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte2New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position: [" + zeile2New + "][" + spalte2New + "]");
                anzahlSteineSpieler2 += 1;
            }
        } while(anzahlSteineSpieler2 != 9);
        setzphaseSpieler1();
    }
}

