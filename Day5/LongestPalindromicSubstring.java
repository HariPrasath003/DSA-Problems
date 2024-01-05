// Given a string s, return the longest palindromic
 
// substring in s.

// Example 1:

// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Example 2:

// Input: s = "cbbd"
// Output: "bb"



class Solution {
    public String longestPalindrome(String str) {
        
        if(str.length() <=1)
        return str;

        String lps ="";

        for(int i =1; i< str.length(); i++){
            int low =i;
            int high =i;

            while(str.charAt(low) == str.chatAt(high)){
                low --;
                high ++;

                if(low ==-1 ||  high == str.length())
                break;
            }
            String palindrome = str.substring(low+1 , high);

            if(palindrome.length()> lps.length()){
                lps = palindrome;
            }
            low = i-1;
            high =i;
            while (str.chatAt(low) == str.charAt(high)){
                low --;
                high ++;

                if(low ==-1 || high == str.length())
                break;
            }

            palindrome = str.substring(low+1 , high);

            if(palindrome.length() > lps.length()){
                lps = palindrome; 
            }
        }
        return lps;
    }
}