// Given a sorted array containing only 0s and 1s, find the transition point, i.e., the first index where 1 was observed, and before that, only 0 was observed.

// Example 1:

// Input:
// N = 5
// arr[] = {0,0,0,1,1}
// Output: 3
// Explanation: index 3 is the transition 
// point where 1 begins.
// Example 2:

// Input:
// N = 4
// arr[] = {0,0,0,0}
// Output: -1
// Explanation: Since, there is no "1",
// the answer is -1.
// Your Task:
// You don't need to read input or print anything. The task is to complete the function transitionPoint() that takes array arr and N as input parameters and returns the 0-based index of the position where 0 ends and 1 begins. If array does not have any 1, return -1. If array does not have any 0, return 0.

// Expected Time Complexity: O(Log(N))
// Expected Auxiliary Space: O(1)

// Constraints:
// 1 ≤ N ≤ 105
// 0 ≤ arr[i] ≤ 1

//{ Driver Code Starts
    import java.util.*;

    class Sorted_Array {
        public static void main(String args[]) {
            Scanner sc = new Scanner(System.in);
            int T = sc.nextInt();
            while (T > 0) {
                int n = sc.nextInt();
                int arr[] = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                Solution obj = new Solution();
                System.out.println(obj.transitionPoint(arr, n));
                T--;
            }
        }
    }
    // } Driver Code Ends
    
    
class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        int start = 0;
        int end = n - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (arr[mid] == 1) {
                if (mid == 0 || arr[mid - 1] == 0) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}

// Time complexity: O(log(n)) where n is the length of the array.
// Space complexity: O(1) where n is the number of elements