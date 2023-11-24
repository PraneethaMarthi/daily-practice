package DAY1;
public class ClimbStairs {
	public static int cs(int n) {
		int prev1 = 1;
		int prev2 = 1;
		if (n == 0 || n == 1)
			return 1;
		for (int i = 2; i <= n ;i++) {
			int temp = prev2;
			prev2 = prev1 + prev2;
			prev1 = temp;
		}
		return prev2;
	}
	public static void main(String args[]) {
		int n = 4;
		System.out.println(cs(n));
	}
}
