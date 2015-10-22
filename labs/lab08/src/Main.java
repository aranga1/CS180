import java.util.InputMismatchException;
import java.util.Scanner;
//import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int choice = 0;
        String color;
        String make;
        
        CarLot carLot = new CarLot(10);
        carLot.add(new Car("red", "ford"));    // 0
        carLot.add(new Car("blue", "gm"));     // 1
        carLot.add(new Car("yellow", "ford")); // 2
        carLot.add(new Car("red", "chevy"));   // 3
        carLot.add(new Car("blue", "ford"));   // 4
        carLot.add(new Car("orange", "gm"));   // 5
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n==========================================================");
            System.out.println("Welcome to the CS180 car lot, what would you like to do?");
            System.out.println("1 - Remove a car from the lot");
            System.out.println("2 - Add a car to the lot");
            System.out.println("3 - Search car lot");
            System.out.println("4 - Quit");
            System.out.println("==========================================================");
            System.out.print("Choice: ");
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You must enter a number");
                sc.next();
                continue;
            }
            System.out.println();
            
            switch (choice) {
                case 1:
                    if (carLot.numVehicles() == 0) {
                        System.out.println("The car lot is empty.");
                        break;
                    }
                    System.out.printf("Car ID |  Color  |  Make\n");
                    for (int i = 0; i < carLot.capacity(); i++) {
                        if (carLot.get(i) != null)
                            System.out.printf("  %2d   | %6s  |  %4s\n", i,
                                              carLot.get(i).getColor(), carLot.get(i).getMake());
                        
                    }
                    System.out.print("\nPlease enter car ID: ");
                    try {
                        choice = sc.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("You must enter a number");
                        sc.next();
                        continue;
                    }
                    System.out.println();
                    Car newCar = carLot.remove(choice);
                    if (newCar == null) {
                        System.out.println("There is no car at Spot " + choice + ", sorry!");
                    } else {
                        System.out.println("A " + newCar.getColor() + " " + newCar.getMake() +
                                           " has been removed from the lot");
                    }
                    break;
                    
                case 2:
                    System.out.print("Please enter the car color: ");
                    color = sc.next();
                    System.out.println();
                    System.out.print("Please enter the car make: ");
                    make = sc.next();
                    System.out.println();
                    
                    if (carLot.add(new Car(color, make))) {
                        System.out.printf("A %s %s has been added to the lot.", color, make);
                    } else {
                        System.out.println("Sorry, CS180 car lot is full. Cannot buy anymore cars.");
                    }
                    System.out.println();
                    break;
                    
                case 3:
                    System.out.print("Please enter car make to find: ");
                    make = sc.next();
                    System.out.println();
                    
                    boolean[] results = carLot.searchByMake(make);
                    int count = 0;
                    for (int i = 0; i < results.length; i++) {
                        if (results[i]) {
                            count++;
                            System.out.println("-->Car ID " + i + " matches search for car of make " + make);
                        }
                    }
                    if (count == 0) {
                        System.out.println("No cars found");
                    }
                    break;
                    
                case 4:
                    System.out.println("Thank you, come again!");
                    sc.close();
                    return;
                    
                default:
                    System.out.println("Unrecognized Command, please try again");
                    break;
            }
        }
    }
}
