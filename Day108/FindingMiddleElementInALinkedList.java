// Given a singly linked list of N nodes.
// The task is to find the middle of the linked list. For example, if the linked list is
// 1-> 2->3->4->5, then the middle node of the list is 3.
// If there are two middle nodes(in case, when N is even), print the second middle element.
// For example, if the linked list given is 1->2->3->4->5->6, then the middle node of the list is 4.

// Example 1:

// Input:
// LinkedList: 1->2->3->4->5
// Output: 3 
// Explanation: 
// Middle of linked list is 3.
// Example 2: 

// Input:
// LinkedList: 2->4->6->7->5->1
// Output: 7 
// Explanation: 
// Middle of linked list is 7.
// Your Task:
// The task is to complete the function getMiddle() which takes a head reference as the only argument and should return the data at the middle node of the linked list.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1 <= N <= 5000

//{ Driver Code Starts
    import java.util.*;
    import java.io.*;
    
    class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
        
    }
    class GFG{
        static void printList(Node node) 
        { 
            while (node != null) 
            { 
                System.out.print(node.data + " "); 
                node = node.next; 
            } 
            System.out.println(); 
        }
        public static void main(String args[]) throws IOException { 
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t > 0){
                int n = sc.nextInt();
                Node head = new Node(sc.nextInt());
                Node tail = head;
                for(int i=0; i<n-1; i++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                Solution g = new Solution();
                int ans = g.getMiddle(head);
                System.out.println(ans);
                //printList(head); 
                t--;
            }
        } 
    } 
       
    // } Driver Code Ends
    
    
    /* Node of a linked list
     class Node {
       int data;
        Node next;
        Node(int d)  { data = d;  next = null; }
    }
    */
class Solution
{
    int getMiddle(Node head)
    {
        if (head == null)
            return -1;
            
        Node slow = head;
        Node fast = head;
            
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}    
// Time Complexity: O(N).
// Space Complexity: O(1).