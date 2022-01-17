/**
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class P59_SpiralMatrixII {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] ret = new int[n][n];
            int left = 0,top = 0;
            int right = n -1,down = n - 1;
            int count = 1;
            //4 steps
            while (left <= right) {
                for (int j = left; j <= right; j ++) {
                    ret[top][j] = count++; //left to right
                }
                top ++; //increase top row count
                for (int i = top; i <= down; i ++) {
                    ret[i][right] = count ++; //top to bottom
                }
                right --; //decrease one right column
                for (int j = right; j >= left; j --) {
                    ret[down][j] = count ++; // right to left
                }
                down --;//descrease one bottom row
                for (int i = down; i >= top; i --) {
                    ret[i][left] = count ++; //bottom to top
                }
                left ++; // increase left row column
            }
            return ret;
        }
    }
}
/**
 * class Solution {
 *     public int[][] generateMatrix(int n) {
 *         int[][] result = new int[n][n];
 *         int cnt = 1;
 *         for (int layer = 0; layer < (n + 1) / 2; layer++) {
 *             // direction 1 - traverse from left to right
 *             for (int ptr = layer; ptr < n - layer; ptr++) {
 *                 result[layer][ptr] = cnt++;
 *             }
 *             // direction 2 - traverse from top to bottom
 *             for (int ptr = layer + 1; ptr < n - layer; ptr++) {
 *                 result[ptr][n - layer - 1] = cnt++;
 *             }
 *             // direction 3 - traverse from right to left
 *             for (int ptr = layer + 1; ptr < n - layer; ptr++) {
 *                 result[n - layer - 1][n - ptr - 1] = cnt++;
 *             }
 *             // direction 4 - traverse from bottom to top
 *             for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
 *                 result[n - ptr - 1][layer] = cnt++;
 *             }
 *         }
 *         return result;
 *     }
 * }
 */