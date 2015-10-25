import java.util.Random;
import java.util.Arrays;

public class Matrix {
	final static int BOUND = 11;
	int[][] matrix;
	int size;
	Random random = new Random();

	public Matrix(int size) {
		this.size = size;
		matrix = new int[size][size];
	}

	public void constructMatrix(String type) {
		if (type.equals("IDENTITY")) {
			constructIdentity();
		} else if (type.equals("SYMMETRIC")) {
			constructSymmetric();
		} else if (type.equals("SKEWSYMMETRIC")) {
			constructSkewSymmetric();
		} else if (type.equals("DIAGONAL")) {
			constructDiagonal();
		} else {
			constructGeneral();
		}
	}

	public void constructDiagonal() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					matrix[i][j] = random.nextInt((21) - 10);
				}
			}
		}
	}

	public void constructIdentity() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					matrix[i][j] = 1;
				}
				if (i != j) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void constructSymmetric() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i != j) {
					matrix[i][j] = random.nextInt((20) + 1) - 10;
					matrix[j][i] = matrix[i][j];
				}
				if (i == j) {
					matrix[i][j] = random.nextInt((20) + 1) - 10;
				}
			}
		}
	}

	public void constructSkewSymmetric() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i != j) {
					matrix[i][j] = random.nextInt((21) - 10);
					matrix[j][i] = (-matrix[i][j]);
				}
				if (i == j) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public void constructGeneral() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextInt((20) + 1) - 10;
			}
		}
	}

	public int computeFrobeniusOneNorm() {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				sum += Math.abs(matrix[i][j]);
			}
		}
		return sum;
	}

	public int computeOneNorm() {
		int oneNorm = 0;
		int k = 0;
		int[] largest = new int[size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				oneNorm += Math.abs(matrix[j][i]);
			}
			if (k < largest.length) {
				largest[k] = oneNorm;
			}
			oneNorm = 0;
			k++;
		}
		Arrays.sort(largest);
		return largest[size - 1];
	}

	public int computeInfinityNorm() {
		int infinityNorm = 0;
		int k = 0;
		int[] largest = new int[size];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				infinityNorm += Math.abs(matrix[i][j]);
			}
			if (k < largest.length) {
				largest[k] = infinityNorm;
			}
			infinityNorm = 0;
			k++;
		}
		Arrays.sort(largest);
		return largest[size - 1];
	}

	public void printMatrix() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%d ", matrix[i][j]);
			}
			System.out.println("");
		}
	}
}
