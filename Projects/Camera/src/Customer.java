import java.util.Scanner;

public class Customer {
	public int compare(Camera camOne, Camera camTwo) {
		int val1 = camOne.computeValue();
		int val2 = camTwo.computeValue();
		int userRating1 = camOne.userRating;
		int userRating2 = camTwo.userRating;
		double price1 = camOne.price;
		double price2 = camTwo.price;
		double ratio1 = price1 / val1;
		double ratio2 = price2 / val2;

		if (val1 == val2) {
			if (userRating1 == userRating2) {
				if ((price1 - price2) < 0.01 && (price2 - price1) < 0.01) {
					return 0;
				}
				else if (price1 < price2) {
					return 1;
				} else {
					return 2;
				} 
			}
			if ((price1 - price2) < 0.01 && (price2 - price1) < 0.01) {
				if (userRating1 < userRating2) {
					return 2;
				}
				if (userRating1 > userRating2) {
					return 1;
				}
			}
		}
		if (userRating1 == userRating2 && price1 == price2) {
			if (val1 < val2) {
				return 2;
			}
			if (val1 > val2) {
				return 1;
			}
		}
		if (ratio1 < ratio2) {
			return 1;
		}
		if (ratio1 > ratio2) {
			return 2;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter attiributes of Camera: 1");
		System.out.println("Is it WiFi enabled?");
		boolean hasWiFi = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Is it Water Resistant?");
		boolean isWaterResistant = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Is it GPS enabled?");
		boolean hasGPS = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Is the lens able to zoom?");
		boolean hasZoom = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Condition?");
		String condition = scan.nextLine();
		System.out.println("Enter price in $");
		double price1 = scan.nextDouble();
		System.out.println("Enter user rating (0 to 5):");
		int userRating1 = scan.nextInt();

		System.out.println("=======================");
		System.out.println("Enter attiributes of Camera: 2");
		System.out.println("Is it WiFi enabled?");
		scan.nextLine();
		boolean hasWiFi1 = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Is it Water Resistant?");
		boolean isWaterResistant1 = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Is it GPS enabled?");
		boolean hasGPS1 = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Is the lens able to zoom?");
		boolean hasZoom1 = scan.nextLine().equalsIgnoreCase("yes") ? true : false;
		System.out.println("Condition?");
		String condition1 = scan.nextLine();
		System.out.println("Enter price in $");
		double price2 = scan.nextDouble();
		System.out.println("Enter user rating (0 to 5):");
		int userRating2 = scan.nextInt();
		Camera camOne = new Camera(hasWiFi, isWaterResistant, hasGPS, hasZoom,
				condition, price1, userRating1);
		Camera camTwo = new Camera(hasWiFi1, isWaterResistant1, hasGPS1,
				hasZoom1, condition1, price2, userRating2);
		Customer cameras = new Customer();
		int better = cameras.compare(camOne, camTwo);
		if (better == 1) {
			System.out.println("Camera 1 is better than Camera 2!");
		} else if (better == 2) {
			System.out.println("Camera 2 is better than Camera 1!");
		} else {
			System.out.println("Both cameras are identical. Choose the one you like!");
		}
		scan.close();
	}
}
