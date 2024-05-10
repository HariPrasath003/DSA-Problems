// Problem statement
// Ninja is playing with intervals. He has an array of intervals called ‘Arr’ having ‘N’ intervals.



// However, he doesn’t like overlapping intervals. So you must help Ninja by merging all the overlapping intervals in ‘Arr’ and return an array of non-overlapping intervals.



// Note:
// Two intervals [L1, R1] and [L2, R2] such that L1 <= L2, are said to be overlapping if and only if L2 <= R1.
// For example:
// For ‘N’ = 4, and 
// ‘Arr’ = {{1, 3}, {2, 4}, {3, 5}, {6, 7}}
// We can see that {1, 3} and {2, 4} overlap, so if we merge them, we get {1, 4}.
// Now ‘Arr’ becomes: {{1, 4}, {3, 5}, {6, 7}}
// Still, we observe that {1, 4} and {3, 5} overlap, hence we merge them into {1, 5}.
// Hence, ‘Arr’ becomes {{1, 5}, {6, 7}}.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// 9
// 1 2
// 1 3
// 1 6
// 3 4
// 4 4
// 4 5
// 5 5
// 6 6
// 6 6
// Sample Output 1 :
// 1 6
// Explanation Of Sample Input 1:
// Arr after each merge
// {{1, 2}, {1, 3}, {1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
// {{1, 3}, {1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
// {{1, 6}, {3, 4}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
// {{1, 6}, {4, 4}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
// {{1, 6}, {4, 5}, {5, 5}, {6, 6}, {6, 6}}
// {{1, 6}, {5, 5}, {6, 6}, {6, 6}}
// {{1, 6}, {6, 6}, {6, 6}}
// {{1, 6}, {6, 6}}
// {{1, 6}}
// Sample Input 2:
// 7
// 2 2
// 2 3
// 2 5
// 3 6
// 4 4
// 4 5
// 6 6
// Sample Output 2:
// 2 6
// Constraints:
// 1 <= N <= 10^5
// 1 <= L <= R <= 10^9

// Time Limit: 1 sec.


import java.util.*;

public class Solution {
    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        ans.add(new ArrayList<>());
        ans.get(0).add(arr[0][0]);
        ans.get(0).add(arr[0][1]);

        for (int[] interval : arr) {
            if (areOverlapping(interval, ans.get(ans.size() - 1)))
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), interval[1]));
            else {
                ans.add(new ArrayList<>());
                ans.get(ans.size() - 1).add(interval[0]);
                ans.get(ans.size() - 1).add(interval[1]);
            }
        }
        return ans;
    }

    public static boolean areOverlapping(int[] a, List<Integer> b) {
        if (a[0] <= b.get(0))
            return b.get(0) <= a[1];
        return a[0] <= b.get(1);
    }
}
