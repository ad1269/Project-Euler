import java.util.*;

/**
 * Project Euler, question number ThirtyEight
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyEight
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

    //Checks if ints in the array are pandigital 1 to 9
    public static boolean isPandigital(int[] products) {
        //Concat the numbers in products together
        String intStr = "";
        for(int i : products)
            intStr += i;
        
        //Convert to digit array
        int[] digits = toDigits(Integer.parseInt(intStr));
        Arrays.sort(digits);

        //What a pandigital array should look like
        int[] pd = {1,2,3,4,5,6,7,8,9};

        //Compare to pandigital array
        if(Arrays.equals(digits, pd))
            return true;

        return false;
    }
    
    //Returns true if the concatenation of all digits in products returns a valid integer
    public static boolean isValidInt(int[] products) {
        String intStr = "";
        for(int i : products)
            intStr += i;        
        if(intStr.length() > 9)
            return false;  
        return true;
    }
    
    public static void main(String[] args) {
        int max = 0;
        int MAX_N = 9, MAX_NUM = 10000;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 2; i < MAX_NUM; i++) {
            for(int n = 2; n < MAX_N + 1; n++) {
                //Multiply number by (1, 2,... n) and check if the products are pandigital
                int[] products = new int[n];
                for(int c = 0; c < n; c++)
                    products[c] = i * (c + 1); 
                if(!isValidInt(products))
                    break;
                if(isPandigital(products)) {
                    String a = "";
                    for(int p : products)
                        a += p;
                    nums.add(Integer.parseInt(a));
                }
            }
        }
        
        //Get maximum pandigital multiple
        int maxProduct = 0;
        for(int p : nums)
            if(maxProduct < p)
                maxProduct = p;
        
        System.out.println(maxProduct);
    }
}