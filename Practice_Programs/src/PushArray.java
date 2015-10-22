
public class PushArray {
	public int[] pushArr(int[] array) {
		int[] newA = new int[array.length];
		int j = 0;
		newA[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] == array[i-1]) {
				array[array.length - i] = array[i];
				continue;
			}
			newA[j] = array[i];
			j++;
		}
		return newA;
	}
	
	public static void main(String args[]) {
		PushArray p = new PushArray();
		int[] array = {0,1,1,2,2,3};
		int[] array1 = p.pushArr(array);
		
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + " ");
		}
	}
}
