/**
 * @link https://leetcode.com/problems/house-robber/
 *
 */
public class P198_HouseRobber {
    static class Solution {
        public int rob(int[] nums) {
            //will use dp and track of max profit till ith house
            //dp[i]=max(dp[i-1],dp[i-2]+nums[i] // if it takes previous house it can't take current house;
            int[] profit=new int[nums.length];
            //edge cases
            if(nums.length==0){
                return 0;
            }else if(nums.length==2){
                profit[0]=nums[0];
                profit[1]=nums[1];
                return Math.max(nums[0],nums[1]);
            }else if(nums.length>1){
                profit[0]=nums[0];
                profit[1]=Math.max(nums[1],nums[0]);
            }else{
                profit[0]=nums[0];
                return nums[0];
            }
            for(int i=2;i<nums.length;i++){
                profit[i]=Math.max(profit[i-1],profit[i-2]+nums[i]);
            }
            return profit[nums.length-1];
        }
    }
}
