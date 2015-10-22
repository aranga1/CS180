
public class StringMaker {
	public String revS(String sentence) {
		StringBuilder sb = new StringBuilder(sentence);
		/**for (int i = 0; i < words.length; i++) {
			sb = new StringBuilder(words[i]);
			temp += sb.reverse() + " ";
		}*/
		return sb.reverse() + "";
	}
	
	public static void main(String args[]) {
		StringMaker s = new StringMaker();
		String sent = "This is war";
		System.out.println(s.revS(sent));
	}
}
