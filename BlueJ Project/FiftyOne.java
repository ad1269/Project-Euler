
/**
 * Write a description of class FiftyOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyOne
{
    public static boolean isPrime(int n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static int[] generateFamily(int n) {
        return null;
    }
    
    public static int getPrimeFamilyCount(int n) {
        int[] primeFamily = generateFamily(n);
        int count = 0;
        for(int num : primeFamily) 
            if(isPrime(num)) 
                count++;
        return count;
    }
    
    public static void main(String[] args) {
        boolean primeFound = false;
        int i = 56994;
        for(; !primeFound; i++) {
            int primeCount = getPrimeFamilyCount(i);
            if(primeCount == 8)
                primeFound = true;
        }
        System.out.println(i);
    }
}
