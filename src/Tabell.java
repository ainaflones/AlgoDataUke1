import java.util.*;

public class Tabell {


    private Tabell(){}


    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }


    public static int min(int[] a, int fra, int til){

    fratilKontroll(a.length,fra,til);


    int m = fra;
    int minverdi = a[fra];

    for( int i=fra+1; i<til; i++){
        if( a[i] < minverdi){
            m = i;
            minverdi = a[m];
        }
    }

    return m;
    }
                     
    public static int min( int[] a){

        return min(a,0,a.length);

    }

    public static int maks(int[] a, int fra, int til) {


        if (a == null){
            throw new NoSuchElementException("tabellen er null");
        }                                                            


        fratilKontroll(a.length,fra,til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) {
            if (a[i] > maksverdi) {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

       return m;
    }

      public static int maks(int[] a)  // bruker hele tabellen

      {

        return maks(a,0,a.length);     // kaller metoden over

      }


        public static int[] nestMaks(int[] a) // ny versjon
        {
          int n = a.length;     // tabellens lengde
          if (n < 2) throw      // må ha minst to verdier
            new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

          int m = 0;      // m er posisjonen til største verdi
          int nm = 1;     // nm er posisjonen til nest største verdi



          // bytter om m og nm hvis a[1] er større enn a[0]
          if (a[1] > a[0]) {; m = 1; nm = 0; }

          int maksverdi = a[m];                // største verdi
          int nestmaksverdi = a[nm];           // nest største verdi

          for (int i = 2; i < n; i++){
            if (a[i] > nestmaksverdi){

              if (a[i] > maksverdi)
              {
                nm = m;
                nestmaksverdi = maksverdi;     // ny nest størst

                m = i;
                maksverdi = a[m];              // ny størst
              }
              else
              {
                nm = i;
                nestmaksverdi = a[nm];         // ny nest størst
              }
            }
          } // for
          return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

        } // nestMaks

      public static void sortering(int[] a ){

       for(int i = a.length; i>1; i--){

           int m = Tabell.maks(a,0,i);
           bytt(a,i-1,m);

        }
      }

      
                            
    
      public static void bytt(char[] c, int i , int j){

        int posI = i;

        c[i] = c[j];
        c[j] = c[posI];

      }

      public static void skriv(int[] a, int fra, int til){  //Skriver ut den valgte delen av tabellen


        fratilKontroll(a.length,fra,til);
        String tekst = "";
        for(int i = fra; i < til-1; i++ ){

           tekst += a[i] + " ";

        }

        System.out.print(tekst);

      }

      public static void skriv(int[] a){      //Skriver hele tabellen

      
        skriv(a,0,a.length);

      }


    public static void skrivlinjeskift(int[] a, int fra, int til){       //Skriver den valgte delen av tabellen

        fratilKontroll(a.length,fra,til);
        skriv(a,fra,til);
        System.out.println();

    }

    public static void skrivlinjeskift(int[] a){  //Skriver ut hele tabellen

        skrivlinjeskift(a,0,a.length);

    }

    public static void fratilKontroll(int tablelengde, int fra, int til){

        if(fra < 0)
            throw new ArrayIndexOutOfBoundsException("fra ("+fra+") er negativ!");

        if(til > tablelengde)
            throw new ArrayIndexOutOfBoundsException("til(" + til + ") > tablengde(" + tablelengde + ")");

        if(fra> til)
             throw new IllegalArgumentException ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if( fra==til){
            throw new NoSuchElementException("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
        }

    }

      public static void vhKontroll(int tablengde, int v, int h)   //Sjekker om et lukket tabellintervall er lovlig
      {
        if (v < 0)
          throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");
    
        if (h >= tablengde)
          throw new ArrayIndexOutOfBoundsException
            ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
          throw new IllegalArgumentException
            ("v = " + v + ", h = " + h);
      }


      public static int[] turTabell(int [] a){

        int n = a.length;

        if(n<2){
            throw new IllegalArgumentException("Tabellen er ikke lang nok");
        }

        int[] b = new int[2*n];

        System.arraycopy(a,0,b,n,n);

        for(int k = 2*n-2; k>1; k-=2){

            b[k/2] = Math.max(b[k], b[k+1]);

        }

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;


        for(int m = 2*n-1, k=2; k<m; k *=2){

            int tempverdi = b[k+1];

            if(maksverdi != b[k]){
                tempverdi = b[k];
                k++;
            }
            if(tempverdi > nestmaksverdi){
                nestmaksverdi = tempverdi;
            }
        }

        return new int[]{maksverdi,nestmaksverdi};
      }

      public static void kopier (int[] orgTab, int startOrg , int[] nyTab, int startNy, int ant){

        for(int k=startNy; k<ant+startNy; k++){

            nyTab[k] = orgTab[startOrg];
            startOrg++;

        }



      }


}
