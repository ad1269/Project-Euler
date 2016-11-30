import java.util.*;
/**
 * Write a description of class FortySix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FortySix
{
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    //Checks if the number - 2 times x^2 is prime for every possible value of x
    public static boolean satisfiesConjecture(int n) {
        int val = n - 2;
        for(int i = 2; val > 1 ; i++) {
            if(isPrime(val))
                return true;
            val = n - 2 * i * i;
        }
        return false;
    }

    public static void main(String[] args) {
        int i = 9;
        for(; ;i += 2)
            if(!isPrime(i) && !satisfiesConjecture(i))
                break;

        System.out.println(i);
    }
}
