// Problem statement
// You have been given an array/list 'arr' consisting of 'n' elements.



// Each element in the array is either 0, 1 or 2.



// Sort this array/list in increasing order.



// Do not make a new array/list. Make changes in the given array/list.



// Example :
// Input: 'arr' = [2, 2, 2, 2, 0, 0, 1, 0]

// Output: Final 'arr' = [0, 0, 0, 1, 2, 2, 2, 2]

// Explanation: The array is sorted in increasing order.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 8
// 2 2 2 2 0 0 1 0


// Sample Output 1:
// 0 0 0 1 2 2 2 2


// Explanation of sample input 1 :
// The initial array 'arr' is [2, 2, 2, 2, 0, 0, 1, 0].

// After sorting the array in increasing order, 'arr' is equal to:
// [0, 0, 0, 1, 2, 2, 2, 2]


// Sample Input 2:
// 5
// 1 1 1 1 1


// Sample Output 2:
// 1 1 1 1 1


// Expected time complexity :
// The expected time complexity is O(n).


// Constraints:
// 1 <= 'n' <= 10 ^ 4
// 0 <= 'arr[i]' <= 2

// Time limit: 1 second

import java.util.ArrayList;
public class Solution {
    public static void sortArray(ArrayList<Integer> arr, int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
    private static void swap(ArrayList<Integer> arr, int i, int j) {
        
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
