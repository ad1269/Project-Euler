import java.math.*;

/**
 * Write a description of class FiftySix here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftySix
{
    public static int getDigitalSum(BigInteger num) {
        int sum = 0;
        String[] digits = num.toString().split("");
        for(String digit : digits)
            sum += Integer.parseInt(digit);
        return sum;
    }
    
    public static void main(String[] args) {
        int maxDigitalSum = 0;
        for(int a = 1; a < 100; a++) {
            for(int b = 1; b < 100; b++) {
                BigInteger aPowerB = new BigInteger(a + "");
                aPowerB = aPowerB.pow(b);
                int digitalSum = getDigitalSum(aPowerB);
                if(digitalSum > maxDigitalSum)
                    maxDigitalSum = digitalSum;
            }
        }
        System.out.println(maxDigitalSum);
    }
}
