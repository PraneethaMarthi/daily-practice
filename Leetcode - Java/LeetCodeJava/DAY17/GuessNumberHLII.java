package DAY17;

public class GuessNumberHLII {
	public static int getMoneyAmount(int n) {
        Integer[][] dp = new Integer[n+1][n+1];
        return miniMax(1, n, dp);
    }
    private static int miniMax(int i, int j, Integer[][] dp){
        if(i >= j)
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i; k <= j; k++)
            dp[i][j] = Math.min(dp[i][j], Math.max(miniMax(i, k-1, dp), miniMax(k+1, j, dp))+k);
        return dp[i][j];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMoneyAmount(10));
	}

}
