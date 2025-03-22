package binarysearch.problems.rotatedsortedarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMinimum {
  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));

    System.out.println(findMin(arr));
  }

  public static int findMin(int[] arr) {
    int left = 0, right = arr.length - 1;
    int mid = 0;
    while(left<=right){
       mid = left + (right - left) / 2;
      if(arr[mid]<arr[right]){
        right = mid;
      }
      else{
        left = mid + 1;
      }
    }
    // System.out.println();
    return mid;
  }
  

  public static int findMin(List<Integer> arr) {
    int left = 0, right = arr.size() - 1;
    int mid = 0;
    while(left<=right){
       mid = left + (right - left) / 2;
      if(arr.get(mid)<arr.get(right)){
        right = mid;
      }
      else{
        left = mid + 1;
      }
    }
    // System.out.println();
    return mid;
  }
}
