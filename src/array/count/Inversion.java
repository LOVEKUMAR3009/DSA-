package array.count;

import java.util.*;
public class Inversion {

  public static void main(String[] args) {
    int[] arr = {2, 4, 1, 3, 5};
    int ans =  mergeSort(arr, 0, arr.length-1);

    System.out.println(Arrays.toString(arr));
    System.out.println(ans);
    

  }
  public static int mergeSort(int[] arr,int low ,int high){
    //base case when we have single element
    int count = 0;
    if(low == high){
      return count;
     }
    int mid = (high+low)/2;
    //left part
    count+=mergeSort(arr,low,mid);
    //right part
    count+=mergeSort(arr,mid+1,high);
    count+=merge(arr,low,mid,high);
    return count ;
  }

  public static int merge(int[]arr,int low,int mid,int high){
    int count =0;
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
         count = count + (mid-leftIndex+1);
        // count = count 
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
    return count;
  }

  //test wheather array is pass by reference or value in java
  //test wheather array is pass by reference or value in java

  
}
