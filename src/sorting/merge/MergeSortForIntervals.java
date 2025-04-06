package sorting.merge;

import java.util.Arrays;

public class MergeSortForIntervals {
  public static void main(String[] args) {
    int[][] arr = {{1,3},{2,6},{8,13},{9,11},{2,4},{8,15},{15,18}};
    mergeSort(arr, 0, arr.length-1);
    for(int[]a: arr) {
      System.out.println(Arrays.toString(a));
    }
  }

  public static void mergeSort(int[][]arr,int low ,int high){
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

  public static void merge(int[][]arr,int low,int mid,int high){
    int [][] nums = new int[high-low+1][2];
    int temp=0;
    //
    int leftIndex =low;
    int rightIndex =mid+1;
    while(leftIndex<=mid && rightIndex<= high){
      if(arr[leftIndex][0]<arr[rightIndex][0]){
        nums[temp]= arr[leftIndex];
        leftIndex++;
        temp++;
      }
      else if(arr[leftIndex][0]==arr[rightIndex][0]){
            if(arr[leftIndex][1] <= arr[rightIndex][1]){
              nums[temp] = arr[leftIndex];
              leftIndex++;
              temp++;
            }
            else{
              nums[temp] = arr[rightIndex];
              rightIndex++;
              temp++;
            }
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
  public static void mergeSort(float[][]arr,int low ,int high){
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

  public static void merge(float[][]arr,int low,int mid,int high){
    float [][] nums = new float[high-low+1][2];
    int temp=0;
    //
    int leftIndex =low;
    int rightIndex =mid+1;
    while(leftIndex<=mid && rightIndex<= high){
      if(arr[leftIndex][0]<arr[rightIndex][0]){
        nums[temp]= arr[leftIndex];
        leftIndex++;
        temp++;
      }
      else if(arr[leftIndex][0]==arr[rightIndex][0]){
            if(arr[leftIndex][1] <= arr[rightIndex][1]){
              nums[temp] = arr[leftIndex];
              leftIndex++;
              temp++;
            }
            else{
              nums[temp] = arr[rightIndex];
              rightIndex++;
              temp++;
            }
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

 
}
