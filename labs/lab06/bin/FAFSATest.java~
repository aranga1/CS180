import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test cases for FAFSA.
 * 
 * @author Neil Allison, nalliso@purdue.edu
 *
 */
public class FAFSATest {

	@Test(timeout = 100)
	public void testEligibilityNotAcceptedStudent() {
		FAFSA s = new FAFSA(false, true, true, true, true, 0, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when isAcceptedStudent is false";
		assertFalse(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilityNotSSRegisteredInAgeRange() {
		FAFSA s = new FAFSA(true, false, true, true, true, 18, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when isSSregistered is false and in age range for this criteria";
		assertFalse(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilityNotSSRegisteredNotInAgeRange() {
		FAFSA s = new FAFSA(true, false, true, true, true, 26, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when isSSregistered is false and not in age range for this criteria";
		assertTrue(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilitySSRegisteredInAgeRange() {
		FAFSA s = new FAFSA(true, true, true, true, true, 25, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when isSSregistered is true and in age range for this criteria";
		assertTrue(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilitySSRegisteredNotInAgeRange() {
		FAFSA s = new FAFSA(true, true, true, true, true, 17, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when isSSregistered is true and not in age range for this criteria";
		assertTrue(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilityNoSSN() {
		FAFSA s = new FAFSA(true, true, false, true, true, 0, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when hasSSN is false";
		assertFalse(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilityNoResidencyStatus() {
		FAFSA s = new FAFSA(true, true, true, false, true, 0, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when hasValidResidency is false";
		assertFalse(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilityAllEligibilityFalse() {
		FAFSA s = new FAFSA(false, false, false, false, true, 0, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when all eligiblity requirements are false";
		assertFalse(message, actual);
	}

	@Test(timeout = 100)
	public void testEligibilityAllEligibilityTrue() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 0, 0, 0, null);

		boolean actual = s.isFederalAidEligible();
		String message = "isFederalAidEligible(): check when all eligibility requirements are true";
		assertTrue(message, actual);
	}

	@Test(timeout = 100)
	public void testWorkStudyEFCGreaterThan50000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 50001, 0, null);

		double expected = 0;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC greater than 50,000";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testWorkStudyEFCEqualTo50000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 50000, 0, null);

		double expected = 500;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC equal to 50,000";

		assertEquals(message, expected, actual, delta);

	}

	@Test(timeout = 100)
	public void testWorkStudyEFCGreaterThan40000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 40001, 0, null);

		double expected = 500;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC greater than 40,000";

		assertEquals(message, expected, actual, delta);

	}

	@Test(timeout = 100)
	public void testWorkSTudyEFCEqualTo40000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 40000, 0, null);

		double expected = 1000;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC equal to 40,000";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testWorkStudyEFCGreaterThan30000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 30001, 0, null);

		double expected = 1000;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC greater than 30,000";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testWorkStudyEFCEqualTo30000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 30000, 0, null);

		double expected = 1500;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC equal to 30,000";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testWorkStudyEFCLessThan30000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 29999, 0, null);

		double expected = 1500;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC less than 30,000";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testWorkStudyEFCEqualTo0() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 0, 0, null);

		double expected = 1500;
		double actual = s.calcWorkStudy();
		double delta = 0.001;
		String message = "calcWorkStudy(): check EFC equal to 0";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testGrantEFCGreaterThan50000() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 50001, 0, "");

		double expected = 0;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check EFC greater than 50,000";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testGrantUndergraduateCreditsLessThan9() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 8, 50000, 0, "UNDERGRADUATE");

		double expected = 2500;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check classStanding is undergraduate and creditHours less than 9";

		assertEquals(message, expected, actual, delta);
	}
	
	@Test(timeout = 100)
	public void testGrantGraduateCreditsLessThan9() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 8, 50000, 0, "GRADUATE");

		double expected = 0;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check classStanding is graduate and creditHours less than 9";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testGrantUndergraduateCreditsGreaterThanEqual9() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 9, 50000, 0, "UNDERGRADUATE");

		double expected = 5775;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check classStanding is undergraduate and creditHours greater than 8";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testGrantGraduateCreditsGreaterThanEqual9() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 9, 50000, 0, "GRADUATE");

		double expected = 0;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check classStanding is graduate and creditHours greater than 8";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testGrantClassStandingMisspelled() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 12, 50000, 0, "incorrect");

		double expected = 0;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check classStanding is an unexpected value";

		assertEquals(message, expected, actual, delta);
	}
	
	@Test(timeout = 100)
	public void testGrantClassStandingNull() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 12, 50000, 0, null);

		double expected = 0;
		double actual = s.calcFederalGrant();
		double delta = 0.001;
		String message = "calcFederalGrant(): check classStanding is null";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testLoanClassStandingNull() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 0, 0, 0, null);

		double expected = 0;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check classStanding is null";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testLoanCreditsHoursLessThan9() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 8, 0, 0, "UNDERGRADUATE");

		double expected = 0;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check creditHours less than 9";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testLoanDependentUndergraduate() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 9, 0, 0, "UNDERGRADUATE");

		double expected = 5000;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check dependent and undergraduate";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testLoanDependentGraduate() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 9, 0, 0, "GRADUATE");

		double expected = 10000;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check dependent and graduate";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testLoanIndependentUndergraduate() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 9, 0, 0, "UNDERGRADUATE");

		double expected = 10000;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check independent and undergraduate";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testLoanIndependentGraduate() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 9, 0, 0, "GRADUATE");

		double expected = 20000;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check independent and graduate";

		assertEquals(message, expected, actual, delta);
	}
	
	@Test(timeout = 100)
	public void testLoanIndependentMisspelled() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 9, 0, 0, "incorrect");

		double expected = 0;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check independent and classStanding is an unexpected value";

		assertEquals(message, expected, actual, delta);
	}
	
	@Test(timeout = 100)
	public void testLoanDependentMisspelled() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 9, 0, 0, "incorrect");

		double expected = 0;
		double actual = s.calcStaffordLoan();
		double delta = 0.001;
		String message = "calcStaffordLoan(): check dependent and classStanding is an unexpected value";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testEFCDependent() {
		FAFSA s = new FAFSA(true, true, true, true, true, 0, 0, 100.01, 100.01, null);

		double expected = 200.02;
		double actual = s.calcEFC();
		double delta = 0.001;
		String message = "calcEFC(): check student is dependent";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testEFCIndependent() {
		FAFSA s = new FAFSA(true, true, true, true, false, 0, 0, 100.01, 100.01, null);

		double expected = 100.01;
		double actual = s.calcEFC();
		double delta = 0.001;
		String message = "calcEFC(): check student is independent";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testFederalAidAmountNonEligible() {
		FAFSA s = new FAFSA(false, false, false, false, false, 0, 0, 0, 0, null);

		double expected = 0;
		double actual = s.calcFederalAidAmount();
		double delta = 0.001;
		String message = "calcFederalAidAmount(): check all eligibility is false";

		assertEquals(message, expected, actual, delta);
	}
	
	@Test(timeout = 100)
	public void testFederalAidAmountEligibleNoAward() {
		FAFSA s = new FAFSA(true, true, true, true, false, 18, 8, 100000, 0, "GRADUATE");

		double expected = 0;
		double actual = s.calcFederalAidAmount();
		double delta = 0.001;
		String message = "calcFederalAidAmount(): check eligible, independent, 18 years old, less than 9 credit hours, EFC 100,000, and graduate";

		assertEquals(message, expected, actual, delta);
	}

	@Test(timeout = 100)
	public void testFederalAidAmountEligibleFullAwardUndergraduate() {
		FAFSA s = new FAFSA(true, true, true, true, false, 18, 9, 0, 0, "UNDERGRADUATE");

		double expected = 17275;
		double actual = s.calcFederalAidAmount();
		double delta = 0.001;
		String message = "calcFederalAidAmount(): check eligible, independent, 18 years old, greater than 8 credit hours, EFC 0, and undergraduate";

		assertEquals(message, expected, actual, delta);
	}
	
	@Test(timeout = 100)
	public void testFederalAidAmountEligibileFullAwardGraduate() {
		FAFSA s = new FAFSA(true, true, true, true, false, 18, 12, 0, 0, "GRADUATE");

		double expected = 21500;
		double actual = s.calcFederalAidAmount();
		double delta = 0.001;
		String message = "calcFederalAidAmount(): check eligible, independent, 18 years old, greater than 11 credit hours, EFC 0, and graduate";

		assertEquals(message, expected, actual, delta);
	}
}
