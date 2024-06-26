// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "(*)"
// Output: true
// Example 3:

// Input: s = "(*))"
// Output: true
 

// Constraints:

// 1 <= s.length <= 100
// s[i] is '(', ')' or '*'.

public class Solution {
    public boolean checkValidString(String s) {

        int leftMin = 0;
        int leftMax = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftMin++;
                leftMax++;
            } 
            else if (c == ')') {
                leftMin--;
                leftMax--;
            } 
            else {
                leftMin--;
                leftMax++;
            }
            if (leftMax < 0) return false;
            if (leftMin < 0) leftMin = 0;
        }

        return leftMin == 0;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Parenthesis String.