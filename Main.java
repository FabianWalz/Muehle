public class Main {
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

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
