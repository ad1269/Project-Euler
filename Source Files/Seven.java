
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seven
{
    public static boolean isPrime(long n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        int i = 2;
        int c = 0;
        while(true) {
            if(isPrime(i)) {
                c++;
                if(c == 10001) {
                    System.out.println(i);
                    break;
                }
            }
            i++;
        }
    }
}