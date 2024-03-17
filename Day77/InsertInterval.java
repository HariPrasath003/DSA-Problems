// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

 

// Example 1:

// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
// Example 2:

// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 

// Constraints:

// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 105
// intervals is sorted by starti in ascending order.
// newInterval.length == 2
// 0 <= start <= end <= 105

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> merged = new ArrayList<>();
        int pos = 0;

        for (var interval : intervals) {
            if (interval[0] > newInterval[0]) {
                break;
            }

            merged.add(interval);
            pos++;
        }

        if (merged.size() == 0) {
            merged.add(newInterval);
        } else {
            merge(merged, newInterval);
        }

        while (pos < intervals.length) {
            merge(merged, intervals[pos++]);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    private void merge(List<int[]> merged, int[] curr) {
        var prev = merged.get(merged.size() - 1);
        if (prev[1] >= curr[0]) {
            merged.set(merged.size() - 1, new int[]{
                prev[0],
                Math.max(prev[1], curr[1])
            });
        } else {
            merged.add(curr);
        }
    }
}