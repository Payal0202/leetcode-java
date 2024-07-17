//Approach : Sorting and Greedy Strategy
class Solution {
    // Method to reverse the elements of an array
    public static void reverse(int[] array) {
        int n = array.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = array[i];
            array[i] = array[n - i - 1];
            array[n - i - 1] = temp;
        }
    }

    // Method to find the minimum cost to cut a chocolate bar
    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        //maintain count of horizonal sections and vertical section after cut which are treated as separate block
        int horizontalBlock = 1, verticalBlock = 1;
        int i = 0, j = 0;
        int ans = 0;

        // Sort horizontalCut and verticalCut arrays in ascending order
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);

        // Reverse the arrays to get them in descending order
        reverse(horizontalCut);
        reverse(verticalCut);

        // Traverse through both arrays and calculate the cost
        while (i < m - 1 && j < n - 1) {
            if (horizontalCut[i] >= verticalCut[j]) {
                ans += verticalBlock * horizontalCut[i];
                horizontalBlock++;
                i++;
            } else {
                ans += horizontalBlock * verticalCut[j];
                verticalBlock++;
                j++;
            }
        }

        // Process any remaining horizontal cuts
        while (i < m - 1) {
            ans += verticalBlock * horizontalCut[i];
            horizontalBlock++;
            i++;
        }

        // Process any remaining vertical cuts
        while (j < n - 1) {
            ans += horizontalBlock * verticalCut[j];
            verticalBlock++;
            j++;
        }

        return ans;
    }
}

// Time Complexity: O(mlogm+nlogn), This is dominated by the sorting step because O(mlogm+nlogn) is greater than O(m+n) whic req for reversing array and merging
// Space Complexity: O(logm+logn) , space complexity is primarily determined by the sorting step
