package lab06;

import static org.junit.Assert.*;
import org.junit.*;

/**
 * lab 06 Description: This JUnitTest checks for border cases. Aakash Ranga,
 * aranga@purdue.edu, lab06 Section: 1
 */
public class MatrixTest {
	private Matrix x;// initialize Matrix instance variable to the required size

	@Before
	public void setUp() throws Exception {
		this.x = new Matrix();
	}

	@Test(timeout = 100)
	public void testIfSymmetric() {
		int[][] matrix = new int[3][3];
		boolean actual = x.isSymmetric(matrix);
		boolean expected = true;
		String message = "isSymmetric() check if the method is working fine";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfNotSymmetric() {
		int[][] matrix = new int[3][3];
		matrix[0][1] = 2;
		matrix[1][0] = 1;
		boolean actual = x.isSymmetric(matrix);
		boolean expected = false;
		String message = "isSymmetric() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfSymmetricWithNumbers() {
		int[][] matrix = new int[3][3];
		matrix[0][0] = 1;
		matrix[1][1] = 2;
		matrix[2][2] = 3;
		matrix[0][2] = 3;
		matrix[2][0] = 3;
		matrix[1][2] = 5;
		matrix[2][1] = 5;
		boolean actual = x.isSymmetric(matrix);
		boolean expected = true;
		String message = "isSymmetric() check if the method is working fine";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testI() {
		int[][] matrix = new int[3][3];
		boolean actual = x.isSymmetric(matrix);
		boolean expected = true;
		String message = "isSymmetric() check if the method is working fine";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfIsDiagonal() {
		int[][] matrix = new int[3][3];
		boolean actual = x.isDiagonal(matrix);
		boolean expected = true;
		String message = "isDiagonal() check if the method is working fine";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfIsNotDiagonal() {
		int[][] matrix = new int[3][3];
		matrix[2][1] = 3;
		boolean actual = x.isDiagonal(matrix);
		boolean expected = false;
		String message = "isDiagonal() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfisDiagonalWithNumbers() {
		int[][] matrix = new int[3][3];
		matrix[0][0] = 3;
		matrix[1][1] = 5;
		matrix[2][2] = 7;
		boolean actual = x.isDiagonal(matrix);
		boolean expected = true;
		String message = "isDiagonal() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfIdentity() {
		int[][] matrix = new int[3][3];
		matrix[1][1] = 1;
		matrix[0][0] = 1;
		matrix[2][2] = 1;
		boolean actual = x.isIdentity(matrix);
		boolean expected = true;
		String message = "isIdentity() check if the method is working fine";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfIsNotIdentity() {
		int[][] matrix = new int[3][3];
		matrix[1][1] = 3;
		boolean actual = x.isIdentity(matrix);
		boolean expected = false;
		String message = "isIdentity() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfIsIdentityWhenNotSquare() {
		int[][] matrix = new int[3][5];
		matrix[0][0] = 1;
		matrix[1][1] = 1;
		matrix[2][2] = 1;
		boolean actual = x.isIdentity(matrix);
		boolean expected = false;
		String message = "isIdentity() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfUpperTriangular() {
		int[][] matrix = new int[3][3];
		boolean actual = x.isUpperTriangular(matrix);
		boolean expected = true;
		String message = "isUpperTriangular() check if the method is working fine";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfIsNotUpperTriangular() {
		int[][] matrix = new int[3][3];
		matrix[2][0] = 2;
		boolean actual = x.isUpperTriangular(matrix);
		boolean expected = false;
		String message = "isSymmetric() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfUpperTriangularWhenNotSquare() {
		int[][] matrix = new int[3][4];
		matrix[0][2] = 3;
		matrix[1][2] = 5;
		boolean actual = x.isUpperTriangular(matrix);
		boolean expected = false;
		String message = "isUpperTriangular() check if the method is working fine in the first for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfNotTriDiagonal() {
		int[][] matrix = new int[3][3];
		matrix[0][2] = 2;
		boolean actual = x.isTriDiagonal(matrix);
		boolean expected = false;
		String message = "isSymmetric() check if the method is working fine in the second for loop";
		assertEquals(message, expected, actual);
	}

	@Test(timeout = 100)
	public void testIfNotSquareTriDiagonal() {
		int[][] matrix = new int[3][5];
		boolean actual = x.isTriDiagonal(matrix);
		boolean expected = false;
		String message = "isSymmetric() check if the method is working fine in the first for loop";
		assertEquals(message, expected, actual);
	}
}
