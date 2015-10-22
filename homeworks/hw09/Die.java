public class Die {
	int roll() {
		return ((int) (Math.random() * 6) + 1);
	}

	public static void main(String args[]) {
		Die d = new Die();
		System.out.println(d.roll());
		WeightedDie d1 = new WeightedDie();
		System.out.println(d1.roll());
	}
}

class WeightedDie extends Die {
	int roll() {
		if (Math.random() < 0.5) {
			return super.roll();
		}
		return 6;
	}
}