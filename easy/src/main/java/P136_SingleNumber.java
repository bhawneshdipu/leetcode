/**
 * @link https://leetcode.com/problems/single-number/
 * use XOR
 * use 2*sum(set(arr))-sum(arr)
 * use hashmap to count occurance and return number with 1 count
 */
public class P136_SingleNumber {
    public static void main(String[] args) {

    }
    static class Solution {
        public int singleNumber(int[] nums) {
            //1. Use XOR as A XOR A = 0, XOR of all numbers will return the single Number which is not twice
            //2. Use HashMap to track the count and return if count =1
            //3. 2*sum(set(nums))-sum(nums)
            int result=0;
            for(int i=0;i<nums.length;i++){
                result^=nums[i];
            }
            return result;
        }
    }
}
