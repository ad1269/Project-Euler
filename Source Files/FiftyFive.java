import java.math.*;

/**
 * Write a description of class FiftyFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyFive
{
    public static boolean isPalindrome(BigInteger n) {
        String[] a = n.toString().split("");
        for(int i = 0; i < a.length/2; i++)
            if(!a[i].equals(a[a.length - i - 1]))
                return false;
        return true;
    }
    
    public static BigInteger reverse(BigInteger n) {
        String[] original = n.toString().split("");
        String[] reversed = new String[original.length];
        
        for(int i = 0; i < original.length; i++)
            reversed[i] = original[original.length - i - 1];
        
        String numString = "";
        for(String digit : reversed)
            numString += digit;
        
        return new BigInteger(numString);
    }
    
    public static boolean isLychrelNumber(BigInteger n) {
        for(int i = 0; i < 50; i++) {
            BigInteger sum = n.add(reverse(n));
            if(isPalindrome(sum))
                return false;
            else
                n = sum;
        }
        return true;
    }
    
    public static void main(String[] args) {
        int count = 0;
        for(int i = 1; i < 10000; i++)
            if(isLychrelNumber(new BigInteger(i + "")))
                count++;
        System.out.println(count);
    }
}