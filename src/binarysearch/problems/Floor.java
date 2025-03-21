package binarysearch.problems;

public class Floor {
  public static void main(String[] args) {
    int[] ar = {1,2};
    int ans = floor(ar, 2);
    System.out.println(ans);
    System.out.println(ar[ans]);
    // int result = Ceil.ceil(ar,21);
    // System.out.println(ar[result]);
  }

  public static int floor(int[]arr,int target){
    int result = arr.length;
    int start = 0;
    int end = arr.length-1;
    while(start<=end){
      int mid = start+(end-start)/2;
      if(arr[mid]<=target){
        result = mid;
        start = mid+1;
      }
      else{
        end = mid-1;
      }
    }
    return result;
  }
}
