class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int oneCount = 0;
        
        // Count the number of 1s in the array
        for (int num : nums) {
            if (num == 1) oneCount++;
        }
        
        // If there are no 1s or all are 1s, no swaps are needed
        if (oneCount == 0 || oneCount == n) return 0;

        // Calculate the initial number of zeros in the first window
        int zeroCount = 0;
        for (int i = 0; i < oneCount; i++) {
            if (nums[i] == 0) zeroCount++;
        }

        // Minimum swaps needed (initially is the count of zeros in the first window)
        int minSwaps = zeroCount;

        // Slide the window across the array
        for (int i = oneCount; i < n + oneCount; i++) {
            // Remove the effect of the element that is sliding out of the window
            if (nums[(i - oneCount) % n] == 0) zeroCount--;

            // Add the effect of the new element that is entering the window
            if (nums[i % n] == 0) zeroCount++;

            // Update the minimum swaps needed
            minSwaps = Math.min(minSwaps, zeroCount);
        }

        return minSwaps;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
