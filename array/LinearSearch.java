package array;
import java.util.*;
public class LinearSearch {
  public static int linearSearchFirst(int[]arr,int k){
    for(int i= 0;i<arr.length;i++){
      if(arr[i]==k){
        return i;
      }
    }
    return -1;
  }
  public static int linearSearchLast(int[]arr,int k){
    for(int i= arr.length-1;i>=0;i--){
      if(arr[i]==k){
        return i;
      }
    }
    return -1;
  }
  public static List<Integer> linearSearchFindAll(int[]arr,int k){
    List<Integer> temp = new ArrayList();
    for(int i= 0;i<arr.length;i++){
      if(arr[i]==k){
        temp.add(i);
      }
    }
    return temp;
  }
}
