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

    public TreeNode createBinaryTree(int[][] descriptions) {
        // HashMap to store the created tree nodes, using their value as the key
        HashMap<Integer, TreeNode> map = new HashMap<>();
        // HashSet to keep track of all child nodes
        HashSet<Integer> children = new HashSet<>();

        // Iterate through each description to build the tree nodes and connections
        for (int[] arr : descriptions) {
            int parent = arr[0]; // Parent node value
            int child = arr[1];  // Child node value
            int isLeft = arr[2]; // Indicates if the child is a left child (1) or right child (0)
            
            children.add(child); // Add the child to the children set

            // Get the parent node from the map or create a new one if it doesn't exist
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));

            // If the child is a left child
            if (isLeft == 1) {
                // Get the child node from the map or create a new one and set it as the left child of the parent
                parentNode.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.left); // Update the map with the child node
            } else {
                // If the child is a right child
                // Get the child node from the map or create a new one and set it as the right child of the parent
                parentNode.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.right); // Update the map with the child node
            }

            // Update the map with the parent node
            map.put(parent, parentNode);
        }
        
        // Find the root node (the node that is not present in the children set)
        int root = -1;
        for (int[] a : descriptions) {
            if (!children.contains(a[0])) {
                root = a[0];
                break;
            }
        }

        // Return the root node from the map, or null if it doesn't exist
        return map.getOrDefault(root, null);
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)
