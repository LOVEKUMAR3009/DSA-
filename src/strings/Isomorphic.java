package strings;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
  public static void main(String[] args) {
    String s1 = "badc";
    String s2 = "baba";
    System.out.println(isIsomorphic2(s1, s2));
  }
  public static boolean isIsomorphic(String s1, String s2) {
    Map<Character,Character> map = new HashMap<>();
    int i = 0;
    int j = 0;
    while(i<s1.length() && j<s2.length()){
      if(map.isEmpty() || (!map.containsKey(s1.charAt(i)) && !map.containsKey(s2.charAt(j)))){
        map.put(s1.charAt(i), s2.charAt(j));
        map.put(s2.charAt(j), s1.charAt(i));
        
      }
      
      else{
        if(map.containsKey(s1.charAt(i))){
          if(map.get(s1.charAt(i))!=s2.charAt(j)){
            return false;
          }
        }
        else if(map.containsKey(s2.charAt(j))){
          if(map.get(s2.charAt(j))!=s1.charAt(i)){
            return false;
          }
        }
      }
      i++;
      j++;
    }
    return true;
  }

  public static boolean isIsomorphic2(String s1, String s2) {
    Map<Character,Character> map = new HashMap<>();
    int i = 0;
    int j = 0;
    while(i<s1.length() && j<s2.length()){
     if(map.isEmpty()){
      map.put(s1.charAt(i), s2.charAt(j));
     }
     else{
      if(map.containsKey(s1.charAt(i))){
        if(map.get(s1.charAt(i))!=s2.charAt(j)){
          return false;
        }
      }
      else{
        for(char ch: map.values()){
          if(ch ==s2.charAt(j)){
            return false;
          }
        }
        map.put(s1.charAt(i), s2.charAt(j));
      }
     }
     i++;
     j++;
    }
    return true;
}
}
