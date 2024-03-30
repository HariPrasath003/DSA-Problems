// Given an integer array nums and an integer k, return the number of good subarrays of nums.

// A good array is an array where the number of different integers in that array is exactly k.

// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.

 

// Example 1:

// Input: nums = [1,2,1,2,3], k = 2
// Output: 7
// Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
// Example 2:

// Input: nums = [1,2,1,3,4], k = 3
// Output: 3
// Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 

// Constraints:

// 1 <= nums.length <= 2 * 104
// 1 <= nums[i], k <= nums.length

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

         return helper(nums,k) - helper(nums,k-1);
    }
    public static int helper(int[] nums, int k){

        Map<Integer,Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int count = 0;

        while(end < nums.length){

            map.put(nums[end],map.getOrDefault(nums[end],0)+1);

            while(map.size() > k){

                map.put(nums[start],map.get(nums[start])-1);

                if(map.get(nums[start])==0){
                    map.remove(nums[start]);
                }
                start++;
            }

            count += (end - start)+1;
            end++;
        }
        return count;
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)
// Approach: Sliding Window
