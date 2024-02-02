package DAY32;

public class BestTimetoBuyandSellwithTransactionFee {
	public static int maxProfit(int[] P, int F) {
        int len = P.length, buying = 0, selling = -P[0];
        for (int i = 1; i < len; i++) {
            buying = Math.max(buying, selling + P[i] - F);
            selling = Math.max(selling, buying - P[i]);
        }
        return buying;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p= {1,3,2,8,4,9};
		int fee=2;
		System.out.println(maxProfit(p,fee));
	}

}
