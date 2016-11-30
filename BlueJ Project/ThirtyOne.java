
/**
 * Project Euler, question number ThirtyOne
 * 
 * @author AD Mohanraj 
 * @version 1
 */
public class ThirtyOne
{
    public static int calculateValue(int[] coins) {
        int a = coins[0];
        int b = coins[1] * 2;
        int c = coins[2] * 5;
        int d = coins[3] * 10;
        int e = coins[4] * 20;
        int f = coins[5] * 50;
        int g = coins[6] * 100;
        int h = coins[7] * 200;
        return a + b + c + d + e + f + g + h;
    }

    public static void main(String[] args) {
        int[] coins = new int[8];
        int count = 0;
        
        //Loop through all possible combinations of 1p coin
        for(int a = 0; a <= 200; a++) {
            //Loop through all possible combinations of 2p coin
            for(int b = 0; b <= 100; b++) {
                //Loop through all possible combinations of 5p coin
                for(int c = 0; c <= 40; c++) {
                    //Loop through all possible combinations of 10p coin
                    for(int d = 0; d <= 20; d++) {
                        //Loop through all possible combinations of 20p coin
                        for(int e = 0; e <= 10; e++) {
                            //Loop through all possible combinations of 50p coin
                            for(int f = 0; f <= 4; f++) {
                                //Loop through all possible combinations of 1lb coin
                                for(int g = 0; g <= 2; g++) {
                                    //Loop through all possible combinations of 2lb coin
                                    for(int h = 0; h <= 1; h++) {
                                        //Set coin array values
                                        coins[0] = a;
                                        coins[1] = b;
                                        coins[2] = c;
                                        coins[3] = d;
                                        coins[4] = e;
                                        coins[5] = f;
                                        coins[6] = g;
                                        coins[7] = h;
                                        
                                        if(calculateValue(coins) == 200) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}