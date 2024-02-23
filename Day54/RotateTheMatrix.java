// Problem statement
// You are given a square matrix ‘Mat’ of size ‘N’. You need to rotate ‘Mat’ by 90 degrees in the clockwise direction.

// Note:

// You must rotate the matrix in place, i.e., you must modify the given matrix itself. You must not allocate another square matrix for rotation.
// For example

// When,
// ‘N’ = 2 and ‘Mat’ = {{1, 2}, {3, 4}}, we must modify ‘Mat’ to {{3, 1}, {4, 2}}.
// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= N <= 100
// 1 <= Mat[i][j] <= 10^9

// Time Limit: 1 sec


import java.util.*;
public class Solution {
    public static void rotateMatrix(int [][]mat){
        
        int n = mat.length;
        int start = 0, end = n - 1;

        while(end > start){

            for(int i = start; i < end; ++i){

                swap(mat, start, i, end - i + start, start);
                swap(mat, end - i + start, start, end, end - i + start);
                swap(mat, end, end - i + start, i, end);
            }
            end--;
            start++;
        }
    }
    public static void swap(int [][]mat, int i, int j, int k, int l){
        int c = mat[i][j];
        mat[i][j] = mat[k][l];
        mat[k][l] = c;
    }
}

// Time Complexity: O(n^2)
// Space Complexity: O(1)
