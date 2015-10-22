package lab05;
import java.util.Scanner;

public class MathToolsClient {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i = 0;
		while (i < 100) {
			
			System.out.println("Select a number from the menu choices:");
			System.out.println("1 - Absolute Value");
			System.out.println("2 - Power");
			System.out.println("3 - Scientific Notation");
			int choice = s.nextInt();
			if (choice == 1) {
				System.out.println("Enter a number:");
				double x = s.nextDouble();
				System.out.println(MathTools.absoluteValue(x));
			}
			else if (choice == 2) {
				System.out.println("***Power***");
				System.out.println("Enter the base:");
				double base = s.nextDouble();
				System.out.println("Enter the exponent:");
				int exp = s.nextInt();
				System.out.println(base + "^" + exp + "=" + MathTools.power(base, exp));
			}
			else if (choice == 3) {
				System.out.println("***Scientific Notation***");
				System.out.println("Enter the number you want converted to Scientific Notation:");
				double n = s.nextDouble();
				System.out.println(MathTools.scientificNotation(n));
			}	
			else {
				System.out.println("Invalid Option");
			}
			System.out.println("Return to menu? (yes/no)");
			//s.next();
			String ans = s.next();
			if (ans.equalsIgnoreCase("yes")) {
				continue;
			}
			else {
				//System.out.println(ans);
				break;//always goes to this condition
			}
		}//end of while loop
		System.out.println("Exiting MathtoolsClient....");
		s.close();
	}//end of main mathod
}
