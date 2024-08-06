class Solution {
    public int minimumPushes(String word){
        // Create a hashmap to store the frequency of each character in the word
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: word.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);        
        }

        // If there are 8 or fewer unique characters, return the length of the word
        if(map.size()<=8){
            return word.length();
        }
        
        // Array to store frequencies of characters
        int[] arr = new int[map.size()];
        int j=0;
        for(Integer i: map.values()){
            arr[j]=i;
            j++;
        }

        // Sort the frequencies in ascending order
        Arrays.sort(arr);
        int mul=1, res=0, cnt=0;
        j=arr.length-1;

        // Calculate the minimum cost
        while(j>=0){
            res += mul*arr[j];
            j--;
            cnt++;

            // Increase multiplier after every 8 elements
            if(cnt==8) {
                cnt=0;
                mul++;
            }
        }

        return res;
    }
}
// Time complexity : O(n + m log m) 
// Space complexity : O(m)
// where n is the length of the string and m is the number of unique characters.
