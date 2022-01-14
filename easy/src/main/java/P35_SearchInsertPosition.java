/**
 * @link https://leetcode.com/problems/search-insert-position/
 * Use binary search to find the position and if not found retrun the left index.
 *
 */
public class P35_SearchInsertPosition {
    public static void main(String[] args) {
        new Solution().searchInsert(new int[]{1,3,5,6},5);
    }
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left=0;
            int right=nums.length-1;
            int mid=0;
            while(left<=right){
                mid=left + (right-left)/2;
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            return left;
        }
    }
}
