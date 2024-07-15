/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//Approach 2
public class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Sort the array
        Arrays.sort(nums);

        ListNode node = head;
        // Finding the first node not in nums
        while (node != null) {
            int ptr = Arrays.binarySearch(nums, node.val);
            if (ptr >= 0) {
                // Element present in nums
                node = node.next;
            } else {
                // Found the first node not in nums
                break;
            }
        }

        if (node == null) {
            return node;
        }

        ListNode node2 = node;
        while (node2.next != null) {
            int ptr = Arrays.binarySearch(nums, node2.next.val);
            if (ptr >= 0) {
                // If next value of node is in nums, skip the next node
                node2.next = node2.next.next;
            } else {
                // If next node value is not in nums, proceed to next node
                node2 = node2.next;
            }
        }
        return node;
    }
}

// Total Time Complexity:Combining the two steps (sorting and searching), the total time complexity is O(mlogm)+O(nlogm)=O((n+m)logm).

// Space Complexity:The space complexity is O(1) for the modifiedList function itself, but O(m) for storing the sorted array nums.


//Approach 1
//TLE
//  class Solution {
//     public ListNode deleteNode(int a, ListNode head) {
//         // Handle the case where the node to delete is at the head
//         while (head != null && head.val == a) {
//             head = head.next;
//         }

//         ListNode temp = head;
//         while (temp != null && temp.next != null) {
//             if (temp.next.val == a) {
//                 temp.next = temp.next.next;
//             } else {
//                 temp = temp.next;
//             }
//         }
        
//         return head;
//     }
    
//     public ListNode modifiedList(int[] nums, ListNode head) {
//         for(int a:nums){
//             head = deleteNode(a,head);
//         }

//         return head;
//     }
// }

// Time Complexity: O(m*n)
// Space Complexity: O(1)
