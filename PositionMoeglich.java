import java.util.Scanner;

public class PositionMoeglich{
    public static void main(String[] args) {

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

        Scanner scan = new Scanner(System.in);
        System.out.println("Du bist an der Reihe. Ziehe einen Spielstein.");
        System.out.println("Zeile: ");
        int zeile = scan.nextInt();
        System.out.println("Spalte: ");
        int spalte = scan.nextInt();
        System.out.println("Die gewaehlte Position lautet: array["+ zeile + "][" + spalte + "]");

        if (array[zeile][spalte] == 1) {
            System.out.println("Die gewuenschte Position ist besetzbar.");
        }else{
            System.out.println("Error. Die Position existiert nicht. Zug ungültig");
        }
        scan.close();
    }
}

