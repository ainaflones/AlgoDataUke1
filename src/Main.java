import java.lang.System.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //int[] a = Tabell.randPerm(20);

        //Tabell.skriv(a,10,15);
        //Tabell.maks(a,0,111); //til er større enn a.length
        //Tabell.maks(a,-10,22); // fra er et negativt tall
        // Tabell.maks(a,10,10); //Tom tabell



    /* int m = b[0];
    int nm = b[1];

    Tabell.skrivlinjeskift(a);

    System.out.print("Størst(" + a[m] + ") har posisjon " + m);
    System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

    Tabell.sortering(a);

        b = Tabell.nestMaks(a);

        m = b[0];
        nm = b[1];

    Tabell.skrivlinjeskift(a);

    System.out.print("Størst(" + a[m] + ") har posisjon " + m);
    System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
*/

        int[] a = {1, 2, 7, 3};
        int[] b = new int [2*a.length];

        Tabell.skrivlinjeskift(b);
        Tabell.kopier(a,0,b,3,4);
        System.out.println("PRØVER METODEN");
        Tabell.skrivlinjeskift(b);



    }
}




