import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.com/problems/merge-intervals/
 */
public class P56_MergeIntervals {
    public static void main(String[] args) {

    }
   static class Solution {
        public int[][] merge(int[][] intervals) {
            //sort with first digit like scheduling algorithm
            Arrays.sort(intervals, (o1,o2)->o1[0]-o2[0]);
            List<List<Integer>> ans=new ArrayList<>();
            int k=-1;
            for(int i=0;i<intervals.length;i++){
                if(i>0){
                    if(ans.get(k).get(1)>=intervals[i][0]){
                        if(ans.get(k).get(1)<intervals[i][1]){
                            ans.get(k).set(1,intervals[i][1]);
                        }
                    }else{
                        ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                        k++;
                    }
                }else{
                    ans.add(Arrays.asList(intervals[i][0],intervals[i][1]));
                    k++;
                }
            }
            int[][] result = new int[ans.size()][2];
            for(int i=0;i< ans.size();i++){
                result[i]=new int[]{ans.get(i).get(0),ans.get(i).get(1)};
            }
            return result;
        }
    }
    static class Solution2 {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            LinkedList<int[]> merged = new LinkedList<>();
            for (int[] interval : intervals) {
                // if the list of merged intervals is empty or if the current
                // interval does not overlap with the previous, simply append it.
                if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                    merged.add(interval);
                }
                // otherwise, there is overlap, so we merge the current and previous
                // intervals.
                else {
                    merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }
    }
}
