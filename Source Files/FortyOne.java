import java.util.Arrays;

/**
 * Project Euler, question number FortyOne
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class FortyOne
{
    public static boolean isPrime(long n) {
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
    
    public static boolean isPandigital(int num) {
        int[] digits = toDigits(num);
        Arrays.sort(digits);
        
        int n = digits.length;
        
        //What a pandigital array should look like
        int[] pd = new int[n];
        for(int i = 1; i <= n; i++)
            pd[i - 1] = i;

        //Compare to pandigital array
        if(Arrays.equals(digits, pd))
            return true;

        return false;
    }
    
    public static void main(String[] args) {
        int maxPandigitalPrime = 0;
        
        for(int i = 10; i < 9999999; i++)
            if(isPandigital(i) && isPrime(i))
                maxPandigitalPrime = i;
        System.out.println(maxPandigitalPrime);
    }
}