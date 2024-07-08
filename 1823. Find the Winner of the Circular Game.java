//4 different Approach

//Optimized Approach: Josephus Problem Formula : Iterative
//Time Complexity:O(n)  Space Complexity: O(1)
class Solution {
    public int findTheWinner(int n, int k) {
        int winner = 0;  // Base case for 1 person
        
        for (int i = 2; i <= n; i++) {
            winner = (winner + k) % i;
        }
        
        return winner + 1;  // Convert zero-based index to one-based
    }
}


// //Optimized Approach: Josephus Problem Formula : Recursion
// //Time Complexity:O(n)  Space Complexity: O(n)
// class Solution {
//     public int findTheWinner(int n, int k) {
//         return findWinnerRecursively(n, k) + 1;
//     }

//     private int findWinnerRecursively(int n, int k) {
//         if (n == 1) {
//             return 0;  // Base case: if there's only one person, they're the winner
//         } else {
//             // Recursive case: adjust the position and apply the formula
//             return (findWinnerRecursively(n - 1, k) + k) % n;
//         }
//     }
// }


// //Time Complexity:O(n×n)  Space Complexity: O(n)
// class Solution {
//     public int findTheWinner(int n, int k) {
//         List<Integer> list = new ArrayList<>();
        
//         // Initialize the list with people 1 to n
//         for (int i = 1; i <= n; i++) {
//             list.add(i);
//         }
        
//         int index = 0;
        
//         // Simulate the elimination process
//         while (list.size() > 1) {
//             // Calculate the next index to remove
//             index = (index + k - 1) % list.size();
//             list.remove(index);
//         }
        
//         // Return the last remaining element
//         return list.get(0);
//     }
// }



//Time Complexity:O(k×n)  Space Complexity: O(n+k)
// class Solution {
//     public int findTheWinner(int n, int k) {
//         Queue<Integer> q = new LinkedList<>();
//         Stack<Integer> st = new Stack<>();

//         for(int i=1;i<=n;i++) q.add(i);

//         while(st.size()<k && q.size()>1){
//             st.push(q.peek());
//             if(st.size()==k){
//                 q.remove();
//                 st.clear();
//             }
//             else{
//                 int ele = q.remove();
//                 q.add(ele);
//             }
//         }

//         return q.remove();
//     }
// }
