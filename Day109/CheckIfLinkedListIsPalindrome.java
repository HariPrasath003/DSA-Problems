// Given a singly linked list of size N of integers. The task is to check if the given linked list is palindrome or not.

// Example 1:

// Input:
// N = 3
// value[] = {1,2,1}
// Output: 1
// Explanation: The given linked list is
// 1 2 1 , which is a palindrome and
// Hence, the output is 1.
// Example 2:

// Input:
// N = 4
// value[] = {1,2,3,4}
// Output: 0
// Explanation: The given linked list
// is 1 2 3 4 , which is not a palindrome
// and Hence, the output is 0.
// Your Task:
// The task is to complete the function isPalindrome() which takes head as reference as the only parameter and returns true or false if linked list is palindrome or not respectively.

// Expected Time Complexity: O(N)
// Expected Auxialliary Space Usage: O(1)  (ie, you should not use the recursive stack space as well)

// Constraints:
// 1 <= N <= 105

//{ Driver Code Starts
    import java.util.*;

    class Node
    {
        int data;
        Node next;
        
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    class Is_LinkedList_Palindrom
    {
         Node head;  
         Node tail;
        
        /* Function to print linked list */
        void printList(Node head)
        {
            Node temp = head;
            while (temp != null)
            {
               System.out.print(temp.data+" ");
               temp = temp.next;
            }  
            System.out.println();
        }
        
     
        /* Inserts a new Node at front of the list. */
        public void addToTheLast(Node node) 
        {
    
            if (head == null) 
            {
                head = node;
                tail = node;
            } else 
            {
                tail.next = node;
                tail = node;
            }
        }
        
        public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
             
            while(t>0)
            {
                int n = sc.nextInt();
                //int k = sc.nextInt();
                Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
                //int n=Integer.parseInt(br.readLine());
                int a1=sc.nextInt();
                Node head= new Node(a1);
                Node tail = head;
                for (int i = 1; i < n; i++) 
                {
                    int a = sc.nextInt(); 
                    tail.next = new Node(a);
                    tail = tail.next;
                }
                
                Solution g = new Solution();
                if(g.isPalindrome(head) == true)
                    System.out.println(1);
                else
                    System.out.println(0);
                t--;
            }
            
        }
    }
    
    
    
    
    // } Driver Code Ends
    
    
    /* Structure of class Node is
    class Node
    {
        int data;
        Node next;
        
        Node(int d)
        {
            data = d;
            next = null;
        }
    }*/
    
    
    class Solution
    {
        boolean isPalindrome(Node head) 
        {
    
            ArrayList<Integer> lst=new ArrayList<>();
    
            while(head!=null){
                lst.add(head.data);
                head=head.next;
            }
            int low=0;
            int high=lst.size()-1;
            while(low<=high){
                if(lst.get(low)!=lst.get(high)){
                    return false;
                }
                low++;
                high--;
            }
            return true;
            
        }    
    }
// Time Complexity: O(N)
// Space Complexity: O(N)