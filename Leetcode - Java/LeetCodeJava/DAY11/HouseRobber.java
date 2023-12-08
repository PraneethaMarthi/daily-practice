package DAY11;

public class HouseRobber {
	public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
    int[] re= new int[nums.length + 1];
    re[0] = 0;
   re[1] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        int val = nums[i];
        re[i+1] = Math.max(re[i], re[i-1] + val);
    }
    return re[nums.length];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3,1};
		System.out.println(rob(nums));
		}

}
