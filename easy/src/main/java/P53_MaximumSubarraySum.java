/**
 * @link https://leetcode.com/problems/maximum-subarray/
 * use kadense algorithm
 */
public class P53_MaximumSubarraySum {
    static class Solution {
        public int maxSubArray(int[] nums) {
            //use kadense algorithm for max sum continous subarray
            int globalSum=Integer.MIN_VALUE;
            int localSum=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>localSum+nums[i]){
                    localSum=nums[i];
                }else{
                    localSum+=nums[i];
                }
                globalSum=Math.max(globalSum,localSum);
            }
            return globalSum;
        }
    }
}
