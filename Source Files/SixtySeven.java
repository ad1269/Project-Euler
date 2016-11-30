import java.nio.file.*;
import java.nio.charset.*;
import java.io.IOException;

/**
 * Project Euler, question number SixtySeven
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class SixtySeven
{
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) throws IOException {
        String tStr = readFile("67.txt", Charset.defaultCharset());
        System.out.println(tStr);
        TriangleArray a = new TriangleArray(tStr);
        System.out.println(a.findGreatestSum());
    }
}