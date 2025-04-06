package binarysearch.problems;
public class MissingKElement {
  public static void main(String[] args) {
    int[] arr = {4,7,9,10};
    int k = 7;
    System.out.println(findMissingKElement(arr, k));
  }
  public static int findMissingKElement(int[] arr, int k) {

    if(arr[0]>k){
      return k;
    }
    int left = 0;
    int leftindex = -1;
    int leftexempet = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if(arr[mid]-mid-1 >=k){
        right = mid-1;
      }
      else{
        leftexempet = arr[mid]-mid-1;
        leftindex = mid;
        left = mid+1;
      }
  }
  return arr[leftindex]+(k-leftexempet);
}
}