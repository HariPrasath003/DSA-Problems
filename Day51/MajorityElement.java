// Problem statement
// You are given an array 'a' of 'n' integers.

// A majority element in the array ‘a’ is an element that appears more than 'n' / 2 times.

// Find the majority element of the array.

// It is guaranteed that the array 'a' always has a majority element.

// Example:
// Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

// Output: 1

// Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
// Hence ‘1’ is the majority element.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 9
// 2 2 1 3 1 1 3 1 1


// Sample Output 1:
// 1


// Explanation Of Sample Input 1:
// Input: ‘n’ = 9, ‘a’ = [2, 2, 1, 3, 1, 1, 3, 1, 1]

// Output: 1

// Explanation: The frequency of ‘1’ is 5, which is greater than 9 / 2.
// Hence ‘1’ is the majority element.


// Sample Input 2:
// 1
// 4


// Sample Output 2:
// 4


// Sample Input 3:
// 5
// -53 75 56 56 56 


// Sample Output 3:
// 56


// Expected time complexity :
// The expected time complexity is O(n).


// Constraints :
// 1 <= 'n' <= 10000
// 0 <= 'arr[i]' <= 10^9

// Time limit: 1 second

public class Solution {
    public static int majorityElement(int []v) {

        int n = v.length;

        for(int i = 0; i < n; ++i) {
            int curr = v[i], cnt = 0;

            for(int j = 0; j < n; ++j) {
                if(curr == v[j]) ++cnt;
            }
            if(cnt > n / 2) {
                return curr;
            }
        }
        return 0;
    }
}   