package array.triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascals {
  public static void main(String[] args) {
    // System.out.println(combination(5,2));

    // List<int[]> triangle = pascalsTriangle(5);
    // // System.out.println(triangle);
    // for(int[] a: triangle){
    //   System.out.println(Arrays.toString(a));
    // }


    List<int[]> result = printTriangle(0);
    for(int[] a: result){
      System.out.println(Arrays.toString(a));
    }


  }


  public static List<int[]> pascalsTriangle(int n) {
    List<int[]> triangle = new ArrayList<>();
    for(int i =0;i<n;i++){
      int[] temp = new int[i+1];
      for(int j =0;j<=i;j++){
        temp[j] = combination2(i, j);
      }
      triangle.add(temp);
    }
    return triangle;

  }

  public static Integer combination(int n,int r){
    if(r> n) return -1;
    if(r ==0 || r==n) return 1;
    int numerator = 1;
    int denominator = 1;
    for(int i =n;i>(n-r);i--){
      numerator = numerator*i;
    }
    for(int i = r;i>=1;i--){
      denominator = denominator*i;
    }
    return numerator/denominator;
  }

  // code by striver for combination

  public static int combination2(int n, int r) {
    if(n<r) return 0;
    if(r==0 || r==n) return 1;
    int result =1;
    for(int i =1;i<=r;i++){
      result = result*(n-i+1)/i;
    } 
    return result;
  }

  //how to print one row of triangle opttimal approch to print row

  /*
   * if we want 4th row then we have to use n as 3 
   * nc0 is always 1 so we use ans =1 and at every iteration we are multiplying someting in numerator and dividing it by something in denominator at same time 
   * 
   * 
   */

  public static int[] printRow(int n) {
    int[] row = new int[n];
    n =n-1;
    int ans =1;
    row[0] = ans;
    for(int i =1;i<=n;i++){
      ans =ans*(n-i+1)/i;
      row[i] = ans;
    }
    return row;
  }


  // optimal to print the whole pascal triangle

  public static List<int[]> printTriangle(int n) {
    List<int[]> result  = new ArrayList<>();
    if(n ==0) return result;
    for(int i =1;i<=n;i++){
      int [] row = printRow(i);
      result.add(row);
    }
    return result;
  }
}
