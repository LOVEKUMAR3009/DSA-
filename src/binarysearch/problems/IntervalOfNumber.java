package binarysearch.problems;

import java.util.function.BinaryOperator;

import binarysearch.binary.BinarySearch;

// import binarysearch.binary.BinarySearch;

public class IntervalOfNumber {
  public static void main(String[] args) {
    int[] arr = {1,2,3,3,3,4,4,5,5,5,5,5,6,8,11,13,15,15,15,16};
    System.out.println(arr.length);
    int target =1;
    int[] result = findInterval2(arr, target);
    System.out.println("Interval of " + target + " is [" + result[0] +" "+ result[1] + "]");

  }

  public static int[] findInterval(int[]arr,int target){
    int start = LowerBound.lowerBound(arr, target);
    if((start == arr.length) || arr[start]!=target){
      return new int[]{-1,-1};
    }
    int end = UpperBound.upperBound(arr, target);
   return new int[]{start,end-1};

  }



  /*
   * using simple binar
   */

   public static int[] findInterval2(int [] arr ,int target){
    
    int start = findFirstOccurance(arr, target);
    int end = findLastOccurance(arr, target);
    if(start ==-1){
      return new int[]{-1,-1};
    }

    return new int[]{start ,end};
   }


   public static int findFirstOccurance(int[]arr,int target){
    int left = 0;
    int right = arr.length-1;
    int ansleft =-1;
    
    while(left<=right){
      int mid = left+(right-left)/2;
      if(arr[mid]==target){
        ansleft = mid;
        right= mid-1;
      }
      else if(arr[mid]> target) {
        right = mid-1;
      }
      else{
        left = mid+1;
      }
    }
    return ansleft;
   }


   public static int findLastOccurance(int[]arr,int target){
  
    int ansright = -1;
     int left = 0;
    int right = arr.length-1;
    while(left<=right){
      int midright = left+(right-left)/2;
      if(arr[midright]==target){
        ansright = midright;
        left = midright+1;
      }
      else if(arr[midright]>target) {
        right = midright-1;
      }
      else{
        left = midright+1;
      }


    }
    return ansright;
  }
}
