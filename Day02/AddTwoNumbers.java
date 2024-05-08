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


//  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

//  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 
  
 
//  Example 1:
 
 
//  Input: l1 = [2,4,3], l2 = [5,6,4]
//  Output: [7,0,8]
//  Explanation: 342 + 465 = 807.
//  Example 2:
 
//  Input: l1 = [0], l2 = [0]
//  Output: [0]
//  Example 3:
 
//  Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//  Output: [8,9,9,9,0,0,0,1]


class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result = new ListNode (0);
        ListNode ptr = result ;

        int carry = 0;

        while(l1 != null || l2 != null){

            int sum = 0 + carry;

            if(l1!= null){
                sum += l1.val;
                l1 = l1.next;
            }
             if(l2!= null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            sum = sum %10;
            ptr.next = new ListNode(sum);
            ptr = ptr.next;
        }
        if (carry == 1) ptr.next = new ListNode(1);
        
        return result.next;
    }
}

// Time Complexity: O(max(m, n)), where m and n represent the lengths of l1 and l2 respectively.
// Space Complexity: O(max(m, n)). The length of the new list is at most max(m,n)+1.