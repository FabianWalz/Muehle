import java.util.Scanner;

public class SpielerAnlegen extends Setzphase {

    int anzahlSteineSpieler1 = 0;
    int anzahlSteineSpieler2 = 0;

    public void anlegenSpieler1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler 1, gebe deinen Namen ein: ");
        String nameSpieler1 = scanner.next();
        System.out.println("Dein Name lautet: " + nameSpieler1);
    }

    public void anlegenSpieler2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spieler 2, gebe deinen Namen ein: ");
        String nameSpieler2 = scanner.next();
        System.out.println("Dein Name lautet: " + nameSpieler2);

    }

}
