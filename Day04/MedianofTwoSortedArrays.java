// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

 

// Example 1:

// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.
// Example 2:

// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.



class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int[] mergedNums = merge(nums1 , nums2);

        if(mergedNums.length % 2 == 1){
            return mergedNums[mergedNums.length / 2];
        }
        return((double)mergedNums[mergedNums.length/2]+
        (double)mergedNums[(mergedNums.length /2) - 1]) / 2;
    }
    public int[] merge(int[] nums1, int[] nums2){

        int[] mergedNums = new int[nums1.length + nums2.length];

        int i =0;
        int j =0;
        int k =0;

        while (i< nums1.length && j< nums2.length){
            if(nums1[i] < nums2[j]){
                mergedNums[k] = nums1[i];
                i++;
            }else{
                mergedNums[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < nums1.length){
            mergedNums[k] = nums1[i];
            i++;
            k++;
        }
        while(j < nums2.length){
            mergedNums[k] = nums2[j];
            j++;
            k++;
        }
        return mergedNums;
        
    }
}