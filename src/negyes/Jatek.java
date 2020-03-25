package negyes;

import java.util.Random;
import java.util.Scanner;

public class Jatek {

    /**
     * A program fő vezérlője, amely ellenőrzi, hogy célba értek e a játékosok, valamint cseréli köztük a fordulókat,
     * így felváltva játszanak egymás ellen.
     * @param args argumentumok
     */
    public static void main(String[] args) {

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

            Operator operator = null;

            do {
                switch (allapot.jatekos){
                    case Gep:
                        //operator = miniMax.lepes(kezdo, p, 3, heurisztika.h(kezdo));
                        operator = NegaMax.lepes(allapot, p, 3);
                        System.out.println(operator);
                        break;
                    case Ember:
                        System.out.println("A tábla jelenlegi állása:");
                        System.out.println(allapot);
                        System.out.print("Írjon be egy oszlop számot:");
                        operator = new Operator(Integer.parseInt(scanner.next()));
                        break;
                }
            }while (!operator.alkalmazhato(allapot));

            allapot = operator.alkalmaz(allapot);

            if (allapot.cel()){
                System.out.println(allapot.jatekos + " Nyert!");
                break;
            }

            allapot.jatekosCsere();
        }
    }
}
