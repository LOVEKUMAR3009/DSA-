package array.matrices;

import java.util.Arrays;

public class SetMatrixZero {
  public static void main(String[] args) {
    int[][] arr = {{1,1,1,1},{1,0,0,1},{1,1,0,1},{1,1,1,1},{1,0,1,0}};
    setZeroesOptimal(arr);
    // System.out.println(arr[0].length);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  /*
   * you have to set all the elements of the matrix to zero if any element is zero in the row or column in the original matrix in the matrix of nXm size

  * tc is o(n*m)*o(n+m) +o(n*m) = o(n3)
   */
  public static void setZeroesBrute(int[][] matrix) {
    int column = matrix[0].length;
    int row = matrix.length;

    // iterate and mark all the valid 1 to zero
    for(int i =0;i<row;i++){
      for(int j=0;j<column;j++){
        if(matrix[i][j] == 0){
          markRowZero(matrix,i);
          markColZero(matrix,j);
        }
      }
    }

    //converting the -1 into 0 again
    for(int i =0;i<row;i++){
      for(int j=0;j<column;j++){
        if(matrix[i][j]== -1){
          matrix[i][j]  = 0;
        }
      }
    }

  }

  public static void markRowZero(int[][] matrix,int row){
    for(int i = 0;i<matrix[row].length;i++){
      if(matrix[row][i] !=0){
        matrix[row][i] = -1;
      }
      else{
        continue;
      }

    }
  }
  public static void markColZero(int[][] matrix,int column){
    for(int i = 0;i<matrix.length;i++){
      if(matrix[i][column] !=0){
        matrix[i][column] = -1;
      }
      else{
        continue;
      }

    }
  
 
}



/*
 * take a two diffferent array and mark that array 1 if that columnn or row needs to 0 in the final array
 */
  public static void setZeroesBetter(int[][] matrix){

    int [] row = new int[matrix.length];
    int [] column = new int[matrix[0].length];

    for(int i =0;i<matrix.length;i++){
      for(int j =0;j<matrix[i].length;j++){
        if(matrix[i][j] == 0){
          row[i] = 1;
          column[j] = 1;

        }
      }
    }

    for(int i =0;i<row.length;i++){
      if(row[i] == 1){
        markRowZeroBetter(matrix, i);
      }
    }
    for(int j =0;j<column.length;j++){
      if(column[j]== 1){
        markColZeroBetter(matrix,j);
      }
    }

  }



  public static void markRowZeroBetter(int[][] matrix,int row){
    for(int i = 0;i<matrix[row].length;i++){
      matrix[row][i] = 0;

    }
  }
  public static void markColZeroBetter(int[][] matrix,int column){
    for(int i = 0;i<matrix.length;i++){
      matrix[i][column] =0;

    }
  
 
}




  /*
   * optimal solution is in which the marking array will be consider inside the array only in which first row and first column will be used as marking array
   * 
   * since there will be collision on the first element because of overlapping so we will use firstelement variable to keep the mark of the first column 
   */

  public static void setZeroesOptimal(int[][] matrix){
    int row = matrix.length;
    int column = matrix[0].length;
    
    int firstelement =1;
    
    // iterating over the matrix
    for(int i =0;i<row;i++){
      for(int j =0;j<column;j++){
        // if the element is zero then mark the corresponding column row and column zero
        if(matrix[i][j]==0){
          // marking the first column of the matrix if got any 0 on that particular row
          matrix[i][0] = 0;

          // because of overlapping we storing the mark of first column in firstelement variable
          if(j ==0){
            firstelement =0;
          }
          // marking the first row element of the matrix if got any 0 on that particular column
          else{
            matrix[0][j] = 0;
          }
        }
      }
    }

    // we will iterate over the matrix but we will start from the second row and second column because we don't want to mark the first row and first column because the storing the mark
    for(int i =1;i<matrix.length;i++){
      for(int j =1;j<matrix[i].length;j++){
        // if either corresponding row or column is zero mark the element zero

        if(matrix[i][j]!=0){
          if(matrix[0][j] ==0 || matrix[i][0]==0){
            matrix[i][j] = 0;
          }
        }
      }
    }

    // we will solve the row first because its depend on the first element of the actual array sign if it is zero than mark the whole row zero
    if(matrix[0][0]==0){
    for(int i=0;i<matrix[0].length;i++){      
        matrix[0][i] = 0;
      }
    }
    // for the first column we were storing there mark in firstelement variable so we will check the firstelement variable if it is zero than mark the whole column zero
    if(firstelement == 0){
    for(int i =0;i<matrix.length;i++){     
        matrix[i][0] =0;
      }
    }


  
  }
}
