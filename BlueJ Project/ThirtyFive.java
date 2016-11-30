import java.util.*;

/**
 * Project Euler, question number ThirtyFive
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyFive
{
    public static boolean isPrime(long n) {
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static Integer[] toDigits(int i) {
        //Split i into its digits
        String iStr = i + "";
        char[] cArr = iStr.toCharArray();
        Integer[] digits = new Integer[cArr.length];
        int a = 0;
        for(char c : cArr) {
            digits[a] = Integer.parseInt(Character.toString(c));
            a++;
        }
        return digits;
    }

    public static int toInt(Integer[] digits) {
        String intString = "";
        for(int i : digits)
            intString += i;
        return Integer.parseInt(intString);
    }

    public static ArrayList<Integer[]> rotate(Integer[] array) {
        ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(array));
        ArrayList<Integer[]> rotations = new ArrayList<Integer[]>();
        for(int i = 0; i < array.length; i++) {
            rotations.add(temp.toArray(new Integer[1]));
            Integer a = temp.remove(0);
            temp.add(a);
        }
        return rotations;
    }

    public static boolean isCircularPrime(int n) {
        //Generate array of digits
        Integer[] digs = toDigits(n);

        //Rotate digs to find all circular primes
        ArrayList<Integer[]> permuted = rotate(digs);

        //Generate array of all circular primes from permuted array
        ArrayList<Integer> circularPrimes = new ArrayList<Integer>();
        for(Integer[] num : permuted)
            circularPrimes.add(toInt(num));

        //Iterate through array and check primality
        for(int cp : circularPrimes)
            if(!isPrime(cp))
                return false;
        return true;
    }

    public static void main(String[] args) {
        //Iterate through numbers less than 1 million and check if its a circular prime
        int count = 0;
        for(int i = 2; i < 1000000; i++)
            if(isCircularPrime(i))
                count++;       
        System.out.println(count);
    }
}