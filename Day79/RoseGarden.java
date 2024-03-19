// Problem statement
// You are given 'n' roses and you are also given an array 'arr' where 'arr[i]' denotes that the 'ith' rose will bloom on the 'arr[i]th' day.



// You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.



// Find the minimum number of days required to make at least 'm' bouquets each containing 'k' roses. Return -1 if it is not possible.



// Example :
// Input: n = 9,  arr = [ 1, 2, 1, 2, 7, 2, 2, 3, 1 ], k = 3, m = 2

// Output: 3. 

// Explanation: This is because on the 3rd day: all the roses with 'arr[i]' less than equal to 3 have already bloomed, this means every rose except the 5th rose has bloomed. Now we can form the first bouquet from the first three roses and the second bouquet from the last three roses.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1 :
// 9
// 1 2 1 2 7 2 2 3 1
// 3 2
// Sample Output 1 :
// 3
// Explanation For Sample Input 1 :
// We will return 3, because:
// All the roses with 'arr[i]' less than equal to 3 have already bloomed after 3 days, this means every rose except the 5th rose has bloomed. Now we can form the first bouquet from the first three roses and the second bouquet from the last three roses.
// Sample Input 2 :
// 4
// 1 1 1 1
// 1 1
// Sample Output 2 :
// 1
// Constraints :
// 1 <= n <= 10^5
// 1 <= arr[i] <= 10^9
// 1 <= k <= n
// 1 <= m <= 10^6

// Time limit: 1 sec

public class Solution {
    public static boolean possible(int[] arr, int day, int m, int k) {
        
        int n = arr.length; 
        int cnt = 0;
        int noOfB = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public static int roseGarden(int[] arr, int k, int m) {
        long val = (long) m * k;
        int n = arr.length; 
        if (val > n) return -1; 
  
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }

        int low = mini, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(arr, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
