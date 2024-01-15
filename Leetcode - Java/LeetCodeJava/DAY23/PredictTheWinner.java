package DAY23;

import java.util.Arrays;

public class PredictTheWinner {
	public static boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        
        if(n%2==0)
            return true;   
        
        int[][] dp = new int[n][n];
        
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        
        
        return util(0, n-1, nums, dp)>=0;
    }
    
    public static int util(int left, int right, int[] nums, int[][] dp){
        
        if(left==right){
          return nums[left];
        }
        
        if(dp[left][right]!=-1){
            return dp[left][right];
        }
        
        int x = nums[left]-util(left+1, right, nums, dp);
        int y = nums[right]-util(left, right-1, nums, dp);
        
        return dp[left][right]=Math.max(x, y);   
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,5,2};
		System.out.println(predictTheWinner(nums));
	}

}
