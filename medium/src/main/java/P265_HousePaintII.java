/**
 * @link https://leetcode.com/problems/paint-house-ii/submissions/
 * To solve this DP problem:
 *
 *     If there's no constraint, we choose min cost for each house.
 *     Since house[i] and house[i - 1] cannot have the same color j, we should choose 2nd min color for house[i - 1].
 *     If we choose the 3rd min color for house[i - 1], we might miss potential min cost.
 *     min(i) = min(cost[i][j] + 1st min / 2nd min), 0 < j < n.
 *     Since current row only relies on last row for getting mins and avoiding same color, O(1) space is enough.
 *
 *
 */
public class P265_HousePaintII {
    static class Solution {
        public int minCostII(int[][] costs) {
            if (costs.length == 0) {
                return 0;
            }
            int min1 = 0, min2 = 0, index1 = -1;

            for (int i = 0; i < costs.length; i++) {
                int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx1 = -1;

                for (int j = 0; j < costs[0].length; j++) {
                    int cost = costs[i][j] + (j != index1 ? min1 : min2);

                    if (cost < m1) {           // cost < m1 < m2
                        m2 = m1; m1 = cost; idx1 = j;

                    } else if (cost < m2) {    // m1 < cost < m2
                        m2 = cost;
                    }
                }

                min1 = m1; min2 = m2; index1 = idx1;
            }
            return min1;
        }
    }
}
/**
 * Intuition
 *
 * Despite Paint House II being listed as a hard question, and the problem statement listing O(n⋅k) time as a "follow up", you'd possibly be expected to come up with this solution at top companies as it's still a fairly basic dynamic programming algorithm. You should, therefore, ensure you're comfortable with this approach and could identify and apply similar observations in other dynamic programming problems. At the very least, it'll make you look awesome!
 *
 * So far, all of our approaches have had a O(n⋅k2) time complexity. This is because calculating the new value for each of the O(n⋅k) cells required looking at each of the kk cells in the row immediately below.
 *
 * However, we don't need to look at the entire previous row for every cell. Let's look again at the large example from above. When we're calculating the values for the second row, we're adding the minimum from the first row onto them. The only cell we can't do this for is the one that was directly below the minimum, as this would break the adjacency rule. For this one, it makes sense to add the second minimum.
 *
 * Time complexity : O(n⋅k).
 *
 * The first loop that finds the minimums of the first row is O(k)O(k) because it looks at each of the kk values in the first row exactly once. The second loop is O(n \cdot k)O(n⋅k) because the outer loop loops nn times, and the inner loop loops kk times. O(n \cdot k) + O(k) = O(n \cdot k)O(n⋅k)+O(k)=O(n⋅k). We know it is impossible to ever do better here, because we cannot solve the problem without at least looking at each of the n \cdot kn⋅k cells once.
 *
 * Space complexity :O(1).
 *
 * Like approach 2, this approach also modifies the input instead of allocating its own space.
 * class Solution {
 *
 *     public int minCostII(int[][] costs) {
 *
 *         if (costs.length == 0) return 0;
 *         int k = costs[0].length;
 *         int n = costs.length;
 *
 *         for (int house = 1; house < n; house++) {
 *
 *             // Find the minimum and second minimum color in the PREVIOUS row.
 *             int minColor = -1; int secondMinColor = -1;
 *             for (int color = 0; color < k; color++) {
 *                 int cost = costs[house - 1][color];
 *                 if (minColor == -1 || cost < costs[house - 1][minColor]) {
 *                     secondMinColor = minColor;
 *                     minColor = color;
 *                 } else if (secondMinColor == -1 || cost < costs[house - 1][secondMinColor]) {
 *                     secondMinColor = color;
 *                 }
 *             }
 *
 *             // And now calculate the new costs for the current row.
 *             for (int color = 0; color < k; color++) {
 *                 if (color == minColor) {
 *                     costs[house][color] += costs[house - 1][secondMinColor];
 *                 } else {
 *                     costs[house][color] += costs[house - 1][minColor];
 *                 }
 *             }
 *         }
 *
 *         // Find the minimum in the last row.
 *         int min = Integer.MAX_VALUE;
 *         for (int c : costs[n - 1]) {
 *             min = Math.min(min, c);
 *         }
 *         return min;
 *     }
 * }
 */