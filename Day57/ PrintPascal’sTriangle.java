// Problem statement
// You are given an integer ‘N’. You need to return the first ‘N’ rows of Pascal’s triangle.

// Example:

// Input:
// N = 4
// Output:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// Explanation: The output matrix has the first four rows of Pascal’s Triangle. 
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= N <= 30
// Time Limit: 1 sec
// Sample Input 1:
// 5
// Sample Output 1:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// Explanation Of Sample Input 1:
// Input:
// N = 5

// Output:
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// Explanation: The output matrix has the first five rows of Pascal’s Triangle.
// Sample Input 2:
// 3
// Sample Output 2:
// 1 
// 1 1
// 1 2 1
// Sample Input 3:
// 4
// Sample Output 3:
// 1 
// 1 1 
// 1 2 1 
// 1 3 3 1 


import java.util.*;

public class Solution {
    public static int[][] pascalTriangle(int N) {
        int [][]triangle = new int[N][];
        
        for (int i = 0; i < N; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            triangle[i][i] = 1;

            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        return triangle;
    }
}