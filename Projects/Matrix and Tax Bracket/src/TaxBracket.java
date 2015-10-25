import java.util.Scanner;

public class TaxBracket {
	static int bracket10;
	static int bracket15;
	static int bracket25;
	static int bracket28;
	static int bracket33;
	static int bracket35;
	static int bracket40;
	static int totalIncomes;

	public TaxBracket() {
		bracket10 = 0;
		bracket15 = 0;
		bracket25 = 0;
		bracket28 = 0;
		bracket33 = 0;
		bracket35 = 0;
		bracket40 = 0;
		totalIncomes = 0;
	}

	public double addBracket(int income) {
		if (income >= 0 && income <= 9075) {
			bracket10++;
			totalIncomes++;
			return 0.10;
		} else if (income > 9075 && income <= 36900) {
			bracket15++;
			totalIncomes++;
			return 0.15;
		} else if (income > 36900 && income <= 89350) {
			bracket25++;
			totalIncomes++;
			return 0.25;
		} else if (income > 89350 && income <= 186350) {
			bracket28++;
			totalIncomes++;
			return 0.28;
		} else if (income > 186350 && income <= 405100) {
			bracket33++;
			totalIncomes++;
			return 0.33;
		} else if (income > 405100 && income <= 406750) {
			bracket35++;
			totalIncomes++;
			return 0.35;
		} else {
			bracket40++;
			totalIncomes++;
			return 0.40;
		}
	}

	public double findDeductible(int income, int dependents) {
		double ppd = dependents * 3950;
		if (income <= 152525) {
			return (ppd + 6200.0);
		} else
			return ((ppd / 3) + 6200.0);
	}

	public double calculateTaxes(int income, int dependents, double bracket) {
		if (findDeductible(income, dependents) >= income) {
			return 0;
		} else {
			return ((income - findDeductible(income, dependents)) * bracket);
		}
	}

	/**
	 * Tax Bracket Project - Main Method Aakash Ranga, aranga@purdue.edu. This
	 * method implements all the methods previously constructed. It will print
	 * out all the main statements as well
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		TaxBracket t = new TaxBracket(); //Tax Bracket object to access the class methods
		String combined = ""; //initialized the empty string combined
		do {
			System.out.println("Please enter income and number of dependents:");
			combined = s.nextLine();

			if (combined.equals(null)) { //defensive code for null case (exception)
				break;
			}

			else if (combined.contains("-")) { //defensive code for negative income case
				break;
			}

			else {

				if (combined.contains(",")) {
					String[] parts = combined.split(",");
					int income = Integer.parseInt(parts[0]);
					int dependents = Integer.parseInt(parts[1]);
					System.out.printf("Taxes for income %d are $%.2f.\n",
							income,
							t.calculateTaxes(income, dependents,
									t.addBracket(income))); //prints out the income and valid taxes
					System.out.println(""); // prints out an empty line to make the output neater
				}
			}
		} while (combined.contains(",")); //while loop controller

		if (totalIncomes > 1) {
			System.out.println("Total incomes entered: " + (totalIncomes - 1)); 
		}

		else {
			System.out.println("Total incomes entered: " + (totalIncomes)); //Defensive code for 
			//possible totalIncome exception
		}

		System.out.printf("Number of 10%% bracket = %d%n", bracket10);
		System.out.printf("Number of 15%% bracket = %d%n", bracket15);
		System.out.printf("Number of 25%% bracket = %d%n", bracket25);
		System.out.printf("Number of 28%% bracket = %d%n", bracket28);
		System.out.printf("Number of 33%% bracket = %d%n", bracket33);
		System.out.printf("Number of 35%% bracket = %d%n", bracket35);
		System.out.printf("Number of 40%% bracket = %d%n", bracket40);
		s.close();
	}
}
