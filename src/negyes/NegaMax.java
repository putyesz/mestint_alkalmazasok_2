package negyes;

public class NegaMax {

    /**
     * Mely lépést javasoljuk a gépnek, hogy megverje ellenfelét?
     * @param allapot A játék jelenlegi állapota.
     * @param p Az adott játék problémája (használható operátorok).
     * @param korlat Milyen mélységig építjük fel a fát.
     * @return A gép számára legmegfelelőbb operátor.
     */
    public static Operator lepes(Allapot allapot, Problema p, int korlat){
        int max = Integer.MIN_VALUE;
        Operator operator = p.operatorok().get(0);
        for (Operator o : p.operatorok())
            if (o.alkalmazhato(allapot)){
                Allapot uj = o.alkalmaz(allapot);
                int v = ertek(p, uj, korlat - 1);
                if (v > max){
                    max = v;
                    operator = o;
                }
            }
        return operator;
    }

    /**
     * Jóság értékek kiszámítása.
     * @param p Probléma.
     * @param allapot Az akkor használt állapot.
     * @param melyseg Milyen mélységben vagyunk most.
     * @return egy heurisztukus érték
     */
    private static int ertek(Problema p, Allapot allapot, int melyseg){
        if (allapot.cel() || melyseg == 0) {
            return Heurisztika.h(allapot);
        }else{
            int max = Integer.MIN_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot)){
                    Allapot uj = o.alkalmaz(allapot);
                    allapot.jatekosCsere();
                    int v = (ertek(p, uj, melyseg - 1)) * (-1);
                    if (v > max)
                        max = v;
                }
            return max;
        }
    }
}
