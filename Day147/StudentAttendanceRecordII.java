package Day147;

// An attendance record for a student can be represented as a string where each character signifies whether the student was absent, late, or present on that day. The record only contains the following three characters:

// 'A': Absent.
// 'L': Late.
// 'P': Present.
// Any student is eligible for an attendance award if they meet both of the following criteria:

// The student was absent ('A') for strictly fewer than 2 days total.
// The student was never late ('L') for 3 or more consecutive days.
// Given an integer n, return the number of possible attendance records of length n that make a student eligible for an attendance award. The answer may be very large, so return it modulo 109 + 7.

 

// Example 1:

// Input: n = 2
// Output: 8
// Explanation: There are 8 records with length 2 that are eligible for an award:
// "PP", "AP", "PA", "LP", "PL", "AL", "LA", "LL"
// Only "AA" is not eligible because there are 2 absences (there need to be fewer than 2).
// Example 2:

// Input: n = 1
// Output: 3
// Example 3:

// Input: n = 10101
// Output: 183236316
 

// Constraints:

// 1 <= n <= 105

class Solution {

    private static final int MOD = 1000000000 + 7;

    public int checkRecord(int n) {
        int prevDP[][] = new int[2][3];
        prevDP[0][0] = 1;
        prevDP[0][1] = 1;
        prevDP[0][2] = 1;
        prevDP[1][0] = 1;
        prevDP[1][1] = 1;
        prevDP[1][2] = 1;
        
        for(int i = 1; i <= n; i++){
            int newDP[][] = new int[2][3];
            for(int a = 0; a < 2; a++){
                for(int l = 0; l < 3; l++){
                    //Pick P
                    newDP[a][l] += prevDP[a][2];
                    if(a > 0){
                        //Pick A
                        newDP[a][l] += prevDP[a - 1][2];
                        newDP[a][l] %= MOD;
                    }
                    if(l > 0){
                        // Pick L
                        newDP[a][l] += prevDP[a][l - 1];
                        newDP[a][l] %= MOD;
                    }
                }
            }
            prevDP = newDP;
        }
        
        return prevDP[1][2];
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)