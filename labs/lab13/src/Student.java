public class Student extends AcademicPerson {

	// Instance variables
	private int[] grades; // grade for the corresponding course
	private static final int MAX_COURSES = 30; // maximum number of courses

	// Constructor
	public Student(String name, String address) {
		super(name, address);
		courses = new String[MAX_COURSES];
		grades = new int[MAX_COURSES];
	}

	// It adds a course and corresponding grade to the lists.
	// Student can take the same course couple of times. If a course that
	// already exists in the list is given as the input of the method you need
	// to compare the input grade with the one that is saved in the Grades list,
	// the higher grade needs to be saved in the Grades list.
	public void addCourseGrade(String course, int grade) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				courses[i] = course;
				grades[i] = grade;
				System.out.println("Course " + course + " added with grade " + grade);
				break;
			}
			else if (courses[i].equals(course)) {
				if (grades[i] < grade) {
					grades[i] = grade;
				}
			}
			else continue;
		}
	}

	// This method prints the student's average grade for all the courses.
	// This method throws IllegalDivisionByZero exception, when there is no
	// courses in the list.
	public void getAverageGrade() throws IllegalDivisionByZero {
		if (courses.length == 0) {
			throw new IllegalDivisionByZero("Division By Zero!");
		}
		double average = 0;
		int i;
		for (i = 0; i < grades.length; i++) {
			if (grades[i] == 0) {
				break;
			}
			average += grades[i];
		}
		average /= i;
		System.out.println("Average is: " + (average));
	}

	// It prints all the courses with the corresponding grades in each line.
	@Override
	public void printCourses() {
		System.out.println("CourseName\t CourseGrade");
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				continue;
			}
			System.out.println(courses[i] + "\t\t\t" +  grades[i]);
		}
	}

	public int[] getGrades() {
		return grades;
	}

	public void setGrades(int[] grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Student: " + super.toString();
	}
}