import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class P48_RotateImage {
    static class Solution {
        public void rotate(int[][] matrix) {
            /*
             * clockwise rotate
             * first reverse up to down, then swap the symmetry
             * 1 2 3     7 8 9     7 4 1
             * 4 5 6  => 4 5 6  => 8 5 2
             * 7 8 9     1 2 3     9 6 3
             */
            /*
             * anticlockwise rotate
             * first reverse left to right, then swap the symmetry
             * 1 2 3     3 2 1     3 6 9
             * 4 5 6  => 6 5 4  => 2 5 8
             * 7 8 9     9 8 7     1 4 7
             */
            // reverse
            int start=0,end=matrix.length-1;
            while(start<end){
                int[] tmp=matrix[start];
                matrix[start]=matrix[end];
                matrix[end]=tmp;
                start++;
                end--;
            }
            //System.out.println(Arrays.deepToString(matrix));
            // swap with symmetry
            for(int i=0;i<matrix.length;i++){
                for(int j=i+1;j<matrix[i].length;j++){
                    int tmp=matrix[i][j];
                    matrix[i][j]=matrix[j][i];
                    matrix[j][i]=tmp;
                }
            }

        }

    }
}
