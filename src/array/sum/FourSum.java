package array.sum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
  public static void main(String[] args) {
    int[] arr = {1,0,-1,0,-2,2};
    List<List<Integer>>  ans = fourSum(arr,0);
    for(List<Integer> a: ans){
      System.out.println(a);
    }
  }

  public static List<List<Integer>> fourSum(int[] arr,int k){
    int n = arr.length;
    Arrays.sort(arr);
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    for(int i =0;i<n-3;i++){
      int target = k - arr[i];
      List<List<Integer>> lastThree= threeSum3(arr,i+1,n-1,target);
      for(List<Integer> a: lastThree){
        a.add(arr[i]);
        set.add(a);

      }
    }
    for(List<Integer> a: set){
      result.add(a);
    }
    return result;
  }
  public static List<List<Integer>> threeSum3(int[] arr,int start,int end ,int target){
    
    // Arrays.sort(arr);
    Set<List<Integer>> st = new HashSet<>();
    for(int i =start;i<arr.length;i++){
      // if the element is first element than we can't check its previous on e
      if(i > start && arr[i] == arr[i-1]) continue;
      int j =i+1;
      int k = end;
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
          while(arr[k] == arr[k-1]){
            k--;
            continue;
          }
          k--;
        }
        else{
          while(arr[j] == arr[j+1]){
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
