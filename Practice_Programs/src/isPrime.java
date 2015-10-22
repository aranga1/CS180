
public class isPrime {
	public int sum1000() {
		int sum = 0;
		int ct = 0;
		for (int i = 0; ct <=1000; i++) {
			if (isPrimeNum(i)) {
				sum += i;
				ct++;
			}
		}
		return sum;
	}
	
	public boolean isPrimeNum(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		isPrime n = new isPrime();
		
		System.out.println(n.sum1000());
	}
}
