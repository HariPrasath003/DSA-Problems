// Problem statement
// Given an array 'arr' of 'n' non-negative integers, your task is to move all the zeros to the end of the array while keeping the non-zero elements at the start of the array in their original order. Return the modified array.



// Example :
// Input: ‘n’ = 5, ‘arr’ = [1, 2, 0, 0, 2, 3]
// Output: [1, 2, 2, 3, 0, 0]

// Explanation: Moved all the 0’s to the end of an array, and the rest of the elements retain the order at the start.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample input 1:
// 4
// 0 0 0 1 
// Sample output 1:
// 1 0 0 0 
// Explanation of sample input 1:
// Output: [1, 0, 0, 0]

// We move all the 0’s to the end of an array, and the rest of the elements retained the order at the start.
// Sample input 2:
// 5
// 4 0 3 2 5 
// Sample output 2:
// 4 3 2 5 0 
// Explanation of sample input 2:
// Output: [4, 3, 2, 5, 0]

// we move all the 0’s to the end of an array, and the rest of the elements retained the order at the start.
// Expected time complexity:
//  The expected time complexity is O(n).
// Constraints:
// 1 ≤ n ≤ 10^6
// 0 ≤ arr[i] ≤ 10^9

// Time limit: 1 sec

public class Solution {
    public static int[] moveZeros(int n, int []a) {
        int j = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[j++] = a[i];
            }
        }

        for (; j < a.length; j++) {
            a[j] = 0;
        }
        return a;
    }
}