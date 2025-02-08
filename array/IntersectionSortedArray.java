package array;

import java.util.*;

public class IntersectionSortedArray {
  public static List<Integer> intersectionSortedArray(int[]arr,int[]num){
    List<Integer> temp = new ArrayList<>();
    int i = 0;
    int j = 0;
    int k=-1;
    while(i<arr.length && j<num.length){
      if(arr[i]<num[j]){
        i++;
      }
      else if(arr[i]==num[j]){
        if(k==-1|| temp.get(k)!=arr[i]){
          k++;
          temp.add(arr[i]);
          i++;
          j++;
        }
        else{
          i++;
          j++;
        }
      }
      
      else{
        j++;
      }
    }
    return temp;
  }
  public static List<Integer> intersectionSortedArray2(int[]arr,int[]num){
    List<Integer> temp = new ArrayList<>();
    int i = 0;
    int j = 0;
    int k=-1;
    while(i<arr.length && j<num.length){
      if(arr[i]<num[j]){
        i++;
      }
      else if(arr[i]==num[j]){
        k++;
        temp.add(arr[i]);
        i++;
        j++;
      }
      
      else{
        j++;
      }
    }
    return temp;
  }
}
