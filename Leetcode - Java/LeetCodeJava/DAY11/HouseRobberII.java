package DAY11;

public class HouseRobberII {
	public static int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        return Math.max(rob(nums,0,n-2),rob(nums,1,n-1)); //as,1st and last houses are adjacent
    }
    public static int rob(int[] nums,int start,int end) {
        int prev_1=nums[start];
        int prev_2=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int curr=Math.max(nums[i]+prev_1,prev_2);
            prev_1=prev_2;
            prev_2=curr;
        }
        return prev_2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,3,2};
		System.out.println(rob(nums));
	}

}
