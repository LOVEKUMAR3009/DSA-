package leetcode;
public class Q2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        int num = 1;  
        int xor = 0;
        int arrayxor = 0;
        for(int i =0;i<n;i++){
          for(int j = 0;i<n;i++){
            arrayxor ^= grid[i][j];
            xor = grid[i][j]^num;
            num++;
          }                                                                                                           
        }


      return ans;
    }
}
