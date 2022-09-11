package kartyajatek;

import java.util.*;

public class Kartyajatek {

    public static String[] pakli = new String[21];
    public static String[] szinek = {"P", "T", "Z", "M"};
    public static String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
    public static int ValasztottSzam;

    public static void main(String[] args) {
        kartyaFeltolt();
        for (int i = 0; i < 3; i++) {
            kirak();
            valaszt();
            keveres();
        }

        ezVolt();
    }

    public static void kartyaFeltolt() {

        for (int i = 0; i < 6; i++) {
            pakli[i] = szinek[0] + ertekek[i];
        }
        for (int i = 0; i < 6; i++) {
            pakli[i + 6] = szinek[1] + ertekek[i];
        }
        for (int i = 0; i < 6; i++) {
            pakli[i + 12] = szinek[2] + ertekek[i];
        }
        for (int i = 0; i < 3; i++) {
            pakli[i + 18] = szinek[3] + ertekek[i];
        }
    }

    public static void kirak() {
        for (int i = 0; i < pakli.length; i++) {
            System.out.printf(pakli[i] + " ");
            if (i == 6) {
                System.out.println();
            } else if (i == 13) {
                System.out.println();
            }
        }
    }

    public static void valaszt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nMelyik sorban van a választott kártyád? (1, 2 vagy 3): ");
        ValasztottSzam = sc.nextInt();
        while(ValasztottSzam > 3 || ValasztottSzam < 1){
            System.out.println("Rossz szám, újra:");
                ValasztottSzam = sc.nextInt();
        }
    }

    public static void keveres(){
         List<String> list = Arrays.asList(pakli);
        if (ValasztottSzam == 1) {
            Collections.rotate(list, 7);
            //pakli[0-6] bekerül középre
        } else if (ValasztottSzam == 2) {
            //pakli[7-13] marad középen
        } else if (ValasztottSzam == 3) {
            Collections.rotate(list, -7);
            //pakli[14-20] kerül középre
        }
    }

    public static void ezVolt() {
        System.out.printf("%s : Ez volt a kártyád?\n", pakli[10]);
    }
}
