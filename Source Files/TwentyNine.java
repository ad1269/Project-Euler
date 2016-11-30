import java.util.*;

/**
 * Project Euler, question number TwentyNine
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class TwentyNine
{
    public static void main(String[] args) {
        double[] powArr = new double[99 * 99];
        int i = 0;
        for(int a = 2; a <= 100; a++) {
            for(int b = 2; b <= 100; b++) {
                powArr[i] = Math.pow(a, b);
                i++;
            }
        }
        
        ArrayList<Double> al = new ArrayList<Double>();
        for(double p : powArr)
            if(!contains(al, p))
                al.add(p);           
        
        System.out.println(al.size());
    }
    
    public static boolean contains(ArrayList<Double> al, double n) {
        for(double a : al)
            if(a == n)
                return true;
        return false;
    }
}