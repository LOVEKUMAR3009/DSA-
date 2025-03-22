package binarysearch.problems;

public class PeakElement {
  public static void main(String[] args) {
    int[]arr = {1,2,3,  1};
    System.out.println(peak(arr));
  }

  public static int peak(int[]arr){
    int n = arr.length;
    
    if(arr.length == 1) return arr[0];
    if(arr[0]>arr[1]) return arr[0];
    if(arr[n-1]>arr[n-2]) return arr[n-1];

    int start = 1;
    int end = arr.length - 2;
    while(start<=end){
      int mid = start + (end - start) / 2;
      
      if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return arr[mid];
      if(arr[mid]<arr[mid-1]) end = mid - 1;
      else start = mid + 1;
    }
    return arr[start];
  }
}
