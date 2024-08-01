class Solution {
    public int countSeniors(String[] details) {
        // phoneno + gender(M/F) + age(2char) + seat(2char) = 15 char
        //return age>60
        int cnt=0;
        for(int i=0;i<details.length;i++){
            // Extract the age substring from the detail string (characters 11 and 12)
            int age = Integer.parseInt(details[i].substring(11,13));

            // Check if the extracted age is greater than 60
            if(age>60) cnt++;
        }
        return cnt;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(1)
