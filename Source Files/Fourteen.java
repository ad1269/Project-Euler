
/**
 * Project Euler, question number Fourteen
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Fourteen
{
    public static long collatzCount(long n) {
        for(long i = 1; true; i++) {
            if(n == 1) return i;
            if(n % 2 == 0)
                n /= 2;
            else
                n = 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        long max = 0;
        for(long n = 1; n <= 1000000; n++) {
            long a = collatzCount(n);
            if(a > max) {
                max = a;
                System.out.println(n);
            }
        }
    }
}