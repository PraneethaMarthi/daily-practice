package DAY3;
//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubArray {
	public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        
        return maxSum;
    }
	public static void main(String args[]) {
		//int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		//int[] nums= {1};
		int[] nums= {5,4,-1,7,8};
		System.out.println(maxSubArray(nums));	
	}
}
