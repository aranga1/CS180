import java.util.Arrays;

public class RandomNumber {
	public static void main(String[] args){ 
		int[] A = {2,5,6,1,2,3,6,9,10,55,1,44,45,54,53}; 
		
		Arrays.sort(A);
		System.out.println(A[A.length-3]);
		
		/*int a=A[0],b=A[0],c=A[0]; 
		for(int i=0;i<A.length;i++) { 
			if(a<A[i]) 
				a=A[i]; 
			if(b<A[i]) 
				if(A[i]!=a) 
					b=A[i]; 
			if(c<A[i]) 
				if(A[i]!=a&&A[i]!=b) 
					c=A[i]; 
			} 
		System.out.println(a); 
		System.out.println(b); 
		System.out.println(c); 
		*/
		}
}
