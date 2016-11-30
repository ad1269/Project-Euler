import java.math.*;
/**
 * Project Euler, question number Sixteen
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Sixteen
{
    public static void main(String[] args) {
        BigInteger n = new BigInteger("2");
        for(int e = 2; e <= 1000; e++)
            n = n.multiply(new BigInteger("2"));
        String[] ns = n.toString().split("");
        int sum = 0;
        for(String d : ns)
            sum += Integer.parseInt(d);
        System.out.println(sum);
    }
}