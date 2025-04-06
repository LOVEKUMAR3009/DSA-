package binarysearch.problems;

import array.findtheelement.LargestElement;
import array.findtheelement.SumOfTheArray;

public class BookAllocation {
  public static void main(String[] args) {
    int[] books = {12, 34, 67, 90};
    int m = 2;
    int n= books.length;
    System.out.println(findMinNumberOfPagesOptimal(books,m,n));

  }
  public static int findMinNumberOfPages(int[] arr,int m ,int n){
    // since we have to find the minimum number of pages a student can get 
    // we will start boundation of max pages for a student  which will be max of the array because
    // if it won't be max then then we might not assign all the books

    if(n<m){
      return -1;
    }
    int max = LargestElement.findLargestOptimal(arr);
    int noOfStudnet = 0;
    while(true){
      noOfStudnet= findNumberofStudent(arr, max);
      if(noOfStudnet == m){
        return max;
      }
      max++;
    }
  }
  public static int findMinNumberOfPagesOptimal(int[] arr,int m ,int n){
    // since we know that when the boundation is so small the number of student would be more than m and when the the boundation is very high like the sum of the array then the number of student would be less than m 
    /*
      if n books are shared into n student then the max of the array would have been the minimum number of pages a student can get
      if the n books are distributed into one student then the min pages would have been the sum of the array  
      so the range is from max to sum of the array
     */

    if(n<m){
      return -1;
    }
    int max = LargestElement.findLargestOptimal(arr);
    int sum  = SumOfTheArray.sum(arr);
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
  public static int findNumberofStudent(int[] arr,int max){
    int student = 1;
    int pages = 0;
    for(int i = 0;i<arr.length;i++){
      if(pages+arr[i]<=max){
        pages+=arr[i];
      }
      else{
        student++;
        pages = arr[i];
      }
    }
    return student;
  }
}
