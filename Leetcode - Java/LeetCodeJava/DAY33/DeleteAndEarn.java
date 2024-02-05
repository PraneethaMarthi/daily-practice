package DAY33;

public class DeleteAndEarn {
	public static int deleteAndEarn(int[] nums) {
        int[] map = new int[10001];
        for (int num : nums) {
            map[num] += num;
        }
        int prev = 0;
        int curr = 0;
        int temp;
        for (int value : map) {
            temp = curr;
            curr = Math.max(curr, prev + value);
            prev = temp;
        }
        return curr;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {3,4,2};
		System.out.println(deleteAndEarn(nums));
	}

}
