// You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.

// Return the head of the linked list after doubling it.


// Example 1:


// Input: head = [1,8,9]
// Output: [3,7,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
// Example 2:


// Input: head = [9,9,9]
// Output: [1,9,9,8]
// Explanation: The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
 

// Constraints:

// The number of nodes in the list is in the range [1, 104]
// 0 <= Node.val <= 9
// The input is generated such that the list represents a number that does not have leading zeros, except the number 0 itself.

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
class Solution {
    public ListNode doubleIt(ListNode head) {
        
        Stack<Integer> values = new Stack<>();
        int val =0;

        while(head != null){
            values.push(head.val);
            head = head.next;
        }
        ListNode newTail = null;

        while(!values.isEmpty() || val != 0){
            newTail = new ListNode(0, newTail);

            if(!values.isEmpty()){
                val += values.pop() *2;
            }
            newTail.val = val % 10;
            val /= 10;
        }
        return newTail;
    }
}

// Time complexity: O(n)
// Space complexity: O(n)

