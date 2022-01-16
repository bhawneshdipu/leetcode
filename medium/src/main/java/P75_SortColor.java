/**
 * @link https://leetcode.com/problems/sort-colors/
 */
public class P75_SortColor {
    static class Solution {
        public void sortColors(int[] nums) {
            //sort the array using two pointer
            // this method is used to sort array with only 3-types of elements in one-pass

            int left=0;
            int right=nums.length-1;
            for(int i=0;i<=right;i++){// imp i<right as we don't want to resort and change order
                //System.out.println(":"+Arrays.toString(nums));
                if(nums[i]==0){
                    int tmp=nums[left];
                    nums[left++]= nums[i];
                    nums[i]=tmp;
                }else if(nums[i]==2){
                    int tmp=nums[right];
                    nums[right--]= nums[i];
                    nums[i]=tmp;
                    i--;//important as what is comming from right has to scan
                }
                //System.out.println("->"+Arrays.toString(nums));
            }
        }
    }
}
