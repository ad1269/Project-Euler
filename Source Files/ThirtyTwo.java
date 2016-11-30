import java.util.*;

/**
 * Project Euler, question number ThirtyTwo
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyTwo
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

    public static int[] concat(int[] a, int[] b) {
        int aLen = a.length;
        int bLen = b.length;
        int[] c = new int[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

    //Checks if a * b = c is 1 to 9 pandigital
    public static boolean isPandigital(int a, int b, int c) {
        int[] ad = toDigits(a);
        int[] bd = toDigits(b);
        int[] cd = toDigits(c);

        //Concatenate and sort the three arrays
        int[] d = concat(concat(ad,bd), cd);
        Arrays.sort(d);

        //What a pandigital array should look like
        int[] pd = {1,2,3,4,5,6,7,8,9};

        //Compare to pandigital array
        if(Arrays.equals(d, pd))
            return true;

        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> pd = new ArrayList<Integer>();

        //Generate list of pandigital products
        for(int a = 1; a < 9876; a++) {
            for(int b = 1; b < 9876; b++) {
                int c = a * b;
                if(isPandigital(a, b, c))
                    pd.add(c);
            }
        }

        //Eliminate duplicates
        Set<Integer> hs = new HashSet<>();
        hs.addAll(pd);
        pd.clear();
        pd.addAll(hs);
        
        //Sum up the pandigital products
        int sum = 0;
        for(int p : pd)
            sum += p;
            
        System.out.println(sum);
    }
}