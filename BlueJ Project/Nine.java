
/**
 * Write a description of class three here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nine
{
    public static boolean isTriple(int a, int b, int c) {
        return a*a + b*b == c*c;
    }
    
    public static void main(String[] args) {
        int a, b, c;
        boolean done = false;
        for(a = 1; a < 999 && !done; a++)
            for(b = 1; b < 999 && !done; b++)
                for(c = 1; c < 999 && !done; c++)
                    if(isTriple(a,b,c) && a + b + c == 1000) {
                        System.out.println(a * b * c);
                        done = true;
                    }
    }
}