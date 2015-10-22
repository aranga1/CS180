package lab11;

public class CounterDriver {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter2();
		Thread inc = new Thread(new IncThread(counter));
		Thread dec = new Thread(new DecThread(counter));
		inc.start();
		dec.start();
		inc.join();
		dec.join();
		System.out.println(counter.get());
	}
}