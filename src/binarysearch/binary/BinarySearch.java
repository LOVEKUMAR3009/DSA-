package binarysearch.binary;

public class BinarySearch {


  // this search function takes an array of integers and a target value as input
  // and its only works on sorted array
  public static void main(String[] args) {
    int[] arr = {3,3,3,3,1,2,3};
    System.out.println(binarySearch(arr,1));
  }
  public static int binarySearch(int[] array, int target) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
        } 
      else if (array[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;

  }
  public static int binarySearch(int[] array, int target,int left,int right) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
        } 
      else if (array[mid] < target) {
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;

  }
}