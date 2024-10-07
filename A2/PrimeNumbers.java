import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class PrimeNumbers {
    private List<Integer> primes = new ArrayList<Integer>();

    public void computePrimes(int n) {
        Boolean isPrimes[];
        isPrimes = new Boolean[n +1];
        for (int i = 0; i < isPrimes.length; i++){
            isPrimes[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++){
            int counter = 0;
            if (isPrimes[i] == true) {
               for (int j = i * i; j <= n; counter++){
                  System.out.println("j = " + j);
                  isPrimes[j] = false;
                  j = (i *i) + (counter * i);
               }
            }
        }

        for (int i = 2; i < isPrimes.length; i++){
            if (isPrimes[i] == true) {
                primes.add(i);
            }
        }
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "PrimeNumbers{" +
                "primes=" + primes +
                '}';
    }

    public static void main(String[] args) {
      System.out.println("Hello world");
        PrimeNumbers pn = new PrimeNumbers();
        pn.computePrimes(59);
        System.out.println(pn.toString());
    }
}
