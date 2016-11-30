import java.util.*;

/**
 * Project Euler, question number ThirtyNine
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyNine
{
    public static boolean isValidTriangle(int a, int b, int c) {
        if(a + b > c && b + c > a && a + c > b)
            return true;
        return false;
    }

    public static boolean isTriple(int a, int b, int c, int p) {
        if(a + b + c != p || a * a + b * b != c * c)
            return false;
        return true;
    }

    public static boolean isDuplicate(Integer[] sides, ArrayList<Integer[]> triplets) {
        Arrays.sort(sides);
        for(Integer[] current : triplets) {
            Arrays.sort(current);
            if(Arrays.equals(sides, current))
                return true;
        }
        return false;
    }

    public static int getNumTriplets(int p) {
        int count = 0;
        ArrayList<Integer[]> triplets = new ArrayList<Integer[]>();
        for(int a = 1; a < p/2; a++) {
            for(int b = 1; b < p/2; b++) {
                for(int c = 1; c < p/2; c++) {
                    Integer[] sides = {a, b, c};
                    if(isValidTriangle(a, b, c)) {
                        if(isTriple(a, b, c, p)) {
                            if(!isDuplicate(sides, triplets)) {
                                count++;
                                triplets.add(sides);
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int maxTriplets = 0;
        int maxP = 4;
        
        //Iterate through all possible values of p and find the value with the most triplets
        for(int p = 4; p <= 1000; p++) {
            int pTrips = getNumTriplets(p);
            if(maxTriplets < pTrips) {
                maxTriplets = pTrips;
                maxP = p;
            }
        }        
        System.out.println(maxTriplets);
        System.out.println(maxP);
    }
}