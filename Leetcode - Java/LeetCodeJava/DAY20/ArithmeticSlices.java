package DAY20;

public class ArithmeticSlices {
	public static int numberOfArithmeticSlices(int[] nums) {
        int n=0;
        int diff=122222;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            int innerDiff=nums[i+1]-nums[i];
            if(diff!=innerDiff){
                ans+=(n*(n+1))/2;
                n=0;
                diff=innerDiff;
            }
            else
                n++;
        }
        ans+=((n*(n+1))/2);
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,3,4};
		System.out.println(numberOfArithmeticSlices(nums));
		}

}
