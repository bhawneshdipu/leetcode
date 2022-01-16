import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://leetcode.com/problems/3sum/
 * fix X use two pointer
 * skip duplicates
 */
public class P15_3Sum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans=new ArrayList<>();
            //fix X;
            for(int i=0;i<nums.length-2;i++){
                //skip the same elements
                if(i > 0 && nums[i]==nums[i-1]){
                    continue;//not i++ as i++ will also be executing at the end of loop
                }
                int X=nums[i];
                //use two-pointer to find pair Y+Z=0
                int left=i+1;
                int right=nums.length-1;
                while(left<right){
                    int Y=nums[left];
                    int Z=nums[right];
                    if(X+Y+Z==0){
                        //found the triplet
                        ans.add(Arrays.asList(X,Y,Z));
                        left++;
                        right--;
                        //skip same element on the left;
                        while(left<right && nums[left]==nums[left-1]){
                            left++;
                        }
                        //skip same element on the right;
                        while(left<right && nums[right]==nums[right+1]){
                            right--;
                        }
                    }else if(X+Y+Z<0){
                        //need to increase left element as array is sorted
                        left++;
                    }else{
                        //need to decrease right element as array is sorted
                        right--;
                    }
                }
            }
            return ans;
        }
    }
}
