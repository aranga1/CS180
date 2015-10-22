import static org.junit.Assert.*;
import org.junit.*;

public class EvenOddTestElegant {
	private EvenOdd eo;
	
	@Before
	public void setUp() {
		eo = new EvenOdd();
		System.out.println("Within setUp()");
	}
	
	@Test(timeout = 100)
	public void testIsEvenZero() {
		int num = 0;
		
		boolean actualResult = eo.isEven(num);
		boolean expectedResult = true;
		String errorMsg = "isEven(): check the value returned when num = 0";
		assertEquals(errorMsg, expectedResult, actualResult);
	}
	
	@Test(timeout = 100)
	public void testIsEvenPimeGreaterThanTwo() {		
		int num = 23;
		
		boolean actualResult = eo.isEven(num);
		boolean expectedResult = false;
		String errorMsg = "isEven(): check the value returned when num = 23";
		assertEquals(errorMsg, expectedResult, actualResult);
	}
}
