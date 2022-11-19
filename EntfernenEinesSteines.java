import java.util.Scanner;

public class EntfernenEinesSteines {

    public void wegnehmenStein(){

        System.out.println("Du hast eine Muehle. Welchen Stein des Gegners möchtest du wegnehmen?");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zeile: ");
        int zeile = scanner.nextInt();
        System.out.println("Spalte: ");
        int spalte = scanner.nextInt();
        if (array[zeile][spalte] == 3){
            array[zeile][spalte] = 1;
            System.out.println("Deine Eingabe war erfolgreich. Der Stein an der Stelle [" + zeile + "][" + spalte + "] wurde entfernt");
        } else if (array[zeile][spalte] != 3){
            System.out.println("Der ausgewaehlte Stein ist ungültig. Welchen Stein moechtest du stattdessen entfernen?");
            System.out.println("Zeile: ");
            int zeileNew = scanner.nextInt();
            System.out.println("Spalte: ");
            int spalteNew = scanner.nextInt();
            array[zeileNew][spalteNew] = 1;
            System.out.println("Deine Eingabe war erfolgreich. Der Stein an der Stelle [" + zeileNew + "][" + spalteNew + "] wurde entfernt.");
        }
    }
}

