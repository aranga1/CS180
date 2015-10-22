package lab14;

import java.util.Stack;

public class Evaluator {
	public static int evaluate(String arguments) {
		
		Stack<Integer> s = new Stack<Integer>();
		int ans = 0;
		
		if (true) {
			char[] array = arguments.toCharArray();
		
			for (int i = 0; i < array.length; i++) {
			//	System.out.println(array[i]);
			//	if (!s.isEmpty())
			//		System.out.println(s.peek());
				if (array[i] != '+' && array[i] != '-' && array[i] != '*' && array[i] != '/' && array[i] != ' ') {
					int x = Integer.parseInt("" + array[i]);
					s.push(x);
				}
				if (array[i] == '+') {
					int x = s.pop();
					int y = s.pop();
					ans = y + x;
					s.push(ans);
				}
				else if (array[i] == '-') {
					int x = s.pop();
					int y = s.pop();
					ans = y - x;
					s.push(ans);
				}
				else if (array[i] == '*' || array[i] == 'x') {
					int x = s.pop();
					int y = s.pop();
					ans = y * x;
					s.push(ans);
				}
				else if (array[i] == '/') {
					int x = s.pop();
					int y = s.pop();
					ans = y / x;
					s.push(ans);
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(evaluate("5 1 2 + 4 * + 3 -"));
	}
}
