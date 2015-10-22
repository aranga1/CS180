import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TeachingAssistantStudent extends Student {

	private int hours; // total hours of TA
	protected HashMap<String, Integer> courseHour = new HashMap<String, Integer>();

	public TeachingAssistantStudent(String name, String address) {
		super(name, address);
		this.hours = 0;
	}

	// It adds a course into the HashMap with the key of course and hours as the
	// value. It also updates the instance variable hours when a course is added.
	// This method throws ArrayElementException when the course that is being
	// added to the HashMap already exists in it.
	public void addCourseHour(String course, int hours) throws ArrayElementException {
		if (courseHour.containsKey(course)) {
			throw new ArrayElementException("Course Already in list!");
		}
		courseHour.put(course, hours);
		this.hours += hours;
	}

	// This method first should print the courses along with the grades that the
	// TA is taking as a student and then print out the courses with the
	// corresponding hours which the TA is assisting in each line.
	// Use Iterator to iterate the HashMap.
	@Override
	public void printCourses() {
		int[] temp = getGrades();
		System.out.println("CourseName\t CourseGrade");
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				continue;
			}
			System.out.println(courses[i] + "\t\t" + temp[i]);
		}
		System.out.println("CoursesAssisting       Hours");
		Iterator it = courseHour.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey()+ "\t\t        " + pair.getValue());
	    }
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return super.toString() + " Also serving as Teaching Assistant.";
	}

}