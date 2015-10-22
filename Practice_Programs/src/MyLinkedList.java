
public class MyLinkedList {
	private Node head;
	private int size;
	
	private class Node {
		Node link;
		String value;
		
		public Node(String value) {
			this.value = value;
			size++;
		}
	}
	
	public MyLinkedList() {
		head = null;
		size = 0;
	}
	
	public void add(String element) {
		Node node = new Node(element);
		node.link = head;
		head = node;
	}
	
	public void remove(int elementX) {
		if (elementX > size) {
			System.out.println("Ain't happening! This aint happening as there aren't enough values");
		}
		else if (elementX == 0) {
			head.link = head;
		}
		else {
			int i = 0;
			Node node = head;
			while (i < elementX - 1) {
				node = node.link;
				i++;
			}
			node = node.link.link;
		}
	}
	
	public void printList() {
		//with array
		///*
		String[] arrayTemp = new String[size];
		int i = 0;
		Node node = head;
		while (node != null) {
			arrayTemp[i++] = node.value;
			node = node.link;
		}
		for (int j = arrayTemp.length - 1; j >= 0; j--) {
			System.out.printf("%s\n", arrayTemp[j]);
		}
		//**/
		//without array
	}
	
	public static void main(String args[]) {
		MyLinkedList ML = new MyLinkedList();
		ML.add("Aakash");
		ML.add("Eehita");
		ML.add("Gunjan");
		ML.printList();
	}
}
