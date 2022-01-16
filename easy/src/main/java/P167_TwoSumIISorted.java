/**
 * @link https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *  //array is sorted
 *             //using two pointer to find the sum to target
 */
public class P167_TwoSumIISorted {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //array is sorted
            //using two pointer to find the sum to target
            int left=0;
            int right=numbers.length-1;
            while(left<right){
                int sum=numbers[left]+numbers[right];
                if(sum==target){
                    return new int[]{left+1,right+1};
                }else if(sum>target){
                    right--;
                }else{
                    left++;
                }
            }
            return new int[]{};
        }
    }
}
