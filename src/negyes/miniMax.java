package negyes;

public class miniMax {

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

    private static int ertek(Problema p, Allapot allapot, int melyseg, int hj) {
        if (allapot.cel() || melyseg == 0)
            return heurisztika.h(allapot);
        else if (allapot.jatekos == Jatekos.Gep){
            int max = Integer.MIN_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot)){
                    Allapot uj = o.alkalmaz(allapot);
                    int v = ertek(p, uj, melyseg - 1, hj);
                    if (v > max)
                        max = v;
                }
            return max;
        }else{
            int min = Integer.MAX_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot)){
                    Allapot uj = o.alkalmaz(allapot);
                    int v = ertek(p, uj, melyseg - 1, hj);
                    if (v < min)
                        min = v;
                }
            return min;
        }
    }



}
