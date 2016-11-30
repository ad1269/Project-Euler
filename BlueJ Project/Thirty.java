import java.util.*;

/**
 * Project Euler, question number Thirty
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Thirty
{
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for(int i = 10; i < 200000; i++) {
            int[] dig = toDigits(i);
            int sum = 0;
            for(int a : dig)
                sum += (int)Math.pow(a, 5);
            if(sum == i)
                nums.add(i);
        }
        
        int sum = 0;
        for(int a : nums)
            sum += a;
        System.out.println(nums);
        System.out.println(sum);
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
}