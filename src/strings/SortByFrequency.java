package strings;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByFrequency {
  public static void main(String[] args) {
    String str = "treeeerc";
    frequencySort(str);
  }

  public static void frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char key = s.charAt(i);
            if(map.isEmpty() || !map.containsKey(key)){
                map.put(key,1);
            }
            else{
              map.put(key,map.get(key)+1);
            }   
        }
        Map<String,Integer> map2 = new HashMap<>();
        for(Map.Entry<Character, Integer> a:map.entrySet()){
          // System.out.println(a);
          // int count = map.get(a);
          String temp = "";
          for(Map.Entry<Character, Integer> b:map.entrySet()){
            // int count2 = map.get(b);
            if(a.equals(b)){
              // System.out.println(b);
              continue;
            }
            else{
              if(a.getValue()==b.getValue()){
                temp+=b.getKey();
                map.remove(b);
              }
            }
          }
          temp+=a;
          map.remove(a);
          System.out.println(temp);
          map2.put(temp,a.getValue());
        }
        System.out.println(map2);
        
    }

    
} 
