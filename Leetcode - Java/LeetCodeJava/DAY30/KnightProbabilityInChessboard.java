package DAY30;

public class KnightProbabilityInChessboard {
	private static double[][][] memo;

    public static double knightProbability(int n, int k, int row, int column) {
        memo = new double[k + 1][n][n];
        return dp(n, k, row, column);
    }

    private static double dp(int n, int k, int row, int column) {
        if (k == 0) return 1.0;
        if (memo[k][row][column] != 0) return memo[k][row][column];

        double sum = 0;
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        for (int[] move : moves) {
            int r = row + move[0];
            int c = column + move[1];
            if (r >= 0 && r < n && c >= 0 && c < n) {
                sum += dp(n, k - 1, r, c);
            }
        }

        memo[k][row][column] = sum / 8;
        return sum / 8;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3, k = 2, row = 0, column = 0;
		System.out.println(knightProbability(n,k,row,column));
	}

}
