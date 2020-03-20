package negyes;

public class heurisztika {

    public static int h(Allapot allapot) {
        return lehetseges(allapot, Jatekos.Gep) - lehetseges(allapot, Jatekos.Ember);
    }

    private static int lehetseges(Allapot allapot, Jatekos jatekos) {
        int ertek = 0;
        //TODO
        // Meg kellene vizsgálni, hogy az újonnan létrejött állapotban közelebb vagy távolabb kerülönk a célhoz.
        // Természetesen mindezt a gép szempontjából.

        for (int k = 4; k > 1; k--) {
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 8; j++) {
                    int mezo = allapot.tabla[i][j];
                    if (mezo == 0) {
                        continue;
                    } else {
                        switch (jatekos) {
                            case Gep:
                                
                                break;
                            case Ember:

                                break;
                        }
                    }
                }
            }
        }
        return ertek;
    }
}
