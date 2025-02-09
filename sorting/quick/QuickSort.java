package sorting.quick;

import java.util.Arrays;

import sorting.selction.Swapping;

public class QuickSort {
  public static void main(String[] args) {
  //test
  int[] array = { 5, 2, 8, 1, 9};
  quickSort(array, 0, array.length-1);
  System.out.println(Arrays.toString(array));


  }
  public static void quickSort(int[] array,int low,int high) {
    // base case that stops the recursion because if the array has 1 or 0 elements it is already sorted
   if(low<high){
    int partitionIndex = partition(array,low,high);
    quickSort(array, low,partitionIndex-1);
    quickSort(array, partitionIndex+1,high);
   }
   
  }

  public static int partition(int[] arr,int low,int high) {

  //first element is the pivote element in the unsorted array
  int pivot = arr[low];
  int i = low;
  int j = high;
  while (i<j) {
    while(arr[i] <= pivot && i<= high){
      i++;
    }
    while(arr[j]> pivot && j>=low){
      j--;
    }
    if(i<j){
      Swapping.swap(arr, i, j);
    }
  }
  Swapping.swap(arr, low, j);
  return j;
  }
}
