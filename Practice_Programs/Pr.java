public class Pr {
    public static void main(String[] args) {
        int[] someInts = new int[100];
        int sum = 0;
        for(int i : someInts){
            sum += i;
        }
        System.out.println( sum / someInts.length);
    }
}