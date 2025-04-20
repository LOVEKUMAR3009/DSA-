package sorting.merge;

import java.util.Arrays;

public class MergeSort {
  public static void main(String[] args) {
    int [] arr = {2,5,6,1};
    mergeSort(arr,0,arr.length-1);
    // test(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void mergeSort(int[] arr,int low ,int high){
    //base case when we have single element
    if(low == high){
      return ;
     }
    int mid = (high+low)/2;
    //left part
    mergeSort(arr,low,mid);
    //right part
    mergeSort(arr,mid+1,high);
    merge(arr,low,mid,high);
    return ;
  }






  public static void merge(int[]arr,int low,int mid,int high){
    int [] nums = new int[high-low+1];
    int temp=0;
    //
    int leftIndex =low;
    int rightIndex =mid+1;
    while(leftIndex<=mid && rightIndex<= high){
      if(arr[leftIndex]<=arr[rightIndex]){
        nums[temp]= arr[leftIndex];
        leftIndex++;
        temp++;
      }
      else{
        nums[temp] = arr[rightIndex];
        rightIndex++;
        temp++;

      }
    }
    //remaining left side array is added to the temp
    while(leftIndex<= mid){
      nums[temp]=arr[leftIndex];
      leftIndex++;
      temp++;
    }
    //remaining right side array is added to the temp
    while(rightIndex<= high){
        nums[temp] = arr[rightIndex];
        rightIndex++;
        temp++;
    }
    //adding sorted value in the original array
    for(int i =low;i<=high;i++){
      arr[i] = nums[i-low];
    }
    // return arr;
  }

  //test wheather array is pass by reference or value in java
  //array is pass by refrence
}
