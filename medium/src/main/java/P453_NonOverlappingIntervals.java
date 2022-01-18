/* 
    Results from this solution:
        - Runtime: 3 ms, faster than 66.65% of Java online submissions for Non-overlapping Intervals.
        - Memory Usage: 42.7 MB, less than 6.25% of Java online submissions for Non-overlapping Intervals.
*/

import java.util.Arrays;

class Solution {

    /*
    This problem is very similar to the interval scheduling problem. In the interval scheduling problem you
    are given a list of time meetings (intervals with start and end times) and you have to find the maximum
    number of meetings you can attend. The solution for this problem involves using a greedy solution. In this
    greedy solution you sort the input by their ending times and only attend meetings where the current start time
    is >= the end time of the previous meeting we attend. In this problem we can do the same thing: 
        - First sort the given input by the 2nd value in each interval
        - Starting at the second interval check for the invalid condition where the current interval's first value
          is < the previous valid interval's second value.
            - If we find an invalid interval then we increase the number of invalid intervals to remove by 1.
            - This requires the program to keep track of the previous valid interval's end time.
        - Return the number of invalid intervals removed.
            
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        // Checking for invalid input:
        if (intervals.length == 0 || intervals == null)
            return 0;

        // Sort by the second number in each interval:
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int removed = 0;
        // The second value of the last valid interval.
        int prevEnd = intervals[0][1];

        // We need to traverse the sorted intervals, counting the number of invalid intervals, and
        // updating the prevEnd value when you find a valid interval.
        for (int i = 1; i < intervals.length; i++) {
            // We have an invalid interval if the  current start time is < prevEnd;
            if (intervals[i][0] < prevEnd)
                removed++;
            else {
                prevEnd = intervals[i][1];
            }
        }

        // Return the number of intervals removed:
        return removed;
    }
}