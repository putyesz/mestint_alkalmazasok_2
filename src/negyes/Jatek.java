package negyes;

import java.util.Random;
import java.util.Scanner;

public class Jatek {

    public static void main(String[] args) {
//        Allapot allapot = new Allapot(Jatekos.Gep);
//        allapot.cel();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Problema p = new Problema();
        Allapot allapot;

        if (random.nextInt() % 2 == 0) {
            allapot = new Allapot(Jatekos.Ember);
            System.out.println("A játékot Ön kezdi.");
        } else {
            allapot = new Allapot(Jatekos.Gep);
            System.out.println("A játékot a számítógép kezdi.");
        }


        while(true){

            System.out.println("A tábla jelenlegi állása:");
            System.out.println(allapot);

            Operator operator = null;

            do {
                switch (allapot.jatekos){
                    case Gep:
                        //Operator o = miniMax.lepes(kezdo, p, 3, heurisztika.h(kezdo));
                        operator = negaMax.lepes(allapot, p, 3, heurisztika.h(allapot));
                        break;
                    case Ember:
                        System.out.print("Írjon be egy oszlop számot:");
                        operator = new Operator(Integer.parseInt(scanner.next()));
                        break;
                }
            }while (operator.alkalmazhato(allapot));

            allapot = operator.alkalmaz(allapot);

            if (allapot.cel()){
                break;
            }

            allapot.jatekosCsere();

        }
        System.out.println(allapot.jatekos + "Nyert!");
    }
}
