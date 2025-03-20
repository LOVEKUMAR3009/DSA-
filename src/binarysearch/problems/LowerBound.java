package binarysearch.problems;

public class LowerBound {
  public static void main(String[] args) {
    // System.out.println(Integer.MAX_VALUE);
    int[] ar = {4 ,3, 8, 4, 7, 10};
    int ans = lowerBound(ar, 5);
    int result = UpperBound.upperBound(ar, 5);
    System.out.println(result);
    System.out.println(ans);

  }

  /*
   * find the index whose value is greter or equal than the target
   */
  public static int lowerBound(int[] array,int target){
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
