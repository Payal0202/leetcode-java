class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        // Populate the map with the frequency of each string
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int cnt=0;

        // Iterate over the original array in order
        for (String str : arr) {
            if (map.get(str) == 1) {  // If the string is distinct
                cnt++;
                if (cnt == k) {
                    return str;
                }
            }
        }

        //wrong output
        // //count distinct string means freq 1
        // for(Map.Entry<String,Integer> entry : map.entrySet()){
        //     if(entry.getValue()==1){
        //         cnt++;
        //         if(cnt==k)
        //             last = entry.getKey();
        //     }     
        // }

        // If there are fewer than k distinct strings
        return "";

    }
}

// Time complexity : O(n)
// Space complexity : O(n)
