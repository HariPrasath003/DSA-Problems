// Problem statement
// You are given two integers 'n', and 'm'.



// Calculate 'gcd(n,m)', without using library functions.



// Note:
// The greatest common divisor (gcd) of two numbers 'n' and 'm' is the largest positive number that divides both 'n' and 'm' without leaving a remainder.


// Example:
// Input: 'n' = 6, 'm' = 4

// Output: 2

// Explanation:
// Here, gcd(4,6) = 2, because 2 is the largest positive integer that divides both 4 and 6.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 9 6


// Sample Output 1:
// 3


// Explanation of sample output 1:
// gcd(6,9) is 3, as 3 is the largest positive integer that divides both 6 and 9.

// Sample Input 2:
// 2 5


// Sample Output 2:
// 1


// Expected Time Complexity:
// Try to solve this in O(log(n)) 


// Constraints:
// 0 <= ‘n’ <= 10^5

// Time Limit: 1 sec


public class Solution {
    public static int calcGCD(int n, int m){
        // Write your code here.
         while (m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        return n;
        
    }
}