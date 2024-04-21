// Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). Palindrome string: A string that reads the same backward. More formally, S is a palindrome if reverse(S) = S. In case of conflict, return the substring which occurs first ( with the least starting index).

// Example 1:

// Input:
// S = "aaaabbaa"
// Output: aabbaa
// Explanation: The longest Palindromic
// substring is "aabbaa".
// Example 2:

// Input: 
// S = "abc"
// Output: a
// Explanation: "a", "b" and "c" are the 
// longest palindromes with same length.
// The result is the one with the least
// starting index.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function longestPalin() which takes the string S as input and returns the longest palindromic substring of S.

// Expected Time Complexity: O(|S|2).
// Expected Auxiliary Space: O(1).

// Constraints:
// 1 ≤ |S| ≤ 103


//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public String longestPalin(String S) {
        if (S == null || S.length() == 0) return "";
        
        String longest = "";
        
        for (int i = 0; i < S.length(); i++) {
            String odd = Center(S, i, i);
            String even = Center(S, i, i + 1);
            
            if (odd.length() > longest.length()) {
                longest = odd;
            }
            
            if (even.length() > longest.length()) {
                longest = even;
            }
        }
        
        return longest;
    }
    
    private String Center(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        return s.substring(left + 1, right);
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)