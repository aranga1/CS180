/**
 * CS180 - Lab 04 - Investor.java
 *
 * (Put a brief description of your program here. For example: 
 * This program implements a tool allowing an investor to know his rate of interest 
 * and calculates simple interest on an investment over a specific period of time.
 *
 * @author Aakash Ranga, aranga@purdue.edu
 *
 * @lab 1
 *
 * @date (Put the date you completed this lab here)
 */
 
//Import Scanner for taking input from the user
 
import java.util.Scanner;

public class Investor {
 
  //Hint: Declare your instance variables here. 
  //Don't forget to comment each variable declaration as
  //specified in the CS18000 Coding Standards. 
 
   /* 
   * Instance variables
   * name: Name of investor
   * customer: customer ID of investor
   * age: age in years
   * balance: Investment balance=> [Math.random()*10000 in range (0,10000)]
   */
  String name;
  String customerID;
  int age;
  double balance;
  int rate;
 
 
 
 
  /*
   * Constructor for Investor:
   * 
   * Initialize instance variables
   * name, customerID and age passed by user input. 
   * *** customerID starting with 'E' implies customer is an employee 
   */ 
  public Investor (String name, String customerID, int age)  {
      this.name = name;
      this.customerID = customerID;
      this.age = age;
      this.balance = (Math.random() * 10000);
//write your code here to initialize your instance variables
  }
 
 
  /* Method: investorGroup()
   * 
   * @return: returns a character encoding the investor group
   * Investor group is decided based on two variables: customerID and balance
   * balance >= 5000 is gold category
   * balance < 5000 is silver category
   * Investor is an employee, if customerID begins with 'E'
   * 
   * Groups are encoded as follows:
   * a- Employee in gold Category
   * b- Employee in silver Category
   * c- Non-Employee in gold category
   * d- Non-Employee in silver category
   * 
   */
  public char investorGroup() {
      if (balance >= 5000 && customerID.substring(0,1).equals("E")) {
          return 'a';
      }
      else if (balance >= 5000) {
          return 'c';
      }
      else if (balance < 5000 && customerID.substring(0,1).equals("E")) {
          return 'b';
      }
      else{
          return 'd';
      }
  }
 
 
  /*
   * Method assignRate:
   * Rate of interest is assigned to investor based on investor group
   * Group a- 4% per year
   * Group b- 3% per year
   * Group c- 2% per year
   * Group d- 1% per year
   */
  public int assignRate(int ratX){
 
    char group = investorGroup();
    
    if (group == 'a'){
        rate = 4;
    }
    else if (group == 'b'){
        rate = 3;
    }
    else if (group == 'c'){
        rate = 2;
    }
    else
    {
        rate = 1;
    }
    return rate;
    // Use the group variable to determine the rate of interest using selection 
    // write the code to implement this method here
 
  }
 
 
  /* Method calculateInterest():
   * @period: investment period
   * simple interest is calculated as balance*rate*period
   */ 
  public double calculateInterest (int period) {
 
    return ((balance*rate*period)/100);
  }
 
  public static void main(String[] args) {
      int x = 0;
      Scanner scanAns = new Scanner(System.in);
      System.out.println("Enter Customer name:");
      String name = scanAns.nextLine();
      System.out.println("Enter Customer ID:");
      String customerID = scanAns.nextLine();
      System.out.println("Enter customer age:");
      int age = scanAns.nextInt();
      System.out.println("Enter period of investment:");
      int period = scanAns.nextInt();
      Investor inv = new Investor(name, customerID, age);
      System.out.println("Investor Information\nName:" + name + "\nCustomer ID:" + customerID + "\nAge:" + age + "\nAccount Balance: " + inv.balance + "\nRate of interest per year: " + inv.assignRate(x) + "\nInterest earned in 4 years will be: " + inv.calculateInterest(period));
      
    
  }  
 
}    