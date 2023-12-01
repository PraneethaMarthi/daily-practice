package DAY7;
//https://leetcode.com/problems/interleaving-string/
public class InterLeavingString {
	public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) return false;

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int j = 1; j <= n; ++j) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= m; ++i) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= n; ++j) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String s1="aabcc";
		String s2="dbbca";
		String s3="aadbbcbcac";*/
		String s1="aabcc";
		String s2="dbbca";
		String s3="aadbbbaccc";
		System.out.println(isInterleave(s1,s2,s3));
	}

}
