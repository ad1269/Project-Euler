
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Four
{
    public static boolean isPalindrome(int n) {
        String[] a = ("" + n).split("");
        for(int i = 0; i < a.length/2; i++)
            if(!a[i].equals(a[a.length - i - 1]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[] palindromes = new int[1000000];
        int i, j, n = 0;
        for(i = 999; i >= 100; i--)
            for(j = 999; j >= 100; j--)
                if(isPalindrome(i * j))
                    palindromes[i * j] = i * j;
        
        for(int c = 999999; c >= 10000; c--) {
            if(palindromes[c] != 0) {
                n = palindromes[c];
                break;
            }
        }
        System.out.println(n);
    }
}