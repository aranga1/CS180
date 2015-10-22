import static org.junit.Assert.*;

import org.junit.Test;


public class lab08Test {
	private Car c;
	private CarLot x;
	
	@Test(timeout = 100)
	public void testgetMake() {
		c = new Car("red" , "ford");
		String actual = c.getMake();
		String expected = "ford";
		String message = "getMake() check if method is working properly";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testgetMakeWhenNull() {
		c = new Car("red" , null);
		String actual = c.getMake();
		String expected = "";
		String message = "getMake() check if method is working properly when input String is null";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testgetColor() {
		c = new Car("red" , "ford");
		String actual = c.getColor();
		String expected = "red";
		String message = "getColor() check if method is working properly";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testgetColorWhenNull() {
		c = new Car(null, "ford");
		String actual = c.getColor();
		String expected = "";
		String message = "getColor() check if method is working properly when input String is null";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void testCapacity() {
		x = new CarLot(10);
		int actual = x.capacity();
		int expected = 10;
		String message = "capacity() check if method is working properly";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void numVehicles() {
		x = new CarLot(10);
		int actual = x.numVehicles();
		int expected = 0;
		String message = "numVehicles() check if method is working properly";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void numVehiclesWhenCarPresent() {
		x = new CarLot(10);
		x.cars[3] = new Car("red", "chevy");
		int actual = x.numVehicles();
		int expected = 1;
		String message = "numVehicles() check if method is working properly";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void addCar() {
		x = new CarLot(1);
		boolean actual = x.add(new Car("Black" , "Mustang"));
		boolean expected = true;
		String message = "add() check if method is working properly";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void addCarWhenNoSpace() {
		x = new CarLot(1);
		x.cars[0] = new Car("red", "chevy");
		boolean actual = x.add(new Car("Black" , "Mustang"));
		boolean expected = false;
		String message = "add() check if method is working properly when no space is present";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void getCar() {
		x = new CarLot(1);
		x.cars[0] = new Car("red", "chevy");
		Car actual = x.get(0);
		Car expected = x.cars[0];
		String message = "get() check if method is working properly when car is present";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void getCarWhenNoCar() {
		x = new CarLot(1);
		Car actual = x.get(0);
		Car expected = null;
		String message = "get() check if method is working properly when no car is present";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void removeCar() {
		x = new CarLot(1);
		x.cars[0] = new Car("red", "chevy");
		Car actual = x.remove(0);
		Car expected = x.cars[0];
		String message = "remove() check if method is working properly when a car is present";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void removeCarWhenNoCar() {
		x = new CarLot(1);
		Car actual = x.remove(0);
		Car expected = null;
		String message = "remove() check if method is working properly when no car is present";
		assertEquals(message, expected, actual);
	}
	
	@Test(timeout = 100)
	public void searchByMake() {
		x = new CarLot(1);
		x.cars[0] = new Car("red", "chevy");
		boolean[] actual = x.searchByMake("chevy");
		boolean[] expected = {true};
		String message = "searchByMake() check if method is working properly when no space is present";
		assertEquals(message, expected[0], actual[0]);
	}
	
	@Test(timeout = 100)
	public void searchByMakeWhenMoreThanOneCarPresent() {
		x = new CarLot(2);
		x.cars[0] = new Car("red", "chevy");
		x.cars[1] = new Car("red", "chevy");
		boolean[] actual = x.searchByMake("chevy");
		boolean[] expected = {true, true};
		String message = "searchByMake() check if method is working properly when no space is present";
		assertEquals(message, expected[0], actual[0]);
		assertEquals(message, expected[1], actual[1]);
	}
	
	@Test(timeout = 100)
	public void searchByMakeWhenNoCars() {
		x = new CarLot(2);
		x.cars[0] = new Car("red", "chevy");
		x.cars[1] = new Car("red", "chevy");
		boolean[] actual = x.searchByMake("ford");
		boolean[] expected = {false, false};
		String message = "searchByMake() check if method is working properly when no current make is present";
		assertEquals(message, expected[0], actual[0]);
		assertEquals(message, expected[1], actual[1]);
	}
}
