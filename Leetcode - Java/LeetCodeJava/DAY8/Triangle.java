package DAY8;
//https://leetcode.com/problems/triangle/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
			return 0;
		
		for (int i=triangle.size() - 2; i>=0; i--) {
			for (int j=0; j<=i; j++) {
				List<Integer> nextRow = triangle.get(i+1);
				int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
				triangle.get(i).set(j, sum);
			}
		}
		return triangle.get(0).get(0);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		
//[[2],[3,4],[6,5,7],[4,1,8,3]])
		System.out.println(minimumTotal(triangle));
		}

}
