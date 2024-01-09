package DAY20;

public class PartitionEqualSubsetSum {
	public static boolean canPartition(int[] nums) {
        int sum = 0;
      for (int i = 0; i < nums.length; i++) {
          sum += nums[i];
      }
      // If the sum is odd, we cannot partition into equal subsets
      if (sum % 2 != 0) {
          return false;
      }
      int half = sum / 2;
      int dp[][] = new int[nums.length + 1][half + 1];
      // Initialize the dp array
      for (int i = 0; i <= nums.length; i++) {
          for (int j = 0; j <= half; j++) {
              if (i == 0 || j == 0) {
                  dp[i][j] = 0;
              } else if (i - 1 == 0) {
                  if (nums[i - 1] <= j) {
                      dp[i][j] = nums[i - 1];
                  } else {
                      dp[i][j] = 0;
                  }
              } else {
                  int t1 = 0;
                  if (nums[i - 1] <= j) {
                      t1 = dp[i - 1][j - nums[i - 1]] + nums[i - 1];
                  }
                  int t2 = dp[i - 1][j];
                  dp[i][j] = Math.max(t1, t2);
              }
          }
      }
      return dp[nums.length][half] == half;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,5,11,5};
		System.out.println(canPartition(nums));
	}

}
