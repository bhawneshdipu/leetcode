/**
 * @link https://leetcode.com/problems/fibonacci-number/
 * fibonacci  number f(n)=f(n-1)+f(n-2)
 */
public class P509_FibonacciNumber {
    public static void main(String[] args) {

    }
    static class Solution {
        public int fib(int n) {
            int first=0;
            int second=1;
            int third=first+second;
            for(int i=2;i<=n;i++){
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
