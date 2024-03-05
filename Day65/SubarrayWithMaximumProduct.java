// Problem statement
// Given an array ‘Arr’ that has ‘N’ elements. You have to find the subarray of ‘Arr’ that has the largest product. You must return the product of the subarray with the maximum product.



// For example:
// When ‘N’ = 5, and ‘Arr’ = {-2, 3, -4, 0}
// The subarrays of ‘Arr’ are:
// {-2}, {-2, 3}, {-2, 3, -4}, {-2, 3, -4, 0}, {3}, {3, -4}, {3, -4, 0}, {-4}, {-4, 0}, {0}.
// Among these, {-2, 3, -4} is the subarray having the maximum product equal to 24.
// Hence, the answer is 24.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 4
// 1 -2 3 -4
// Sample Output 1:
// 24
// Explanation Of Sample Input 1:
// Given, ‘Arr’ = {1, -2, 3, -4}. The subarrays of ‘Arr’ are: 
// {{1}, {1, -2}, {1, -2, 3}, {1, -2, 3, -4}, {-2}, {-2, 3}, {-2, 3, -4}, {3}, {3, -4}, {-4}}.
// Among these subarrays, {1, -2, 3, -4} and {-2, 3, -4} have the maximum product, equal to 24.
// Hence, the answer is 24.
// Sample Input 2:
// 5
// -1 3 0 -4 3
// Sample Output 2:
// 3
// Constraints:
// 1 <= N <= 10^5
// -100 <= Arr[i] <= 100

// -10^9 <= The product of elements of any subarray <= 10^9.
// The sum of ‘N’ over all test cases <= 10^5.
// Time Limit: 1-sec


public class Solution {
    public static int subarrayWithMaxProduct(int[] arr) {

        int max = arr[0];
        int min = arr[0];
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            int tempMax = Math.max(arr[i], Math.max(max * arr[i], min * arr[i]));
            min = Math.min(arr[i], Math.min(max * arr[i], min * arr[i]));
            
            result = Math.max(result, tempMax);
            max = tempMax;
        }
        
        return result;
    }
}
