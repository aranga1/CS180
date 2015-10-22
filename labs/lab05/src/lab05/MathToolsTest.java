package lab05;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * JUnit test cases for MathTools.
 * 
 * @author Neil Allison, nalliso@purdue.edu
 *
 */
public class MathToolsTest {
	private final double DELTA = 0.000001;
	
	@Test(timeout = 100)
	public void testAbsoluteValueLessThanZero() {
		double actual = MathTools.absoluteValue(-42);
		double expected = 42;
		String message = "absoluteValue(): check when value is negative";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testAbsoluteValueEqualToZero() {
		double actual = MathTools.absoluteValue(0);
		double expected = 0;
		String message = "absoluteValue(): check when value is 0";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testAbsoluteValueGreaterThanZero() {
		double actual = MathTools.absoluteValue(42);
		double expected = 42;
		String message = "absoluteValue(): check when value is positive";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerBaseLessThanZeroExponentEven() {
		double actual = MathTools.power(-3, 2);
		double expected = 9;
		String message = "power(): check when the base is negative and exponent is even";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerBaseLessThanZeroExponentOdd() {
		double actual = MathTools.power(-3, 3);
		double expected = -27;
		String message = "power(): check when base is negative and exponent is odd";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerBaseEqualZero() {
		double actual = MathTools.power(0, 2);
		double expected = 0;
		String message = "power(): check when base is zero and exponent non-zero";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerBaseGreaterThanZeroExponentEven() {
		double actual = MathTools.power(3, 2);
		double expected = 9;
		String message = "power(): check when base is positive and exponent is even";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testBaseGreaterThanZeroExponentOdd() {
		double actual = MathTools.power(3, 3);
		double expected = 27;
		String message = "power(): check when base is positive and exponent is odd";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerExponentLessThanZero() {
		double actual = MathTools.power(3, -2);
		double expected = 0.11111111;
		String message = "power(): check when base is non-zero and exponent is negative";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerExponentZero() {
		double actual = MathTools.power(3, 0);
		double expected = 1;
		String message = "power(): check when base is non-zero and exponent is zero";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testPowerExponentGreaterThanZero() {
		double actual = MathTools.power(7, 6);
		double expected = 117649;
		String message = "power(): check when base is positive and exponent is even";
		assertEquals(message, expected, actual, DELTA);
	}
	
	@Test(timeout = 100)
	public void testScientificNotationNoShift() {
		String actual = MathTools.scientificNotation(1.2345678);
		String expected = "1.234567 x 10 ^ 0";
		String message = "scientificNotation(): check when no shift is needed";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testScientificNotationShiftLeft() {
		String actual = MathTools.scientificNotation(1234.5678);
		String expected = "1.234567 x 10 ^ 3";
		String message = "scientificNotation(): check when decimal must shift left";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testScientificNotationShiftRight() {
		String actual = MathTools.scientificNotation(0.00012345678);
		String expected = "1.234567 x 10 ^ -4";
		String message = "scientificNotation(): check when decimal must shift right";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testScientificNotationEqualOne() {
		String actual = MathTools.scientificNotation(1);
		String expected = "1.0 x 10 ^ 0";
		String message = "scientificNotation(): check border case when number is 1";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testScientificNotationEqualTen() {
		String actual = MathTools.scientificNotation(10);
		String expected = "1.0 x 10 ^ 1";
		String message = "scientificNotation(): check border case when number is 10";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testScientificNotationEqualMillion() {
		String actual = MathTools.scientificNotation(1000000);
		String expected = "1.0 x 10 ^ 6";
		String message = "scientificNotation(): check for 7 digit number with result 1 decimal place";
		assertEquals(message, expected, actual);
	}
}
