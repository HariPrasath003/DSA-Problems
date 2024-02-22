// Problem statement
// There is an integer array ‘A’ of size ‘N’.

// A sequence is successive when the adjacent elements of the sequence have a difference of 1.

// You must return the length of the longest successive sequence.

// Note:

// You can reorder the array to form a sequence. 
// For example,

// Input:
// A = [5, 8, 3, 2, 1, 4], N = 6
// Output:
// 5
// Explanation: 
// The resultant sequence can be 1, 2, 3, 4, 5.    
// The length of the sequence is 5.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= N <= 10^5
// 1 <= A[i] <= 10^9
// Time Limit: 1 sec

import java.util.*;
public class Solution {
    public static int longestSuccessiveElements(int[] a) {

        Set<Integer> numSet = new HashSet<>();
        for (int num : a) {
            numSet.add(num);
        }
        int maxLen = 0;
        for (int num : a) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLen++;
                }
                maxLen = Math.max(maxLen, currentLen);
            }
        }
        return maxLen;
    }
}
