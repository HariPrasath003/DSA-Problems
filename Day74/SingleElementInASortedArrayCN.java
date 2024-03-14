// Problem statement
// You are given a sorted array ‘arr’ of ‘n’ numbers such that every number occurred twice in the array except one, which appears only once.



// Return the number that appears once.



// Example:
// Input: 'arr' = [1,1,2,2,4,5,5]

// Output: 4 

// Explanation: 
// Number 4 only appears once the array.


// Note :
// Exactly one number in the array 'arr' appears once.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 5 
// 1 1 3 5 5 


// Sample Output 1 :
// 3 


// Explanation of Sample Input 1 :
// Given array is [1, 1, 3, 5, 5]    
// Here, 3 occurs once in the array. So, the answer is 3.


// Sample Input 2 :
// 5
// 1 1 4 4 15


// Sample Output 2 :
// 15


// Explanation of Sample Input 2 :
// The array is [1, 1, 4, 4, 15].    
// Here, 15 occurs once in the array. So, the answer is 15.


// Expected Time Complexity:
// Try to solve this in O(log(n)).


// Constraints :
// 1 <= n <= 10^5
// 0 <= arr[i] <= 10^9

// Time Limit: 1 sec

import java.util.ArrayList;

public class Solution {
    public static int singleNonDuplicate(ArrayList < Integer > arr) {
        
        int n = arr.size();
        int low = 0, high = n - 1, mid;

        while (low < high) {
            mid = (low + high) / 2;
            if (mid % 2 == 1) {
                int a = arr.get(mid);
                int b = arr.get(mid - 1);
                if (a == b) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
            else if (mid % 2 == 0) {

                int a = arr.get(mid);
                int b = arr.get(mid + 1);

                if (a == b) {
                    low = mid + 1;
                }
                else {
                    high = mid;
                }
            }
        }
        return arr.get(low);
    }
}