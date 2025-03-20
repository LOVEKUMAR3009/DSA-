package array.subarray1;

import java.util.HashMap;
import java.util.Map;

public class SubarrayXorisK {
 public static void main(String[] args) {
  int[] arr = {4,2,2,6,4};
  System.out.println(subarrayXorIsK(arr, 6));
 }
 
 /*
  * intution is simple prefix xor 
  */
 public static int subarrayXorIsK(int[] arr,int k){
  int n = arr.length;
  Map<Integer,Integer>  map = new HashMap<>();
  map.put(0,1);
  int current = 0;
  int count =0;
  for(int i =0;i<n;i++){
    current = current^arr[i];
    int complement = current^k;
    if(map.containsKey(complement)){
      count+= map.get(complement);
    }
    if(!map.containsKey(current)){
      map.put(current,1);
    }
    else{
      map.put(current,map.get(current)+1);
    }
  }
  return count;
 }
}
