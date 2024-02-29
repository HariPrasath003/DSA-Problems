// Problem statement
// You are given an array ‘NUMS’ of length ‘N’. You are also given an integer ‘TARGET’.



// Return an array of all the unique quadruplets [ ‘NUMS[ a ]’, ‘NUMS[ b ]’, ‘NUMS[ c ]’, ‘NUMS[ d ]’ ] with the following conditions:



// i. 0 <= a, b, c, d < ‘N’ and a, b, c, and d are distinct.

// ii. NUMS[ a ] + NUMS[ b ] + NUMS[ c ] +NUMS[ d ] = TARGET



// Return the array in any order.



// Note:


// (NUMS[ a ], NUMS[ b ], NUMS[ c ], NUMS[ d ]), (NUMS[ a ], NUMS[ d ], NUMS[ c ], NUMS[ b ]), (NUMS[ a ], NUMS[ c ], NUMS[ b ], NUMS[ d ])... all of them are treated or considered the same quadruplets.



// Two quadruplets are different if there is any integer in one quadruplet which is not in the other.



// The solution will be verified by the number of valid quadruplets returned. In the output, only the number of valid quadruplets will be printed.



// Example:
// Input: ‘N’ = 5,  ‘TARGET’ = 5, ‘NUMS’ = [ 1, 2, 1, 0, 1 ]

// Output: 1.

// There is only one unique quadruplet with sum = 5 and that is [1, 2, 1, 1].
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 6 8
// 2 2 2 2 1 3
// Sample Output 1 :
// 2
// Explanation Of Sample Input 1:
// (2+2+2+2) = (2+2+1+3) = 4.
// Sample Input 2:
// 4 4
// 1 1 1 0
// Sample Output 2 :
// 0
// Constraints :
// 4 <= N <= 100
// -10^6 <= NUMS[ i ] <= 10^6
// -10^6 <= TARGET <= 10^6


// Time Limit: 1 sec

import java.util.*;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {

                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {

                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
