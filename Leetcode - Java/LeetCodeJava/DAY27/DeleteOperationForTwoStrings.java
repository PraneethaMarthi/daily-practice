package DAY27;

public class DeleteOperationForTwoStrings {
	public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return (n - dp[n][m]) + (m - dp[n][m]); 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word1="sea", word2 = "eat";
		System.out.println(minDistance(word1,word2));
	}

}
