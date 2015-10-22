public class MainThread {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.printf("main thread = %s\n", t);
        
        System.out.printf("going to sleep...\n");
        
        try {
             t.sleep(5000);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        
        System.out.printf("ah, that was nice\n");
    }
}