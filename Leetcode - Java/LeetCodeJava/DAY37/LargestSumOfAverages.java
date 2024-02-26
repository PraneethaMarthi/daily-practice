package DAY37;

public class LargestSumOfAverages {
	public static double largestSumOfAverages(int[] nums, int k) {
        return solve(0, k, nums, new double[nums.length][k+1]);
    }

    private static double solve(int i, int lvl, int[] nums, double[][] memo){
        if (lvl == 0)
            return i == nums.length? 0 : -10000000;
        if (memo[i][lvl] > 0)
            return memo[i][lvl];

        double ans = 0, cur = 0;
        for (int j = i; j <= nums.length - lvl; j++){
            cur += nums[j];
            ans = Math.max(ans, cur/(j-i+1) + solve(j + 1, lvl - 1, nums, memo));
        }

        return memo[i][lvl] = ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {9,1,2,3,9};
		int k=3;
		System.out.println(largestSumOfAverages(nums,k));
	}

}
