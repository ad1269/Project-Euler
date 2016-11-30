import java.util.Arrays;
/**
 * Write a description of class TwentyFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentyFour
{    
    public static int factorial(int n) {
        if(n == 1) return 1;
        return factorial(n - 1) * n;
    }

    //Recursively generates all possible permutations of the characters in the String str
    public static String[] permute(String str) {
        String[] permutations = new String[factorial(str.length())];
        if(str.length() == 1)
            permutations[0] = str;
        else {
            String[] breakStr = str.split("");
            String[] recursivePermute = permute(str.substring(0, str.length() - 1));
            String broken = breakStr[breakStr.length - 1];

            for(int a = 0, b = 0; b < recursivePermute.length; b++) {
                String currentPerm = recursivePermute[b];
                for(int c = 0; c <= currentPerm.length(); c++) {
                    String newPerm = currentPerm;
                    newPerm = new StringBuilder(newPerm).insert(c, broken).toString();

                    permutations[a] = newPerm;
                    a++;
                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        String[] permutations = permute("0123456789");
        Arrays.sort(permutations);
        System.out.print(permutations[999999]);
    }
}
