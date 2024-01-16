package DAY24;

public class LongestPalinfromicSubsequence {
	public static int longestPalindromeSubseq(String s) {
        StringBuilder strb = new StringBuilder(s);
        String str=strb.reverse().toString();

        int n=s.length();
        int m=str.length();
        int dp[][]=new int[n+1][m+1];
        
        //base case
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int i=0;i<=n;i++) dp[i][0]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){

                if(s.charAt(i-1)==str.charAt(j-1))  dp[i][j]=1+dp[i-1][j-1];

                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bbbab";
		System.out.println(longestPalindromeSubseq(s));
	}

}
