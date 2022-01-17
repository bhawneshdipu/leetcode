/**
 * @link https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class P557_ReverseWordsInStringIII {
    static class Solution {
        public String reverseWords(String s) {
            String ans="";
            String str="";
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)==' '){
                    ans+=reverse(str.toCharArray())+" ";
                    str="";
                }else{
                    str+=s.charAt(i);
                }
            }
            ans+=reverse(str.toCharArray());
            return ans;
        }
        public String reverse(char[] s){
            for(int i=0;i<s.length/2;i++){
                char ch=s[i];
                s[i]=s[s.length-i-1];
                s[s.length-i-1]=ch;
            }
            return new String(s);
        }
    }
}
