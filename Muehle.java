import java.util.Scanner;

public class Muehle {   //Anweisungsblock muss noch geändert werden...

    int[][] array = new int[7][7];  // nur damit funktioniert

    public void wegnehmenStein() {
        // EntfernenEinesSteines
    }

    public void abfrageMuehleSpieler1() {


        if (array[0][0] == 2 && array[0][3] == 2 && array[0][6] == 2) {
            wegnehmenStein();
        } else if (array[0][0] == 2 && array[3][0] == 2 && array[6][0] == 2) {
            wegnehmenStein();
        } else if (array[0][6] == 2 && array[3][6] == 2 && array[6][6] == 2) {
            wegnehmenStein();
        } else if (array[6][0] == 2 && array[6][3] == 2 && array[6][6] == 2) {
            wegnehmenStein();
        } else if (array[1][1] == 2 && array[1][3] == 2 && array[1][5] == 2) {
            wegnehmenStein();
        } else if (array[1][1] == 2 && array[3][1] == 2 && array[5][1] == 2) {
            wegnehmenStein();
        } else if (array[1][5] == 2 && array[3][5] == 2 && array[5][5] == 2) {
            wegnehmenStein();
        } else if (array[5][1] == 2 && array[5][3] == 2 && array[5][5] == 2) {
            wegnehmenStein();
        } else if (array[2][2] == 2 && array[2][3] == 2 && array[2][4] == 2) {
            wegnehmenStein();
        } else if (array[2][2] == 2 && array[3][2] == 2 && array[4][2] == 2) {
            wegnehmenStein();
        } else if (array[2][4] == 2 && array[3][4] == 2 && array[4][4] == 2) {
            wegnehmenStein();
        } else if (array[4][2] == 2 && array[4][3] == 2 && array[4][4] == 2) {
            wegnehmenStein();
        } else if (array[0][3] == 2 && array[1][3] == 2 && array[2][3] == 2) {
            wegnehmenStein();
        } else if (array[3][0] == 2 && array[3][1] == 2 && array[3][2] == 2) {
            wegnehmenStein();
        } else if (array[3][4] == 2 && array[3][5] == 2 && array[3][6] == 2) {
            wegnehmenStein();
        } else if (array[4][3] == 2 && array[5][3] == 2 && array[6][3] == 2) {
            wegnehmenStein();
        }
    }

    public void abfrageMuehleSpieler2() {

        if (array[0][0] == 3 && array[0][3] == 3 && array[0][6] == 3) {
            wegnehmenStein();
        } else if (array[0][0] == 3 && array[3][0] == 3 && array[6][0] == 3) {
            wegnehmenStein();
        } else if (array[0][6] == 3 && array[3][6] == 3 && array[6][6] == 3) {
            wegnehmenStein();
        } else if (array[6][0] == 3 && array[6][3] == 3 && array[6][6] == 3) {
            wegnehmenStein();
        } else if (array[1][1] == 3 && array[1][3] == 3 && array[1][5] == 3) {
            wegnehmenStein();
        } else if (array[1][1] == 3 && array[3][1] == 3 && array[5][1] == 3) {
            wegnehmenStein();
        } else if (array[1][5] == 3 && array[3][5] == 3 && array[5][5] == 3) {
            wegnehmenStein();
        } else if (array[5][1] == 3 && array[5][3] == 3 && array[5][5] == 3) {
            wegnehmenStein();
        } else if (array[2][2] == 3 && array[2][3] == 3 && array[2][4] == 3) {
            wegnehmenStein();
        } else if (array[2][2] == 3 && array[3][2] == 3 && array[4][2] == 3) {
            wegnehmenStein();
        } else if (array[2][4] == 3 && array[3][4] == 3 && array[4][4] == 3) {
            wegnehmenStein();
        } else if (array[4][2] == 3 && array[4][3] == 3 && array[4][4] == 3) {
            wegnehmenStein();
        } else if (array[0][3] == 3 && array[1][3] == 3 && array[2][3] == 3) {
            wegnehmenStein();
        } else if (array[3][0] == 3 && array[3][1] == 3 && array[3][2] == 3) {
            wegnehmenStein();
        } else if (array[3][4] == 3 && array[3][5] == 3 && array[3][6] == 3) {
            wegnehmenStein();
        } else if (array[4][3] == 3 && array[5][3] == 3 && array[6][3] == 3) {
            wegnehmenStein();
        }
    }
}
