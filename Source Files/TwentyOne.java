import java.util.ArrayList;
/**
 * Write a description of class TwentyOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentyOne
{
    public static void main(String[] args) {
        ArrayList<Integer> amicableNums = new ArrayList<Integer>();
        for(int i = 1; i < 10000; i++)
            if(getSumOfDivisors(getSumOfDivisors(i)) == i && getSumOfDivisors(i) != i)
                amicableNums.add(i);

        int sum = 0;
        for(int a : amicableNums)
            sum += a;
        
        System.out.println(sum);
    }

    public static int getSumOfDivisors(int n) {
        int sum = 0;
        for(int i = 1; i < n; i++)
            if(n % i == 0)
                sum += i;
        return sum;
    }
}