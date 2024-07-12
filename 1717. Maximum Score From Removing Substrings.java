import java.util.Stack;

class Solution {

    // Helper method to handle the case when x > y
    public int xgreater(String s, int x, int y, Stack<Character> st) {
        int ans = 0;

        // Phase 1: Remove "ab" substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && !st.isEmpty() && st.peek() == 'a') {
                ans += x;
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        // Prepare the remaining string for the next phase
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        
        s = res.reverse().toString();
        st.clear();

        // Phase 2: Remove "ba" substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && !st.isEmpty() && st.peek() == 'b') {
                ans += y;
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        return ans;
    }

    // Helper method to handle the case when x < y
    public int ygreater(String s, int x, int y, Stack<Character> st) {
        int ans = 0;

        // Phase 1: Remove "ba" substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' && !st.isEmpty() && st.peek() == 'b') {
                ans += y;
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        // Prepare the remaining string for the next phase
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        
        s = res.reverse().toString();
        st.clear();

        // Phase 2: Remove "ab" substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b' && !st.isEmpty() && st.peek() == 'a') {
                ans += x;
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }

        return ans;
    }

    // Main method to compute the maximum gain
    public int maximumGain(String s, int x, int y) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Character> st = new Stack<>();
        int ans = 0;

        // Choose the appropriate helper method based on the values of x and y
        if (x > y) {
            ans = xgreater(s, x, y, st);
        } else {
            ans = ygreater(s, x, y, st);
        }

        return ans;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)
