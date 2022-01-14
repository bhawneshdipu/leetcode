/**
 * @link https://leetcode.com/problems/binary-search/
 * #binarysearch
 * #Array
 */
public class P704_BinarySearch {

    public static void main(String[] args) {
        new Solution().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},1);
    }
    static class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums,target,0,nums.length-1);
        }
        public int binarySearch(int[] nums,int target,int left,int right){
            int mid=0;
            while(left<=right){
                mid=(left+((right-left)/2));
                if(nums[mid]==target){
                    return mid;
                }else if(nums[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
            return -1;
        }
    }
}

