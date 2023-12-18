package DAY18;

public class CombinationSumIV {
	public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1; i <= target; i++) {
            for(int j : nums) {
                if(i - j >= 0) {
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[target];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3};
		int target=4;
		System.out.println(combinationSum4(nums,target));
	}

}
