package DAY29;

public class Keys2Keyboard {
	public static int minSteps(int n) {
        int dp[] = new int[n+1];
        for(int i=2;i<n+1;i++)
        {
            dp[i] = i;
            for(int j=1;j<i/2;j++)
            {
                if(i%j==0)
                dp[i] = Math.min(dp[i],dp[j]+i/j);
            }
        }
        return dp[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(minSteps(n));
		}

}
