package array.matrices;

import java.util.Arrays;

import array.rotation.LeftRoatation;

public class RotateMatrix {
  public static void main(String[] args) {
    
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

     rotateMatrix(matrix);
    for(int [] arr :matrix){
      System.out.println(Arrays.toString(arr));
    }
    
  }
  /*
   * 
   */
  public static int[][] rotateMatrixBrute(int[][] matrix) {
    int row =  matrix.length;
    int col = matrix[0].length;
    int[][] rotated = new int[col][row];

    // iterate over each element in the matrix at it correct position in the rotated matrix
    for(int i =0;i<row;i++){
      for(int j =0;j<col;j++){
        // current column will be row in the rotated matrix and temp will be there new column
        int temp = row-1-i; 
        rotated[j][temp] = matrix[i][j]; 
      }
    }
    return rotated;
  }




  public static void rotateMatrix(int[][] matrix) {
    // transpose the matrix
    TransposeMatrix.transpose(matrix);
    for(int i = 0; i < matrix.length; i++){
      // reverse each row
      LeftRoatation.reverseArray(matrix[i], 0, matrix[i].length-1);     
    }
  }

}

