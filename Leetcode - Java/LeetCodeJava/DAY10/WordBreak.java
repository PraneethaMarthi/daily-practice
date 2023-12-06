package DAY10;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        int max_len = 0;
        for (String word : wordDict) {
            max_len = Math.max(max_len, word.length());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(i - max_len - 1, 0); j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsandog";
		List<String> wordDict = new ArrayList();
		//wordDict.add("leet");
		//wordDict.add("code");
		wordDict.add("cats");
		wordDict.add("dog");
		wordDict.add("sand");
		wordDict.add("and");
		wordDict.add("cat");
		System.out.println(wordBreak(s,wordDict));
	}

}
