public class Factory {

	public static void main(String[] args) {

		SorterFirstGeneration sort = new SorterFirstGeneration();
		PiecesFactory fact = new PiecesFactory();

		String[] triangleSpecs = fact.getNext();

		while (triangleSpecs != null) {
			/* Construct the triangle */
			Triangle t;

			if (triangleSpecs[0].equals("S")) {
				int l1 = Integer.parseInt(triangleSpecs[1]);
				int l2 = Integer.parseInt(triangleSpecs[2]);
				int l3 = Integer.parseInt(triangleSpecs[3]);
				t = new Triangle(l1, l2, l3);
			} else {
				int l1 = Integer.parseInt(triangleSpecs[1]);
				int l2 = Integer.parseInt(triangleSpecs[2]);
				double l3 = Math.toRadians(Double.parseDouble(triangleSpecs[3]));
				t = new Triangle(l1, l2, l3);
			}

			/* Sort the triangle */
			sort.sort(t);

			/* get the next specifications */
			triangleSpecs = fact.getNext();
		}

		sort.printStatistics();
	}
}