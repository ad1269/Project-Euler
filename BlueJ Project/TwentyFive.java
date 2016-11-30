import java.math.BigInteger;
/**
 * Project Euler, question number TwentyFive
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class TwentyFive
{
    public static void main(String[] args) {
        BigInteger s = BigInteger.TEN.pow(999);
        System.out.println(fibonacci(s));
    }
    
    public static int fibonacci(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int i;
        for(i = 1; a.compareTo(n) == -1; i++) {
            BigInteger ob = b;
            b = b.add(a);
            a = ob;
        }
        return i;
    }
}