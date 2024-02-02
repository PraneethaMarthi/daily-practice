package DAY32;

import java.util.Arrays;

public class MinASCIIDel {
	static int [][]dp;
    public static int minimumDeleteSum(String s1, String s2) {
      
       dp=new int[s1.length()+1][s2.length()+1];
       for(int[] i : dp)
       {
           Arrays.fill(i,-1);
       }
       return rec(s1,s2,0,0);
    }
        // ArrayList<int> = new ArrayList<>();
        public static int rec(String s1,String s2,int i,int j)
        {       
            int sum=0;
            int AM = Integer.MAX_VALUE;
            if(dp[i][j] != -1)
            {
                return dp[i][j];
            }
            if(i == s1.length())
            {
                for(int k=j;k<s2.length();k++)
                {
                    sum+=s2.charAt(k);
                }
                return sum;
            }
            if(j == s2.length())
            {
                for(j=i;j<s1.length();j++)
                {
                    sum += s1.charAt(j);
                }
                return sum;
            }
            int m = Math.min(s1.charAt(i)+rec(s1,s2,i+1,j),s2.charAt(j)+rec(s1,s2,i,j+1));
            
            if(s1.charAt(i) == s2.charAt(j))
            {
                return AM =rec(s1, s2, i + 1, j + 1);

            }
            return dp[i][j]=Math.min(AM,m);
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "sea", s2 = "eat";
		System.out.println(minimumDeleteSum(s1,s2));
		}

}
