import java.util.Scanner;

public class Setzphase {
    public static void main(String[] args) {

        int anzahlSteineSpieler1 = 9;
        int anzahlSteineSpieler2 = 9;
        String spieler1;
        String spieler2;
        int array[][] = new int[7][7];

        System.out.println("Setze den " + anzahlSteine + ". Stein");
        Scanner scan = new Scanner(System.in);
        System.out.println("Zeile:");
        int zeile = scanner.nextInt();
        System.out.println("Spalte:");
        int spalte = scanner.nextInt();

       anzahlSteineSpieler1 -= 1;
       anzahlSteineSpieler2 -= 1;


        if ((anzahlSteineSpieler1 == 0) && (anzahlSteineSpieler2 == 0)) {
            System.out.println("Die Setzphase ist beendet. Nun beginnt die Zugphase.");
        }


    }
}

