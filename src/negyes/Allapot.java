package negyes;

public class Allapot {

    int[][] tabla;
    Jatekos jatekos;

    /**
     * Konstruktor, amellyel létrehozzuk magát a játéktáblát és
     * @param jatekos megadjuk, hogy melyik játékos van soron.
     */
    public Allapot(Jatekos jatekos) {
        this.tabla = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0}};
        this.jatekos = jatekos;
    }

    @Override
    public String toString() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 8; j++)
                System.out.print(this.tabla[i][j] + " ");
            System.out.println();
        }
        return "";
    }

    /**
     * Minden érvényes lépés után az ellenfél következik.
     */
    public void jatekosCsere(){
        if (this.jatekos == Jatekos.Gep)
            this.jatekos = Jatekos.Ember;
        else
            this.jatekos = Jatekos.Gep;
    }

    /**
     * Megvizsgáljuk minden lehetséges irányban, hogy az állapothoz tartozó játékos célállapotot ért-e el.
     * @return igaz-hamis érték, hogy cél-e az aktuális állapot
     */
    public boolean cel() {
        for (int i = 1; i < 7; i++)
            for (int j = 1; j < 8; j++) {
                int aktualis = this.tabla[i][j];
                if (aktualis == 0)
                    continue; //Üres mezőkkel nem foglalkozunk

                if (j + 3 < 8 &&
                        aktualis == this.tabla[i][j + 1] && //Sorban
                        aktualis == this.tabla[i][j + 2] &&
                        aktualis == this.tabla[i][j + 3])
                    return true;
                if (i + 3 < 7) {
                    if (aktualis == this.tabla[i + 1][j] && //Oszlopban
                        aktualis == this.tabla[i + 2][j] &&
                        aktualis == this.tabla[i + 3][j])
                        return true;
                    if (j + 3 < 8 &&
                            aktualis == this.tabla[i + 1][j + 1] && //Fel és jobbra
                            aktualis == this.tabla[i + 2][j + 2] &&
                            aktualis == this.tabla[i + 3][j + 3])
                        return true;
                    if (j - 3 >= 1 &&
                            aktualis == this.tabla[i + 1][j - 1] && //Fel és balra
                            aktualis == this.tabla[i + 2][j - 2] &&
                            aktualis == this.tabla[i + 3][j - 3])
                        return true;
                }
            }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        Allapot a = (Allapot) o;
        for (int i = 1; i < 7; i++)
            for (int j = 1; j < 8; j++)
                if (a.tabla[i][j] != this.tabla[i][j])
                    return false;
        return true;
    }
}

