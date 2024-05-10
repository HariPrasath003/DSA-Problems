// Problem statement
// You are given an array ‘a’ of ‘n’ integers.



// You have to return the lexicographically next to greater permutation.



// Note:

// If such a sequence is impossible, it must be rearranged in the lowest possible order.


// Example:

// Input: 'a' = [1, 3, 2]

// Output: 2 1 3

// Explanation: All the permutations of [1, 2, 3] are [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ]. Hence the next greater permutation of [1, 3, 2] is [2, 1, 3].


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 3
// 3 1 2


// Sample Output 1:
// 3 2 1


// Explanation Of Sample Input 1:
// Input:
// A = [3, 1, 2]
// Output:
// 3 2 1

// Explanation: All the permutations of [1, 2, 3] are [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1], ]. Hence the next greater permutation of [3, 1, 2] is [3, 2, 1].


// Sample Input 2:
// 3
// 3 2 1


// Sample Output 2:
// 1 2 3


// Constraints:
// 1 <= n <= 100
// 1 <= a[ i ] <= 100
// Time Limit: 1 sec

import java.util.*;
public class Solution {
    public static List< Integer > nextGreaterPermutation(List< Integer > A) {
        int n = A.size();
        int ind = -1;

        for (int i = n - 1; i >= 1; i--) {
            if (A.get(i) > A.get(i - 1)) {
                ind = i - 1;
                break;
            }
        }
        if (ind == -1) {
            Collections.reverse(A);
            return A;
        }
        int justGreaterElementIndex = n - 1;
        while (A.get(justGreaterElementIndex) <= A.get(ind)) {
            justGreaterElementIndex--;
        }
        swap(A, ind, justGreaterElementIndex);
        reverse(A, ind + 1);
        
        return A;
    }
    public static void swap(List< Integer > A, int i, int j){
        int x = A.get(i);
        A.set(i, A.get(j));
        A.set(j, x);
    }
    public static void reverse(List< Integer > a, int i){
        int j = a.size() - 1;
        for(; i < j; i++, j--){
            int x = a.get(i);
            a.set(i, a.get(j));
            a.set(j, x);
        }
    }
}