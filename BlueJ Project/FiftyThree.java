
/**
 * Write a description of class FiftyThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyThree
{   
    public static double binCoefficient(int n, int r) {
        if(r == 0)
            return 1.0;
        return binCoefficient(n, r - 1) * (n - r + 1) / r;
    }
    
    public static void main(String[] args) {
        int count = 0;
        for(int n = 23; n <= 100; n++) {
            for(int r = 3; r <= n; r++) {
                double nCr = binCoefficient(n, r);
                if(nCr > 1000000)
                    count++;
            }
        }
        System.out.println(count);
    }
}
