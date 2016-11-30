import java.util.Arrays;
/**
 * Write a description of class FiftyEight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyEight
{
    public static int[] getStartIndex(int n) {
        int[] index = new int[2];

        //Odd side length
        if(n % 2 == 1) {
            index[0] = n/2;
            index[1] = n/2;
            return index;
        }
        else {
            index[0] = n/2;
            index[1] = (n/2) - 1;
            return index;
        }
    }

    public static int[] getIndexInDirection(int direction, int i, int j) {
        int[] index = new int[2];

        if(direction == 0) {
            index[0] = i;
            index[1] = j + 1;
        }
        else if(direction == 1) {
            index[0] = i - 1;
            index[1] = j;
        }
        else if(direction == 2) {
            index[0] = i;
            index[1] = j - 1;
        }
        else if(direction == 3) {
            index[0] = i + 1;
            index[1] = j;
        }

        return index;
    }

    public static boolean lastRun(int n, int i, int j) {
        if(n % 2 == 1) {
            if(i == n - 1 && j == n - 1)
                return true;
            return false;
        }
        else {
            if(i == 0 && j == 0)
                return true;
            return false;
        }
    }

    public static long[][] generateSpiralFromPreviousSpiral(long[][] previousSpiral) {
        int n = previousSpiral.length + 2;
        long[][] spiral = new long[n][n];
        
        //More efficient copy
        for(int i = 0; i < n; i++)
            if(i != 0 && i != n - 1)
                System.arraycopy(previousSpiral[i - 1], 0, spiral[i], 1, n - 2);

        long count = (n - 2) * (n - 2) + 1;
        for(int i = n - 2; i >= 0; i--) {
            spiral[i][n - 1] = count;
            count++;
        }
        for(int j = n - 2; j >= 0; j--) {
            spiral[0][j] = count;
            count++;
        }
        for(int i = 1; i < n; i++) {
            spiral[i][0] = count;
            count++;
        }
        for(int j = 1; j < n; j++) {
            spiral[n - 1][j] = count;
            count++;
        }

        return spiral;
    }

    public static long[][] generateSpiral(int n) {
        long[][] spiral = new long[n][n];

        int[] start = getStartIndex(n);
        int i = start[0];
        int j = start[1];
        spiral[i][j] = 1;

        int currentDirection = 0;
        int currentSide = 1;
        int currentSteps = 0;
        long currentNumber = 2;
        int lengthSwitch = 0;
        for(;currentSide <= n;) {
            if(currentNumber == 35)
                currentNumber = 35;
            for(;currentSteps < currentSide; currentSteps++) {
                if(!lastRun(n, i, j)) {
                    int[] nextStep = getIndexInDirection(currentDirection, i , j);
                    i = nextStep[0];
                    j = nextStep[1];
                    spiral[i][j] = currentNumber;
                    currentNumber++;
                }
            }
            currentSteps = 0;
            currentDirection = (currentDirection + 1) % 4;
            lengthSwitch++;
            if(lengthSwitch % 2 == 0)
                currentSide++;
        }

        return spiral;
    }

    public static boolean isPrime(long n) {
        for(long i = 2; i <= (long) (Math.sqrt(n) + 0.5); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static double getFrequency(long[][] spiral) {
        int n = spiral.length;
        long diagLength = (2 * n) - 1;

        long primeCount = 0;

        //Negative Slope Diagonal
        for(int i = 0; i < n; i++)
            if(isPrime(spiral[i][i]))
                primeCount++;

        //Positive Slope Diagonal
        for(int i = 0; i < n; i++)
            if(isPrime(spiral[spiral.length - 1 - i][i]))
                primeCount++;

        double frequency = ((double) primeCount) / diagLength;
        return frequency;
    }

    public static void main(String[] args) {
        //n > 12000
        double primeFrequency = 1.0;
        int n = 13000;
        long[][] spiral = generateSpiral(n);
        while(primeFrequency >= 0.1) {
            spiral = generateSpiralFromPreviousSpiral(spiral);
            primeFrequency = getFrequency(spiral);
            n += 2;
        }

        System.out.println(n);
    }
}
