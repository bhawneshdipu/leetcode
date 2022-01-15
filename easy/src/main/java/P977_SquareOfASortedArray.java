/**
 * @link https://leetcode.com/problems/squares-of-a-sorted-array/
 * The idea is that array is already sorted and squares of any number is positive
 * We used two pointer approach to solve it in O(n)
 */
public class P977_SquareOfASortedArray {
    public static void main(String[] args) {
        new Solution().sortedSquares(new int[]{-4,-2,-1,0,1,2,4});
    }
    static class Solution {
        public int[] sortedSquares(int[] nums) {
            //find squares
            int[] squares=new int[nums.length];
            //array is already sorted and squares of -ve number is positive
            //use two pointer to place the square at correct position
            int left=0;
            int right=nums.length-1;
            for(int i=nums.length-1;i>=0;i--){
                int leftSq=nums[left]*nums[left];
                int rightSq=nums[right]*nums[right];
                if(leftSq>rightSq){
                    squares[i]=leftSq;
                    left++;
                }else{
                    squares[i]=rightSq;
                    right--;
                }
            }
            return squares;
        }
    }
}
