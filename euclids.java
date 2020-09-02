import java.util.Random;

public class euclids {


    public euclids(){

    }

    /*
    Finds the GCD of m and n iteratively
    logn
     */
    private static int gcd(int m, int n) {
        int r = 0;
        while (n != 0) {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    /*
    Finds the GCD of m and n recursively
     */
    private static int recursively(int m, int n) {
        if (n == 0) {
            return m;
        }
        else {
            return gcd(n, m % n);    //gcd(m, n) = gcd(n, m mod n)
        }
    }

    /*
    Finds the GCD of m and n using the consecutive integer checking algorithm
     */
   private static int consecutive(int m, int n) {
       for (int t = Math.min(m, n); t > 0; t--) {
           if (m % t == 0 && n % t == 0) {
               return t;
           }
       }
       return 1;
   }


   /*
   Calculates the time it takes to perform a function
    */
   private static long timegcd (int m, int n) {
       long start = System.nanoTime();
       gcd(m, n);
       long end = System.nanoTime();

       return end - start;
   }

    private static long timeRecursively (int m, int n) {
        long start = System.nanoTime();
        recursively(m, n);
        long end = System.nanoTime();

        return end - start;
    }

    private static long timeConsecutive (int m, int n) {
        long start = System.nanoTime();
        consecutive(m, n);
        long end = System.nanoTime();

        return end - start;
    }



    public static void main(String[] args) {

        Random rand = new Random();

        System.out.println("GCD M N Iteratively Recursively Consecutive");

        int rangeMin = 100;
        int rangeMax = 200;
        int loops = 20;


        while (loops > 0) {
            int m = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
            int n = rand.nextInt((rangeMax - rangeMin) + 1) + rangeMin;
            System.out.println(gcd(m,n) + ", " + m + ", " + n + ", " + timegcd(m,n) + ","
                    + timeRecursively(m,n) + ", " + timeConsecutive(m,n));

            rangeMin *= 2;
            rangeMax *= 2;
            loops--;
        }



    }


}
