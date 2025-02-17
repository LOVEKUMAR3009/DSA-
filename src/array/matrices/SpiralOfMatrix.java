package array.matrices;

import java.util.Arrays;

public class SpiralOfMatrix {
  public static void main(String[] args) {
    int [][] arr = {
      {1, 2, 3, 4},
      {5, 6, 7, 8},
      {9, 10, 11, 12}
      };
      int [] result = spiralOfMatrix(arr);
      System.out.println(Arrays.toString(result));
  }

 

  public static int[] spiralOfMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[] result = new int[row * col];
    int k = -1;
    int top = 0;
    int right = col - 1;
    int left = 0;
    int bottom = row - 1;

    while (left <= right && top <= bottom) {
        // Traverse from left to right along the top row
        for (int i = left; i <= right; i++) {
            result[++k] = matrix[top][i];
        }
        top++;

        // Traverse from top to bottom along the right column
        for (int i = top; i <= bottom; i++) {
            result[++k] = matrix[i][right];
        }
        right--;

        // Traverse from right to left along the bottom row, if still within bounds
        if (top <= bottom) {
            for (int i = right; i >= left; i--) {
                result[++k] = matrix[bottom][i];
            }
            bottom--;
        }

        // Traverse from bottom to top along the left column, if still within bounds
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result[++k] = matrix[i][left];
            }
            left++;
        }
    }

    return result;
}

}
