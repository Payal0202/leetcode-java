//CODE

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int max = numBottles; // Total number of bottles that can be drunk
        int empty = numBottles; // Number of empty bottles initially

        while(empty >= numExchange) {
            int rem = empty % numExchange; // Remainder bottles after exchanging
            empty = empty / numExchange; // Full bottles obtained by exchanging
           
            max += empty; // Add the new full bottles to the total count
            empty += rem; // Update the number of empty bottles (remaining + new empty bottles)
        }
      
        return max; // Return the total number of bottles drunk
    }
}


// Time Complexity: O(log numExchange(numBottles)). This is because, in each iteration of the loop, the number of empty bottles is reduced approximately by a factor of numExchange.

// Space Complexity: O(1). Since the algorithm uses a constant amount of extra space.
