import java.util.Arrays;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // Total number of subarrays in nums is n * (n + 1) / 2.
        int[] sum = new int[n * (n + 1) / 2 + 1]; // +1 is to handle 1-based indexing later
        int k = 0; // Counter for the sum array
        int mod = (int)1e9 + 7; // Modulo value to prevent overflow
        
        // Calculate the sum of all possible subarrays
        for (int i = 0; i < n; i++) {
            int s = 0; // Start a new subarray sum from index i
            for (int j = i; j < n; j++) {
                s += nums[j]; // Add the current element to the sum
                sum[k] = s; // Store the sum in the array
                k++; // Increment the index for the sum array
            }
        }

        // Sort the array of subarray sums
        Arrays.sort(sum);

        // Calculate the sum of elements in the range [left, right]
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = (res + sum[i]) % mod; // Add the current element to result and take modulo
        }

        return res; // Return the final result
    }
}


// Time Complexity: O(n^2 * log n)
// Space Complexity: O(n^2)
