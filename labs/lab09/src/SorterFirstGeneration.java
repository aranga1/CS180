public class SorterFirstGeneration {
	private Triangle[] small;
	private Triangle[] medium;
	private Triangle[] large;

	private int nSmall;
	private int nMedium;
	private int nLarge;

	public SorterFirstGeneration() {
		this.small = new Triangle[5];
		this.medium = new Triangle[5];
		this.large = new Triangle[5];

		this.nSmall = 0;
		this.nMedium = 0;
		this.nLarge = 0;
	}

	/**
	 * Add the triangle in the right container and update the statistics.
	 */
	public void sort(Triangle p) {
		if (p.area() < 10) {
			for (int i = 0; i < small.length; i++) {
				if (small[i] == null) {
					small[i] = p;
				}
				else continue;
			}
			nSmall++;
		}
		else if (p.area() > 10 && p.area() < 50) {
			for (int i = 0; i < medium.length; i++) {
				if (medium[i] == null) {
					medium[i] = p;
				}
				else continue;
			}
			nMedium++;
		}
		else {
			for (int i = 0; i < large.length; i++) {
				if (large[i] == null) {
					large[i] = p;
				}
				else continue;
			}
			nLarge++;
		}
		// put your code here
	}

	/**
	 * This function check the state of the three arrays. If one of them is
	 * full, it constructs a new array with one more element and transfers all
	 * the Triangles.
	 */
	public void checkAndExpand() {
		if (nLarge >= large.length) {
			Triangle[] temp = large;
			large = new Triangle[temp.length + 1];
			for (int i = 0; i < temp.length; i++) {
				large[i] = temp[i];
			}
		}
		if (nMedium >= medium.length) {
			Triangle[] temp = medium;
			medium = new Triangle[temp.length + 1];
			for (int i = 0; i < temp.length; i++) {
				medium[i] = temp[i];
			}
		}
		if (nSmall >= small.length) {
			Triangle[] temp = small;
			small = new Triangle[temp.length + 1];
			for (int i = 0; i < temp.length; i++) {
				small[i] = temp[i];
			}
		} 	
	}
		// put your code here

	public void printStatistics() {
		System.out.printf("There are currently %d triangle in stock:\n",
				this.nSmall + this.nMedium + this.nLarge);
		System.out.printf(" - %d small\n", this.nSmall);
		System.out.printf(" - %d medium\n", this.nMedium);
		System.out.printf(" - %d large\n\n", this.nLarge);
	}
}