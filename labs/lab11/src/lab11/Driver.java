package lab11;

public class Driver {
	public static void main(String[] args) {
		Thread t = new A();
		Runnable r = new B();
		Thread t1 = new Thread(r);
		t.start();
		t1.start();
	}
}
