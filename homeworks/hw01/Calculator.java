public class Calculator {
    public int add(int x, int y) {
        return (x + y);
    }
    public int sub(int x, int y) {
        return (x - y);
    }
    public int mul(int x, int y) {
        return (x * y);
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(10, 20));
        System.out.println(c.sub(50, 25));
        System.out.println(c.mul(8, 8));
    }
}