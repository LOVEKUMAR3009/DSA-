package binarysearch.problems;

public class Ceil {
  public static void main(String[] args) {
    int[] ar = {1,2,4,5,8,11,13,14,15,20};
    System.out.println(ceil(ar, 21));
  }

  public static int ceil(int[]arr,int target){
    int n = LowerBound.lowerBound(arr, target);
    if(n == arr.length){
      return -1;
    }
    return n;
  }
}
