package lab11;

public class A extends Thread {
	public void run() {
		while (true) {
			System.out.println("A");
			Thread.yield();
		}
	}

	public static void main(String[] args) {
		Thread t = new A();
		t.start();
	}
}