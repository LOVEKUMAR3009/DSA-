package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2570 {

  public static void main(String[] args) {
      int[][] arr1 = {{1,2},{2,3},{4,5}};
      int [][] arr2 = {{1,4},{3,2},{4,1}};
      int[][] resuList = merget2(arr1,arr2);
      for(int[] list : resuList) {
        System.out.println(Arrays.toString(list));
      }
      
  }
  public static int[][] merget(int[][]arr1,int[][]arr2){
        int n = arr1.length;
        int m = arr2.length;
        List<List<Integer>> ans= new ArrayList<>();
       int i =0;
       int j =0;
       while(i<n && j<m){
        List<Integer> tempList = new ArrayList<>();  
        if(arr1[i][0] ==arr2[j][0]){
            int temp = arr1[i][1]+ arr2[j][1];
            tempList.add(arr1[i][0]);
            tempList.add(temp);
            i++;
            j++;
        }
        else if(arr1[i][0]>arr2[j][0]){
            tempList.add(arr2[j][0]);
            tempList.add(arr2[j][1]);
            j++;
        }
        else{
          tempList.add(arr1[i][0]);
          tempList.add(arr1[i][1]);
            i++;  
        }
        ans.add(tempList);

       }

       while(i<n){
        List<Integer> temp = new ArrayList<>();
        temp.add(arr1[i][0]);
        temp.add(arr1[i][1]);
        ans.add(temp);
       }
       while(j<m){
        List<Integer> temp = new ArrayList<>();
        temp.add(arr2[j][0]);
        temp.add(arr2[j][1]);
        ans.add(temp);
       }

    int len = ans.size();
    int[][] result = new int[len][2];
    for(int k=0;k<len;k++){
        result[k][0] = ans.get(k).get(0);
        result[k][1] = ans.get(k).get(1);

    }
    return result;
    }
    public static int[][] merget2(int[][]arr1,int[][]arr2){
      int n = arr1.length;
      int m = arr2.length;
      List<int[]> ans= new ArrayList<>();
     int i =0;
     int j =0;
     while(i<n && j<m){
      // int[] temp = new int[2];
      if(arr1[i][0] ==arr2[j][0]){
          int tempsum = arr1[i][1]+ arr2[j][1];
          int[] temp = new int[2];
          temp[0] = arr1[i][0];
          temp[1] = tempsum ;
          ans.add(temp);
          i++;
          j++;
      }
      else if(arr1[i][0]>arr2[j][0]){
          ans.add(arr2[j]);
          j++;
      }
      else{
          ans.add(arr1[i]);
          i++;
      }
      

     }

     while(i<n){
      ans.add(arr1[i]);
     }
     while(j<m){
      ans.add(arr2[j]);
     }

  int len = ans.size();
  int[][] result = new int[len][2];
  for(int k=0;k<len;k++){
      result[k][0] = ans.get(k)[0];
      result[k][1] = ans.get(k)[1];

  }
  return result;
  }
}
