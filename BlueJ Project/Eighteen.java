import java.nio.charset.*;
import java.nio.file.*;
import java.io.IOException;

/**
 * Project Euler, question number Eighteen
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class Eighteen
{
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) throws IOException {
        String tStr = readFile("18.txt", Charset.defaultCharset());
        System.out.println(tStr);
        TriangleArray a = new TriangleArray(tStr);
        System.out.println(a.findGreatestSum());
    }
}