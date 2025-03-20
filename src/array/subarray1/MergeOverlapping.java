package array.subarray1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sorting.merge.MergeSortForIntervals;

public class MergeOverlapping {
  
  public static void main(String[] args) {
    int[][] arr = {{1,3},{2,6},{8,13},{2,7},{8,15},{15,18}};
    List<List<Integer>> result = mergeoverlapping(arr);
    for(List<Integer> a:result){
      System.out.println(a);
    }
  }

  /*
   * brute force
   */
  public static List<List<Integer>> merge(int[][] intervals) {
    int max = 0;
    for(int[] interval : intervals) {
      max = Math.max(max, interval[1]);
    }
    int[] merged = new int[max+1];

    for(int[] interval:intervals){
      int i = interval[0];
      while(i<=interval[1]){
        merged[i] = 1;
        i++;
      }
    }
    // System.out.println(Arrays.toString(merged));
    List<List<Integer>> result = new ArrayList<>();
    int j =0;
    while(j<merged.length){
      int start =-1;
      int end = -1;
      if(start ==end && merged[j]==0){
        j++;
        continue;
      }
      else{
        start = j;
        while(j<merged.length && merged[j]==1){
          j++;
        }
        end = j-1;
      }
       List<Integer> a = new ArrayList<>();
        a.add(start);
        a.add(end);
      result.add(a);
    }
    
    // return result.stream().map(a -> a.stream().mapToInt(i -> i).toArray()).toArray
    // int[][] res = new int[result.size()][2];
    // return res;
    return  result;
  }



  public static List<List<Integer>> mergeoverlapping(int[][] intervals){
    List<List<Integer>> ans  = new ArrayList<>();

    MergeSortForIntervals.mergeSort(intervals,0,intervals.length-1);
    int anspointer =-1;
    for(int i =0;i<intervals.length;i++){
      List<Integer> temp = new ArrayList<>();
      if(ans.isEmpty()){
          temp.add(intervals[i][0]);
          temp.add(intervals[i][1]);
          ans.add(temp);
          anspointer++;
      }
      else if(ans.get(anspointer).get(1) >= intervals[i][0]){
        ans.get(anspointer).remove(1);
        ans.get(anspointer).add(1, intervals[i][1]);
      }
      else if (ans.get(anspointer).get(1) < intervals[i][0]){
          temp.add(intervals[i][0]);
          temp.add(intervals[i][1]);
          ans.add(temp);
          anspointer++;
      }
      else{

      }
      
    }
    return ans;
  }

}


