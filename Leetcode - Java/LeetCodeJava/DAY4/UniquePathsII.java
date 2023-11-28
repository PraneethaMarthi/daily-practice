package DAY4;
//https://leetcode.com/problems/unique-paths-ii/description/
import java.util.Arrays;

public class UniquePathsII {
	public static int helper2(int obstacleGrid[][]){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m+1][n+1];
        for(var a : dp) Arrays.fill(a,0);
        dp[m-1][n-1] = 1;
    
        for(int i=m-1; i>=0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

       if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
       return helper2(obstacleGrid);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] obstacleGrid= {{0,1},{0,0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

}
