
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Three
{
    public static boolean isPrime(long n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        long n = Long.parseLong("600851475143");
        while(true) {
            long i;
            for(i = 2; i < n/2; i++)
                if(n % i == 0)
                    break;
            n /= i;
            if(isPrime(n))
                break;
        }
        System.out.println(n);
    }
}
