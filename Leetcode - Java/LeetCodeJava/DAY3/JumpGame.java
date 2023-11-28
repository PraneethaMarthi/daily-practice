package DAY3;
//https://leetcode.com/problems/jump-game/
public class JumpGame {
	public static boolean Jump(int[] nums) {
	       int end = 0;
	       for(int i = 0; i < nums.length && (end < nums.length-1); i ++) {
	           if(i > end) return false;
	           end = Math.max(end, i + nums[i]);
	       } 
	       return true;
	    }
	public static void main(String args[]) {
		int[] nums= {3,2,1,0,4};
		//int[] nums= {2,3,1,1,4};
		System.out.println(Jump(nums));
	}
}
