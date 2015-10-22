
/**
 * CS 180 - Lab 07 - CollegeFeeCalculator
 * 
 * This program creates a series of GUI's to interact with the user to calculate their College fee.
 * 
 * @author Aakash Ranga, aranga@purdue.edu
 * 
 */
import javax.swing.JOptionPane;

public class CollegeFeeCalculator {

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Welcome to CollegeFeeCalculator!",
				"CollegeFeeCalculator", JOptionPane.INFORMATION_MESSAGE);
		String residenceHall = "";
		String creditHours = "";
		int i = 1;
		int j = 1;
		int crdtHrs = 0;
		double tutionFee = 0;
		double housingFee = 0;
		double finalFee = 0;

		while (i < 100) {
			String name = JOptionPane.showInputDialog(null,
					"Please enter your name. Then press OK.", "Name",
					JOptionPane.QUESTION_MESSAGE);
			if (name == null || name.equals("")) {
				break;
			}
			String[] selections = { "Part-Time", "Full-Time" };
			int choice = JOptionPane.showOptionDialog(null,
					"Please select your enrollment.", "Enrollment",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, selections, null);
			creditHours = JOptionPane.showInputDialog(null,
					"Please enter the no. of Credit Hours. Then press OK.",
					"Credit Hours", JOptionPane.QUESTION_MESSAGE);

			if (creditHours == null || creditHours.equals("")) {
				break;
			}
			while (j < 2) {
				crdtHrs = Integer.parseInt(creditHours);
				if ((choice == 0 && (crdtHrs >= 8))
						|| (choice == 1 && (crdtHrs < 8))) {
					JOptionPane
							.showMessageDialog(
									null,
									"Please enter valid credit hours for the current enrollment",
									"Invalid no. of credits",
									JOptionPane.ERROR_MESSAGE);
					continue;
				} else {
					break;
				}
			}
			String[] selections1 = { "In-State", "Out-Of-State",
					"International" };
			String residency = (String) JOptionPane.showInputDialog(null,
					"Please select the appropriate Residency", "Residency",
					JOptionPane.QUESTION_MESSAGE, null, selections1,
					selections[0]);
			if (residency == null) {
				break;
			}
			String[] selections2 = { "On-Campus", "Off-Campus" };
			String housing = (String) JOptionPane.showInputDialog(null,
					"Please select your housing.", "Housing",
					JOptionPane.QUESTION_MESSAGE, null, selections2,
					selections[0]);
			if (housing == null) {
				break;
			}
			String[] selections3 = { "Earhart", "Hillenbrand", "Owen",
					"Windsor" };
			if (housing.equals("On-Campus")) {
				residenceHall = (String) JOptionPane.showInputDialog(null,
						"Please select the residence hall", "Residence-Hall",
						JOptionPane.QUESTION_MESSAGE, null, selections3,
						selections[0]);
			}
			if (residenceHall == null) {
				break;
			}
			CollegeFeeCalculator c = new CollegeFeeCalculator();
			tutionFee = c.calculateTutionFee(choice, residency);
			housingFee = c.calculatorHousingFee(housing, residenceHall);
			finalFee = tutionFee + housingFee;
			String finalMessage = "Name: " + name + "\n" + "Credit Hours: "
					+ creditHours + "\n" + "Enrollment: " + selections[choice]
					+ "\n" + "Residency: " + residency + "\n" + "Tution Fee: "
					+ tutionFee + "\n" + "Housing Expense: " + housingFee
					+ "\n" + "Total Sem. Fee: " + finalFee;
			JOptionPane.showMessageDialog(null, finalMessage,
					"CollegeFeeCalculator", JOptionPane.INFORMATION_MESSAGE);
			int repeat = JOptionPane.showOptionDialog(null,
					"Would you like to perform another fee calculation?",
					"Are you done?", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (repeat == 0) {
				continue;
			} else {
				break;
			}
		}
		JOptionPane.showMessageDialog(null,
				"Thank you for using College Fee calculator",
				"CollegeFeeCalculator", JOptionPane.PLAIN_MESSAGE);
	}

	public double calculateTutionFee(int choice, String residency) {
		double fee = 0;
		if (choice == 0) {
			if (residency.equals("In-State")) {
				fee += 350;
			} else if (residency.equals("Out-Of-State")) {
				fee += 600 + 350;
			} else {
				fee += 70 + 600 + 350;
			}
		} else {
			if (residency.equals("In-State")) {
				fee += 4996;
			} else if (residency.equals("Out-Of-State")) {
				fee += 9401 + 4996;
			} else {
				fee += 1000 + 9401 + 4996;
			}
		}
		return fee;
	}

	public double calculatorHousingFee(String housing, String residenceHall) {
		double fee = 0;
		if (housing.equals("On-Campus")) {
			if (residenceHall.equals("Earhart")) {
				fee += 4745;
			} else if (residenceHall.equals("Hillenbrand")) {
				fee += 5307;
			} else if (residenceHall.equals("Owen")) {
				fee += 4130;
			} else {
				fee += 4150;
			}
		} else {
			fee += 0;
		}
		return fee;
	}
}
