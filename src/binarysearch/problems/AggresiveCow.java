package binarysearch.problems;

import array.findtheelement.LargestElement;
import sorting.merge.MergeSort;

public class AggresiveCow {
  public static void main(String[] args) {
    int[] arr= {0,9,4,5 ,10,3};
    int k = 4;
    System.out.println(aggressiveCow(arr, k));
  }

  public static int aggressiveCow(int []arr, int k) {
    MergeSort.mergeSort(arr, 0, arr.length-1);
    int min =1;
    int max = arr[arr.length-1];
    int ans = 0;
    while(min<max){
      int mid = min+(max-min)/2;
      if(isPossible(arr, k, mid)){
        ans = mid;
        min = mid+1;
      }
      else{
        max = mid-1;
      }
    }
    return ans;
    
  }
  public static boolean isPossible(int []arr, int k, int distance) {
    int current = 0;
    int count = 1;
    int i = 1;
    while(count<k&& i<arr.length ){
      if(arr[i]-arr[current]>=distance){
        current = i;
        count++;
      }
      i++;
    }
    return count==k ? true : false;

  }
}
