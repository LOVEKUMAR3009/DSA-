package binarysearch.problems;

public class Ceil {
  public static void main(String[] args) {
    int[] ar = {3,4,4,7,8,10};
    System.out.println(ceil(ar, 8));
  }

  public static int ceil(int[]array,int target){
    int result = array.length;
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(array[mid]>=target){ 
        result = mid;
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }
    return result;
  }
}
