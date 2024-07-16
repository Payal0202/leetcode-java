/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean dfs(TreeNode root, int node, StringBuilder s) {
        if (root.val == node) {
            return true; // Node found
        }

        if (root.left != null && dfs(root.left, node, s)) {
            s.append("L"); // Append 'L' if node is in the left subtree
        } else if (root.right != null && dfs(root.right, node, s)) {
            s.append("R"); // Append 'R' if node is in the right subtree
        }

        return s.length() > 0; // Return true if any path found
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        
        // Use DFS to find the path to start and destination nodes
        dfs(root, startValue, s);
        dfs(root, destValue, d);
        
        int i = 0;
        int maxi = Math.min(s.length(), d.length());
        
        s.reverse();
        d.reverse();
        
        // Find the common path length from the end
        while (i < maxi && s.charAt(i) == d.charAt(i)) {
            i++;
        }

        // Get the path from start to LCA (Lowest Common Ancestor)
        String start = s.toString().substring(i);

        // Construct the result path: 'U' for moving up from start node to LCA, then add the path from LCA to destination
        String res = "";
        for (int j = 0; j < start.length(); j++) {
            res += "U";
        }

        return res + d.toString().substring(i);
    }
}

//Time complexity : O(N)
//Space complexity : O(H)  , H=height
