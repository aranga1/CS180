package lab12;

public class Q3 {
	public static int findGCD(int num1, int num2) {
			int result = 1;
			for (int i = 1; i < num1 || i < num2; i++) {
				if (num1 % i == 0 && num2 % i == 0) {
					result = i;
				}
			}
			return result;
	}
	
	public static void main(String[] args) {
		System.out.println(findGCD(30,27));
	}
}
