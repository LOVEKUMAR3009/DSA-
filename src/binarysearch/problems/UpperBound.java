package binarysearch.problems;

public class UpperBound {

  public static void main(String[] args) {
    // System.out.println(Integer.MAX_VALUE);
    int[] ar = {1,2,};
    int ans = upperBound(ar, 2);
    System.out.println(ans);

  }
  
  public static int upperBound(int[] array,int target){
    /*
     * what is upper bound 
     * when the arr[i]>target;
     */
    int n = array.length;
    int result = array.length;
    int left = 0;
    int right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(array[mid]>target){
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
