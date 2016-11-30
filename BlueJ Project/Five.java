
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Five
{
    public static boolean isDivisible(int a, int b) {
        if(b == 1) return true;
        return a % b == 0 && isDivisible(a, b - 1);
    }
    
    public static void main(String[] args) {
        int[] primesLessThan20 = {2,3,5,7,11,13,17,19};
        int i = 1, q = 1;
        for(int j = 0; j < primesLessThan20.length; j++)
            q *= primesLessThan20[j];
        
        for(; true; i++)
            if(isDivisible(q * i, 20))
                break;
        
        System.out.println(isDivisible(q * i, 20));
        System.out.println(q * i);
    }
}