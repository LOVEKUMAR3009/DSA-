package array.arrange;

import java.util.Arrays;

import array.rotation.LeftRoatation;
import sorting.selction.Swapping;

public class NextPermutation {
  public static void main(String[] args) {
    int [] arr = {7,6,5,4,3,0,1}; //ans = {2,3,0,0,1,4,5}
    nextPermutation(arr);
    System.out.println(Arrays.toString(arr));
  }


  /*
   * 
   * brute force 
   * generate all permutations  and the linear search and then return the next permutation
   */

   public static void nextPermutation(int[] nums) {
    //find the break point where the previous element is smaller 
    int n = nums.length;  
    int breakPoint = -1;
    for(int i =n-1;i>=1;i--){
      // if the next element is bigger then the previous one then we have a break point
      if(nums[i]> nums[i-1]){
        breakPoint = i-1;
        System.out.println(breakPoint);
        break;
      }

    }
    // if there is no breakpoint means the array was sorted in the descending order so we need to reverse the array
    if(breakPoint == -1){
      LeftRoatation.reverseArray(nums, 0, n-1);
    }

    else{
      // find the smallest element on the right side of the break point which is greater than the break point element and swap it with the brekpoint element
      for(int i =n-1;i>breakPoint;i--){
        if(nums[i]>nums[breakPoint]){
          Swapping.swap(nums, i, breakPoint);
          break;
        }
      }
      // sort the right side of the break point in ascending order or reverse it
      LeftRoatation.reverseArray(nums, breakPoint+1, n-1);
    }
  }


}
