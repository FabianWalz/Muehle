import java.util.Scanner;

public class Probe1 {
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
                anzahlSteineSpieler2 += 1;
            } else if ((array[zeile1][spalte1] == 0) || (array[zeile1][spalte1] == 2) || (array[zeile][spalte] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                System.out.println("Zeile:");
                int zeile1New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte1New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position: [" + zeile1 + "][" + spalte1 + "]");
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
            int zeile1 = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte1 = scanner.nextInt();
            System.out.println("Gewaehlte Position: [" + zeile1 + "][" + spalte1 + "]");
            if (array[zeile1][spalte1] == 1) {
                array[zeile1][spalte1] = 3;
                anzahlSteineSpieler2 += 1;
            } else if ((array[zeile1][spalte1] == 0) || (array[zeile1][spalte1] == 2) || (array[zeile][spalte] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                System.out.println("Zeile:");
                int zeile1New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte1New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position: [" + zeile1 + "][" + spalte1 + "]");
                anzahlSteineSpieler2 += 1;
            }
        } while(anzahlSteineSpieler2 != 9);
            setzphaseSpieler1();
    }
}