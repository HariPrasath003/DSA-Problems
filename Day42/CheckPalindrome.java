// Problem statement
// Determine if a given string ‘S’ is a palindrome using recursion. Return a Boolean value of true if it is a palindrome and false if it is not.

// Note: You are not required to print anything, just implement the function. Example:
// Input: s = "racecar"
// Output: true
// Explanation: "racecar" is a palindrome.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// abbba
// Sample Output 1:
// true
// Explanation Of Sample Input 1 :
// “abbba” is a palindrome
// Sample Input 2:
// abcd
// Sample Output 2:
// false
// Explanation Of Sample Input 2 :
// “abcd” is not a palindrome.
// Constraints:
// 0 <= |S| <= 10^6
// where |S| represents the length of string S.

class Solution {
    private static boolean isPalindromeHelper(String str, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (str.charAt(left) == str.charAt(right)) {
            return isPalindromeHelper(str, left + 1, right - 1);
        }

        return false;
    }

    public static boolean isPalindrome(String S) {
        return isPalindromeHelper(S, 0, S.length() - 1);
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)