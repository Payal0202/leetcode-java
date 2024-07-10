class Solution {
    public int minOperations(String[] logs) {
        // Initialize a counter to keep track of the current directory depth.
        int cnt = 0;

        // Iterate through each log in the logs array.
        for (int i = 0; i < logs.length; i++) {
            // If the log is "../", move up one directory if we're not already at the root.
            if (logs[i].equals("../") && cnt > 0) {
                cnt--;
            }
            // If the log is "./" or "../" and we're at the root, do nothing.
            else if (logs[i].equals("./") || (logs[i].equals("../") && cnt == 0)) {
                continue;
            }
            // Otherwise, the log is a folder name, so we move down one directory.
            else {
                cnt++;
            }
        }
        // Return the final count, which represents the minimum operations to reach the main folder.
        return cnt;
    }
}


//Time Complexity: O(n), The algorithm iterates through the logs array exactly once, where n is the length of the logs array. Each operation inside the loop takes constant time.
//Space Complexity: O(1), The algorithm uses a constant amount of extra space, regardless of the input size. The counter cnt and the loop variables require a constant amount of memory.
