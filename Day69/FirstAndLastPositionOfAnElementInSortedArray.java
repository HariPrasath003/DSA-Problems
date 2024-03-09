// Problem statement
// You have been given a sorted array/list 'arr' consisting of ‘n’ elements. You are also given an integer ‘k’.



// Now, your task is to find the first and last occurrence of ‘k’ in 'arr'.



// Note :
// 1. If ‘k’ is not present in the array, then the first and the last occurrence will be -1. 
// 2. 'arr' may contain duplicate elements.


// Example:
// Input: 'arr' = [0,1,1,5] , 'k' = 1

// Output: 1 2

// Explanation:
// If 'arr' = [0, 1, 1, 5] and 'k' = 1, then the first and last occurrence of 1 will be 1(0 - indexed) and 2.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 8 2
// 0 0 1 1 2 2 2 2


// Sample output 1:
// 4 7


// Explanation of Sample output 1:
// For this testcase the first occurrence of 2 in at index 4 and last occurrence is at index 7.


// Sample Input 2:
// 4 2
// 1 3 3 5


// Sample output 2:
// -1 -1


// Expected Time Complexity:
// Try to do this in O(log(n)).


// Constraints:
// 1 <= n <= 10^5
// 0 <= k <= 10^9
// 0 <= arr[i] <= 10^9

// Time Limit : 1 second

import java.util.ArrayList;

public class Solution {
    public static int[] firstAndLastPosition(ArrayList<Integer> arr, int n, int k) {

        int first = -1;
        int last = -1;

        int si = 0;
        int ei = n - 1;

  
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr.get(mid) == k) {
                first = mid;
                ei = mid - 1;
            } else if (arr.get(mid) < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }

        si = 0;
        ei = n - 1;
        
        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr.get(mid) == k) {
                last = mid;
                si = mid + 1;
            } else if (arr.get(mid) < k) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return new int[]{first,last};
    }
}
