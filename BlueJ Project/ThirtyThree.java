import java.util.ArrayList;
import java.util.Arrays;

/**
 * Project Euler, question number ThirtyThree
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyThree
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

    //Returns cancelled fraction in the form {numerator, denominator}
    public static int[] cancelDuplicates(int[] n, int[] d) {
        Arrays.sort(n);
        Arrays.sort(d);
        int[] a = {n[1], d[1]};
        int[] b = {n[0], d[0]};
        if(n[0] == d[0] && n[1] != d[1])
            return a;
        else if(n[1] == d[1] && n[0] != d[0])
            return b;
        int[] error = {-1, -1};
        return error;
    }

    public static boolean isDigitCancelling(int n, int d) {
        //Eliminate trivial cases
        if(n != d && n % 10 != 0 && d % 10 != 0 && n <= d) {
            //Split numerator and denominator into digits
            int[] nd = toDigits(n);
            int[] dd = toDigits(d);

            //Cancel duplicate digits
            int[] cancelledFraction = cancelDuplicates(nd, dd);
            int cancelledNumerator = cancelledFraction[0];
            int cancelledDenominator = cancelledFraction[1];

            //Check equality between cancelled fraction and noncancelled fraction
            if( (double) n / cancelledNumerator == (double) d / cancelledDenominator && cancelledNumerator != -1)
                return true;
        }
        return false;
    }

    /*public static void main(String[] args) {
    System.out.println(isDigitCancelling(35, 53));
    System.out.println(isDigitCancelling(49, 98));
    }*/

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        ArrayList<Integer> dens = new ArrayList<Integer>();

        //Iterate through all 2 digit numerator/denominator fractions
        for(int n = 11; n <= 99; n++) {
            for(int d = 11; d <= 99; d++) {
                //Check if it's digit-cancelling
                if(isDigitCancelling(n, d)) {
                    nums.add(n);
                    dens.add(d);
                }
            }
        }
        
        //Calculate the product of the fractions and print
        int tn = 1;
        int td = 1;
        for(int n : nums)
            tn *= n;
        for(int d : dens)
            td *= d;

        //Simplify tn/td
        System.out.println(td / tn);
    }
}