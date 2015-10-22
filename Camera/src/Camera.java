public class Camera {
	boolean hasWiFi;
	boolean isWaterResistant;
	boolean hasGPS;
	boolean hasZoom;
	String condition;
	double price;
	int userRating;

	public Camera(boolean hasWiFi, boolean isWaterResistant, 
		boolean hasGPS, boolean hasZoom, String condition, double price, int userRating) {
		this.hasWiFi = hasWiFi;
		this.isWaterResistant = isWaterResistant;
		this.hasGPS = hasGPS;
		this.hasZoom = hasZoom;
		this.condition = condition;
		this.price = price;
		this.userRating = userRating;
	}
	public int computeValue() {
		int value = 0;
		if (hasWiFi) {
			value += 1;
		}
		if (isWaterResistant) {
			value += 1;
		}
		if (hasGPS) {
			value += 1;
		}
		if (hasZoom) {
			value += 1;
		}
		if (condition.equals("New")) {
			value += 2;
		}
		else if (condition.equals("Refurbished")) {
			value += 1;
		}
		else {
			return value;
		}
		return value;
	}
}