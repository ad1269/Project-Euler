import java.util.ArrayList;
/**
 * Write a description of class TwentyThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentyThree
{
    public static void main(String[] args) {
        ArrayList<Integer> abundantNums = new ArrayList<Integer>();
        for(int i = 1; i <= 28123; i++)
            if(getSumOfDivisors(i) > i)
                abundantNums.add(i);

        int sum = 0;
        for(int i = 1; i <= 28123; i++)
            if(!isSumOfTwoAbundants(i, abundantNums))
                sum += i;
        
        System.out.println(sum);
    }

    public static int getSumOfDivisors(int n) {
        int sum = 0;
        for(int i = 1; i < n; i++)
            if(n % i == 0)
                sum += i;
        return sum;
    }

    public static boolean isSumOfTwoAbundants(int n, ArrayList<Integer> ls) {
        for(int a : ls)
            for(int b : ls)
                if(a + b == n)
                    return true;
        return false;
    }
}
