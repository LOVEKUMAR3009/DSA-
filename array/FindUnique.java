package array;

import java.util.HashMap;
import java.util.Map;

public class FindUnique {
  public static int findUnique(int[]arr){
    Map<Integer,Integer> temp = new HashMap<>();
    for(int a:arr){
      if(!temp.containsKey(a)){
        temp.put(a,1);
      }
      else{
        temp.replace(a,temp.get(a)+1);
      }
    }
    System.out.println(temp);
    for(int b:temp.keySet()){
      if(temp.get(b)==1){
        return b;
      }
    }
    return Integer.MAX_VALUE;
  }
  public static int findUnique2(int[]arr){
    int xor =0;
    for(int a : arr){
      xor = xor^a;
    }
    return xor;
  }
  
}

