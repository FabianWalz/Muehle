public class Muehle {
    public void abfrageMuehleSpieler1(){

        if (array[0][0] == 2 && array[0][3] == 2 && array[0][6] == 2) {
            System.out.println("Muehle");
        } else if (array[0][0] == 2 && array[3][0] == 2 && array[6][0] == 2) {
            System.out.println("Muehle");
        } else if (array[0][6] == 2 && array[3][6] == 2 && array[6][6] == 2) {
            System.out.println("Muehle");
        } else if (array[6][0] == 2 && array[6][3] == 2 && array[6][6] == 2) {
            System.out.println("Muehle");
        } else if (array[1][1] == 2 && array[1][3] == 2 && array[1][5] == 2) {
            System.out.println("Muehle");
        } else if (array[1][1] == 2 && array[3][1] == 2 && array[5][1] == 2) {
            System.out.println("Muehle");
        } else if (array[1][5] == 2 && array[3][5] == 2 && array[5][5] == 2) {
            System.out.println("Muehle");
        } else if (array[5][1] == 2 && array[5][3] == 2 && array[5][5] == 2) {
            System.out.println("Muehle");
        } else if (array[2][2] == 2 && array[2][3] == 2 && array[2][4] == 2) {
            System.out.println("Muehle");
        } else if (array[2][2] == 2 && array[3][2] == 2 && array[4][2] == 2) {
            System.out.println("Muehle");
        } else if (array[2][4] == 2 && array[3][4] == 2 && array[4][4] == 2) {
            System.out.println("Muehle");
        } else if (array[4][2] == 2 && array[4][3] == 2 && array[4][4] == 2) {
            System.out.println("Muehle");
        } else if (array[0][3] == 2 && array[1][3] == 2 && array[2][3] == 2) {
            System.out.println("Muehle");
        } else if (array[3][0] == 2 && array[3][1] == 2 && array[3][2] == 2) {
            System.out.println("Muehle");
        } else if (array[3][4] == 2 && array[3][5] == 2 && array[3][6] == 2) {
            System.out.println("Muehle");
        } else if (array[4][3] == 2 && array[5][3] == 2 && array[6][3] == 2) {
            System.out.println("Muehle");
        }
    }
}