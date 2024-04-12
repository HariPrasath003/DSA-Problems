// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

// Example 1:


// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
// Example 2:

// Input: height = [4,2,0,3,2,5]
// Output: 9
 

// Constraints:

// n == height.length
// 1 <= n <= 2 * 104
// 0 <= height[i] <= 105

class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int left = 0;
        int right = n-1;

        int maxLeft = 0;
        int maxRight = 0;
        int result = 0;

        while(left<=right){

            if(height[left]<=height[right]){
                if(height[left]>=maxLeft){
                    maxLeft = height[left];
                }
                else{
                    result+=(maxLeft-height[left]);
                }
                left++;
            }
            else{
                if(height[right]>=maxRight){
                    maxRight = height[right];
                }
                else{
                    result+=(maxRight-height[right]);
                }
                right--;
            }
        }
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)
