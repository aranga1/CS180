// Define class Teacher, subclass of AcademicPerson
public class Teacher extends AcademicPerson {
	// Instance variables
	private static final int MAX_COURSES = 10; // maximum courses

	// Constructor
	public Teacher(String name, String address) {
		super(name, address);
		courses = new String[MAX_COURSES];
	}

	
	// It adds a course into the list of courses.
	// This method throws ArrayElementException when the course that is being
	// added to the list already exists in it.
	public void addCourse(String course) throws ArrayElementException {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				courses[i] = course;
				break;
			}
			if (courses[i].equals(course)) {
				throw new ArrayElementException("Course already exists!");
			}
			
			continue;
		}
	}

	// It removes a course into the list of courses.
	// This method throws ArrayElementException when the course does not exist
	// in the list.
	public void removeCourse(String course) throws ArrayElementException {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				continue;
			}
			if (courses[i].equals(course)) {
				courses[i] = null;
				return;
			}
			continue;
		}
		throw new ArrayElementException("Course not found");
	}

	// It prints all the courses in the list in each line
	@Override
	public void printCourses() {
		System.out.println("Courses Teaching this semester:");
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				continue;
			}
			System.out.println(courses[i]);
		}
	}

	@Override
	public String toString() {
		return "Teacher: " + super.toString();
	}

}