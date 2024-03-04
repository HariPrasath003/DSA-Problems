// Problem statement
// School is organizing a team contest. You are given an array ‘SKILL’ containing the skill level of ‘N’ candidates.



// Two candidates(having index ‘i’ and ‘j’) can pair up to form a team if for index i < j, SKILL[i] > 2*SKILL[j].

// Your task is the return the count of all the possible pairs to take part in the contest.



// Example:
// Input: ‘N’ = 5
// ‘SKILL’ = [4, 1, 2, 3, 1] 

// Output: 3
// Explanation:
// Possible pairs are (4,1), (4,1), (3,1).
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 5
// 4 1 2 3 1
// Sample Output 1 :
// 3
// Explanation Of Sample Input 1:
// Possible pairs are (4,1), (4,1), and (3,1).
// Sample Input 2:
// 4 
// 100 49 201 100
// Sample Output 2 :
// 2
// Constraints:
// 1  <= N <= 10^5
// 1 <= SKILL[i] <= 10^6
// Time Limit: 1 sec


import java.util.*;

public class Solution {

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return cnt;
    }

    public static int team(int[] skill, int n) {
        return mergeSort(skill, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3, 1};
        int n = 5;
        int cnt = team(a, n);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}
