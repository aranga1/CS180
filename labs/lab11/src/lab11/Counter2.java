package lab11;
import java.util.concurrent.atomic.*;


public class Counter2 implements Counter {
	private AtomicInteger value = new AtomicInteger(0);
	
	public synchronized void inc() {
		value.getAndIncrement();
	}

	public synchronized void dec() {
		value.getAndDecrement();
	}

	public synchronized int get() {
		return value.get();
	}
}
