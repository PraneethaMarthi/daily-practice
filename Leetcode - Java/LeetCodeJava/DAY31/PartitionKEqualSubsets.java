package DAY31;

import java.util.Arrays;

public class PartitionKEqualSubsets {
	public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=Arrays.stream(nums).sum();
        if(sum%k!=0)
            return false;
        
        int v=sum/k;
        int[] A=new int[k];        
        Arrays.sort(nums);
        
        return dfs(nums.length-1,nums,v,A);
    }
    
    private static boolean dfs(int idx,int[] N,int v,int[] A){
        if(idx==-1){
            for(int a:A){
                if(a!=v)
                    return false;
            }
            return true;
        }
        
        for(int i=0;i<A.length;i++){
            if(A[i]+N[idx]<=v){
                A[i]+=N[idx];
                if(dfs(idx-1,N,v,A))
                    return true;
                
                A[i]-=N[idx];
            }
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {4,3,2,3,5,2,1};
		int k=4;
		System.out.println(canPartitionKSubsets(nums,k));
	}

}
