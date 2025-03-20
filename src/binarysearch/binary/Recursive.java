package binarysearch.binary;

public class Recursive {
  public static void main(String[] args) {
    int[] arr = {1,4,6,9,11,14,15,36,48};
    int result = binarySearch(arr, 0, arr.length-1, 11);
    System.out.println(result);
  }

  public static int binarySearch(int[] array,int start ,int end,int target){
    if(start> end){
      return -1;
    }
    int mid = start + (end - start) / 2;
    if (array[mid] == target) {
      return mid;
      } 
    else if (array[mid] > target) {
      return binarySearch(array, start, mid-1, target);
    }
    else {
      return binarySearch(array, mid+1, end, target);
    }
  }
}
