// Problem statement
// You are given an integer ‘n’.



// Your task is to return an array containing integers from 1 to ‘n’ (in increasing order) without using loops.



// Example:
// Input: ‘n’ = 5

// Output: 1 2 3 4 5

// Explanation: An array containing integers from ‘1’ to ‘n’ is [1, 2, 3, 4, 5].
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 5
// Sample Output 1 :
// 1 2 3 4 5
// Explanation Of Sample Input 1:
// The array contains all integers from 1 to 5 in ascending order.
// Sample Input 2:
// 2
// Sample Output 2:
// 1 2
// Explanation Of Sample Input 2:
// The array contains all integers from 1 to 2 in ascending order.
// Expected Time Complexity:
// The expected time complexity is O(n), where 'n' is the given integer.
// Constraints:
// 1 <= n <= 10^6

// Time Limit: 1-sec

public class Solution {
    public static int[] printNos(int x) {
        if (x <= 0) {
            return new int[0]; 
        }
        
        int[] result = new int[x];
        printNos(result, x);
        return result;
    }
    
    private static void printNos(int[] arr, int x) {
        if (x == 1) {
            arr[0] = 1;
            return;
        }
        
        printNos(arr, x - 1); 
        
        arr[x - 1] = x;
    }
}
