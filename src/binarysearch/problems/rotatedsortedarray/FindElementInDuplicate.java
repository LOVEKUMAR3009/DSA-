package binarysearch.problems.rotatedsortedarray;

public class FindElementInDuplicate {
  public static void main(String[] args) {
    int[] arr = {1,0,1,1,1};
    System.out.println(findelement(arr, 0));
  }

  public static boolean findelement(int[]arr,int target){
    int left  = 0;
    int right = arr.length-1;

    while(left<=right){
      int mid = left +(right-left)/2;
      // element found
      if(arr[mid] == target){
        return true;

      }

      if(arr[mid]==arr[left] && arr[mid]==arr[right]){
        left++;
        right--;
        continue;
      }
      
      // left half is sorted
    
      if(arr[left]<=arr[mid]){
        if(arr[left]<= target && target<=arr[mid]){
          // if target is greater than mid then it must be in right half
          right = mid-1;
        }
        else{
          // if target is smaller than mid then it must be in left half
          left = mid+1;
        }
      }
      // right half is sorted
      else{
        if(arr[right]>=target && target>=arr[mid]){
          // if target is greater than mid then it must be in right half
          left = mid+1;
        }
        else{
          // if target is smaller than mid then it must be in left half
          right = mid-1;
        }
      }
    }
    return false;
  }
}
