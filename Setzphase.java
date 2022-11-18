import java.util.Scanner;

public class SetzphaseMuehle {
    public static void main(String[] args) {

        int anzahlSteineSpieler1 = 0;
        int anzahlSteineSpieler2 = 0;
        String spieler1 = "Thomas";
        String spieler2 = "Denis";
        int array[][] = new int[7][7];

        do {
            System.out.println(spieler1 + ", du bist an der Reihe.");
            System.out.println("Setze deinen " + anzahlSteineSpieler1 + ". Stein");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zeile:");
            int zeile = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte = scanner.nextInt();
            if (array[zeile][spalte] == 1) {
                array[zeile][spalte] = 2;
                anzahlSteineSpieler1 += 1;
            } else if ((array[zeile][spalte] == 0) || (array[zeile][spalte] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                int zeile = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte = scanner.nextInt();
                anzahlSteineSpieler1 += 1;
            }

            System.out.println(spieler2 + ", du bist an der Reihe.");
            System.out.println("Setze deinen " + anzahlSteineSpieler2 + ". Stein");
            System.out.println("Zeile:");
            int zeile = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte = scanner.nextInt();
            if (array[zeile][spalte] == 1) {
                array[zeile][spalte] = 3;
                anzahlSteineSpieler1 += 1;
            } else if ((array[zeile][spalte] == 0) || (array[zeile][spalte] == 2)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                int zeile = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte = scanner.nextInt();
                anzahlSteineSpieler2 += 1;
            }
            while ((anzahlSteineSpieler1 != 9) && (anzahlSteineSpieler2 != 9)) ;
        }
    }
}

