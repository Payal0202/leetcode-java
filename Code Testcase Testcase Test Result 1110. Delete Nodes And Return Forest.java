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

/*
Steps:
1.Create set and store values which we have to del from tree
  (using any traversal)
2.(in postorder)
  Check is node present in set
  if yes add its left right to list
  and then return
*/

class Solution {

    // Helper function to perform postorder traversal and handle deletions
    public TreeNode dfs(TreeNode root, HashSet<Integer> set, List<TreeNode> ans) {
        // Base case: if the current node is null, return null
        if (root == null) return null;

        // Recursively process the left and right subtrees
        root.left = dfs(root.left, set, ans);
        root.right = dfs(root.right, set, ans);

        // If the current node's value is in the set of nodes to delete
        if (set.contains(root.val)) {
            // If the left child is not null, add it to the result list
            if (root.left != null) {
                ans.add(root.left);
            }
            // If the right child is not null, add it to the result list
            if (root.right != null) {
                ans.add(root.right);
            }
            // Return null to delete the current node
            return null;
        }
        // Return the current node if it is not deleted
        return root;
    }

    // Main function to initiate the deletion process and return the forest
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // Initialize a set to store the values of nodes to be deleted
        HashSet<Integer> set = new HashSet<>();
        // Initialize a list to store the roots of the resulting forest
        List<TreeNode> ans = new ArrayList<>();

        // Add each value from the to_delete array to the set
        for (int i : to_delete) {
            set.add(i);
        }

        // Call the dfs function to process the tree and handle deletions
        dfs(root, set, ans);
        
        // If the root node is not deleted, add it to the result list
        if (!set.contains(root.val)) {
            ans.add(root);
        }

        // Return the list of roots of the resulting forest
        return ans;
    }
}

// Time complexity : O(n)
// Space complexity : O(n)
