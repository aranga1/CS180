package lab12;

public class Q2 {
	public static boolean isAscending(int[] array) {
		if (array == null) {
			return false;
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i - 1] + 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {0,4,7,16,24};
		System.out.println(isAscending(arr));
	}
}
