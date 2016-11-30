import java.math.*;

/**
 * Write a description of class FiftySeven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftySeven
{
    public static Fraction squareRootConvergence(int iteration) {
        if(iteration == 0)
            return Fraction.fractionFromInt(BigInteger.ZERO);
        return Fraction.fractionFromInt(BigInteger.ONE).divide(squareRootConvergence(iteration - 1).add(new BigInteger("2")));
    }
    
    public static Fraction squareRootConvergence2(int iteration) {
        return squareRootConvergence(iteration).add(BigInteger.ONE);
    }
    
    public static void main(String[] args) {
        int count = 0;
        for(int i = 1; i <= 1000; i++) {
            Fraction expansion = squareRootConvergence2(i);
            if(expansion.getNumerator().length() > expansion.getDenominator().length())
                count++;
        }
        
        System.out.println(count);
    }
}
