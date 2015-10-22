import java.util.LinkedList;
import java.util.Scanner;

public class LLPractice {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		LLPractice p = new LLPractice();
		String ansEnd = "";
		LinkedList<String> list = new LinkedList<String>();
		String[] array = {"Dog", "Cow", "Cat", "Eehita", "Gunjan", "East", "West", "South"};
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		System.out.println("Here is the current linked list:");
		p.printLL(list);
		while (ansEnd != "yes") {
			System.out.println("Choose what you would like to do:");
			System.out.println("1: Remove item");
			System.out.println("2: Remove multiple items");
			System.out.println("3: Add item");
			int ans = s.nextInt();
			
			switch (ans) {
			case 1:
				System.out.println("Which item would you like to remove? (Enter a number)");
				int ans1 = s.nextInt();
				if (ans1 > list.size()) {
					System.out.println("Element at that index doesn't exist!");
					break;
				}
				p.remove(list, ans1);
				p.printLL(list);
				break;
				
			case 2:
				System.out.println("Which items would you like to remove? (Enter a number range)");
				int ans1a = s.nextInt();
				int ans2 = s.nextInt();
				if (ans1a > list.size() || ans2 > list.size()) {
					System.out.println("No item exists at that index");
					break;
				}
				p.removeMultiple(list, ans1a, ans2);
				p.printLL(list);
				break;
				
			case 3: 
				System.out.println("What would you like to add? (Type any word!)");
				String ans1b = s.next();
				p.add(list, ans1b);
				p.printLL(list);
				break;
			}
			
			System.out.println("Do you want to quit?");
			ansEnd = s.next();
		}
		s.close();

	}
	
	public void printLL(LinkedList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%s \n", list.get(i));
		}
	}
	
	public void remove(LinkedList<String> list, int element) {
		list.remove(element);
	}
	
	public LinkedList<String> removeMultiple(LinkedList<String> list, int start, int end) {
		if (start > end) {
			System.out.println("Start more than end");
			return null;
		}
		for (int i = start; i < end; i++) {
			list.remove(i);
		}
		return list;
	}
	
	public void add(LinkedList<String> list, String s) {
		list.add(s);
	}
}
