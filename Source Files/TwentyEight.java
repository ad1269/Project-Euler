
/**
 * Write a description of class TwentyEight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentyEight
{
    public static void main(String[] args) {
        System.out.println(numArrayDiagonalSum(1001));
    }
    
    public static int numArrayDiagonalSum(int n) {
        int sum = 1;
        for(int i = 3; i <= n; i+=2) {
            sum += i * i;
            sum += i * i - 4 * (i - 1)/2;
            sum += i * i - 2 * (i - 1)/2;
            sum += i * i - 6 * (i - 1)/2;
        }
        return sum;
    }
}
