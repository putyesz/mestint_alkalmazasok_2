package negyes;

public class negaMax {

    public static Operator lepes(Allapot allapot, Problema p, int korlat, int h){
        int max = Integer.MIN_VALUE;
        Operator operator = p.operatorok().get(0);
        for (Operator o : p.operatorok())
            if (o.alkalmazhato(allapot)){
                Allapot uj = o.alkalmaz(allapot);
                int v = ertek(p, uj, korlat - 1, h);
                if (v > max){
                    max = v;
                    operator = o;
                }
            }
        return operator;
    }

    private static int ertek(Problema p, Allapot allapot, int melyseg, int hj){
        if (allapot.cel() || melyseg == 0)
            return heurisztika.h(allapot);
        else{
            int max = Integer.MIN_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot)){
                    Allapot uj = o.alkalmaz(allapot);
                    int v = (ertek(p, uj, melyseg - 1, hj)) * (-1);
                    if (v > max)
                        max = v;
                }
            return max;
        }
    }

}
