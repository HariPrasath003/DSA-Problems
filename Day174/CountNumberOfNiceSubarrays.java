// 1248. Count Number of Nice Subarrays : https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=daily-question&envId=2024-06-22

// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
// Return the number of nice sub-arrays.


// Example 1:

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

// Example 2:

// Input: nums = [2,4,6], k = 1
// Output: 0
// Explanation: There are no odd numbers in the array.

// Example 3:

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16
 

// Constraints:

// 1 <= nums.length <= 50000
// 1 <= nums[i] <= 10^5
// 1 <= k <= nums.length


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {

        int n = nums.length;
        int sum = 0;
        int count = 0;
        int goal = k;
        
        int[] map = new int[50001];
        map[0] = 1;

        for (int i = 0; i < n; i++) {
          sum += nums[i] % 2;
          if (sum >= goal)
            count += map[sum - goal];
          map[sum]++;
        }
        return count;
    }
}


// Time Complexity: O(N)
// Space Complexity: O(N)