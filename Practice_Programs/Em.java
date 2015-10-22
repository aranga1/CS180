import java.util.Arrays;
public class Em {
public int[] maxEnd3(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        nums[i] = nums[nums.length-1];
    }
    return nums;
    }
}
