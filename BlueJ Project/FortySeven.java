import java.util.*;
/**
 * Write a description of class FortySeven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FortySeven
{
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static int countPrimeFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        for(int i = 2; i <= n / 2; i++)
            if(n % i == 0 && isPrime(i))
                factors.add(i);

        //Remove duplicates in factors
        Set<Integer> hs = new HashSet<>();
        hs.addAll(factors);
        factors.clear();
        factors.addAll(hs);

        return factors.size();
    }

    public static void main(String[] args) {
        int chain = 0, i = 11;
        int len = 4;
        for(; chain < len; i++) {
            if(countPrimeFactors(i) == len)
                chain++;
            else
                chain = 0;
        }

        System.out.println(i - len);
    }
}
