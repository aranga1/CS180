/**
 * CS180 - lab 1
 * This program gets a users input for Farhenheit temperature and gives output in Celsius
 * @ Aakash Ranga, aranga@purdue.edu, lab - 01
 */

import java.util.Scanner;
public class Temperature {
    public static void main(String[] args) {
        double fht;
        double cls;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Temperature in Farhenheit: ");
        fht = s.nextDouble();
        cls = ((fht - 32) * 5) / 9;
        System.out.println("Farhenheit: " + fht);
        System.out.println("Celsius: " + cls);
    }
}