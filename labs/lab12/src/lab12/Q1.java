package lab12;

public class Q1 {
	public static void reverse(int num) {
		/**if (num % 10 == num) {
			System.out.println(num);
		}*/
		while (num % 10 != num) {
			int x = num % 10;
			num /= 10;
			System.out.print(x);
		}
		System.out.print(num);
	}
	
	public static void main(String[] args) {
		reverse(0001);
	}
}
