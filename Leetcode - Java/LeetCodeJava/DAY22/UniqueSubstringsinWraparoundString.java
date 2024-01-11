package DAY22;

public class UniqueSubstringsinWraparoundString {
	public static int findSubstringInWraproundString(String p) {
        int n = p.length(), max = 1;   
      int[] count = new int[26];
      char[] pc = p.toCharArray();
      
      for(int i = 0; i < n; i++){
        if(i > 0){
          int t = pc[i] - pc[i - 1];
          if(t == 1 || t == -25) {
            max++;
          } else {
            max = 1;
          } 
        }
        int index = pc[i] - 'a';
        count[index] = Math.max(count[index], max);
      }
      
      int res = 0;
      for(int c : count){
        res += c;  
      }
      return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "cac";
		System.out.println(findSubstringInWraproundString(p));
	}

}
