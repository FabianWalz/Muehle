import java.util.Scanner;

public class Setzphase {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Name Spieler 1:");
        String spieler1 = scan.next();
        System.out.println("Name Spieler 1:");
        String spieler2 = scan.next();

        int anzahlSteineSpieler1 = 0;
        int anzahlSteineSpieler2 = 0;

        int array[][] = new int[7][7];

        do {
            System.out.println(spieler1 + ", du bist an der Reihe.");
            System.out.println("Setze deinen " + anzahlSteineSpieler1 + ". Stein");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Zeile:");
            int zeile1 = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte1 = scanner.nextInt();
            System.out.println("Gewaehlte Position:" + array[zeile1][spalte1]);
            if (array[zeile1][spalte1] == 1) {
                array[zeile1][spalte1] = 2;
                anzahlSteineSpieler1 += 1;
            } else if ((array[zeile1][spalte1] == 0) || (array[zeile1][spalte1] == 3)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                int zeile1New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte1New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position:" + array[zeile1New][spalte1New]);
                anzahlSteineSpieler1 += 1;
            }

            System.out.println(spieler2 + ", du bist an der Reihe.");
            System.out.println("Setze deinen " + anzahlSteineSpieler2 + ". Stein");
            System.out.println("Zeile:");
            int zeile2 = scanner.nextInt();
            System.out.println("Spalte:");
            int spalte2 = scanner.nextInt();
            System.out.println("Gewaehlte Position:" + array[zeile2][spalte2]);
            if (array[zeile2][spalte2] == 1) {
                array[zeile2][spalte2] = 3;
                anzahlSteineSpieler1 += 1;
            } else if ((array[zeile2][spalte2] == 0) || (array[zeile2][spalte2] == 2)) {
                System.out.println("Bitte ein freies Feld waehlen.");
                int zeile2New = scanner.nextInt();
                System.out.println("Spalte:");
                int spalte2New = scanner.nextInt();
                System.out.println("Neue gewaehlte Position:" + array[zeile2New][spalte2New]);
                anzahlSteineSpieler2 += 1;
            }
            scanner.close();
        } while ((anzahlSteineSpieler1 != 9) && (anzahlSteineSpieler2 != 9));
    }
}

