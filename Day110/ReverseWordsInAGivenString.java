// Fast-Track your resumes to top tech companies and get the job you deserve! Register for Job-A-Thon Hiring Challenge  

// banner
// Given a String S, reverse the string without reversing its individual words. Words are separated by dots.

// Example 1:

// Input:
// S = i.like.this.program.very.much
// Output: much.very.program.this.like.i
// Explanation: After reversing the whole
// string(not individual words), the input
// string becomes
// much.very.program.this.like.i
// Example 2:

// Input:
// S = pqr.mno
// Output: mno.pqr
// Explanation: After reversing the whole
// string , the input string becomes
// mno.pqr

// Your Task:
// You dont need to read input or print anything. Complete the function reverseWords() which takes string S as input parameter and returns a string containing the words in reversed order. Each word in the returning string should also be separated by '.' 


// Expected Time Complexity: O(|S|)
// Expected Auxiliary Space: O(|S|)


// Constraints:
// 1 <= |S| <= 105

//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    class GFG {
        public static void main(String[] args) {
    
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while (t > 0) {
                String s = sc.next();
                Solution obj = new Solution();
                System.out.println(obj.reverseWords(s));
                t--;
            }
        }
    }
    
    // } Driver Code Ends
    
    class Solution {
        String reverseWords(String S) {
            
            String[] words = S.split("\\.");
    
            int left = 0, right = words.length - 1;
            while (left < right) {
                String temp = words[left];
                words[left] = words[right];
                words[right] = temp;
                left++;
                right--;
            }
            
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                result.append(words[i]);
                if (i != words.length - 1) {
                    result.append(".");
                }
            }
            return result.toString();
        }
    }
    