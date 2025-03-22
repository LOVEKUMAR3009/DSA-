package binarysearch.problems;

public class SingleElement {
  public static void main(String[] args) {
    int[] arr = { 1};
    System.out.println(findsingle(arr));
  }

  public static int findsingle(int[]arr){
    int low = 0, high = arr.length - 1;
    int mid = 0;
    while(low<=high){
       mid = low+(high-low)/2;
      if(low == mid || mid==high){
        return arr[mid];
      }
      if(mid%2== 0){
        if(arr[mid]==arr[mid+1]){
          low = mid+2;
        }
        else{
          high = mid;
        }
      }
      else{
        if(arr[mid]==arr[mid-1]){
          low = mid+1;
        }
        else{
          high = mid;
        }
      }
    }
    return arr[mid];
  }
}
