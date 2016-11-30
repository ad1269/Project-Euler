
/**
 * Project Euler, question number FortyFour
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class FortyFour
{
    public static boolean isPentagonal(int n) {
        //Use quadratic formula to calculate n's position in the sequence
        double position = (1 + Math.sqrt(1 + 24 * n))/6;
        
        //Checks if the position is an integer
        if((position == Math.floor(position)) && !Double.isInfinite(position))
            return true;
            
        return false;
    }
    
    public static int pentagon(int n) {
        return n * (3 * n - 1) / 2;
    }
    
    public static void main(String[] args) {
        int minimumD = 10000000;
        for(int j = 1; j < 10000; j++) {
            for(int k = 1; k < 10000; k++) {
                int pj = pentagon(j);
                int pk = pentagon(k);
                int d = Math.abs(pj - pk);
                
                if(isPentagonal(d) && isPentagonal(pj + pk))
                    if(d < minimumD)
                        minimumD = d;
            }
        }
        System.out.println(minimumD);
    }
}