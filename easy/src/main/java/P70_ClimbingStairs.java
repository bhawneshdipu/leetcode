/**
 * @link https://leetcode.com/problems/climbing-stairs/
 *     //number of ways to reach nth step
 *    // if we have two options 1 step and 2 step
 *    //ways[n]=ways[n-1]+ways[n-2]
 *    // if we have three options 1 step , 2 step and 3 step
 *    //ways[n]= ways[n-1]+ways[n-2]+ways[n-3]
 */
public class P70_ClimbingStairs {
    public static void main(String[] args) {

    }
    static class Solution {
        public int climbStairs(int n) {
            //number of ways to reach nth step
            // if we have two options 1 step and 2 step
            //ways[n]=ways[n-1]+ways[n-2]
            // if we have three options 1 step , 2 step and 3 step
            //ways[n]= ways[n-1]+ways[n-2]+ways[n-3]

            int first=0;
            int second=1;
            int third=first+second;
            for(int i=1;i<=n;i++){
                third=first+second;
                first=second;
                second=third;
            }
            if(n==0){
                return 0;
            }else if(n==1){
                return 1;
            }else{
                return third;
            }
        }
    }
}
