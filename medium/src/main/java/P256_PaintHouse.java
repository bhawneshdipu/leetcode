public class P256_PaintHouse {
    static class Solution {
        public int minCost(int[][] costs) {
            if(costs==null||costs.length==0){
                return 0;
            }
            for(int i=1; i<costs.length; i++){
                costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
                costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
                costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
            }
            int n = costs.length-1;
            return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
        }
    }
}
/**
 * Justifying why this is a Dynamic Programming Problem
 * Many dynamic programming problems have very straightforward solutions. As you get more experience with them, you'll gain a better intuition for when a problem might be solvable with dynamic programming, and you'll also get better at quickly identifying the overlapping subproblems (e.g. that painting the 3rd house green will have the same total cost regardless of whether the 2nd house was blue or red). Thinking about the tree structure can help too for identifying those subproblems, although you won't always need to draw it out fully like we did here.
 *
 * Remember that a subproblem is any call to the recursive function. Subproblems are solved either as a base case (in this case a simple lookup from the table and no further calculations) or by looking at the solutions of a bunch of lower down subproblems. In dynamic programming lingo, we say that this problem has an optimal substructure. This means that the optimal cost for each subproblem is constructed from the optimal cost of subproblems below it. This is the same property that must be true for greedy algorithms to work.
 *
 * If, for example, we hadn't been able to choose the minimum and know it was optimal (perhaps because it would impact a choice further up the tree) then there would not have been optimal substructure.
 *
 * In addition this problem also had overlapping subproblems. This just means that the lower subproblems were often shared (remember how the tree had lots of branches that looked the same?)
 *
 * Problems that have optimal substructure can be solved with greedy algorithms. If they also have overlapping subproblems, then they can be solved with dynamic programming algorithms.
 * 
 * class Solution {
 *     public int minCost(int[][] costs) {
 *
 *         for (int n = costs.length - 2; n >= 0; n--) {
 *             // Total cost of painting the nth house red.
 *             costs[n][0] += Math.min(costs[n + 1][1], costs[n + 1][2]);
 *             // Total cost of painting the nth house green.
 *             costs[n][1] += Math.min(costs[n + 1][0], costs[n + 1][2]);
 *             // Total cost of painting the nth house blue.
 *             costs[n][2] += Math.min(costs[n + 1][0], costs[n + 1][1]);
 *         }
 *
 *         if (costs.length == 0) return 0;
 *
 *         return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
 *     }
 * }
 */