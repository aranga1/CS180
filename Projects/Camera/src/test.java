import static org.junit.Assert.*;

import org.junit.Test;


public class test {

	@Test
	public void test() {
		Customer c = new Customer();
		Camera camOne = new Camera(true, false, true, true, "New", (1000/3.0), 3);
		Camera camTwo = new Camera(true, false, true, true, "New", 333.33, 3);
		int actualSelection = c.compare(camOne, camTwo);
		System.out.println(actualSelection);
	}

}
