import java.util.*;
import java.math.*;

/**
 * Project Euler, question number Twenty
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Twenty
{
    public static void main(String[] args) {
        //Calculate 100!
        BigInteger a = new BigInteger("1");
        for(int i = 2; i <= 100; i++)
            a = a.multiply(new BigInteger(i + ""));
        
        //Convert the digits of 100! to an integer array
        String[] digitStr = a.toString().split("");
        int[] digits = new int[digitStr.length];
        int i = 0;
        for(String d : digitStr) {
            digits[i] = Integer.parseInt(d);
            i++;
        }
        
        //Find the sum of the digits
        int sum = 0;
        for(int d : digits)
            sum += d;
            
        System.out.println(sum);
    }
}