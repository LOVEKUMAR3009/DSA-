package array.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sorting.merge.MergeSort;

public class ThreeSum {
  public static void main(String[] args) {
    int[] arr = {-1,0,1,2,-1,-4};
    List<List<Integer>> result = threeSumBetterOptimal(arr);
    for(List<Integer> a:result){
      System.out.println(a);
    }

  }

  /*
   * brute force very brute force 
   */
  public static List<List<Integer>> threeSumBruteForce(int[] arr,int p) {
    int n =arr.length;
    int i =0;
    int j =0;
    
    Set<List<Integer>> ans = new HashSet<>();
    // List<int[]> ans = new ArrayList<>();

    while(i <n){
      while(j < n){
        if(i == j){
          j++;
          continue;
        }
        int k =0;
        while(k<n){
          if(i == k || j == k){
            k++;
            continue;
          }
          int sum = arr[i]+arr[j]+arr[k];
          if(sum == p){
            // list are mutabele thats why jvm first check in the memory if it is present or not
            List<Integer> temp  = Arrays.asList(arr[i],arr[j],arr[k]);
            Collections.sort(temp);
            ans.add(temp);
            break;        
          }
          k++;
        }
        j++;
      }
      i++;
    }

    List<List<Integer>> result = new ArrayList<>();
    for(List<Integer> a: ans){
      result.add(a);
    }
  
    return result;
  }







  /*
   * 
   */

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> st = new HashSet<>();
    int n = nums.length;
    for(int i =0;i<n;i++){
      for(int j =i+1;j<n;j++){
        for(int k =j+1;k<n;k++){
          if(nums[i]+nums[j]+nums[k]==0){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
            temp.add(nums[k]);
            Collections.sort(temp);
            st.add(temp);
            // result.add(temp);
        }
      }
    }
}
for(List<Integer> a: st){
  result.add(a);
}
return result;
  }





  public static List<List<Integer>> threeSumBetter(int[]arr){

    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> st = new HashSet<>();
    int n = arr.length;
    for(int i =0;i<n;i++){
      Set<Integer> st1 = new HashSet<>();
      for(int j =i+1;j<n;j++){
        int sum = arr[i]+arr[j];
        int complement = -sum;
        if(st.contains(complement)){
          List<Integer> temp = new ArrayList<>();
          temp.add(arr[i]);
          temp.add(arr[j]);
          temp.add(complement);
          Collections.sort(temp);
          st.add(temp);
        }
        st1.add(arr[j]);
      }
    }

    for(List<Integer> a: st){
      result.add(a);
    }
    return result;
  }



  /*
   * since we are sorting in the last to identify the whether the triplet is dupllicaate or not so why not sort the array in the first
   */

  public static List<List<Integer>> threeSumBetterOptimal(int[]arr){
    List<List<Integer>> result = new ArrayList<>();
    int n = arr.length;
    MergeSort.mergeSort(arr, 0, n-1 );
    Set<List<Integer>> st = new HashSet<>();
    // int first = Integer.MIN_VALUE;
    // int second = Integer.MIN_VALUE;
    // int third = Integer.MIN_VALUE;
    int i =0;
    while(i<n-2){
      // 
      int first = arr[i];
      int j =i+1;
      int k = n-1;
      while(j<k){
        int second = arr[j];
        int third = arr[k];
        int sum = arr[i]+arr[j]+arr[k];
        if(sum == 0){
          List<Integer> list  = new ArrayList<>();
          list.add(arr[i]);
          list.add(arr[j]);
          list.add(arr[k]);
          st.add(list);

          while(arr[j]==second){
            j++;
          }
          while(arr[k]==third){
            k--;
          }
        }
        
        else if(sum> 0){
          while(arr[k]== third){
            k--;
          }
        }
        else{
          while(arr[j]== second){
            j++;
          }
        }
        

      }
      
    i++;
    }

    for(List<Integer> a: st){
      result.add(a);
    }
    return result;
  }




  public static List<List<Integer>> threeSum3(int[] arr,int start,int end ,int target){
    
    Arrays.sort(arr);
    Set<List<Integer>> st = new HashSet<>();
    for(int i =start;i<=end;i++){
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
          while(k>start && arr[k] == arr[k-1]){
            k--;
            continue;
          }
          k--;
        }
        else{
          while(j<end-1 && arr[j] == arr[j+1]){
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
