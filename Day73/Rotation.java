// You are given an array 'arr' having 'n' distinct integers sorted in ascending order. The array is right rotated 'r' times



// Find the minimum value of 'r'.



// Right rotating an array means shifting the element at 'ith' index to (‘i+1') mod 'n' index, for all 'i' from 0 to ‘n-1'.



// Example:
// Input: 'n' = 5 , ‘arr’ = [3, 4, 5, 1, 2]

// Output: 3 

// Explanation:
// If we rotate the array [1 ,2, 3, 4, 5] right '3' times then we will get the 'arr'. Thus 'r' = 3.


// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 4
// 2 3 4 1


// Sample Output 1:
// 3   


// Explanation of sample output 1:
// If we right rotate the array {1, 2, 3, 4} by '3' times then we will get {2, 3, 4, 1}. Thus 'r' = 3.


// Sample Input 2:
// 3
// 1 2 3


// Sample Output 2:
// 0


// Explanation of sample output 2:
// If we right rotate the array {1, 2, 3} by '0' time then we will get {1, 2, 3}. Thus 'r' = 0.


// Expected time complexity:
// Can you solve this in O(logn) time complexity?


// Constraints:
// 1 <= ‘n’ <= 10^5    
// 1 <= ‘arr[i]’ <= 10^9
// Time Limit: 1 sec

public class Solution {
    public static int findKRotation(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (arr[mid] > arr[mid + 1]) {
                return mid + 1;
            }

            if (arr[mid] > arr[low]) {
                low = mid + 1;
            } else { 
                high = mid;
            }
        }
        return 0;
    }
}
