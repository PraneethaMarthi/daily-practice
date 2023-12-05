package DAY9;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public boolean checkPalindrome(String str, int startIndex, int lastIndex){
        while(startIndex <= lastIndex){
            if(str.charAt(startIndex) != str.charAt(lastIndex))
                return false;
            startIndex++;
            lastIndex--;
        }
        return true;
    }
    public void palindromePartition(int index, List<String> ds, List<List<String>> output, String str){
        if(index == str.length()){
            output.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < str.length(); i++){
            if(checkPalindrome(str, index, i)){
                ds.add(str.substring(index, i + 1));
                palindromePartition(i+1, ds, output, str);
                ds.remove(ds.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> output = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        palindromePartition(0, ds, output, s);
        return output;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aab";
		PalindromePartitioning pp=new PalindromePartitioning();
		List<List<String>> result=pp.partition(s);
		System.out.println(result);
	}

}
