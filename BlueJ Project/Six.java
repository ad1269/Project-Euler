
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Six
{
    public static long sumOfSquares(long n) {
        if(n == 1) return 1;
        return n * n + sumOfSquares(n - 1);
    }
    
    public static long squareOfSum(long n) {
        long sum = n * (n + 1) / 2;
        return sum * sum;
    }
    
    public static void main(String[] args) {
        System.out.println(squareOfSum(100) - sumOfSquares(100));
    }
}