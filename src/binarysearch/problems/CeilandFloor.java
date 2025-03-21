package binarysearch.problems;

import java.util.Arrays;

public class CeilandFloor {
  public static void main(String[] args) {
    int[] arr = {5, 6, 8, 9, 6, 5, 5, 6};
    int x = 7;
    int []result = floorandciel(arr, x);
    System.out.println(Arrays.toString(result));
  }

  public static int[] floorandciel(int[] arr,int target){
        
    int[] ans = {Integer.MIN_VALUE,Integer.MAX_VALUE};
    boolean isfloor = false;
    boolean isceil = false;
    for(int i =0;i<arr.length;i++){
        if(arr[i]<=target && arr[i]>ans[0]){
            ans[0] = arr[i];
            isfloor = true;
        }
        if(arr[i]>= target && arr[i]<ans[1]){
            ans[1] = arr[i];
            isceil = true;
        }
    }
    if(!isceil){
      ans[1]  = -1;
    }
    if(!isfloor){
      ans[0] =-1;
    }
    return ans;
}
}
