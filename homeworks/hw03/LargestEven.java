public class LargestEven {
    public int largestEven(int x, int y, int z) {
        if ((x % 2 != 0) && (y % 2 != 0) && (z % 2 != 0)) {
            return 0;
        }
        if ((x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0)) {
            if ((x > y) && (x > z)) {
                return x;
            }
            if ((y > x) && (y > z)) {
                return y;
            }
            if ((z > x) && (z > y)) {
                return z;
            }
        }
        if ((x % 2 == 0) && (y % 2 == 0)) {
            if (x > y) {
                return x;
            }
            else return y;
        }
        if ((y % 2 == 0) && (z % 2 == 0)) {
            if (y > z) {
                return y;
            }
            else return z;
        }
        if ((x % 2 == 0) && (z % 2 == 0)) {
            if (x > z) {
                return x;
            }
            else return z;
        }
        if (x % 2 == 0) {
            return x;
        }
        if (y % 2 == 0) {
            return y;
        }
        if (z % 2 == 0) {
            return z;
        }
        return 0;
    }
    public static void main(String[] args) {
        LargestEven l = new LargestEven();
        System.out.println(l.largestEven(1, 3, 5));
        System.out.println(l.largestEven(2, 4, 9));
        System.out.println(l.largestEven(2, 1001, 1003));
    }
}
            