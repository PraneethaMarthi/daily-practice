package DAY28;

public class PalindromicSubstrings {
	public static int countSubstrings(String s) {
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        int count = 0;
        for(int k = n -1; k >= 0; k--)
        {
            for(int j = k; j < n; j++)
            {
                if(s.charAt(k) == s.charAt(j) && (j - k < 2 || dp[k+1][j-1]))
                {
                    dp[k][j] = true;
                    count++;
                }
            }
        }
        return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="abc";
		System.out.println(countSubstrings(s));
	}

}
