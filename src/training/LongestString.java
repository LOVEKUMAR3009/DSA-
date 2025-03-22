package training;

import java.util.HashMap;
import java.util.Map;

public class LongestString {
  public static void main(String[] args) {
    String str = " ";
    System.out.println(longestString(str));
  }

  public static int longestString(String str){

    int n = str.length();
    int max = 0;
    for(int i = 0;i<n;i++){
      int count = 0;
      Map<Character,Integer> map = new HashMap<>();
      for(int j = i;j<n;j++){
        char a = str.charAt(j);
        if(map.isEmpty() || !map.containsKey(a)){
          map.put(a,1);
          count++;
        }
        else{
          max = Math.max(max, count);
          break;
        }
      }
      max = Math.max(max, count);
    }
    return max;
  }
}
