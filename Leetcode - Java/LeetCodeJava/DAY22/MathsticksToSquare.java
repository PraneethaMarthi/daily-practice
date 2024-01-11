package DAY22;

import java.util.Arrays;

public class MathsticksToSquare {
	public static boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4)
		return false;
	int sum = 0;
	for (int num : nums)
		sum += num;
	if (sum % 4 != 0)
		return false;

	Arrays.sort(nums);

	return dfs(nums, new int[4], nums.length - 1, sum / 4);
}

private static boolean dfs(int[] nums, int[] sums, int index, int target) {
	if (index == -1) {
		if (sums[0] == target && sums[1] == target && sums[2] == target) {
			return true;
		}
		return false;
	}
	for (int i = 0; i < 4; i++) {
		if (sums[i] + nums[index] > target)
			continue;
		sums[i] += nums[index];
		if (dfs(nums, sums, index -1, target))
			return true;
		sums[i] -= nums[index];
	}
	return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,1,2,2,2};
		System.out.println(makesquare(nums));
	}

}
