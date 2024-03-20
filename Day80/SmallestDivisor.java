// Problem statement
// You are given an array of integers 'arr' and an integer 'limit'.



// Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given integer's limit.



// Note:
// Each result of the division is rounded to the nearest integer greater than or equal to that element. For Example, 7/3 = 3.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 5
// 1 2 3 4 5
// 8  
// Sample Output 1 :
// 3
// Explanation for Sample Input 1 :
// We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
// The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor, and the sum is 7(1 + 1 + 1 + 2 + 2) if we choose 3 as a divisor, which is less than the 'limit'.
// Hence we return 3.
// Sample Input 2 :
// 4
// 8 4 2 3 
// 10
// Sample Output 2 :
// 2
// Explanation for Sample Input 2:
// We can get a sum of 17(8 + 4 + 2 + 3) if we choose 1 as a divisor. 
// The sum is 9(4 + 2 + 1 + 2) if we choose 2 as a divisor, which is less than the 'limit'.
// Hence, we return 2.
// Sample Input 3:
// 5
// 2 3 5 7 11
// 11
// Sample Output 3 :
// 3
// Constraints :
// 1 <= n <= 10 ^ 5
// 1 <= arr[i] <= 10 ^ 6
// N <= limit <= 10 ^ 4

// Time Limit: 1 sec.

public class Solution {
    public static int smallestDivisor(int arr[], int limit) {
        
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(arr, mid, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean isValid(int[] arr, int divisor, int limit) {
        int sum = 0;
        for (int num : arr) {
            sum += (int) Math.ceil((double) num / divisor);
        }
        return sum <= limit;
    }
}

// Time Complexity: O(nlogm), where n is the length of arr and m is the maximum value in arr.
// Space Complexity: O(1).