/**
 * CS180 lab 02: pythagorasClient
 * Calls the hypotenuse method to display result
 * @Aakash Ranga, aranga@purdue.edu, lab - 01
 */
import java.util.Scanner;
public class PythagorasClient {
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras();
        int x;
        int y;       
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the length of the first side: ");
        x = s.nextInt();
        System.out.print("Enter the length of the second side: ");
        y = s.nextInt();
        double hyp = p.getHypotenuse(x, y);
        System.out.println("The first side is: " + x);
        System.out.println("The second side is: " + y);
        System.out.println("The calculated Hypotenuse is: " + hyp);
        s.close();
    }
}
        