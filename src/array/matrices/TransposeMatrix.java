package array.matrices;

import java.util.Arrays;

public class TransposeMatrix {
  
  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},  
      {7, 8, 9}
    };
    transpose(matrix);
    for(int [] arr :matrix){
      System.out.println(Arrays.toString(arr));
    }
  }


  public static void transpose(int[][] matrix){

    int row = matrix.length;
    //iterate over the matrix
    for(int i =0;i<row;i++){
      for(int j =0;j<matrix[i].length;j++){
        // using continue because don't want to swap again 
        if(i<=j){
          continue;
        }
        else{
          int temp = matrix[i][j];
          matrix[i][j] = matrix[j][i];
          matrix[j][i] = temp;
        }
      }
  }
  }
}
