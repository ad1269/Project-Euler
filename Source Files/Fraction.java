import java.math.*;
/**
 * Write a description of class Fraction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fraction
{
    // instance variables - replace the example below with your own
    private BigInteger numerator;
    private BigInteger denominator;

    /**
     * Constructor for objects of class Fraction
     */
    public Fraction(BigInteger n, BigInteger d)
    {
        // initialise instance variables
        numerator = n;
        denominator = d;
    }

    public static Fraction fractionFromInt(BigInteger num) {
        return new Fraction(num, BigInteger.ONE);
    }

    private BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).divide(a.gcd(b));
    }

    public Fraction add(Fraction num) {
        BigInteger commonDen = lcm(this.denominator, num.denominator);
        BigInteger thisNum = this.numerator.multiply(commonDen.divide(this.denominator));
        BigInteger numNum = num.numerator.multiply(commonDen.divide(num.denominator));
        return new Fraction(thisNum.add(numNum), commonDen);
    }

    public Fraction add(BigInteger num) {
        return this.add(Fraction.fractionFromInt(num));
    }

    public Fraction divide(Fraction num) {
        return new Fraction(this.numerator.multiply(num.denominator), this.denominator.multiply(num.numerator));
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
    
    public String getNumerator() {
        return numerator + "";
    }
    
    public String getDenominator() {
        return denominator + "";
    }
}
