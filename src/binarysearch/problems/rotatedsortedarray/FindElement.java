package binarysearch.problems.rotatedsortedarray;

public class FindElement {
  public static void main(String[] args) {
    int [] arr = {0,1,2,3,4,5,6,7,8,9};
    System.out.println(findbreakPoint(arr, 0));
  }

  //first thing the array is rotated from some palce but it has all unique element 

  /*
   * burte force to solve this problem is using linear search which will take O(n) time complexity
   * since the array is sorted so we will try to use the binary search for searching
   */

   public static int findbreakPoint(int[] nums,int target) {
    int start =0;
    int end = nums.length-1;
    int ans =-1;
    // int start = 0;
    // int end = nums.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;

      // if the the element is found 
      if(nums[mid] == target){
        ans = mid;
        return ans;
      }
      // if target is greater than mid element
      if(nums[mid] >target){
        //
        if(nums[end] > nums[mid]){
          end = mid-1;
        }
        else{
          start  = mid+1;
        }
      }
      // if target is less than mid element
      else{
        if(nums[start]< nums[mid] ){
          start = mid+1;
        }
        else{
          end= mid-1;
        }
      }
    }
    return ans;
    
  }
}
