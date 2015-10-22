import java.util.Scanner;

public class Calculator {
    public int sum(String s) {
        Scanner in = new Scanner(s);
        int sum = 0;
        int x = 0;
        while (in.hasNextInt()) {
            x = in.nextInt();
            sum += x;
        }
        return sum;
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
        Scanner s = new Scanner(System.in);
        String x = s.nextLine();
        System.out.println(c.sum(x));
    }
}
        