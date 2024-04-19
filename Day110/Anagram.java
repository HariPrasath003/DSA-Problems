// Fast-Track your resumes to top tech companies and get the job you deserve! Register for Job-A-Thon Hiring Challenge  

// banner
// Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings a and b can only contain lower case alphabets.

// Note:-

// If the strings are anagrams you have to return True or else return False

// |s| represents the length of string s.


// Example 1:

// Input:a = geeksforgeeks, b = forgeeksgeeks
// Output: YES
// Explanation: Both the string have same characters with
//         same frequency. So, both are anagrams.
// Example 2:

// Input:a = allergy, b = allergic
// Output: NO
// Explanation: Characters in both the strings are 
//         not same, so they are not anagrams.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function isAnagram() which takes the string a and string b as input parameter and check if the two strings are an anagram of each other. The function returns true if the strings are anagram else it returns false.

// Expected Time Complexity:O(|a|+|b|).
// Expected Auxiliary Space: O(Number of distinct characters).

// Constraints:
// 1 ≤ |a|,|b| ≤ 105

//{ Driver Code Starts
    import java.util.*;
    import java.util.stream.*; 
    import java.lang.*;
    import java.io.*;
    
    class GFG {
        
        public static void main (String[] args)throws IOException {
        
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
            {
                String str = br.readLine();
                String s1 = str.split(" ")[0];
                String s2 = str.split(" ")[1];
                
                Solution obj = new Solution();
                
                if(obj.isAnagram(s1,s2))
                {
                    System.out.println("YES");
                }
                else
                {
                     System.out.println("NO");
                }
                
                
                
            }
        }
    }
    // } Driver Code Ends
    
    
    class Solution {
        public static boolean isAnagram(String a, String b) {
            
            if (a.length() != b.length()) {
                return false; 
            }
    
            int[] count = new int[26];
            
            for (int i = 0; i < a.length(); i++) {
                count[a.charAt(i) - 'a']++;
            }
            
            for (int i = 0; i < b.length(); i++) {
                count[b.charAt(i) - 'a']--;
            }
            
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
    