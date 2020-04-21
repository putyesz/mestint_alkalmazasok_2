package negyes;

import java.util.Arrays;

public class Heurisztika {

    private static int ertek;

    public static int h(Allapot allapot) {
        return lehetseges(allapot);
    }

    /**
     * Megszámolja, az adott tömbben egy elem, hányszor fordul elő.
     * @param arr tömb
     * @param number szám
     * @return egész szám (1-4)
     */
    private static int szamolo(int[] arr, int number){
        return (int) Arrays.stream(arr).filter(value -> value == number).count();
    }

    /**
     * Értékeljük az aktuális lépésünk után, milyen jóságértékkel
     * @param resz azon 4 mező, amelyet vizsgálunk a táblán
     */
    private static void ertekeles(int[] resz) {
        int nulla = szamolo(resz, 0);
        int ketto = szamolo(resz, 2);

        if (ketto == 4) {
            ertek += 100;
        }else if (ketto == 3 && nulla == 1){
            ertek += 10;
        }else if (ketto == 2 && nulla == 2) {
            ertek += 5;
        }

        if (szamolo(resz, 1) == 3 && nulla == 1) {
            ertek -= 120;
        }
    }

    private static int lehetseges(Allapot allapot) {
        ertek = 0;

        int[] kozep = new int[7];
        for (int i = 0; i < 7; i++){
            kozep[i] = allapot.tabla[i][4];
        }
        ertek += szamolo(kozep, 2) * 6;

        //Vízszintes
        for (int i = 1; i < 7; i++) {
            int[] sor = allapot.tabla[i];
            for (int j = 1; j < 5; j++) {
                int[] resz = new int[]{sor[j], sor[j + 1], sor[j + 2], sor[j + 3]};
                ertekeles(resz);
            }
        }

        //Függőleges
        for (int i = 1; i < 8; i++) {
            int[] oszlop = new int[7];
            for (int ii = 1; ii < 7; ii++){
                oszlop[ii] = allapot.tabla[ii][i];
            }
            for (int j = 1; j < 4; j++){
                int[] resz = new int[]{oszlop[j], oszlop[j + 1], oszlop[j + 2], oszlop[j + 3]};
                ertekeles(resz);
            }

        }

        //Átló jobbra fel
        for (int i = 1; i < 4; i++)
            for (int j = 1; j < 5; j++) {
                int[] resz = new int[]{allapot.tabla[i][j],
                                        allapot.tabla[i + 1][j + 1],
                                        allapot.tabla[i + 2][j + 2],
                                        allapot.tabla[i + 3][j + 3]};
                ertekeles(resz);
            }

        //Átló balra le
        for (int i = 1; i < 4; i++)
            for (int j = 1; j < 5; j++) {
                int[] resz = new int[]{allapot.tabla[i + 3][j],
                                        allapot.tabla[i + 2][j + 1],
                                        allapot.tabla[i + 1][j + 2],
                                        allapot.tabla[i][j + 3]};
                ertekeles(resz);
            }
        return ertek;
    }
}