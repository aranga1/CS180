// Define superclass AcademicPerson
public abstract class AcademicPerson {
   // Instance variables
   private String name;
   private String address;
   protected int numCourses; // number of courses taken so far
   protected String[] courses; // course codes
   
   // Constructor
   public AcademicPerson(String name, String address) {
      this.name = name;
      this.address = address;
      this.numCourses = 0;
   }
   
   // Getters
   public String getName() {
      return name;
   }
   public String getAddress() {
      return address;
   }
   
   public String toString() {
      return name + " (" + address + ")";
   }
   
   
   // Print Courses details.
   public abstract void printCourses();


   
}