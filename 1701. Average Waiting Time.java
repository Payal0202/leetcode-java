/*
Why This is a Greedy Approach:
The algorithm’s goal is to minimize the average waiting time by making the optimal choice at each step without revisiting previous choices. 
By always starting the next order as soon as possible (either right after the previous one or at the customer's arrival time), it adheres to the greedy strategy.
*/

//Time Complexity: O(N)   Space Complexity: O(1)
class Solution {
    public double averageWaitingTime(int[][] customers) {
        // Number of customers
        int n = customers.length;
        // Variable to keep track of the time the chef starts serving the next customer
        int start = customers[0][0];
        // Sum of all waiting times
        double sum = 0;

        // Loop through each customer
        for(int i = 0; i < n; i++){
            // Update start to be the maximum of the current start time and the arrival time of the current customer,
            // then add the time taken to prepare the current customer's order
            start = Math.max(start, customers[i][0]) + customers[i][1];
            // Add the waiting time of the current customer to the sum
            sum += start - customers[i][0];
        }

        // Return the average waiting time
        return sum / n;
    }
}



// class Solution {
//     public double averageWaitingTime(int[][] customers) {
//         int n = customers.length;
//         int start = customers[0][0];
//         double sum=0;

//         for(int i=0;i<n;i++){
//             if(start>=customers[i][0]){
//                 start = customers[i][1]+start;
//                 sum += start-customers[i][0];
//             }
//             else{
//                 start = customers[i][0] + customers[i][1];
//                 sum += start-customers[i][0];
//             }
//         }

//         return sum/n;
//     }
// }
