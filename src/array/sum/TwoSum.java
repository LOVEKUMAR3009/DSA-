package array.sum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sorting.merge.MergeSort;

public class TwoSum {
  public static void main(String[] args) {
    int[] arr = {2, 7, 11, 15,14,8};
    int target = 2;
    // boolean result = hasTwoSum(arr, target);
    boolean result2 = hasTwoSumOptimal(arr, target);
    System.out.println(result2);
    // List<int[]> result1 = twoSumIndexes(arr, target);
    // List<int[]> result1 = twoSumIndexesBetter(arr, target);
    
    // for(int[] a:result1){
    //   System.out.print(Arrays.toString(a));
    // }
  }

  /*
   * brute force approach
   * time complexity is o(n2)
   */
  public static boolean hasTwoSum(int[]arr,int target){
    int n = arr.length;
    for(int i =0;i<n;i++){
      for(int j =i+1;j<n;j++){
        if(arr[i]+arr[j]==target){
          return true;
        }
      }
    }
    return false;
  }
  public static List<int[]> twoSumIndexes(int[]arr,int target){
    int n = arr.length;
    List<int[]> indexes = new ArrayList<int[]>();
    for(int i =0;i<n;i++){
      // int [] index = new int[2];
      for(int j =i+1;j<n;j++){
        if(arr[i]+arr[j]==target){
          int [] temp = {i,j};
          indexes.add(temp);
        }
      }
    }
    return indexes;
  }


/*
 * better solution is using hashmap
 */


  public static boolean hasTwoSumBetter(int []arr,int target){
    int n = arr.length;
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    
    for(int i =0;i<n;i++){
      int complement = target - arr[i];
      if(map.containsKey(complement)){
        return true;
      }
      map.put(arr[i],i);
    }
    return false;
  }
  


  /*
   * time complexity  o(n*logn)
   * space complexity o(n)
   */
  public static List<int[]> twoSumIndexesBetter(int []arr,int target){
    int n = arr.length;
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    
    List<int[]> indexes = new ArrayList<int[]>();
    
    for(int i =0;i<n;i++){
      int complement = target - arr[i];
      if(map.containsKey(complement)){
        int[] temp = {i,map.get(complement)};
        indexes.add(temp);
      }
      map.put(arr[i],i);
    }
    return indexes;
  }





  /*
   * 
   * can i use this solution without map
   * 
   * tc = o(n) + o(nlogn)
   * sc = o(1)
   * 
   */

   public static boolean hasTwoSumOptimal(int []arr,int target){

    int n = arr.length;

    MergeSort.mergeSort(arr, 0, n-1);

    int left = 0;
    int right = n-1;
    while(left<right){
      int sum = arr[left]+arr[right];
      if(sum< target){
        left++;
      }
      else if(sum >target){
        right--;
      }
      else{
        return true;
      }

   }
   return false;
   }
}
