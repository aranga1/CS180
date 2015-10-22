package lab12;

public class Q4 {
	public static String decimalToHex(String num) {
		
		try {
			int dec = Integer.parseInt(num);
			String ans = "";
			while (true) {
				int i = dec % 16;
				if (i == 10) {
					ans = "A" + ans;
				}
				else if (i == 11) {
					ans = "B" + ans;
				}
				else if (i == 12) {
					ans = "C" + ans;
				}
				else if (i == 13) {
					ans = "D" + ans;
				}
				else if (i == 14) {
					ans = "E" + ans;
				}
				else if (i == 15) {
					ans ="F" + ans;
				}
				else {
					ans = i + ans;
				}
				dec /= 16;
				if (dec == 0) {
					break;
				}
			}
			return ans;
		} catch (Exception e) {
			return "Not a number";
		}
		/**for (int i = num.length() - 1; i >= 0; i--) {
			int counter = 1;
			int decimal = 0;
			if (num.charAt(i) == '1') {
				decimal = 1;
			}
			else if (num.charAt(i) == '2') {
				decimal = 2;
			}
			else if (num.charAt(i) == '3') {
				decimal = 3;
			}
			else if (num.charAt(i) == '4') {
				decimal = 4;
			}
			else if (num.charAt(i) == '5') {
				decimal = 5;
			}
			else if (num.charAt(i) == '6') {
				decimal = 6;
			}
			else if (num.charAt(i) == '7') {
				decimal = 7;
			}
			else if (num.charAt(i) == '8') {
				decimal = 8;
			}
			else if (num.charAt(i) == '9') {
				decimal = 9;
			}
			int temp = decimal;
			decimal = decimal * counter;
			if (decimal < 10) {
				temp = decimal;
			}
			else decimal = decimal + temp;
			counter++;
		}*/
	}
	public static void main(String args[]) {
		System.out.println(decimalToHex("232434"));
	}
}
