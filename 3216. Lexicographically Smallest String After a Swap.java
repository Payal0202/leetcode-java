class Solution {
    public String getSmallestString(String s) {
        char[] ch = s.toCharArray(); // Convert the string to a character array for easy manipulation
        int i = 0, j = 1; // Initialize two pointers

        // Traverse the character array
        while (j < ch.length) {
            // Check if both characters at indices i and j are even
            if (ch[i] % 2 == 0 && ch[j] % 2 == 0) {
                // If they are out of order, swap them
                if (ch[i] > ch[j]) {
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                    break; // Stop after the first swap
                }
                i++;
                j++;

            // Check if both characters at indices i and j are odd
            } else if (ch[i] % 2 != 0 && ch[j] % 2 != 0) {
                // If they are out of order, swap them
                if (ch[i] > ch[j]) {
                    char temp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = temp;
                    break; // Stop after the first swap
                }
                i++;
                j++;

            // If one is odd and the other is even, move to the next pair
            } else {
                i++;
                j++;
            }
        }

        // Construct the result string from the modified character array
        String res = "";
        for (char c : ch) {
            System.out.println(c + " ");
            res += c;
        }
        return res;
    }
}



//Time Complexity: O(n)
//Space Complexity: O(n)
