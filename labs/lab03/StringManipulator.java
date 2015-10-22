import java.util.*;
/**
 * CS180 - Lab 03 - StringManipulator
 * 
 * (Brief description of the class file)
 * 
 * @author Aakash Ranga, aranga@purdue.edu, lab section: 1
 */
public class StringManipulator {

/**
 * @param fullName contains the person's 
 * first and last name separated by a space
 * @return user name
 */
public String makeUserName(String fullName) {
    if (fullName.equals("")) {
        return null;
    }
    else{
     String fName = fullName.substring(0, 1);
     String lName = fullName.substring(fullName.indexOf(" ") + 1);
     String uID = fName.concat(lName).toLowerCase();
     return uID;
    }
}

public String makeEmail(String name, String domain) {
    return (name + '@' + domain).toLowerCase();
}

public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    StringManipulator str = new StringManipulator();
    System.out.println("Enter the Full Name of the person. First Name followed by Last Name.");
    String inp1 = s.nextLine();
    System.out.println("Enter the domain");
    String inp2 = s.nextLine();
    System.out.println("The user name for the person is: " + str.makeUserName(inp1));
    System.out.println("The email id for the person is: " + str.makeEmail(str.makeUserName(inp1), inp2));
    s.close();
}
}