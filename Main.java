import java.util.Scanner;

public class Main extends SpielerAnlegen {
    public static void main(String[] args) {

        SpielerAnlegen nameSpieler1 = new SpielerAnlegen();
        nameSpieler1.anlegenSpieler1();
        SpielerAnlegen nameSpieler2 = new SpielerAnlegen();
        nameSpieler2.anlegenSpieler2();

        nameSpieler1.setzphaseSpieler1();
        nameSpieler2.setzphaseSpieler2();


    }
}
