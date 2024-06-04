// Given a string s which consists of lowercase or uppercase letters, return the length of the longest 
// palindrome
//  that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

// Example 1:

// Input: s = "abccccdd"
// Output: 7
// Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
// Example 2:

// Input: s = "a"
// Output: 1
// Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

// Constraints:

// 1 <= s.length <= 2000
// s consists of lowercase and/or uppercase English letters only.

class Solution {
    public int longestPalindrome(String s) {

        int count = 0;
        HashSet<Character> set = new HashSet<>();

        for(char ch : s.toCharArray()){

            if(set.contains(ch)){
                count += 2;
                set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }

        if(!set.isEmpty()){
            count += 1;
        }

        return count;
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)