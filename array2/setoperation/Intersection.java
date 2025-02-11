package array2.setoperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Intersection {
  public static void main(String[] args) {
    int [] arr = {1,1,2,3,3,4,5};
    int[] nums = {1,3,3,5};
    List<Integer> result =  intersectionOfArray(arr, nums);
    System.out.println(result);
  }

  public static List<Integer> intersectionOfArray(int[] arr,int []nums){
    List<Integer> set = new ArrayList<>();
    int i =0;
    int j =0;
    while(i<arr.length && j<nums.length){
      if(arr[i]<nums[j]){
        i++;
      }
      else if (nums[j]<arr[i]){
        j++;
      }
      else{
        set.add(arr[i]);
        i++;
        j++;
      }
    }
    return set;
  }
}