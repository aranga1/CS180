/**
 * HW 05
 * This code takes an array and gives out the sum and the average of its contents
 * Aakash Ranga, aranga@purdue.edu
*/
public class Array {
    double array[] = new double[10];
    
    public Array(double [] array) {
        this.array = array;
    }
    public double sum() {
        if (array == null) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    public double average() {
        if (array == null) {
            return 0;
        }
        double average = 0;
        int i = 0;
        for (i = 0; i < array.length; i++) {
            average += array[i];
        }
        average /= i;
        return average;
    }
    public static void main(String[] args) {
        double array[] = new double[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Array x = new Array(array);
        System.out.println(x.sum());
        System.out.println(x.average());
    }
}
        