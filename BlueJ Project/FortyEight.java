import java.util.*;
import java.math.BigInteger;
/**
 * Write a description of class FortySeven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FortyEight
{
    public static void main(String[] args) {
        BigInteger powers = new BigInteger("0");
        for(int i = 1; i <= 1000; i++) {
            BigInteger currentInt = new BigInteger(i + "");
            powers = powers.add(currentInt.pow(i));
        }
        System.out.println(powers.toString().substring(powers.toString().length() - 10));
    }
}
