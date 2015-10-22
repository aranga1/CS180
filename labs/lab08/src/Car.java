class Car {
	private String color;
	private String make;
	/**
	 * @param color
	 *            of the car
	 * @param make
	 *            of the car
	 */
	public Car(String color, String make) {
		this.color = color;
		this.make = make;// put your code here.
	}

	/**
	 * @return the make of the vehicle
	 */
	String getMake() {
		if (make == null) {
			return "";
		}
		return make;
		// put your code here.
		
	}

	/**
	 * @return the color of the vehicle
	 */
	String getColor() {
		if (color == null) {
			return "";
		}
		return color;
		// put your code here.
		
	}
}