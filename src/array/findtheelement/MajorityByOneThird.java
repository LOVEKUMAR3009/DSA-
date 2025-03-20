package array.findtheelement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityByOneThird {
  public static void main(String[] args) {
    int[] arr = {1,1,1,3,3,2,2,2};
    System.out.println(Arrays.toString(majorityByOneThird3(arr)));
  } 

  /*
   * brute would have pick the element and liner search aint he array and increment count if present and if it is more than n/3 than add into the result array 
   * tc =o(n2)
   */
  
  
   /*
   * store every element count in the map than iterate over map and check whose count is more than n/3
   */
  public static List<Integer> majorityByOneThird(int[]arr){

    Map<Integer,Integer> map=new HashMap<>();
    for(int i =0;i<arr.length;i++){
      if(map.containsKey(arr[i])){
        map.put(arr[i],map.get(arr[i])+1);
      }
      else{
        map.put(arr[i],1);
      }
    }
    List<Integer> list = new ArrayList<>();
    for(int key:map.keySet()){
      if(map.get(key)>arr.length/3){
        list.add(key);
      }  
    }
    return list;
  }




  public static List<Integer> majorityByOneThird2(int[]arr){
    int n= arr.length;
    Map<Integer,Integer> map=new HashMap<>();
    List<Integer> list = new ArrayList<>();
    //itereatin over the array
    for(int i =0;i<arr.length;i++){
      // check if it is present
      if(map.containsKey(arr[i])){
          map.put(arr[i],map.get(arr[i])+1);
        // check if the value count is more then the n/3
        if(map.get(arr[i])>n/3){
          list.add(arr[i]);
        }
        // if not more than 3 than increment the count
      }
      // not present than put with value 1
      else{
        map.put(arr[i],1);
      }
    }
   
    return list;
  }



  /*
   * optimal solution is 
   */
  public static int[] majorityByOneThird3(int[]arr){
    int n = arr.length;
    int count1 = 0,count2 = 0;
    int candidate1 = 0,candidate2 = 0;
    for(int i = 0;i<n;i++){
      if(count1 ==0 && arr[i]!=candidate2){
        candidate1 = arr[i];
        count1 = 1;
      }
      else if(count2 ==0 && arr[i]!=candidate1){
        candidate2 = arr[i];
        count2 = 1;
      }
      else if(arr[i] == candidate1){
        count1++;
      }
      else if(arr[i] == candidate2){
        count2++;
      }
      else{
        count1--;
        count2--;
      }
    }

    count1 =0;count2=0;
    for(int i = 0;i<n;i++){
      if(arr[i] == candidate1){
        count1++;
      }
      else if(arr[i] == candidate2){
        count2++;
      }
    }
    if(count1 > n/3 && count2 > n/3){
      return new int[]{candidate1,candidate2};
    }
    else if(count1 > n/3){
      return new int[]{candidate1};
    }
    else if(count2 > n/3){
      return new int[]{candidate2};
    }
    else{
      return new int[]{};
    }
  }
  
}
