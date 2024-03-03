// Problem statement
// You are given an array of ‘N’ integers where each integer value is between ‘1’ and ‘N’.



// Each integer appears exactly once except for ‘P’, which appears exactly twice, and ‘Q’, which is missing.



// Your task is to find ‘P’ and ‘Q’ and return them respectively.



// Example:
// Input: ‘N’ = 4
// ‘A’ = [1, 2, 3, 2]

// Output: {2, 4}

// Explanation: The integer appearing twice is ‘2’, and the integer missing is ‘4’.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 4
// 1 2 3 2
// Sample Output 1:
// 2 4
// Explanation Of Sample Input 1:
// Input: ‘N’ = 5
// ‘A’ = [1, 2, 3, 2]

// Output: {2, 4}

// Explanation: The integer appearing twice is ‘2’, and the integer missing is ‘4’.
// Sample Input 2:
// 3
// 1 2 1
// Sample Output 2:
// 1 3
// Constraints:
// 2 <= N <= 10^5
// 1 <= A[i] <= N

// Time Limit: 1-sec

public class Solution {
    public static int[] findMissingRepeatingNumbers(int []a) {

        int n = a.length; 
        int []count = new int[n + 1]; 

        for(int i = 0; i < n; ++i) {
            ++count[a[i]];
        }

        int missing = 0;
        int repeating = 0;

        for(int i = 1; i <= n; ++i) {
            if(count[i] == 0) missing = i;
            else if(count[i] == 2) repeating = i;
        }

        int []ans = new int[2];
        ans[0] = repeating;
        ans[1] = missing;
        
        return ans;
    }
}