package negyes;

public class MiniMax {

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

    private static int ertek(Problema p, Allapot allapot, int melyseg) {
        allapot.jatekosCsere();
        if (allapot.cel() || melyseg == 0) {
            return Heurisztika.h(allapot);
        }else if (allapot.jatekos == Jatekos.Gep){
            int max = Integer.MIN_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot)){
                    Allapot uj = o.alkalmaz(allapot);
                    int v = ertek(p, uj, melyseg - 1);
                    if (v > max)
                        max = v;
                }
            return max;
        }else{
            int min = Integer.MAX_VALUE;
            for (Operator o : p.operatorok())
                if (o.alkalmazhato(allapot)){
                    Allapot uj = o.alkalmaz(allapot);
                    int v = ertek(p, uj, melyseg - 1);
                    if (v < min)
                        min = v;
                }
            return min;
        }
    }
}
