// Problem statement
// You are given an array ‘ARR’ containing ‘N’ integers.



// Return all the unique triplets [ARR[i], ARR[j], ARR[k]] such that i != j, j != k and k != i and their sum is equal to zero.



// Example:
// Input: ‘N’ = 5 
// 'ARR' =  [-1, -1, 2, 0, 1] 

// Output: 
// -1 -1 2
// -1 0 1

// Explanation:
// (-1 -1 +2) = (-1 +0 +1) = 0.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 5 
// -1 -1 2 0 1
// Sample Output 1 :
// -1 -1 2
// -1 0 1
// Explanation Of Sample Input 1:
// (-1 -1 +2) = (-1 +0 +1) = 0.
// Sample Input 2:
// 4 
// 0 0 0 0
// Sample Output 2 :
// 0 0 0
// Constraints:
// 1  <= N <= 1000
// 1 <= ARR[i] <= 1000
// Time Limit: 1 sec

import java.util.*;

public class Solution {
    public static List<List<Integer>> triplet(int n, int[] arr) {

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int idx = 0; idx < (n-2); idx++) {

            if(idx == 0 || (arr[idx] != arr[idx-1])) {
                
                int left = idx+1, right = n-1, sum = -arr[idx];
                while(left < right) {
                    if((arr[left] + arr[right]) == sum) {

                        ans.add(Arrays.asList(arr[idx], arr[left], arr[right]));

                        while(left < right && arr[left] == arr[left+1]) {
                            left++;
                        }

                        while(left < right && arr[right] == arr[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                    
                    else if((arr[left] + arr[right]) < sum) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }
}
