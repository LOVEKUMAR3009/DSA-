package array.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

 
  public static List<List<Integer>> fourSum(int[] arr, int k) {
   Arrays.sort(arr);
   int n = arr.length;
  List<List<Integer>> list = new ArrayList<>();
  Set<List<Integer>> st = new HashSet<>();
   for(int i =0;i<n-3;i++){
      if(i > 0 && arr[i] == arr[i-1]) continue;
      int target = k-arr[i];
      // System.out.println(target);
      List<List<Integer>> result = threeSum(arr,i+1,target);
      for(List<Integer> a: result){
          a.add(arr[i]);
          st.add(a);
      }
      
      
   }
   for(List<Integer> a : st){
      list.add(a);
   }
   return list;
  }

  // find triplets
  public static List<List<Integer>> threeSum(int[] arr,int start,int target) {
  Set<List<Integer>> st = new HashSet<>();
  for(int i =start;i<arr.length;i++){
    // if the element is first element than we can't check its previous on e
    if(i > start && arr[i] == arr[i-1]) continue;
    int j =i+1;
    int k = arr.length-1;
    int complement = target-(arr[i]);
    while(j<k){
      if (arr[j]+arr[k] == complement){
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[i]);
        temp.add(arr[j]);
        temp.add(arr[k]);
        st.add(temp);
        k--;
        j++;
      }
      else if(arr[j]+ arr[k] > complement){
        while(k> 0 && arr[k] == arr[k-1]){
          k--;
          continue;
        }
        k--;
      }
      else{
        while(j<arr.length-1 && arr[j] == arr[j+1]){
          j++;
          continue;
        }
        j++;
      }
    }

  }
  List<List<Integer>> ans = new ArrayList<>();
  for(List<Integer> a: st){
    ans.add(a);
  }
  return ans;
  }
}
