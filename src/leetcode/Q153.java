package leetcode;

public class Q153 {
  public static void main(String[] args) {
    int [] arr = {1,2,4,5,6,7,0};
    System.out.println(binarySearch(arr));
  }

  public static int binarySearch(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    int mid = 0;
    while (left <= right) {
       mid = left + (right - left) / 2;
       if(arr[mid]<arr[left] && arr[mid]<arr[right]){
        return arr[mid];
       }
      if(arr[mid]>arr[left]){
        left = mid+1;
      }
      else{
        right = mid-1;
      }

  }
  return arr[mid];
  
}
}
