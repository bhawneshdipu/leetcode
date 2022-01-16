/**
 * @link https://leetcode.com/problems/move-zeroes/
 *             //use two pointer
 *             //one will point to filling position and 2nd will point to element to be filled
 *             //at last fill other with 0
 */
public class P283_MoveZeros {
    static class Solution {
        public void moveZeroes(int[] nums) {
            //use two pointer
            //one will point to filling position and 2nd will point to element to be filled
            //at last fill other with 0

            int i=0;
            int j=0;
            while(i<nums.length && j<nums.length){
                if(nums[j]==0){
                }else{
                    nums[i++]=nums[j];
                }
                j++;
            }
            while(i<nums.length){
                nums[i++]=0;
            }
        }
    }
}
