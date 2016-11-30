import java.util.ArrayList;

/**
 * Project Euler, question number ThirtyFour
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyFour
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
    
    public static int factorial(int n) {
        if(n == 0)
            return 1;
        return n * factorial(n - 1);
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> digitFactorials = new ArrayList<Integer>();
        
        //Iterate through all numbers less than 9999999 and check for digit factorial numbers
        for(int i = 11; i < 9999999; i++) {
            int[] digits = toDigits(i);
            int sum = 0;
            for(int d : digits) {
                sum += factorial(d);
            }
            if(sum == i)
                digitFactorials.add(i);
        }
        
        //Sum the digit factorial numbers
        int sum = 0;
        for(int n : digitFactorials)
            sum += n;
            
        System.out.println(digitFactorials);
        System.out.println(sum);
    }
}