// Problem statement
// Programming languages have some conditional / decision-making statements that execute when some specific condition is fulfilled.

// If-else is one of the ways to implement them.

// You are given two numbers 'a' and 'b'.

// Compare the numbers and print the relation.

// Print “smaller”, “greater” or “equal” when ‘a’ is smaller than ‘b’, greater than ‘b’, or equal to ‘b’ respectively.

// Example :
// Input: ‘a’ = 5 and ‘b’ = 3

// Output: greater

// Explanation: Since ‘a’ (= 5) is greater than ‘b’ (= 3), we are printing “greater”.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 5 3

// Sample Output 1:
// greater

// Explanation of sample input 1 :
// Since ‘a’ (= 5) is greater than ‘b’ (= 3), we are printing “greater”.

// Sample Input 2:
// 2 2

// Sample Output 2:
// equal

// Explanation of sample input 2 :
// Since ‘a’ (= 2) is equal to ‘b’ (= 2), we are printing “equal”.

// Expected time complexity :
// The expected time complexity is O(1).

// Constraints :
// -10 ^ 5 <= ‘a’ <= 10 ^ 5
// -10 ^ 5 <= ‘b’ <= 10 ^ 5

// Time limit: 1 second

public class Solution {
    public static String compareIfElse(int a, int b) {
        // Write your code here
        if (a < b) {
            return "smaller";
        } else if (a > b) {
            return "greater";
        } else {
            return "equal";
        }
    }
}