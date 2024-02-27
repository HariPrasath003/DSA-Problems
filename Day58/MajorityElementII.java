// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

// Example 1:

// Input: nums = [3,2,3]
// Output: [3]
// Example 2:

// Input: nums = [1]
// Output: [1]
// Example 3:

// Input: nums = [1,2]
// Output: [1,2]
 

// Constraints:

// 1 <= nums.length <= 5 * 104
// -109 <= nums[i] <= 109
 

// Follow up: Could you solve the problem in linear time and in O(1) space?

class Solution {
public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        qSort(nums, 0, nums.length - 1,ans);
        return ans;
    }
    private void qSort(int[] nums,int a,int b,List<Integer> ans) {
        int len = nums.length / 3;
        if (b - a < len)
            return;
        int l = a;
        int r = b;
        int i = a+1;
        while(r>=i){
            if (nums[l] > nums[i]) {
                swap(nums, l, i);
                i++;
                l++;
            }
            else if(nums[l] < nums[i]){
                if(nums[i] > nums[r])
                    swap(nums, r, i);
                r--;
            }
            else
                i++;
        }
        if (r - l >= len)
            ans.add(nums[r]);
        qSort(nums, a, l - 1, ans);
        qSort(nums, r + 1, b, ans);
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

}