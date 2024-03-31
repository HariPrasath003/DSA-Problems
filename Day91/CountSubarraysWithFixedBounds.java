// You are given an integer array nums and two integers minK and maxK.

// A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

// The minimum value in the subarray is equal to minK.
// The maximum value in the subarray is equal to maxK.
// Return the number of fixed-bound subarrays.

// A subarray is a contiguous part of an array.

 

// Example 1:

// Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
// Output: 2
// Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
// Example 2:

// Input: nums = [1,1,1,1], minK = 1, maxK = 1
// Output: 10
// Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 

// Constraints:

// 2 <= nums.length <= 105
// 1 <= nums[i], minK, maxK <= 106

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {

            int start = 0;
            int minStart = 0;
            int maxStart = 0;
            boolean isMin = false;
            boolean isMax = false;
            long result = 0;

            for(int i = 0; i < nums.length; i++){
                int num = nums[i];

                if(num < minK || num > maxK){
                    isMin = false;
                    isMax = false;
                    start = i+1;
                }
                if(num == minK){
                    isMin = true;
                    minStart = i;
                }
                if(num == maxK){
                    isMax = true;
                    maxStart = i;
                }
                if( isMin && isMax){
                    result += Math.min(minStart,maxStart)-start+1;
                }
            }
            return result;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
