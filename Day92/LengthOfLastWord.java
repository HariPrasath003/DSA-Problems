// Given a string s consisting of words and spaces, return the length of the last word in the string.

// A word is a maximal 
// substring
//  consisting of non-space characters only.

 

// Example 1:

// Input: s = "Hello World"
// Output: 5
// Explanation: The last word is "World" with length 5.
// Example 2:

// Input: s = "   fly me   to   the moon  "
// Output: 4
// Explanation: The last word is "moon" with length 4.
// Example 3:

// Input: s = "luffy is still joyboy"
// Output: 6
// Explanation: The last word is "joyboy" with length 6.
 

// Constraints:

// 1 <= s.length <= 104
// s consists of only English letters and spaces ' '.
// There will be at least one word in s.

class Solution {
    public int lengthOfLastWord(String s) {

        // String str = s.trim();
        // int count = 0;

        // for(int i = str.length()-1; i >= 0; i--){
        //     if(str.charAt(i)==' '){
        //         break;
        //     }
        //     count++;
        // }
        // return count;

        s = s.trim();
        int last = s.lastIndexOf(' ');
        
        return s.length() - last - 1;
    }
}
// Complexity Analysis
// Time Complexity: O(N) where N is the length of s.
// Space Complexity: O(1)  as we are using constant space.