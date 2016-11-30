import java.nio.charset.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Write a description of class TwentyTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwentyTwo
{    
    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) throws IOException {
        String tStr = readFile("names.txt", Charset.defaultCharset());
        String[] names = tStr.split(",");
        
        //Format array
        for(int i = 0; i < names.length; i++)
            names[i] = names[i].substring(1, names[i].length() - 1).toLowerCase();

        //Sort names
        System.out.println(Arrays.toString(names));
        Arrays.sort(names);
        System.out.println(Arrays.toString(names));
        
        int nScore = 0;
        int i = 1;
        for(String name : names) {
            char[] l = name.toCharArray();
            int n = 0;
            for(char c : l) {
                n += ((int)c) - 96;
            }
            nScore += n * i;
            i++;
        }
        System.out.println(nScore);
    }

}
