// Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
// Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

// Example 1:

// Input:
// N = 3, sum = 4
// coins = {1,2,3}
// Output: 4
// Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
// Example 2:

// Input:
// N = 4, Sum = 10
// coins = {2,5,3,6}
// Output: 5
// Explanation: Five Possible ways are: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function count() which accepts an array coins its size N and sum as input parameters and returns the number of ways to make change for given sum of money. 

// Expected Time Complexity: O(sum*N)
// Expected Auxiliary Space: O(sum)

// Constraints:
// 1 <= sum, N, coins[i] <= 103

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[] dp = new long[sum + 1];
        dp[0] = 1;
        
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        
        return dp[sum];
    }
}

// Time complexity: O(sum * N) where N is the number of coins and sum is the target sum. We are iterating over the sum and the coins array.
// Space complexity: O(sum) where sum is the target sum. We are using an array of size sum + 1.