package DAY25;

public class CoinChangeII {
	public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
    dp[0] = 1;

    for (int coin : coins) {
        for (int i = coin; i <= amount; i++) {
            dp[i] += dp[i - coin];
        }
    }

    return dp[amount];
          
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount=5;
		int[] coins= {1,2,5};
		System.out.println(change(amount,coins));
		}

}
