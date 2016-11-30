import java.util.Arrays;

/**
 * Write a description of class FiftyTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyTwo
{
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
    
    public static boolean sameDigits(int a, int b) {
        int[] ad = toDigits(a);
        int[] bd = toDigits(b);
        Arrays.sort(ad);
        Arrays.sort(bd);
        
        if(Arrays.equals(ad, bd))
            return true;
        
        return false;
    }
    
    public static boolean checkX(int x) {
        for(int i = 2; i <= 6; i++)
            if(!sameDigits(x, i * x))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        boolean done = false;
        for(int x = 1; !done; x++) 
            if(checkX(x)) {
                done = true;
                System.out.println(x);
            }
    }
}
