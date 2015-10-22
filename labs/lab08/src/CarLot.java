class CarLot {
	private int numVehicles;
	//Car newCar = new Car(null, null);
	public Car[] cars;
	
	/**
	 * constructor
	 * 
	 * @param the
	 *            number of vehicles in the car lot
	 */
	public CarLot(int numVehicles) {
		this.numVehicles = numVehicles;
		cars = new Car[numVehicles];
		// put your code here
	}

	/**
	 * @return the storage capacity of the car lot
	 */
	int capacity() {
		return numVehicles;
		// put your code here
		
	}

	/**
	 * @return the number of vehicles in the car lot
	 */
	int numVehicles() {
		int numCars = 0;
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				numCars++;
			}
		}
		return numCars;
		// put your code here	
	}

	/**
	 * add a vehicle to the car lot
	 * 
	 * @param car
	 *            to be added
	 * @return true if there is space for the car, false otherwise
	 */
	boolean add(Car car) {
		
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] != null) {
				continue;
			}
			else {
				cars[i] = new Car(car.getColor(), car.getMake());
				return true;
			}
		}
		return false;
		// put your code here
		
	}

	/**
	 * return the car at the specified location
	 * 
	 * @param location
	 *            from which to retrieve the car
	 * @return car at that location, or null if the location is empty
	 */
	Car get(int location) {
		if (cars[location] != null) {
			return cars[location];
		}
		else return null;
		// put your code here
		
	}

	/**
	 * remove and return the car at the specified location
	 * 
	 * @param location
	 *            of the car to remove
	 * @return car removed from that location, or null if the location is empty
	 */
	Car remove(int location) {
		if (location > numVehicles) {
			return null;
		}
		else if (cars[location] != null) {
			Car c = cars[location];
			cars[location] = null;
			return c;
		}
		else return null;
		// put your code here
		
	}

	/**
	 * search for car that match the specified make
	 * 
	 * @param make
	 *            of the car to search for
	 * @return array of boolean values indicating which spaces contain vehicles
	 *         of the specified make.
	 * 
	 *         A value of true at index n indicates that the n-th space contains
	 *         a car of the specified make (match), whereas a value of false at
	 *         index n indicates that the n-th space contains a car of a
	 *         different make (mismatch).
	 */
	boolean[] searchByMake(String make) {
		boolean[] results = new boolean[numVehicles()];
		for (int i = 0; i < cars.length; i++) {
			if (cars[i] == null) {
				continue;
			}
			else if (cars[i].getMake().equals(make)) {
				results[i] = true;
			}
			else results[i] = false;
		}
		return results;
		// put your code here
		
	}

}