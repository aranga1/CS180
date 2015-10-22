
public class Solution {
	    public int findDuplicate(int[] nums) {
	        int j = 0;
	           for (int i = 0; i < nums.length; i++) {
	                if ((nums[i] == nums[j]) && (i != j)) {
	                	System.out.println("This happened");
	                    return nums[i];
	                }
	                if ( nums.length - j == 1) {
	                	System.out.println("Went back");
	                    i = 0;
	                    j++;
	                }
	        }
	           return 0;
	    }
	    
	    public static void main(String args[]) {
	    	Solution s = new Solution();
	    	int[] nums = {1,2,3,4,5,2,6,7,8};
	    	System.out.println(s.findDuplicate(nums));
	    }
}
