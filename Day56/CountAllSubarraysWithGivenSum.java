// Problem statement
// You are given an integer array 'arr' of size 'N' and an integer 'K'.

// Your task is to find the total number of subarrays of the given array whose sum of elements is equal to k.

// A subarray is defined as a contiguous block of elements in the array.

// Example:
// Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

// Output: 2

// Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 2
// 4 6
// 3 1 2 4

// 3 3
// 1 2 3
// Sample output 1:
// 2
// 2
// Explanation:
// Test Case 1:

// Input: ‘N’ = 4, ‘arr’ = [3, 1, 2, 4], 'K' = 6

// Output: 2

// Explanation: The subarrays that sum up to '6' are: [3, 1, 2], and [2, 4].

// Test Case 2:

// Input: ‘N’ = 3, ‘arr’ = [1, 2, 3], 'K' = 3

// Output: 2

// Explanation: The subarrays that sum up to '7' are: [1, 2], and [3].
// Sample Input 2:
// 2
// 3 7
// 1 2 3

// 4 9
// 6 3 5 2
// Sample output 2:
// 0
// 1


import java.util.*;
public class Solution {
    public static int findAllSubarraysWithGivenSum(int arr[], int s) {
        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum > s) {
                sum -= arr[left];
                left++;
            }

            if (sum == s) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); 
            int k = scanner.nextInt(); 
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            System.out.println(findAllSubarraysWithGivenSum(arr, k));
        }
        scanner.close();
    }
}
