import java.lang.StringBuilder;

/**
 * Project Euler, question number Fourty
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Forty
{
    public static int getIntegerElement(String str, int n) {
        String element = str.substring(n - 1, n);
        return Integer.parseInt(element);
    }
    
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < 190000; i++)
            sb.append(i);
        String Champernowne = sb.toString();
        
        int product = 1;
        for(int i = 1; i <= 1000000; i *= 10)
            product *= getIntegerElement(Champernowne, i);
        
        System.out.println(product);
    }
}