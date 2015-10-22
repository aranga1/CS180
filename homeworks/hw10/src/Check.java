import java.awt.Toolkit;
public class Check {
	static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			Toolkit.getDefaultToolkit().beep();;
			return true;
		} catch (NumberFormatException e) {
			Toolkit.getDefaultToolkit().beep();;
			return false;
			
		}		
	}
	
	public static void main(String[] args) {
		System.out.println(isInteger("7"));
	}
}
