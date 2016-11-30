
/**
 * Project Euler, question number ThirtySeven
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtySeven
{
    public static boolean isPrime(long n) {
        if(n == 1)
            return false;
            
        for(int i = 2; i <= (int) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    
    public static boolean isTruncatablePrime(int n) {
        String str = n + "";
        int size = str.length();
        //Left to right truncation
        for(int i = 0; i < size; i++) {
            if(!isPrime(Integer.parseInt(str)))
                return false;
            str = str.substring(1);
        }
        
        str = n + "";
        //Right to left truncation
        for(int i = str.length(); i > 1; i--) {
            str = str.substring(0, str.length() - 1);
            if(!isPrime(Integer.parseInt(str)))
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        int count = 0, sum = 0;
        for(int i = 23; count < 11; i++) {
            if(isTruncatablePrime(i)) {
                sum += i;
                count++;
            }
        }
        System.out.println(sum);
    }
}