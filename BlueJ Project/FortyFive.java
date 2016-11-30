
/**
 * Write a description of class FortyFive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FortyFive
{
    public static boolean isPentagonalNumber(long n) {
        //Use quadratic formula to calculate n's position in the sequence
        double position = (1 + Math.sqrt(1 + 24 * n))/6;
        
        //Checks if the position is an integer
        if((position == Math.floor(position)) && !Double.isInfinite(position))
            return true;
            
        return false;
    }
    
    public static boolean isHexagonalNumber(long n) {
        //Use quadratic formula to calculate n's position in the sequence
        double position = (1 + Math.sqrt(1 + 8 * n))/4;
        
        //Checks if the position is an integer
        if((position == Math.floor(position)) && !Double.isInfinite(position))
            return true;
            
        return false;
    }
    
    public static long triangle(long n) {
        return n * (n + 1) / 2;
    }
    
    public static void main(String[] args) {
        long triangle;
        for(long i = 40756; ;i++) {
            triangle = triangle(i);
            if(isHexagonalNumber(triangle) && isPentagonalNumber(triangle))
                break;
        }
        System.out.println(triangle);
    }
}
