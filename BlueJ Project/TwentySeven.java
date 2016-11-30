
/**
 * Write a description of class TwentySeven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentySeven
{
    public static boolean isPrime(long n) {
        if(n < 0) 
            return false;
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int longestRun = 0;
        int maxA = 0, maxB = 0;
        for(int a = -999; a < 999; a++) {
            for(int b = -999; b < 999; b++) {
                boolean shouldContinue = true;
                int i;
                for(i = 0; shouldContinue; i++) {
                    int value = i * i + a * i + b;
                    shouldContinue = isPrime(value);
                }
                if(i > longestRun) {
                    longestRun = i;
                    maxA = a;
                    maxB = b;
                }
            }
        }
        System.out.println("a: " + maxA + " b: " + maxB);
        System.out.println("Product: " + maxA * maxB);
        System.out.println("Longest Run: " + longestRun);
    }
}
