import java.util.*;

/**
 * Write a description of class Fifty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fifty
{
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    //Sieve of Eratosthenes that generates list of primes less than n
    public static long[] sieveOfEratosthenes(int n) {
        boolean[] numArr = new boolean[(int)n+1];
        ArrayList<Integer> primeArr = new ArrayList<Integer>();

        //Sieve
        for(long i = 2; i <= n; i++) {
            if(numArr[(int)i] == false)
                primeArr.add((int)i);

            for(long j = i*i; j <= n; j += i) {
                numArr[(int)j] = true;
            }
        }

        //Convert arraylist to array
        long[] primes = new long[primeArr.size()];
        long j = 0;
        for(long i : primeArr) {
            primes[(int)j] = i;
            j++;
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 1000000;
        long[] primes = sieveOfEratosthenes(n);
        int maxChain = 0;
        int maxConsecutivePrime = 0;
        for(int chain = 500; chain <= 600; chain++) {
            for(int startingPoint = 0; startingPoint <= primes.length - chain; startingPoint++) {
                int sum = 0;
                for(int i = startingPoint; i < chain + startingPoint && i < primes.length; i++) {
                    sum += primes[i];
                }
                if(isPrime(sum) && chain > maxChain && sum < 1000000) {
                    maxChain = chain;
                    maxConsecutivePrime = sum;
                }
            }
        }
        System.out.println(maxConsecutivePrime);
    }
}
