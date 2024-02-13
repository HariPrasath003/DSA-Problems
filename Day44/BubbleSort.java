// Problem statement
// You are given an integer array 'arr' of size 'N'.



// You must sort this array using 'Bubble Sort'.



// Note:
// Change in the input array itself. You don't need to return or print the elements.
// Example:
// Input: ‘N’ = 7
// 'arr' = [2, 13, 4, 1, 3, 6, 28]

// Output: [1 2 3 4 6 13 28]

// Explanation: After applying bubble sort on the input array, the output is [1 2 3 4 6 13 28].
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 7
// 2 13 4 1 3 6 28
// Sample Output 1:
// 1 2 3 4 6 13 28
// Explanation of Sample Output 1:
// After applying bubble sort on the input array, the output is [1 2 3 4 6 13 28].
// Sample Input 2:
// 5
// 9 3 6 2 0
// Sample Output 2:
// 0 2 3 6 9
// Explanation of Sample Output 2:
// After applying bubble sort on the input array, the output is [0 2 3 6 9].
// Constraints :
// 1 <= N <= 10^3
// 0 <= arr[i] <= 10^9
// Time Limit: 1 sec

public class Solution {
    public static void bubbleSort(int[] arr, int n) {
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 13, 4, 1, 3, 6, 28};
        bubbleSort(arr1, arr1.length);
        System.out.print("Sorted array 1: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] arr2 = {9, 3, 6, 2, 0};
        bubbleSort(arr2, arr2.length);
        System.out.print("Sorted array 2: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}