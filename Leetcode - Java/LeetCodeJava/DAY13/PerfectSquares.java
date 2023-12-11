package DAY13;

public class PerfectSquares {
	public static int numSquares(int n) {
        int[] dp = new int[n + 1];
	dp[0] = 0;
	
	for (int i = 1; i <= n; i++) {
		dp[i] = i;
		
		for (int j = 1; j * j <= i; j++) {
			int square = j * j;
			dp[i] = Math.min(dp[i], 1 + dp[i - square]);
		}
	}
	
	return dp[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(12));
	}

}
