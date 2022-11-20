import java.util.Scanner;

public class EntfernenEinesSteines {

    int[][] array = new int[7][7];  // nur damit funktioniert
    public void wegnehmenStein(){

        System.out.println("Du hast eine Muehle. Welchen Stein des Gegners möchtest du wegnehmen?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zeile: ");
        int zeile = scanner.nextInt();
        System.out.println("Spalte: ");
        int spalte = scanner.nextInt();
        if (array[zeile][spalte] == 3){ //FUNKTIONIERT ERSTMAL NUR WENN SPIELER1 EINEN STEIN VON SPIELER2 WEGNIMMT?
            array[zeile][spalte] = 1;
            System.out.println("Deine Eingabe war erfolgreich. Der Stein an der Stelle [" + zeile + "][" + spalte + "] wurde entfernt");
            //ANZAHL DER STEINE VON SPIELER2 VERRINGERN, WEIL MAN JA AB 3 STEINEN SPRINGEN KANN?
        } else if (array[zeile][spalte] != 3){
            System.out.println("Der ausgewaehlte Stein ist ungültig. Welchen Stein möchtest du stattdessen entfernen?");
            System.out.println("Zeile: ");
            int zeileNew = scanner.nextInt();
            System.out.println("Spalte: ");
            int spalteNew = scanner.nextInt();
            array[zeileNew][spalteNew] = 1;
            System.out.println("Deine Eingabe war erfolgreich. Der Stein an der Stelle [" + zeileNew + "][" + spalteNew + "] wurde entfernt.");
            //ANZAHL DER STEINE VON SPIELER2 VERRINGERN, WEIL MAN JA AB 3 STEINEN SPRINGEN KANN?
        }
    }
}

