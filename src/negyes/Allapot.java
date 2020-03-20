package negyes;

public class Allapot {

    int[][] tabla;
    Jatekos jatekos;

    public Allapot(Jatekos jatekos) {
        this.tabla = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};
        this.jatekos = jatekos;
    }

    @Override
    public String toString() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 8; j++) {
                System.out.print(this.tabla[i][j] + " ");
            }
            System.out.println();
        }
        return "";
    }

    public void jatekosCsere(){
        if (this.jatekos == Jatekos.Gep)
            this.jatekos = Jatekos.Ember;
        else
            this.jatekos = Jatekos.Gep;
    }

    public boolean cel() {
        System.out.println(this.tabla[3][4]);
        for (int i = 1; i < 7; i++)
            for (int j = 1; j < 8; j++) {
                int aktualis = this.tabla[i][j];
                if (aktualis == 0)
                    continue; // don't check empty slots

                if (j + 3 < 8 &&
                        aktualis == this.tabla[i][j + 1] && // look right
                        aktualis == this.tabla[i][j + 2] &&
                        aktualis == this.tabla[i][j + 3])
                    return true;
                if (i + 3 < 7) {
                    if (aktualis == this.tabla[i + 1][j] && // look down
                        aktualis == this.tabla[i + 2][j] &&
                        aktualis == this.tabla[i + 3][j])
                        return true;
                    if (j + 3 < 8 &&
                            aktualis == this.tabla[i + 1][j + 1] && // look up & right
                            aktualis == this.tabla[i + 2][j + 2] &&
                            aktualis == this.tabla[i + 3][j + 3])
                        return true;
                    if (j - 3 >= 1 &&
                            aktualis == this.tabla[i + 1][j - 1] && // look up & left
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
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 8; j++) {
                if (a.tabla[i][j] != this.tabla[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

