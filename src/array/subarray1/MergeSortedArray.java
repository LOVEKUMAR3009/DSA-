package array.subarray1;

import java.util.Arrays;

import sorting.merge.MergeSort;

public class MergeSortedArray {
  public static void main(String[] args) {
    int[]arr = {0,3,5,7};
    int[]brr = {1,2,4,6};
    merge(arr,brr);
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));
    

    
  }
  public static void merge(int[] arr, int[] brr) {
    int i =arr.length-1;
    int j =0;
    while(i>=0 && j< brr.length) {
      if(arr[i]>brr[j]){
        int temp = arr[i];
        arr[i] = brr[j];
        brr[j] = temp;
        i--;
        j++;
      }
      else{
        break;
      } 
    }
    MergeSort.mergeSort(arr, 0, arr.length-1);
    MergeSort.mergeSort(brr, 0, arr.length-1);

  }
}
