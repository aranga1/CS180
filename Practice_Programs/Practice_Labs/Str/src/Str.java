
public class Str {
	
	    public static void main(String args[]) {
	        String[] x = {"a","b","c","d"};
	        for (int i = 0; i < x.length / 2; i++) {
	        	String a = x[i];
	        	x[i] = x[x.length - i - 1];
	        	x[x.length - i - 1] = a;
	        }
	        for (int b = 0; b < x.length; b++) {
	        	System.out.println(x[b]);
	        }
	    }
	}
