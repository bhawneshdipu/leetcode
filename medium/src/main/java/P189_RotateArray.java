/**
 * @link https://leetcode.com/problems/rotate-array/
 * O(N) with extra space
 * also without extra space;
 *
 */
public class P189_RotateArray {
    public static void main(String[] args) {
        new Solution().rotate(new int[]{1,2,3,4,5,6,7,8,9},3);
    }
    static class Solution {
        public void rotate(int[] nums, int k) {
            //if extra memory allowed
            // take the last k and fill neww array, then take first n-k and fill new array

            // if no extra space then
            //1. reverse 0->n
            //2. reverse 0-k
            //3. revrese k->n
            //take k%=n
            k%=nums.length;
            nums=reverse(nums,0,nums.length-1);
            nums=reverse(nums,0,k-1);
            nums=reverse(nums,k,nums.length-1);
        }
        public int[] reverse(int[] arr,int start,int end){
            while(start<end){
                int tmp=arr[start];
                arr[start]=arr[end];
                arr[end]=tmp;
                start++;
                end--;
            }
            return arr;
        }
    }
}
