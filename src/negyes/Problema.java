package negyes;

import java.util.ArrayList;
import java.util.List;

public class Problema {

    static List<Operator> OPERATOROK = new ArrayList<>();
    static {
        for (int i = 1; i < 8; i++)
            OPERATOROK.add(new Operator(i));
    }

    public List<Operator> operatorok() {
        return OPERATOROK;
    }
}
