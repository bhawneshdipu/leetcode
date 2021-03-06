/**
 * @Link  https://leetcode.com/problems/majority-element/
 *
 *
 *      A A A C C B B C C C B C C
 *      ^
 *      ?:0
 *      We will sweep down the sequence starting at the pointer position shown above.
 *
 *      As we sweep we maintain a pair consisting of a current candidate and a counter. Initially, the current candidate is unknown and the counter is 0.
 *
 *      When we move the pointer forward over an element e:
 *
 *      If the counter is 0, we set the current candidate to e and we set the counter to 1.
 *      If the counter is not 0, we increment or decrement the counter according to whether e is the current candidate.
 *      When we are done, the current candidate is the majority element, if there is a majority.
 *
 */
public class P169_MajorityElement {

    class Solution {
        public int majorityElement(int[] nums) {
            int majority = 0;
            int count=0;
            for(int i=0;i<nums.length;i++){
                if(count==0){
                    majority=nums[i];
                    count++;
                }else if(majority==nums[i]){
                    count++;
                }else{
                    count--;
                }
            }
            return majority;
        }
    }
}
