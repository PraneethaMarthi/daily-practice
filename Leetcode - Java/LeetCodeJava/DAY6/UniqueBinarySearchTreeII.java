package DAY6;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

//https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBinarySearchTreeII {
	public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();

        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(null);
        for (int nodes = 1; nodes <= n; nodes++) {
            dp[nodes] = new ArrayList<>();
            for (int root = 1; root <= nodes; root++) {
                for (TreeNode left_tree : dp[root - 1]) {
                    for (TreeNode right_tree : dp[nodes - root]) {
                        TreeNode root_node = new TreeNode(root);
                        root_node.left = left_tree;
                        root_node.right = clone(right_tree, root);
                        dp[nodes].add(root_node);
                    }
                }
            }
        }
        return dp[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
