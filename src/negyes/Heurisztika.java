package negyes;

import java.util.Arrays;

public class Heurisztika {

    private static int ertek;

    /**
     *
     * @param allapot
     * @return egy jóságértéket
     */
    public static int h(Allapot allapot) {
        //System.out.println(lehetseges(allapot));
        return lehetseges(allapot);
    }

    /**
     * Értékeljük az aktuális lépésünk után, milyen jóságértékkel
     * @param resz azon 4 mező, amelyet vizsgálunk a táblán
     */

    //TODO mindig kettest ír be a heurisztika!!!
    private static void ertekeles(int[] resz) {
        if (Arrays.stream(resz).filter(value -> value == 2).count() == 4) {
            ertek += 100;
        }else if (Arrays.stream(resz).filter(value -> value == 2).count() == 3 &&
                Arrays.stream(resz).filter(value -> value == 0).count() == 1){
            ertek += 10;
        }else if (Arrays.stream(resz).filter(value -> value == 2).count() == 2 &&
                Arrays.stream(resz).filter(value -> value == 0).count() == 2) {
            ertek += 5;
        }

        if (Arrays.stream(resz).filter(value -> value == 1).count() == 3 &&
                Arrays.stream(resz).filter(value -> value == 0).count() == 1) {
            ertek -= 80;
        }
    }

    private static int lehetseges(Allapot allapot) {
        ertek = 0;

        int[] kozep = new int[7];
        for (int i = 0; i < 7; i++){
            kozep[i] = allapot.tabla[i][4];
        }
        ertek += Arrays.stream(kozep).filter(value -> value == 2).count() * 6;

        //Vízszintes
        for (int i = 1; i < 7; i++) {
            int[] sor = allapot.tabla[i];
            for (int j = 1; j < 5; j++) {
                int[] resz = new int[]{sor[j], sor[j + 1], sor[j + 2], sor[j + 3]};
                ertekeles(resz);
            }
        }

        //Függőleges
        for (int i = 1; i < 7; i++) {
            int[] oszlop = new int[7];
            System.arraycopy(allapot.tabla[i], 1, oszlop, 1, 6);
            for (int j = 1; j < 4; j++) {
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