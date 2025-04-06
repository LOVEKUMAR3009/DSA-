package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import array.findtheelement.LargestElement;

public class Q1636 {
  /*
   * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

    Return the sorted array.
   */
  public static void main(String[] args) {
    int[] arr = {1,1,2,2,2,3};
    frequencySort(arr);

  }

  public static void frequencySort(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for (int num : nums) {
          if(map.isEmpty() || !map.containsKey(num)){
            map.put(num,1);
          }
          else{
            map.put(num,map.get(num)+1);
          }
        }
        
        
  }
  // public static void frequencySort(int[] nums) {
  //       int max = LargestElement.findLargestOptimal(nums);
  //       int[] frequency = new int[max+1];
  // }
}
