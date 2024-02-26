package DAY37;

import java.util.Arrays;

public class SoupServings {
	static double dp[][];
    public static double soupServings(int n) {
        if (n>4800) return 1;
        dp = new double[n/25+1][n/25+1];
        for(double dp1[]:dp) Arrays.fill(dp1, -1);
        return help(n,n,1);
    }
    private static double help (int a, int b, double curr){
        double res = 0;
        if (a<=0 && b>0) res = curr;
        else if (a<=0 && b<=0) res = curr/2;
        else if(a>0 && b>0){
            if (dp[a/25][b/25]!= -1)
            return dp[a/25][b/25];
            res =0.25 *(help(a-100,b,curr)+
                        help(a-75, b-25, curr)+
                        help(a-50, b-50, curr)+
                        help(a-25,b-75,curr));
            dp[a/25][b/25] = res;
        }
            else return 0;
            return res;
        }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=50;
		System.out.println(soupServings(n));
		}

}
