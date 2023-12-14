package DAY15;

import java.util.Arrays;

public class CoinChange {
	public static int coinChange(int[] coins, int amount) {
	    int[] minCoins = new int[amount + 1]; // Min coins amount for every particular sum
	    Arrays.fill(minCoins, Integer.MAX_VALUE); // Default is MAX_VAL
	    minCoins[0] = 0; // To get 0 we need 0 coins
	    // Check every sum starting from 1 to amount
	    for (int sum = 1; sum <= amount; sum++) {
	      // Try to get the sum using every coin as (sum - coin denomination) + this coin
	      for (int coinDenomination: coins) {
	        if (sum >= coinDenomination && minCoins[sum - coinDenomination] != Integer.MAX_VALUE) {
	          // Check if we add this coin to (sum - coinDenomination), will it be better?
	          minCoins[sum] = Math.min(minCoins[sum], minCoins[sum - coinDenomination] + 1); 
	        }
	      }
	    }
	    return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount=11;
		int[] coins= {1,2,5};
		System.out.println(coinChange(coins,amount));
	}

}
