
public class Scenario {
	
	// Print courses details for each AcademicPerson
	public void printCourses(AcademicPerson[] ap){	
		for ( int i = 0; i < ap.length; i++) {
			System.out.println("Course Details for AcademicPerson number " + i + ":"); // add description);	
			ap[i].printCourses();
		}
	}
	
	
	public static void main(String[] args) {

		Scenario sc = new Scenario();
		
		// Test TA class
		TeachingAssistantStudent ta1 = new TeachingAssistantStudent("Sara Smith", "100 State Ave");
		System.out.println(ta1);
	
			try {
				ta1.addCourseHour("CS180",10);
				System.out.println("CS180 added for TA.");
			} catch (ArrayElementException e) {
				System.out.println(e.getMessage());
			}
			try {
				ta1.addCourseHour("CS252", 10);
				System.out.println("CS252 added for TA.");
			} catch (ArrayElementException e) {
				System.out.println(e.getMessage());
			}
			try {
				ta1.addCourseHour("CS180",10);
				System.out.println("CS180 added for TA.");
			} catch (ArrayElementException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		System.out.println("Total TA hours: " + ta1.getHours());
		
		ta1.printCourses();
		
		
		// Test Student class
		System.out.println();
		Student s1 = new Student("John Doe", "1 Happy Ave");
		System.out.println(s1);
		try {
			s1.getAverageGrade();
		} catch (IllegalDivisionByZero e1) {
			System.out.println(e1.getMessage());
		}
		s1.addCourseGrade("CS180", 97);
		s1.addCourseGrade("CS252", 68);
		s1.printCourses();
		try {
			s1.getAverageGrade();
		} catch (IllegalDivisionByZero e1) {
			System.out.println(e1.getMessage());
		}

		
		// Test Teacher class
		System.out.println();
		Teacher t1 = new Teacher("William Birck", "8 Sunset Way");
		System.out.println(t1);
		String[] courses = { "CS177", "CS180", "CS177" };
		for (String course : courses) {
			try {
				t1.addCourse(course);
				System.out.println(course + " added.");
				} 
			catch (ArrayElementException e) {
				System.out.println(e.getMessage());
			}
		}
		
		t1.printCourses();
		
		for (String course : courses) {
			try {
				t1.removeCourse(course);
				System.out.println(course + " removed.");
			} catch (ArrayElementException e) {
				System.out.println(e.getMessage());
			} 
		}		
		t1.printCourses();
		
		
		
		// Dynamic Binding Testing.
		AcademicPerson[] ap = new AcademicPerson[3];
		ap[0] = ta1;
		ap[1] = s1;
		ap[2] = t1;
		sc.printCourses(ap);
		
		
		
	}
}