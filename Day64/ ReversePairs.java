// Given an integer array nums, return the number of reverse pairs in the array.

// A reverse pair is a pair (i, j) where:

// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
 

// Example 1:

// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:

// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -231 <= nums[i] <= 231 - 1

class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        
        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }
    
    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int left = low;
        int right = mid + 1;
        
        while (left <= mid && right <= high) {
            if ((long)nums[left] > 2 * (long)nums[right]) {
                count += mid - left + 1; // Count the remaining elements in the left subarray
                right++;
            } else {
                left++;
            }
        }
        
        Arrays.sort(nums, low, high + 1); // Merge the two halves
        
        return count;
    }
}
