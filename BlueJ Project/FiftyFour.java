import java.nio.file.*;
import java.nio.charset.*;
import java.io.IOException;
import java.util.*;

/**
 * Write a description of class FiftyFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiftyFour
{   
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static String[] stripSuitInfo(String[] hand) {
        String[] strippedHand = new String[5];

        //Grab just the value of the card and replace the letter values with numbers
        for(int i = 0; i < 5; i++) {
            strippedHand[i] = hand[i].substring(0,1);
            if(strippedHand[i].equals("T"))
                strippedHand[i] = "10";
            if(strippedHand[i].equals("J"))
                strippedHand[i] = "11";
            if(strippedHand[i].equals("Q"))
                strippedHand[i] = "12";
            if(strippedHand[i].equals("K"))
                strippedHand[i] = "13";
            if(strippedHand[i].equals("A"))
                strippedHand[i] = "14";
            if(strippedHand[i].equals("Z"))
                strippedHand[i] = "0";
        }

        return strippedHand;
    }

    public static int[] getCardValues(String[] hand) {
        String[] strippedHand = stripSuitInfo(hand);
        int[] intHand = new int[5];

        for(int i = 0; i < 5; i++)
            intHand[i] = Integer.parseInt(strippedHand[i]);    

        return intHand;
    }

    public static String[] pokerSort(String[] hand) {
        String[] sortedHand = stripSuitInfo(hand);

        //Create copy of hand
        String[] handCopy = new String[5];
        for(int i = 0; i < 5; i++) {
            handCopy[i] = hand[i];
        }        

        //Create an int array from the values
        int[] tempSort = new int[5];
        for(int i = 0; i < 5; i++)
            tempSort[i] = Integer.parseInt(sortedHand[i]);

        //Sort the int array
        Arrays.sort(tempSort);

        //Convert back to String array
        for(int i = 0; i < 5; i++)
            sortedHand[i] = cardValueToString(tempSort[i]);

        //Add back the suit information
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(handCopy[j].substring(0, 1).equals(sortedHand[i])) {
                    sortedHand[i] = sortedHand[i] + handCopy[j].substring(1);
                    handCopy[j] = "ZZ";
                }
            }
        }

        return sortedHand;
    }

    public static int countPairs(String[] hand) {
        String[] strippedHand = stripSuitInfo(hand);
        int[] cardCounts = new int[14];

        //Increase count of card in cardCounts array
        for(int i = 0; i < 5; i++)
            cardCounts[Integer.parseInt(strippedHand[i]) - 1]++;

        boolean threeCount = false;
        boolean pairDetected = false;
        for(int count : cardCounts) {
            //Four of a Kind
            if(count == 4)
                return 7;

            //Three of a Kind or Full House
            if(count == 3) {
                //Full House
                if(pairDetected)
                    return 6;
                threeCount = true;
            }

            //One or two pair or Full House
            if(count == 2) {
                //Full House
                if(threeCount)
                    return 6;

                //Two pair
                if(pairDetected)
                    return 2;

                pairDetected = true;
            }
        }

        //Three of a Kind
        if(threeCount)
            return 3;

        //One Pair
        if(pairDetected)
            return 1;

        //Nothing detected
        return 0;
    }

    public static boolean isFlush(String[] hand) {
        //Strip number information
        String[] suits = new String[5];
        for(int i = 0; i < 5; i++)
            suits[i] = hand[i].substring(1);

        for(int i = 0; i < 4; i++)
            if(suits[i] != suits[i + 1])
                return false;
        return true;
    }

    public static boolean isStraight(String[] hand) {
        //Strip suit information and store in int array
        String[] strippedHand = stripSuitInfo(hand);
        int[] intHand = new int[5];
        for(int i = 0; i < 5; i++)
            intHand[i] = Integer.parseInt(strippedHand[i]);

        for(int i = 0; i < 4; i++)
            if(intHand[i] + 1 != intHand[i + 1])
                return false;

        return true;
    }

    public static int detectHand(String[] hand) {
        int value = 0;

        //Detect OnePair, TwoPair, ThreeOfAKind, FullHouse, FourOfAKind
        value = countPairs(hand);
        if(value != 0)
            return value;

        boolean flush = isFlush(hand), straight = isStraight(hand);

        //Detect RoyalFlush
        if(flush && straight && hand[0].substring(0,1) == "T")
            return 9;

        //Detect StraightFlush
        if(flush && straight)
            return 8;

        //Detect Straight, Flush
        if(flush)
            return 5;
        if(straight)
            return 4;

        //It's a high card
        return 0;
    }

    public static int getRepeatCardValue(String[] hand) {
        int[] handValues = getCardValues(hand);
        int[] cardCounts = new int[14];

        //Increase count of card in cardCounts array
        for(int i = 0; i < 5; i++)
            cardCounts[handValues[i] - 1]++;

        //Ignore everything in the first index of cardCounts
        for(int i = 1; i < cardCounts.length; i++)
            if(cardCounts[i] > 1)
                return i + 1;

        //Should never be reached
        return 0;
    }

    public static int getHighCard(String[] hand) {
        int[] handValues = getCardValues(hand);
        int max = 0;
        for(int cardValue : handValues)
            if(max < cardValue)
                max = cardValue;
        return max;
    }

    public static String cardValueToString(int value) {
        if(value < 10)
            return value + "";
        else if(value == 10)
            return "T";
        else if(value == 11)
            return "J";
        else if(value == 12)
            return "Q";
        else if(value == 13)
            return "K";
        else if(value == 14)
            return "A";

        //Should never be reached
        return "";
    }

    public static String[] removeCardFromHand(String[] hand, int card) {
        String cardString = cardValueToString(card);
        String[] handCopy = new String[5];
        for(int i = 0; i < 5; i++)
            handCopy[i] = hand[i];

        for(int i = 0; i < 5; i++)
            if(hand[i].substring(0, 1).equals(cardString)) {
                handCopy[i] = "ZZ";
                break;
            }

        return handCopy;
    }

    public static boolean playerOneWinsTiebreaker(int situation, String[] player1, String[] player2) {
        //1 pair tie
        if(situation == 1) {
            int p1 = getRepeatCardValue(player1);
            int p2 = getRepeatCardValue(player2);
            if(p1 > p2)
                return true;
            else if(p1 == p2) {
                //Remove the repeats and rerun tiebreaker
                String[] newOneHand = removeCardFromHand(player1, p1);
                String[] newTwoHand = removeCardFromHand(player2, p2);
                return playerOneWinsTiebreaker(0, newOneHand, newTwoHand);
            }
            return false;
        }
        //2 Pair tie
        else if(situation == 2) {
            int[] player1Pairs = new int[2];
            int[] player2Pairs = new int[2];

            //Get First Pair
            player1Pairs[0] = getRepeatCardValue(player1);
            player2Pairs[0] = getRepeatCardValue(player2);

            //Remove First Pair and get Second Pair
            String[] newOneHand = removeCardFromHand(player1, player1Pairs[0]);
            String[] newTwoHand = removeCardFromHand(player2, player2Pairs[0]);
            player1Pairs[1] = getRepeatCardValue(newOneHand);
            player2Pairs[1] = getRepeatCardValue(newTwoHand);

            //Sort the pair array to make it easier to compare
            Arrays.sort(player1Pairs);
            Arrays.sort(player2Pairs);

            //Compare the higher pair
            if(player1Pairs[1] > player2Pairs[1])
                return true;
            else if(player1Pairs[1] == player2Pairs[1]) {
                //Compare the lower pair
                if(player1Pairs[0] > player2Pairs[0])
                    return true;
                else if(player1Pairs[0] == player2Pairs[0]) {
                    //Remove Pairs and rerun tiebreaker to get winner
                    newOneHand = removeCardFromHand(player1, player1Pairs[0]);
                    newTwoHand = removeCardFromHand(player2, player2Pairs[0]);
                    newOneHand = removeCardFromHand(newOneHand, player1Pairs[1]);
                    newTwoHand = removeCardFromHand(newTwoHand, player2Pairs[1]);

                    return playerOneWinsTiebreaker(0, newOneHand, newTwoHand);
                }
            }
            return false;
        }        
        //High Card or Flush, Straight, StraightFlush
        else {
            int p1 = getHighCard(player1);
            int p2 = getHighCard(player2);
            if(p1 > p2)
                return true;
            else if(p1 == p2) {
                //Remove the duplicates and rerun tiebreaker
                String[] newOneHand = removeCardFromHand(player1, p1);
                String[] newTwoHand = removeCardFromHand(player2, p2);
                return playerOneWinsTiebreaker(0, newOneHand, newTwoHand);
            }
            return false;
        }
    }

    public static boolean playerOneWins(String hands) {
        String[] cards = hands.split(" ");
        String[] player1 = new String[5];
        String[] player2 = new String[5];
        for(int i = 0; i < 10; i++)
            if(i >= 5)
                player2[i - 5] = cards[i];
            else
                player1[i] = cards[i];

        //Sort hands by lowest to highest
        player1 = pokerSort(player1);
        player2 = pokerSort(player2);

        //Gets the type of hand that the players have
        int player1Hand = detectHand(player1);
        int player2Hand = detectHand(player2);

        if(player1Hand > player2Hand)
            return true;
        else if(player1Hand == player2Hand)
            return playerOneWinsTiebreaker(player1Hand, player1, player2);
        return false;
    }

    public static void main(String[] args) throws IOException {
        String allHands = readFile("poker.txt", Charset.defaultCharset());
        String[] handArray = allHands.split("\n");

        int playerOneWinCount = 0;
        for(String playerHands : handArray)
            if(playerOneWins(playerHands))
                playerOneWinCount++;

        System.out.println(playerOneWinCount);
    }
}