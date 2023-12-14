package DAY16;

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode() {}
	 TreeNode(int val) { this.val = val; }
	 TreeNode(int val, TreeNode left, TreeNode right) {
	 this.val = val;
	 this.left = left;
	 this.right = right;
	     }
	 }
public class HouseRobberIII {
	public int rob(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}
	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.right.right=new TreeNode(1);
        

 
        HouseRobberIII houseRobberIII = new HouseRobberIII();

                int result = houseRobberIII.rob(root);

                System.out.println(result);
    }
	
}
