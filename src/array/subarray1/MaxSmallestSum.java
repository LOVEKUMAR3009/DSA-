package array.subarray1;

import java.util.ArrayList;
import java.util.List;

public class MaxSmallestSum {
  public static void main(String[] args) {
    int[] arr = {4,9,3,15,1,11,4,13};
    System.out.println(maxSmallestSum2(arr));
  }
  /*
  public static int maxSmallestSum(int[] arr){
    int n = arr.length;
    int  largest =0;
    int secondLargest = -1;
    if(arr[0]> arr[1]){
      largest = 0;
      secondLargest = 1;
    }
    else{
      largest = 1;
      secondLargest =0;
    }
    int sum = arr[largest]+arr[secondLargest];
    for(int k =2;k<arr.length;k++){
      if(arr[k]<=arr[secondLargest]){
        break;
      }
      else if(arr[k]> arr[largest]){
        secondLargest = largest;
        largest = k;
      }
      else if(arr[k] > arr[secondLargest] && arr[k] < arr[largest]){
        secondLargest = k;
      }
    }
    int sum = largest+secondLargest;

    int start = Math.min(largest,secondLargest);
    int end = sum -start;
    for(int i =start;i<=end;i++){
      System.out.println(arr[i]);
    }
    return arr[secondLargest]+arr[largest];


  }
  */

  public static int maxSmallestSum2(int[]arr){
    int n = arr.length;
    int smallest = Math.min(arr[0],arr[1]);
    int secondSmallest = Math.max(arr[0],arr[1]);
    int sum = secondSmallest+smallest;
    for(int i =1;i<n-1;i++){
      if(arr[i]+arr[i+1] > sum){
        sum = arr[i]+arr[i+1];
      }
    }
    return sum;
  }

}
