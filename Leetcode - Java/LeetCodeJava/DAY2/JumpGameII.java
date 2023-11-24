package DAY2;
//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII {
	
	public static int jump(int[] nums) {
        int i =0;
          int counter=0;
          if(nums.length==1)
          return 0;
      while(i<nums.length)
      {
      counter++;
          int range = i+nums[i];
          if(range>=nums.length-1)
           break;
          int max=0;
          int temp=0;
          for( int k=i+1;k<=range;k++)
          {
              if(nums[k]+k>=max)
              {
                  max=nums[k]+k;
                  temp=k;
              }
              
          }
          i=temp;
      }
      return counter;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,3,0,1,4};
		System.out.println(jump(nums));
	}

}
