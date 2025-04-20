package sorting.bubble;

import java.util.Arrays;

import sorting.selction.Swapping;

public class Bubble {
  public static void main(String[] args) {
    // testing
    int[] arr = { 5, 2, 8, 1, 9};
    int [] ans = bubble2(arr);
    System.out.println(Arrays.toString(ans));
  }
  public static int[] bubble(int[] arr) {
    int n = arr.length;
    for(int i = n-1;i>=1;i--){
      for(int j = 0;j<i-1;j++){
        if(arr[j]>arr[j+1]){
          Swapping.swap(arr, j, j+1);
        }
      }
    }
    return arr;
  }
  public static int[] bubble2(int[] arr) {
    int n = arr.length;
    for(int i = 0;i<n-1;i++){
      for(int j = 0;j<(n-i-1);j++){
        if(arr[j]<arr[j+1]){
          Swapping.swap(arr, j, j+1);
        }
      }
    }
    return arr;
  }







  public static int[] bubble_optimize(int[] arr) {
    int n = arr.length;
    for(int i = n-1;i>=1;i--){
      boolean swapped = false;
      for(int j = 0;j<i-1;j++){
        if(arr[j]>arr[j+1]){
          Swapping.swap(arr, j, j+1);
          swapped = true;
        }
      }
      if (!swapped){
        break;
      }
    }
    return arr;
  }
}
