// 633. Sum of Square Numbers : https://leetcode.com/problems/sum-of-square-numbers/description/?envType=daily-question&envId=2024-06-17

// Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

// Example 1:
// Input: c = 5
// Output: true
// Explanation: 1 * 1 + 2 * 2 = 5

// Example 2:
// Input: c = 3
// Output: false
 

// Constraints:
// 0 <= c <= 231 - 1


class Solution {
    public boolean judgeSquareSum(int c) {
        
        int b = (int)Math.sqrt(c);
        int a = 0;

        while(a<=b){
            long res = (long)a*a + (long)b*b;

            if(res == c){
                return true;
            }
            else if(res < c){
                a++;
            }
            else{
                b--;
            }
        }

        return false;
    }
}


// Time Complexity: O(sqrt(c))
// Space Complexity: O(1)