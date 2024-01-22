package DAY27;

public class OutOfBoundaryPaths {
	static Integer[][][] memo;
    static int m;
	static int n;
    static int[] DIR = new int[]{0, 1, 0, -1, 0};
    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Integer[m][n][maxMove+1];
        this.m = m; this.n = n;
        return dp(startRow, startColumn, maxMove);
    }
    static int dp(int r, int c, int maxMove) {
        if (r < 0 || r == m || c < 0 || c == n) return 1; // Out of bound -> Count 1 way
        if (memo[r][c][maxMove] != null) return memo[r][c][maxMove];
        if (maxMove == 0) return 0;
        int ans = 0;
        for (int i = 0; i < 4; ++i) {
            ans = (ans + dp(r + DIR[i], c + DIR[i + 1], maxMove - 1)) % 1_000_000_007;
        }
        return memo[r][c][maxMove] = ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0;
		System.out.println(findPaths(m,n,maxMove,startRow,startColumn));
		}

}
