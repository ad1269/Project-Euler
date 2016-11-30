import java.util.*;
/**
 * Write a description of class FortyNine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FortyNine
{
    //Sieve of Eratosthenes that generates list of primes less than n
    public static int[] sieveOfEratosthenes(int n) {
        boolean[] numArr = new boolean[(int)n+1];
        ArrayList<Integer> primeArr = new ArrayList<Integer>();

        //Sieve
        for(int i = 2; i <= n; i++) {
            if(numArr[(int)i] == false)
                primeArr.add((int)i);

            for(int j = i*i; j <= n; j += i) {
                numArr[(int)j] = true;
            }
        }

        //Convert arraylist to array
        int[] primes = new int[primeArr.size()];
        int j = 0;
        for(int i : primeArr) {
            primes[(int)j] = i;
            j++;
        }
        return primes;
    }

    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static int[] toDigits(int i) {
        //Split i into its digits
        String iStr = i + "";
        char[] cArr = iStr.toCharArray();
        int[] digits = new int[cArr.length];
        int a = 0;
        for(char c : cArr) {
            digits[a] = Integer.parseInt(Character.toString(c));
            a++;
        }
        return digits;
    }

    public static boolean isPermutation(int a1, int a2, int a3) {
        int[] d1 = toDigits(a1);
        int[] d2 = toDigits(a2);
        int[] d3 = toDigits(a3);
        Arrays.sort(d1);
        Arrays.sort(d2);
        Arrays.sort(d3);
        
        if(Arrays.equals(d1, d2) && Arrays.equals(d2, d3))
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] primes = sieveOfEratosthenes(10000);

        for(int d = 1; d < 5000; d++) {
            for(int a2 : primes) {
                int a1 = a2 - d;
                int a3 = a2 + d;
                if(a1 > 1000 && a2 > 1000 && a3 > 1000) {
                    if(a1 < 10000 && a2 < 10000 && a3 < 10000) {
                        if(isPrime(a1) && isPrime(a2) && isPrime(a3)) {
                            if(isPermutation(a1, a2, a3)) {
                                System.out.println(a1 + "" + a2 + "" + a3);
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Done");
    }
}