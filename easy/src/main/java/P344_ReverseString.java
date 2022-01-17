/**
 * @link https://leetcode.com/problems/reverse-string/
 *
 */
public class P344_ReverseString {
    static class Solution {
        public void reverseString(char[] s) {
            for(int i=0;i<s.length/2;i++){
                char ch=s[i];
                s[i]=s[s.length-i-1];
                s[s.length-i-1]=ch;
            }
        }
    }
}
