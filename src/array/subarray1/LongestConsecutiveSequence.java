package array.subarray1;

// import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import sorting.merge.*;;

public class LongestConsecutiveSequence {
  public static void main(String[] args) {
    int []  arr ={-2,1,-3,4,-1,2,1,-5,4};
    int longest = longestConsecutiveOptimal(arr);
    System.out.println(longest);
    // System.out.println(Arrays.toString(arr));
  }
  /*
   * brute force would be to sort the array and then tranverse the array and keeping max len in mind
   */

  public static int longestConsecutive(int[] arr){
    int n = arr.length;
    if(n == 0) return 0;
    //array sorted
    MergeSort.mergeSort(arr, 0, arr.length-1);

    int max =0;
    int count =0;
    int previous = Integer.MIN_VALUE;

    for(int i =0;i<n;i++){
      if(arr[i]-previous ==1){
        count++;
        previous = arr[i];
      }
      else if(arr[i] == previous) {
        continue;
      }
      else{
        previous = arr[i];
        max = Math.max(max, count);
        count =1;
      }
    }
    return Math.max(max, count);

  }


  public static int longestConsecutiveOptimal(int[] arr){
    Set<Integer> set = new HashSet<Integer>();
    int n =arr.length;
    //adding every unique element to the set
    for(int i =0;i<n;i++){
      set.add(arr[i]);
    }
    int count =0;
    int longest = 0;

    // iterating over the set
    for(int element : set){
      // element-1 is containing then we don't start checking for consecutive sequence
      if(set.contains(element-1)){
        continue;
      }
      // we start checking from element
      else{
        int current = element;
        count =1;
        while(set.contains(current+1)){
          current = current+1;
          count++;
        }
        longest = Math.max(longest, count);
      }
      }
      return longest;
    }
    
  }


