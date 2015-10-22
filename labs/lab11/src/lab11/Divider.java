package lab11;
import java.util.concurrent.atomic.*;
public class Divider extends Thread {
	private static AtomicInteger counter = new AtomicInteger(0);
	private int start;
	private int end;
	
	public Divider(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public synchronized void run() {
			for (int i = start; i <= end; i++) {
				if (i % 7 == 0) {
					counter.getAndIncrement();
				}
			}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Divider(1, 1000);
		Thread t2 = new Divider(1001, 2000);
		Thread t3 = new Divider(2001, 3000);
		
		t1.start();
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.out.println("Big Problem");
		}
		System.out.println("Your answer is: " + counter.get());
	}
}
