package DAY18;

public class WiggleSequence {
	public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
        return nums.length;
    }

    int count = 1;
    int diff = 0; 

    for (int i = 1; i < nums.length; i++) {
        int currentDiff = nums[i] - nums[i - 1];

        if ((currentDiff > 0 && diff <= 0) || (currentDiff < 0 && diff >= 0)) {
            count++;
            diff = currentDiff;
        }
    }

    return count;
    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,7,4,9,2,5};
		System.out.println(wiggleMaxLength(nums));
	}

}
