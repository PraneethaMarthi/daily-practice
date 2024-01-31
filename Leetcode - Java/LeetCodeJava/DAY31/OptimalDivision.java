package DAY31;

import java.util.HashMap;
import java.util.Map;

public class OptimalDivision {
	public String optimalDivision(int[] nums) {
        Map<String, pair> memory = new HashMap<>();
        pair sol = divid(nums,0,nums.length-1, memory);
        return sol.maxS;
    }
    
    public pair divid(int[] nums, int start, int end, Map<String, pair> memory){
        String key = start + " " + end;
        if(memory.containsKey(key)) return memory.get(key);
        if(start == end)    return new pair(nums[start], "" + nums[start],nums[start], "" + nums[start]);
        
        pair sol = new pair(0,"",0,"");
        
        for(int i = start; i < end; i++){
            pair left = divid(nums, start, i, memory);
            pair right = divid(nums, i + 1, end, memory);
            
            double min = left.min / right.max;
            String minS = left.minS + "/" + (i + 1 == end ? right.maxS : "(" + right.maxS + ")"); 
            double max = left.max / right.min;
            String maxS = left.maxS + "/" + (i + 1 == end ? right.minS : "(" + right.minS + ")"); 
            if(sol.min == 0 || min < sol.min){
                sol.min = min;
                sol.minS = minS;
            }
            if(max > sol.max){
                sol.max = max;
                sol.maxS = maxS;
            }
        }
        memory.put(key, sol);
        return sol;
    }
}

class pair{
    double min;
    String minS;
    double max;
    String maxS;
    
    public pair(double min, String minS, double max, String maxS){
        this.min = min;
        this.minS = minS;
        this.max = max;
        this.maxS = maxS;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimalDivision optimalDivisionSolver = new OptimalDivision();
        int[] nums = {1000,100,10,2};
        String result = optimalDivisionSolver.optimalDivision(nums);
		System.out.println(result);
		}

}
