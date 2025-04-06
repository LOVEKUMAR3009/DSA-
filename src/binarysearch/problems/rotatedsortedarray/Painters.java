package binarysearch.problems.rotatedsortedarray;

import java.util.ArrayList;

public class Painters {

    public static int findLargestMinDistance(ArrayList<Integer> arr, int m)
    {
        //    Write your code here.
         int n = arr.size();
       if(n<m){
        return -1;
       } 
        int max = findLargestOptimal(arr);
        int sum  = sum(arr);
        int low = max;
    int high = sum;
    while(low<=high){
      int mid = low + (high-low)/2;
      int noOfStudent = findNumberofStudent(arr, mid);
      if(noOfStudent>m){
        low = mid+1;
      }else{
        high = mid-1;
      }
    }
    return low;
    }

    public static int findLargestOptimal(ArrayList<Integer> array) {
    int max = array.get(0);
    for(int i =0;i<array.size();i++){
      if(array.get(i)>max){
        max = array.get(i);
      }
    }
    return max;
    }

    public static int sum(ArrayList<Integer>arr){
    int sum = 0;
    for(int n:arr){
      sum+=n;
    }
    return sum;
  }

  public static int findNumberofStudent(ArrayList<Integer>arr,int max){
    int student = 1;
    int pages = 0;
    for(int i = 0;i<arr.size();i++){
      if(pages+arr.get(i)<=max){
        pages+=arr.get(i);
      }
      else{
        student++;
        pages = arr.get(i);
      }
    }
    return student;
    }
}

