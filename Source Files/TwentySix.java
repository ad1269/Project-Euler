import java.util.ArrayList;
/**
 * Project Euler, question number TwentySix
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class TwentySix
{   
    public static int[] arrayFromList(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            array[i] = list.get(i);
        return array;
    }

    public static ArrayList<Integer> listFromArray(int[] array) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++)
            list.add(array[i]);
        return list;
    }

    public static boolean isPrime(int n) {
        if(n == 1) return false;
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static ArrayList<Integer> getPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        int copy = n;
        for(int i = 2; i <= copy; i++) {
            if(copy % i == 0) {
                factors.add(i);
                copy /= i;
                i--;
            }
        }
        return factors;
    }  

    public static int countRepeats(int num, ArrayList<Integer> list) {
        int count = 0;
        for(int n : list)
            if(n == num)
                count++;
        return count;
    }    

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

    public static int modulo(int a,int b,int c) {
        long x=1;
        long y=a;
        while(b > 0){
            if(b%2 == 1){
                x=(x*y)%c;
            }
            y = (y*y)%c; // squaring the base
            b /= 2;
        }
        return (int) x%c;
    }

    public static void main(String[] args) {
        int L = 1000;
        int[] primes = sieveOfEratosthenes(L);
        int answer = 0;
        for(int d : primes) {
            if(d != 2 && d != 5) {
                int period = 1;
                while(modulo(10, period, d) != 1)
                    period++;
                if(d - 1 == period)
                    answer = d;
            }
        }
        System.out.println(answer);
    }
}