package negyes;

public class Operator {

    int oszlop;

    public Operator(int oszlop) {
        this.oszlop = oszlop;
    }

    /**
     * Akkor tudunk beejteni egy korongot az adott oszlopba, ha az még nincs tele,
     * vagyis a legfelső sorban nincs korong.
     * @param allapot amelyre szeretnénk vizsgálni az operátort.
     * @return Üres-e a felső sorban az adott oszlop.
     */
    public boolean alkalmazhato(Allapot allapot) {
        switch (this.oszlop) {
            case 1:
                return allapot.tabla[1][1] == 0;
            case 2:
                return allapot.tabla[1][2] == 0;
            case 3:
                return allapot.tabla[1][3] == 0;
            case 4:
                return allapot.tabla[1][4] == 0;
            case 5:
                return allapot.tabla[1][5] == 0;
            case 6:
                return allapot.tabla[1][6] == 0;
            case 7:
                return allapot.tabla[1][7] == 0;
            default:
                break;
        }
        return false;
    }

    /**
     * Alulról felfelé haladva megnézzük, hogy az oszlopban melyik az első szabad pozíció és oda helyezzük a korongot.
     * @param allapot Az aktuális állapot, amelyre szeretnénk alkalmazni az operátort.
     * @return Egy új állapot áll elő az operátor alkalmazása után.
     */
    public Allapot alkalmaz(Allapot allapot) {
        Allapot uj = new Allapot(allapot.jatekos);
        int[][] a = allapot.tabla;
        int[][] b = uj.tabla;

        for (int i  = 0; i < 7; i++)
            System.arraycopy(a[i], 0, b[i], 0, 8);

        for (int i = 6; i > 0; i--){
            if (b[i][this.oszlop] == 0)
                switch (allapot.jatekos) {
                    case Gep:
                        b[i][this.oszlop] = 2;
                        return uj;
                    case Ember:
                        b[i][this.oszlop] = 1;
                        return uj;
            }
        }
        return allapot;
    }


    @Override
    public String toString() {
        return "Operátor : " + oszlop;
    }
}
