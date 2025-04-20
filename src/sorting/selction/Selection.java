package sorting.selction;

import java.util.Arrays;

public class Selection {
  public static void main(String[] args) {
    // testing the function
    int[] array = {5, 2, 8, 1, 9};
    int[] sortedArray = selection(array);
    System.out.println(Arrays.toString(sortedArray));
  }

  public static int[] selection(int[] nums){
    int n = nums.length;
    for (int i = 0; i < n-1; i++){
      //let assume starting index has smallest number
      int minIndex = i;
      for (int j = i+1;j< n;j++){
        //check for minimum index
        if(nums[j]<nums[minIndex]){
          minIndex = j;
        }
      }
      Swapping.swap(nums,i,minIndex);
    }
    return nums;
  }
}
