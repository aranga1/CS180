public class SumFactory {
    static int totalSum = 0;
    int sum = 0;
    
    void add(int[] array) {
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        totalSum += sum;
    }
    
    int getSum() {
        return sum;
    }
    int getTotalSum() {
        return totalSum;
    }
    
    public static void main(String[] args) {
        SumFactory s1 = new SumFactory();
        SumFactory s2 = new SumFactory();
        SumFactory s3 = new SumFactory();
        s1.add(new int[]{1, 2, 3});
        s2.add(new int[]{100, 200, 300});
        s3.add(new int[]{16, 32, 64, 128, 256});
        System.out.println(s1.getSum()); //prints "6"
        System.out.println(s2.getSum()); //prints "600"
        System.out.println(s3.getSum()); //prints "496"
        System.out.println(s1.getTotalSum()); //prints "1102
    }
}