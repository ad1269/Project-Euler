
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ten
{
    public static boolean isPrime(long n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        long sum = 0;
        for(int i = 2; i < 2000000; i++)
            if(isPrime(i))
                sum += i;
        System.out.println(sum);
    }
}