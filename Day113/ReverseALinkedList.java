// Given a linked list of N nodes. The task is to reverse this list.

// Example 1:

// Input:
// LinkedList: 1->2->3->4->5->6
// Output: 6 5 4 3 2 1
// Explanation: After reversing the list, 
// elements are 6->5->4->3->2->1.
// Example 2:

// Input:
// LinkedList: 2->7->8->9->10
// Output: 10 9 8 7 2
// Explanation: After reversing the list,
// elements are 10->9->8->7->2.
// Your Task:
// The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1 <= N <= 104

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
            
                Solution ob = new Solution();
                head = ob.reverseList(head);
                printList(head); 
                t--;
            }
        } 
    } 
       
    // } Driver Code Ends
    
    
    //function Template for Java
    
    /* linked list node class:
    
    class Node {
        int data;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
    
    */
class Solution {
    public Node reverseList(Node head) {
            
        if (head == null || head.next == null) {
            return head; 
        }
            
        Node prev = null;
        Node current = head;
            
        while (current != null) {
            Node next = current.next; 
            current.next = prev; 
            prev = current;
            current = next;
        }

        return prev;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(1)