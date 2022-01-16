/**
 * https://leetcode.com/problems/house-robber-ii/
 */
public class P213_HouseRobberII{
    static class Solution {
        public int rob(int[] nums) {
            //will use dp and track of max profit till ith house
            //dp[i]=max(dp[i-1],dp[i-2]+nums[i] // if it takes previous house it can't take current house;
            //circular arrangement so if we rob 1st then we can't rob last
            //we can excluse 1st house or last one

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
            //excluse last one
            for(int i=2;i<nums.length-1;i++){
                profit[i]=Math.max(profit[i-1],profit[i-2]+nums[i]);
            }
            int max=profit[nums.length-2];
            profit[1]=nums[1];
            profit[2]=Math.max(nums[1],nums[2]);
            //excluse first one
            for(int i=3;i<nums.length;i++){
                profit[i]=Math.max(profit[i-1],profit[i-2]+nums[i]);
            }

            return Math.max(profit[nums.length-1],max);
        }
    }
}
