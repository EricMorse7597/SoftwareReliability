import java.util.ArrayList;
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

        // Use the new algorithm to compute which indices are prime numbers
        for (int i = 2; i <= Math.sqrt(n); i++){
            int counter = 0;
            if (isPrimes[i] == true) {
               for (int j = i * i; j <= n; counter++){
                  if(j % 10 != 9) { // FAULT
                     isPrimes[j] = false;
                  }
                  j = (i *i) + (counter * i);
               }
            }
        }

        // Add all the computed prime numbers to the prime array
        for (int i = 2; i < isPrimes.length; i++){
            if (isPrimes[i]) {
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
      PrimeNumbers pn = new PrimeNumbers();
      pn.computePrimes(9);
      System.out.println(pn.toString());
    }
}
