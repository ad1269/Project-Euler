
/**
 * Project Euler, question number ThirtySix
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtySix
{
    public static boolean isPalindromeBase10(int n) {
        String[] a = ("" + n).split("");
        for(int i = 0; i < a.length/2; i++)
            if(!a[i].equals(a[a.length - i - 1]))
                return false;
        return true;
    }
    
    public static String convertToBinary(int n) {
        if(n == 0)
            return "";
        return convertToBinary(n/2) + "" + (n % 2) + "";
    }
    
    public static boolean isPalindromeBase2(int n) {
        String binary = convertToBinary(n);
        String[] a = binary.split("");
        for(int i = 0; i < a.length/2; i++)
            if(!a[i].equals(a[a.length - i - 1]))
                return false;
        return true;
    }
    
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i < 1000000; i++) {
            if(isPalindromeBase10(i) && isPalindromeBase2(i))
                sum += i;
        }
        System.out.println(sum);
    }
}