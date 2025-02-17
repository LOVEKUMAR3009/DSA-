package array.setoperation;

import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Union {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5};
    int[] arr2 = {4, 5, 6, 7, 8};
    // List<Integer>result = unionOfArray(arr, arr2);
    List<Integer> result2 = unionOfArrayOptimal(arr, arr2);
    // System.out.println(result);
    System.out.println(result2);
  }
  // Function to perform union operation on two arrays
  /*
   * brute force sollution that is use set to remove duplicates
   * 
   * insertion in set is n1logN where n1 is size of array and n is size of set at any point
   * 
   * and o(n1+n2) to add in list 
   * 
   * so the total time complexity is o(n1logn +n2logn+n1+n2)
   */
  public static List<Integer> unionOfArray(int[]arr,int[]nums){
    Set<Integer> set = new TreeSet<Integer>();
    // adding all unique element to set from arr array
    for(int i:arr){
      if(set.isEmpty() || !set.contains(i)){
        set.add(i);
      }
    }
    //adding all items from nums array to set
    for(int i:nums){
      if(set.isEmpty() || !set.contains(i)){
        set.add(i);
      }
    }
     List<Integer> ans = new ArrayList<Integer>();
     for(int i:set){
      ans.add(i);
     }
   
    return ans;
}


/*
this function is only for sorted array  
 * 
 * optimal solution is 
 */
  public static List<Integer> unionOfArrayOptimal(int[] arr, int[] nums) {
    List<Integer> ans = new ArrayList<>();
    int i = 0, j = 0;
    while (i < arr.length && j < nums.length) {
      //if arr array element at i  is smaller than nums array element at j
        if(arr[i]<nums[j] ) {
          //check if the element is not already present in ans array
          if(!ans.contains(arr[i])){
            ans.add(arr[i]);
            i++;
          }
          // just move the pointer  in arr array
          else{
            i++;
          }
        }
        //if nums array element at j  is smaller tha element at i in arr
        else if(arr[i]> nums[j] ) {
          //check if the element is not already present in ans array
          if(!ans.contains(nums[j])){
            ans.add(nums[j]);
            j++;
          }
          // just move pointer in the nums array
          else{
            j++;
          }
          
        }
        // if both the array is equal 
        else {
          if(!ans.contains(arr[i])){
            ans.add(arr[i]);
            i++;
            j++;
          }
          else{
            i++;
            j++;
          }         
        }
    }

    // add the rest of the element of the arr array in ans 
    while(i<arr.length){

         //check if the element is not already present in ans array
          if(!ans.contains(arr[i])){
            ans.add(arr[i]);
            i++;
          }
          // just move the pointer  in arr array
          else{
            i++;
          }
    }

    // add the rest of the element of the num array
    while(j<nums.length){
      //check if the element is not already present in ans array
      if(!ans.contains(nums[j])){
        ans.add(nums[j]);
        j++;
      }
      // just move pointer in the nums array
      else{
        j++;
      }
    }
        
  return ans;
  }
}