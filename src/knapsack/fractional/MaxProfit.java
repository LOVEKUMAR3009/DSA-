package knapsack.fractional;

import java.util.Arrays;

import sorting.merge.MergeSortForIntervals;

public class MaxProfit {
  public static void main(String[] args) {
    int[] item = {10, 20, 10, 30, 50};
    int[] cost = {40, 100, 50, 60, 200};
    int capacity = 60;
    float result = maxProfit(item, cost, capacity);
    System.out.println(result);
  }
  public static float maxProfit(int[] item, int[] cost, int capacity) {
    float[][] arr = new float[item.length][2];
    for(int i = 0; i < item.length; i++) {
      
        arr[i][0] = Math.round((float)cost[i]/(float)item[i] * 100.0f) / 100.0f;
        arr[i][1] = item[i];

    }
    MergeSortForIntervals.mergeSort(arr, 0, arr.length-1);
    // return kpfractional(arr, capacity);
    for(float[]ans:arr){
        System.out.println(Arrays.toString(ans));
    }
    return kpfractional(arr, capacity, arr.length);
  }

  public static float kpfractional(float[][]arr,float capacity,int n){
      if(capacity==0|| n==0){
        return 0;
      }
      if(capacity>=arr[n-1][1]){
        return arr[n-1][0]*arr[n-1][1]+kpfractional(arr, capacity-arr[n-1][1], n-1);
      }
      else{
        return arr[n-1][0]*(capacity);
      }
  }
}
