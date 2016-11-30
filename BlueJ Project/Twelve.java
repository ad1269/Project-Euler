import java.util.*;
/**
 * Project Euler, question number Twelve
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Twelve
{
    //Slowest implementation
    public static long numOfFactors(long n) {
        long c = 0;
        for(long i = 1; i <= n; i++)
            if(n % i == 0)
                c++;
        return c;
    }

    //Much faster
    public static long numOfFactors2(long n) {
        long c = 0;
        for(long i = 1; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                c++;
        return 2 * c;
    }
    
    public static void main(String[] args) {
        //long[] primes = sieveOfEratosthenes(99999);
        long n = 0;
        long numDiv = 0;
        long max = numDiv;
        for(long s = 1; numDiv <= 500; s++) {
            //n is the sth triangular number
            n += s;
            numDiv = numOfFactors2(n);
            if(numDiv > max) {
                max = numDiv;
                System.out.println(max);
            }
        }
        System.out.println(n);
    }
}