import java.lang.StringBuilder;
/**
 * Project Euler, question number FortyThree
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class FortyThree
{
    public static int factorial(int n) {
        if(n <= 1) 
            return 1;
        return n * factorial(n - 1);
    }

    public static int[] toDigits(long i) {
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
    
    //Recursively generates all possible permutations of the characters in the String str
    public static String[] permute(String str) {
        String[] permutations = new String[factorial(str.length())];
        if(str.length() == 1)
            permutations[0] = str;
        else {
            String[] breakStr = str.split("");
            String[] recursivePermute = permute(str.substring(0, str.length() - 1));
            String broken = breakStr[breakStr.length - 1];
            
            for(int a = 0, b = 0; b < recursivePermute.length; b++) {
                String currentPerm = recursivePermute[b];
                for(int c = 0; c <= currentPerm.length(); c++) {
                    String newPerm = currentPerm;
                    newPerm = new StringBuilder(newPerm).insert(c, broken).toString();

                    permutations[a] = newPerm;
                    a++;
                }
            }
        }

        return permutations;
    }

    public static int getSubstringInt(long n, int start, int end) {
        int[] digits = toDigits(n);
        String sub = "";
        for(int i = start; i <= end; i++)
            sub += digits[i - 1];
        
        return Integer.parseInt(sub);
    }
    
    public static int getPrimeForIndex(int i) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17};
        return primes[i - 2];
    }
    
    public static boolean satisfiesDivisibility(long n) {
        for(int i = 2; i <= 8; i++) {
            int num = getSubstringInt(n, i, i + 2);
            int divisor = getPrimeForIndex(i);
            if(num % divisor != 0)
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        //Generate all possible 0 to 9 pandigital numbers
        String[] allDigitPandigitalStrings = permute("1234567890");
        long[] allDigitPandigitals = new long[allDigitPandigitalStrings.length];
        for(int i = 0; i < allDigitPandigitalStrings.length; i++)
            allDigitPandigitals[i] = Long.parseLong(allDigitPandigitalStrings[i]);
        
        long sum = 0;
        for(long n : allDigitPandigitals)
            if(n > 999999999 && satisfiesDivisibility(n))
                sum += n;
        
        System.out.println(sum);
    }
}