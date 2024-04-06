// Given a string s of '(' , ')' and lowercase English characters.

// Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

// Formally, a parentheses string is valid if and only if:

// It is the empty string, contains only lowercase characters, or
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
 
// Example 1:

// Input: s = "lee(t(c)o)de)"
// Output: "lee(t(c)o)de"
// Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
// Example 2:

// Input: s = "a)b(c)d"
// Output: "ab(c)d"
// Example 3:

// Input: s = "))(("
// Output: ""
// Explanation: An empty string is also valid.
 
// Constraints:

// 1 <= s.length <= 105
// s[i] is either'(' , ')', or lowercase English letter.

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        int Count = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(')
                Count++;
            else if (arr[i] == ')') {
                if (Count == 0)
                    arr[i] = '*';
                else
                    Count--;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (Count > 0 && arr[i] == '(') {
                arr[i] = '*';
                Count--;
            }
        }

        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*')
                arr[p++] = arr[i];
        }
        return new String(arr, 0, p);
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)