import java.nio.charset.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Project Euler, question number FortyTwo
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class FortyTwo
{
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
    
    public static boolean isTriangularNumber(int n) {
        //Use quadratic formula to calculate n's position in the sequence
        double position = ((-1) + Math.sqrt(1 + 8 * n))/2;
        
        //Checks if the position is an integer
        if((position == Math.floor(position)) && !Double.isInfinite(position))
            return true;
            
        return false;
    }
    
    public static void main(String[] args) throws IOException {
        String wordStr = readFile("words.txt", Charset.defaultCharset());
        String[] words = wordStr.split(",");
        
        //Format array
        for(int i = 0; i < words.length; i++)
            words[i] = words[i].substring(1, words[i].length() - 1).toLowerCase();
        
        int triangleCount = 0;
        for(String word : words) {
            char[] letters = word.toCharArray();
            int wordValue = 0;
            for(char c : letters)
                wordValue += ((int)c) - 96;
            
            if(isTriangularNumber(wordValue))
                triangleCount++;
        }
        
        System.out.println(triangleCount);
    }
}