package lab05;

public class MathTools {
	public static double absoluteValue(double n) {
		if ( n < 0) {
			return -n;
		}
		return n;
		}
	public static double power(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent < 0) {
			double result = 1;
			for (int i = 0; i < -exponent; i++) {
				result *= base;
			}
			return (1 / result);
		}
		if (exponent > 0) {
			double result = 1;
			for (int i = 0; i < exponent; i++) {
				result *= base;
			}
			return result;
		}
		return 0;
	}
	public static String scientificNotation(double n) {
		if (n < 0) {
			n = MathTools.absoluteValue(n);
		}
		if (n < 1) {
			int i = 0;
			while (n < 1) {
				n = n * 10;
				i++;
			}
			n = ((int)(n * 1000000)) / 1000000.0;
			String ans = ( n + " x 10 ^ " + "-" + i );
			return ans;
		}
		else if (n >= 10) {
			int i = 0;
			while (n >= 10) {
				n = n / 10;
				i++;
			}
			n = ((int)(n * 1000000)) / 1000000.0;
			String ans = ( n + " x 10 ^ " + i );
			return ans;
		}
		else {
			n = ((int)(n * 1000000)) / 1000000.0;
			String ans =  n + " x 10 ^ 0";
			return ans;
		}
	}
}
