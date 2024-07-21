import java.util.*;

class Solution {
    // Topological Sort function
    public List<Integer> topo(int[][] edges, int numNodes) {
        // Create the graph and in-degree array
        List<Integer>[] graph = new List[numNodes + 1]; // Adjacency list representation
        int[] inDegree = new int[numNodes + 1]; // Array to store in-degrees of nodes

        // Initialize the graph
        for (int i = 1; i <= numNodes; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the graph and populate in-degrees
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            inDegree[v]++;
        }

        // Find all nodes with 0 in-degree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= numNodes; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Process nodes with 0 in-degree
        List<Integer> topologicalOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topologicalOrder.add(node);

            // Decrease the in-degree of each neighbor
            for (int neighbor : graph[node]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Check if there was a cycle
        if (topologicalOrder.size() != numNodes) {
            return new ArrayList<>(Collections.singletonList(-1)); // Cycle detected
        }

        return topologicalOrder; // Return topological order
    }

    // Function to build the matrix
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] ans = new int[k][k]; // Initialize the answer matrix

        // Get topological sort orders for row and column conditions
        List<Integer> row = topo(rowConditions, k);
        List<Integer> col = topo(colConditions, k);
        if(row.get(0) == -1 || col.get(0) == -1) return new int[0][0]; // If cycle detected, return empty matrix

        // Create mappings from element to their respective row and column indices
        HashMap<Integer, Integer> rmap = new HashMap<>();
        HashMap<Integer, Integer> cmap = new HashMap<>();

        for (int i = 0; i < row.size(); i++) {
            rmap.put(row.get(i), i);
        }

        for (int i = 0; i < col.size(); i++) {
            cmap.put(col.get(i), i);
        }

        // Populate the answer matrix using the mappings
        for (int i = 1; i <= k; i++) {
            int r = rmap.get(i); // row index of element
            int c = cmap.get(i); // col index of element

            ans[r][c] = i; // Place element in its correct position
        }

        return ans; // Return the final matrix
    }
}


// Time Complexity: O(k + E)
// Space Complexity: O(k^2)
