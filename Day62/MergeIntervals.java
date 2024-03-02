// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

// Example 1:

// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// Example 2:

// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

// Constraints:

// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104

import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            if (interval[0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = interval;
            }
        }
        
        mergedIntervals.add(currentInterval);
        
        int[][] result = new int[mergedIntervals.size()][2];
        for (int i = 0; i < mergedIntervals.size(); i++) {
            result[i] = mergedIntervals.get(i);
        }
        
        return result;
    }
}
