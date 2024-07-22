class Solution {
    // Inner class to hold a pair of height and name
    class Pair {
        int first; // Height
        String second; // Name
        
        // Constructor to initialize a Pair object
        Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }
    
    // Method to sort people by their heights in descending order
    public String[] sortPeople(String[] names, int[] heights) {
        // Create a list to store pairs of heights and names
        ArrayList<Pair> list = new ArrayList<>();
        
        // Populate the list with pairs
        for (int i = 0; i < names.length; i++) {
            list.add(new Pair(heights[i], names[i]));
        }
        
        // Sort the list based on heights in descending order
        Collections.sort(list, (x, y) -> y.first - x.first);
        
        // Extract the names from the sorted list and update the names array
        for (int i = 0; i < names.length; i++) {
            names[i] = list.get(i).second;
        }
        
        // Return the sorted names array
        return names;
    }
}

//Time complexity : O(n log n)
//Space complexity : O(n)
