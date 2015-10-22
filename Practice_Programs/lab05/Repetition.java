import java.util.Scanner;
/**
 * Lab 5: Repetition
 */
public class Repetition {
 
    /**
     * Program entry point.
     * Your main method will not be tested. You can modify this to help you
     * debug your code.
     * 
     * @param args
     *
     */
    public static void main(String[] args) {
        // Your testing can go here
        // Note that you do not need to create objects of
        // type Repetition. This is because the methods are
        // declared as "static"
        binaryCounter();
        System.out.println("----------------");
        even(100);
        System.out.println("\n----------------");
        System.out.println(factorial(8));
        System.out.println("----------------");
        vertical("Hello");
        System.out.println("----------------");
        testResults();
        //change as you need
    }
 
 
    /**
     * Print out every letter of the string s, each on its own line.
     * Sample Output for argument "Hello":
     * ===================================
     * H
     * e
     * l
     * l
     * o
     * 
     * @param str input string.
     */
    public static void vertical (String str) {
        System.out.println("================");
        for(int i = 0; i < str.length(); i++) {
            System.out.printf("%s \n", str.charAt(i));
        }
    }
 
 
 
    /**
     * Generate and print out all even numbers from 0 to end (inclusive)
     * on the same line.
     * 
     * output should be formatted exactly like what is between [].
     * [0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 ...]
     *
     * @param end the maximum value to print (could be even or odd)
     */
    public static void even(int end) {
        System.out.print("[");
        for (int i = 0; i <= end; i += 2) {
            System.out.printf("%d ", i);
        }
        System.out.print("]");
    }
 
 
    /**
     * Calculate the value of n!. The value of factorials can be quite large,
     * so use long instead of int to do your calculations.
     * 
     * @param n calculates n!
     * 
     * @return n!
     */
    public static long factorial(long n) {
        long x = 1;
        for(long i = 1; i < n; i++){
            x = (x * i);
        }
        return x;
    }
 
 
    /**
     * Print out all 8 digit binary numbers, each on its own line.
     *
     * Hint: Use nested loops that count from 0 to 1; one loop for each digit of
     * the binary string
     * 
     * 0 - 256 print binary format
     *
     * output should look like the following:
     * 00000000
     * 00000001
     * 00000010
     * 00000011
     * ...
     */
    public static void binaryCounter() {
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        for (int e = 0; e < 2; e++) {
                            for (int f = 0; f < 2; f++) {
                                for (int g = 0; g < 2; g++) {
                                    for (int h = 0; h < 2; h++) {
                                            System.out.println("" + a + b + c + d + e + f + g + h);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

 
    /**
     * Print test result summary.
     * Requirements
     * 
     *  - Print out "Enter scores now:"
     *     (Make sure there is no space after the colon here)
     *  - Takes in scores (ints) from the user until they 
     *     enter a -1.
     *  - After the user enters -1, you will print out the
     *     lowest score, the highest score, and the average 
     *     of the scores (rounded to the floor, or greatest integer not
     *     exceeding the average. Just use integer division).
     *     See the format outlined in the instructions' sample execution.
     * 
     * Hints 
     *  - No arrays are necessary for this method. If you try to use them, you
     *    are doing too much work
     *  - You can calculate the average by maintaining the sum of all the grades
     *    and the count of all the grades and only calculating the average when
     *    the user is done supplying the grades.
     *  - Maintain one variable for each statistic (count, sum, lowest,
     *    highest), updating each of them for each grade entered.
     *  - When printing the output; note that the output statistics are right
     *    justified.
     *  - You can assume all scores range from 0 to 100 (inclusive). 
     *  - To print out, you can use the following lines
     *
     *    System.out.println("=====-----=====-----=====-----=====");
     *    System.out.println("=            Test Results         =");
     *    System.out.printf("= Average: %22d =\n",average);
     *    System.out.printf("= Lowest:  %22d =\n",lowest);
     *    System.out.printf("= Highest: %22d =\n",highest);
     *    System.out.println("=====-----=====-----=====-----=====");
     * 
     * Where 'average', 'lowest', and 'highest' are int variables whose values
     * are the values you computed.
     */
    public static void testResults() {
        Scanner s = new Scanner(System.in);
        int score = 0;
        int sum = 0;
        int i = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (score != -1) {
            System.out.println("Enter test scores now:");
            score = s.nextInt();
            if (score > max) {
                max = score;
            }
            if (score < min && score != -1) {
                min = score;
            }
            sum += score;
            i++;
        }
        int average = (sum+1) / (i-1);
        System.out.println("=====-----=====-----=====-----=====");
        System.out.println("=          Test Results           =");
        System.out.printf("= Average: %22d =\n", average);
        System.out.printf("= Lowest: %22d  =\n", min);
        System.out.printf("= Highest: %22d = \n", max);
        System.out.println("=====-----=====-----=====-----=====");
    }
}