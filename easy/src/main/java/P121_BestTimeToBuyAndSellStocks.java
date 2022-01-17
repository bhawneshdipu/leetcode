/**
 *https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class P121_BestTimeToBuyAndSellStocks {
    static class Solution {
        public int maxProfit(int[] prices) {
            int ans=0;
            int min=prices[0];
            for(int i=0;i<prices.length;i++){
                if(min>prices[i]){
                    min=prices[i];
                }
                else if(prices[i]-min>ans){
                    ans=prices[i]-min;
                }

            }
            return ans;
        }
    }
}
/**
 * The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following the smallest valley. We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
 * public class Solution {
 *     public int maxProfit(int prices[]) {
 *         int minprice = Integer.MAX_VALUE;
 *         int maxprofit = 0;
 *         for (int i = 0; i < prices.length; i++) {
 *             if (prices[i] < minprice)
 *                 minprice = prices[i];
 *             else if (prices[i] - minprice > maxprofit)
 *                 maxprofit = prices[i] - minprice;
 *         }
 *         return maxprofit;
 *     }
 * }
 */
