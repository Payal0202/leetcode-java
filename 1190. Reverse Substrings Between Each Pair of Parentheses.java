import java.util.Stack;

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>(); // Stack to hold characters
        
        // Iterate through each character in the string
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ')') { // If we encounter a closing parenthesis
                StringBuilder r = new StringBuilder(); // To hold the reversed substring
                
                // Pop characters from the stack until an opening parenthesis is found
                while (st.peek() != '(') {
                    r.append(st.pop());
                }
                
                st.pop(); // Remove the opening parenthesis '('
                
                // Push the reversed substring back to the stack
                for (int i = 0; i < r.length(); i++) {
                    st.push(r.charAt(i));
                }
            } else {
                // Push the current character to the stack
                st.push(s.charAt(j));
            }
        }
        
        // Collect the final result from the stack
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }
        
        // Reverse the collected result since the stack gives it in reverse order
        return result.reverse().toString();
    }
}

/*
Example:
input: (u(love)u)
approach: 1st reverse love = evol , and remove it's opening and closing bracket 
          now we have (uevoli)
          now reverse it and remove bracket = iloveu
output: iloveu
*/

//Time Complexity: O(n)
//Space Complexity: O(n)
