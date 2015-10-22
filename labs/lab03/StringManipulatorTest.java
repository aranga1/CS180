import static org.junit.Assert.*;
import org.junit.*;

/**
 * JUnit test case class for testing the functionality of methods from the
 * StringManipulator class.
 */
public class StringManipulatorTest {
	private StringManipulator sm;

	@Before
	public void setUp() throws Exception {
		sm = new StringManipulator();
	}

	/**
	 * Test the basic functionality of makeUserName. Don't check for correct
	 * case.
	 */
	@Test(timeout = 100)
	public void testMakeUserNameBasic() {
		String ret = sm.makeUserName("john doe");
		String message = "makeUserName(): check if username follows the basic Unix style structure";
		assertEquals(message, "jdoe", ret);
	}

	@Test(timeout = 100)
	public void testMakeUserNameLower() {
		String ret1 = sm.makeUserName("JoHN DoE");
		String message = "makeUserName(): check if your toLowerCase() setup is working, cause apparently, it isn't";
		assertEquals(message, "jdoe", ret1);
	}

	@Test(timeout = 100)
	public void testMakeEmail() {
		String ret2 = sm.makeEmail("jdoe", "Purdue.EDU");
		String message = "makeEmail(): Check if your return statement and if your toLowerCase() setup is working, cause apparently, it isn't";
		assertEquals(message, "jdoe@purdue.edu", ret2);
	}
}