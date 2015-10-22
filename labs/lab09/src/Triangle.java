public class Triangle {
	private int l1;
	private int l2;
	private int l3;
	private double angle;
	private double angle2;
	private double angle3;
	
	
	/* Constructor with 3 sides */
	public Triangle(int l1, int l2, int l3) {
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
		angle = angleFromSides(l1, l2, l3);
		angle2 = angleFromSides(l2, l3, l1);
		angle3 = angleFromSides(l3, l1, l2);
		
	}
	 
	/* Constructor with 2 sides and the included angle */
	public Triangle(int l1, int l2, double angle) {
		this(l1, l2, (int) oppSide(angle, l1, l2));	
	}
	 
	/* compute the perimeter */
	public double perimeter() {
		return (l1 + l2 + l3);
	}
	 
	/* compute the area */
	public double area() {
		return (0.5 * l1 * l2 * Math.sin(angle));
	}
	
	public static double area(int l1, int l2, double angle) {
		return (0.5 * l1 * l2 * Math.sin(angle));
	}
	// Auxiliary functions given

	

	/**
	 * This functions computes the included angles of a triangle
	 * 
	 * @param adj1
	 *            one of the adjacent side
	 * @param adj2
	 *            the other adjacent side
	 * @param opp
	 *            the opposite side
	 */
	public static double angleFromSides(double adj1, double adj2, double opp) {
		
		double pythagoras = opp * opp - adj1 * adj1 - adj2 * adj2;
		if (pythagoras >= 0)
			return Math.acos(pythagoras / (2 * adj1 * adj2));
		else
			return Math.PI - Math.acos(-pythagoras / (2 * adj1 * adj2));
	}

	/**
	 * This functions computes the length of the opposite side
	 * 
	 * @param angle
	 *            the included angle
	 * @param adj1
	 *            one of the adjacent side
	 * @param adj2
	 *            the other adjacent side
	 */
	public static double oppSide(double angle, double adj1, double adj2) {
		
		return Math.sqrt(adj1 * adj1 - 2 * adj1 * adj2 * Math.cos(angle) + adj2
				* adj2);
	}

}
