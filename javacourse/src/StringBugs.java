import java.util.Scanner;

/**
 * This program implements two buggy methods that process strings.
 *
 * @author Jim Skrentny, copyright 2009-2010, all rights reserved
 */

public class StringBugs{


    /**
     * Main program to test methods. 
     * 
     * @bugs none.
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        
        System.out.println("Enter a String: ");
        String str = stdin.next();
        
        System.out.println("Enter a char: ");
        char ch = stdin.next().charAt(0);
        
        System.out.println("Character " + ch + " occurs "
                           + countOccurrences(str, ch) + " times in string \""
                           + str + "\".");
        
        System.out.println("\n\nEnter another String: ");
        str = stdin.next();
        
        System.out.println("The reverse of string \""
                            + str + "\" is " + reverseString(str));
    }   

    /**
     * Counts the number of occurrences of char ch in String str.
     * 
     * @param s - String to search for ch 
     * @param c - char whose occurrence should be counted 
     * @return int - the number of occurrences
     * 
     * @bugs There are TWO minor errors. Can you find and fix them?
     */
    public static int countOccurrences(String s, char c) {
        int count = 0;  //BUG changed to 1
        if (s != null) {
            for (int i = 0; i < s.length(); i++) { //BUG changes to i = 1
                if (s.charAt(i) == c) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Reverses the String.
     * 
     * @param s - String to reverse 
     * @return String - the reversed String
     * 
     * @bugs There are TWO minor errors. Can you find and fix them?
     */
    public static String reverseString(String s) {
        //toCharArray converts string s to an array of characters
        char[] swap = s.toCharArray();
        System.out.println("Array is length of:"+swap.length+"with first character as:"+swap[0]+"with last character as:"+swap[swap.length-1]);
        //bugs are in the for loop
       int h = s.length() - 1;
       for (int i = 1; i < swap.length-1; i++)
        {
            // swap values at `l` and `h`
            char cTmp = swap[i-1];
            swap[i-1] = swap[swap.length - i];
            swap[swap.length - i] = cTmp;
        }

        //converts the swap array of characters back to a String
        return new String(swap);
        //return String.copyValueOf(swap);
    }

}