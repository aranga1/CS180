import static org.junit.Assert.*;
import org.junit.*;

public class EvenOddTest {
	
	@Test(timeout = 100)
	public void testIsEvenZero() {
		int num = 0;
		
		EvenOdd eo = new EvenOdd(); // common step
		
		boolean actualResult = eo.isEven(num);
		boolean expectedResult = true;
		String errorMsg = "isEven(): check the value returned when num = 0";
		assertEquals(errorMsg, expectedResult, actualResult);
	}
	
	@Test(timeout = 100)
	public void testIsEvenPimeGreaterThanTwo() {		
		int num = 23;
		
		EvenOdd eo = new EvenOdd(); // common step
		
		boolean actualResult = eo.isEven(num);
		boolean expectedResult = false;
		String errorMsg = "isEven(): check the value returned when num = 23";
		assertEquals(errorMsg, expectedResult, actualResult);
	}
	
	
}
