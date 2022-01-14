/**
 * @link https://leetcode.com/problems/first-bad-version/
 * The question is asking for the first bad version and not the count
 * but we have to call the function minium number of times
 * using binary search
 */
public class P278_FirstBadVersion {
    public static void main(String[] args) {
        new Solution().firstBadVersion(5);
    }

    static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int low=0;
            int high=n;
            int ans=n;
            int mid=0;
            while(low<=high){
                mid=low + (high-low)/2;
                if(isBadVersion(mid)){
                    high=mid-1;
                    ans=mid;
                }else{
                    low=mid+1;
                }
            }
            return ans;
        }
    }
    static class VersionControl{
        public static boolean isBadVersion(int n){
            return true;
        }
    }
}
