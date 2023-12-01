package DAY6;
//updated
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/unique-binary-search-trees-ii/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class UniqueBinarySearchTreeII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();

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
        if (n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreeII uniqueBinarySearchTreeII = new UniqueBinarySearchTreeII();

        int n = 3; // You can change this value as needed

        List<TreeNode> result = uniqueBinarySearchTreeII.generateTrees(n);

        // Display the generated trees in the specified format
        System.out.println(generateTreesFormat(result));
    }

    // Helper function to print the tree structure in the specified format
    private static String generateTreesFormat(List<TreeNode> trees) {
        List<String> result = new ArrayList<>();
        for (TreeNode root : trees) {
            StringBuilder sb = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            if (root != null) {
                queue.add(root);
                while (!queue.isEmpty()) {
                    TreeNode current = queue.poll();
                    if (current != null) {
                        sb.append(current.val);
                        sb.append(",");
                        queue.add(current.left);
                        queue.add(current.right);
                    } else {
                        sb.append("null,");
                    }
                }
                sb.deleteCharAt(sb.length() - 1); // Remove the trailing comma
            }
            sb.append("]");
            result.add(sb.toString());
        }
        return result.toString();
    }
}
