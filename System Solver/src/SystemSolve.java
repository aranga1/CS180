import java.io.*;

public class SystemSolve {
	private double[][] coefficientsMatrix;
	private double[] bVector;
	private double[] solutionVector;
	private int numEquations;

	/**
	 * Solves a system of equations given as a lower-triangular matrix.
	 */
	private void forwardSolve() {
		double subVal = 0;
		solutionVector = new double[numEquations];
		for (int i = 0; i < coefficientsMatrix.length; i++) {
			subVal = 0;
			for (int j = 0; j < i; j++) {
				subVal += (solutionVector[j] * coefficientsMatrix[i][j]);
			}
			solutionVector[i] = (bVector[i] - subVal) / coefficientsMatrix[i][i];
		}
		// TODO: implement this method
	}

	/**
	 * Solves a system of equations given as an upper-triangular matrix.
	 */
	private void backwardSolve() {
		double subVal = 0;
		solutionVector = new double[numEquations];
		solutionVector[numEquations - 1] = bVector[numEquations - 1] / coefficientsMatrix[numEquations - 1][0];
		for (int i = numEquations - 2; i >= 0; i--) {
			subVal = 0;
			for (int j = i + 1; j < this.numEquations; j++) {
				subVal += (solutionVector[j] * coefficientsMatrix[i][j - i]);
			}
			solutionVector[i] = (bVector[i] - (subVal)) / coefficientsMatrix[i][0];
		}
		// TODO: implement this method
	}

	/**
	 * Reads the file at the given filename to parse and store the coefficients
	 * matrix and the bVector. The file should be a text file starting with a
	 * single integer on the first line specifying the total number of
	 * equations. The following lines contain the equations, one per line as the
	 * coefficients and b-constant. Equations are of the form:
	 * 
	 * a_0*x_0 + a_1*x_1 + ... + a_n-1*x_n-1 = b_n-1
	 * 
	 * listed in the text file as the form:
	 * 
	 * a_0,a_1,...,a_n,b_n
	 * 
	 * The equations represent a system and is given as either an upper
	 * triangular system or a lower triangular system.
	 * 
	 * @param filename
	 *            The name of the file containing the input text
	 * @throws IOException
	 */
	public double[] parseAndSolve(String filename) throws MissingVariableException, UndeterminedSystemException {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			numEquations = Integer.parseInt(reader.readLine());
			bVector = new double[numEquations];
			coefficientsMatrix = new double[numEquations][];
			System.out.println(numEquations);
			int i = 0;
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				// int i = 0;
				String[] tokens = line.split(",");
				System.out.println("tokens:" + tokens.length);
				if (tokens.length == 1) {
					reader.close();
					throw new MissingVariableException();
				}
				int commas = tokens.length;
				double[] temp = new double[tokens.length - 1];
				for (int j = 0; j < tokens.length - 1; j++) {
					System.out.println(tokens[j]);
					temp[j] = Double.parseDouble(tokens[j]);
				}
				coefficientsMatrix[i] = temp;
				bVector[i] = Double.parseDouble(tokens[tokens.length - 1]);
				if ((i > 0 && (Math.abs(commas - 1 - this.coefficientsMatrix[i - 1].length) != 1))) {
					reader.close();
					throw new UndeterminedSystemException();
				}
				i++;
			}
			System.out.println("coefficient");
			for (int k = 0; k < this.coefficientsMatrix.length; k++) {
				for (int l = 0; l < this.coefficientsMatrix[k].length; l++) {
					System.out.print(this.coefficientsMatrix[k][l] + " ");
				}
				System.out.println();
			}
			System.out.println("bvector");
			for (int k = 0; k < this.bVector.length; k++)
				System.out.println(this.bVector[k]);
			if (coefficientsMatrix[1].length > coefficientsMatrix[2].length) {
				backwardSolve();
			}
			if (coefficientsMatrix[1].length < coefficientsMatrix[2].length) {
				forwardSolve();
			}
			reader.close();
			// TODO: implement this method
			return solutionVector;
		} catch (IOException e) {
			System.out.println("IO Exception");
			return null;
		}
	}

	/**
	 * Prints the given coefficients matrix and solution vector as a system with
	 * matrix formatting as a lower triangular matrix.
	 * 
	 * @param matrix
	 *            The coefficients matrix
	 * @param vector
	 *            The solution vector
	 */
	void printLowerTriangularMatrix(double[][] matrix, double[] vector) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%.3f\t", matrix[i][j]);
			}
			for (int k = matrix.length - 1; k > i; k--) {
				System.out.print("\t");
			}
			System.out.printf("| %.3f%n", vector[i]);
		}
		System.out.println();
	}

	/**
	 * Prints the given coefficients matrix and solution vector as a system with
	 * matrix formatting as an upper triangular matrix.
	 * 
	 * @param matrix
	 *            The coefficients matrix
	 * @param vector
	 *            The solution vector
	 */
	void printUpperTriangularMatrix(double[][] matrix, double[] vector) {
		for (int i = 0; i < matrix.length; i++) {
			for (int k = 0; k < i; k++) {
				System.out.print("\t");
			}
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%.3f\t", matrix[i][j]);
			}
			System.out.printf("| %.3f%n", vector[i]);
		}
		System.out.println();
	}

	/**
	 * Prints the given vector as a column vector.
	 * 
	 * @param vector
	 *            The vector to print
	 */
	void printVector(double[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.printf("%3.3f%n", vector[i]);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		SystemSolve s = new SystemSolve();
		String filename = "upper-tri.txt";
		try {
			double[] temp = s.parseAndSolve(filename);
			System.out.println("Solution");
			for (int i = 0; i < temp.length; i++) {
				System.out.println(temp[i]);
			}
		} catch (MissingVariableException | UndeterminedSystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}