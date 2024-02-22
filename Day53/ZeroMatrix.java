// Problem statement
// You are given a matrix 'MATRIX' of dimension 'N' x 'M'. Your task is to make all the elements of row 'i' and column 'j' equal to 0 if any element in the ith row or jth column of the matrix is 0.

// Note:

// 1) The number of rows should be at least 1.

// 2) The number of columns should be at least 1.

// 3) For example, refer to the below matrix illustration: 

// Detailed explanation ( Input/output format, Notes, Images )
// Constraints:
// 1 <= N <= 100
// 1 <= M <= 100
// -10^9 <= MATRIX[i][j] <= 10^9

// Where 'MATRIX[i][j]' denotes the matrix element.
// Follow Up:

// Can you solve it with the space complexity of O(1)?

// Time limit: 1 sec


import java.util.ArrayList;

public class Solution {
    public static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
     
        ArrayList<Boolean> row = new ArrayList<Boolean>(n);
        ArrayList<Boolean> col = new ArrayList<Boolean>(m);

        for (int i = 0; i < n; i++) {
            row.add(false);
        }
        for (int j = 0; j < m; j++) {
            col.add(false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 0) {
  
                    row.set(i, true);
                    col.set(j, true);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row.get(i) || col.get(j)) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }
}