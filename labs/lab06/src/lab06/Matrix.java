package lab06;

/**
 * lab 06 Description: This algorithm identifies if a matrix (2D array) is one
 * of the following types: a-Diagonal, b-Identity, c-Upper Triangular,
 * d-Symmetric, e-Tri Diagonal Aakash Ranga, aranga@purdue.edu, lab06 Section: 1
 */

public class Matrix {
	public boolean isSymmetric(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix.length != matrix[i].length) {
				return false;// by putting the if statement here itself, we can
								// check for the length and get rid of the array
								// out of bounds exception.
			}
			for (int j = 0; j < matrix[i].length; j++) {
				if ((matrix[i][j] != matrix[j][i])) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isDiagonal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix.length != matrix[i].length) {
				return false;// by putting the if statement here itself, we can
								// check for the length and get rid of the array
								// out of bounds exception.
			}
			for (int j = 0; j < matrix[i].length; j++) {
				if (((i != j) && (matrix[i][j] != 0))) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isIdentity(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix.length != matrix[i].length) {
				return false;// by putting the if statement here itself, we can
								// check for the length and get rid of the array
								// out of bounds exception.
			}
			for (int j = 0; j < matrix[i].length; j++) {
				if (((i == j) && (matrix[i][j] != 1))
						|| ((i != j) && (matrix[i][j] != 0))) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isUpperTriangular(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix.length != matrix[i].length) {
				return false;// by putting the if statement here itself, we can
								// check for the length and get rid of the array
								// out of bounds exception.
			}
			for (int j = 0; j < matrix[i].length; j++) {
				if ((i > j) && (matrix[i][j] != 0)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isTriDiagonal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix.length != matrix[i].length) {
				return false;// by putting the if statement here itself, we can
								// check for the length and get rid of the array
								// out of bounds exception.
			}
			for (int j = 0; j < matrix[i].length; j++) {
				if ((Math.abs(i - j) > 1) && (matrix[i][j] != 0)) {
					return false;
				}
			}
		}
		return true;
	}
}
