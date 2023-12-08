package Day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiffWaystoAddParanthesis {
	Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        
        List<Integer> ret = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            if (input.charAt(i) == '-' ||
                input.charAt(i) == '*' ||
                input.charAt(i) == '+' ) {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1);
                List<Integer> part1Ret = diffWaysToCompute(part1);
                List<Integer> part2Ret = diffWaysToCompute(part2);
                for (Integer p1 :   part1Ret) {
                    for (Integer p2 :   part2Ret) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+': c = p1+p2;
                                break;
                            case '-': c = p1-p2;
                                break;
                            case '*': c = p1*p2;
                                break;
                        }
                        ret.add(c);
                    }
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(Integer.valueOf(input));
        }
        map.put(input, ret);
        return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiffWaystoAddParanthesis dp = new DiffWaystoAddParanthesis();
		List<Integer> res=dp.diffWaysToCompute("2*3-4*5");
		System.out.println(res);
		
	}

}
