package sorting.countSort;

import java.util.Arrays;

import array.findtheelement.LargestElement;

public class CountSort {
  public static void main(String[] args) {
    int[] arr = {1,9,7,3,2,2,5,3,4,4};
    countSort(arr);
  }

  public static void countSort(int[]arr){
    int n = arr.length;
    int max = LargestElement.findLargestOptimal(arr);
    int[]frequency = new int[max+1];

    
    // frequency  of the number
    for(int i = 0;i<n;i++){
      frequency[arr[i]]++;
    }

    //  cumlative sum of the frequency
    for(int i =0;i<max;i++){
      frequency[i+1] = frequency[i]+frequency[i+1];
    }
    int[] ans = new int[n];

    for(int k = n-1;k>=0;k--){
      frequency[arr[k]] = frequency[arr[k]]-1;
      ans[frequency[arr[k]]] = arr[k];
    }
    System.out.println(Arrays.toString(ans));
  }
}
