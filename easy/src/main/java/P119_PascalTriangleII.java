import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * https://stackoverflow.com/questions/26228385/time-complexity-of-recursive-algorithm-for-calculating-binomial-coefficient/26229383#26229383
 */
public class P119_PascalTriangleII {
    static class Solution {
        public List<Integer> getRow(int k) {
            Integer[] arr = new Integer[k + 1];
            Arrays.fill(arr, 0);
            arr[0] = 1;

            for (int i = 1; i <= k; i++){
                for (int j = i; j > 0; j--){
                    arr[j] = arr[j] + arr[j - 1];
                }
            }
            return Arrays.asList(arr);
        }
    }
}

/**
 *
 * DP: pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j]
 *
 *
 * Math! (specifically, Combinatorics)
 *
 * class Solution {
 *   public List<Integer> getRow(int n) {
 *     List<Integer> row =
 *         new ArrayList<>() {
 *           {
 *             add(1);
 *           }
 *         };
 *
 *     for (int k = 1; k <= n; k++) {
 *       row.add((int) ((row.get(row.size() - 1) * (long) (n - k + 1)) / k));
 *     }
 *
 *     return row;
 *   }
 * }
 */