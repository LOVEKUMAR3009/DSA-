package strings;

import java.util.Arrays;

public class LongestcommonPrefix {
  public static void main(String[] args) {
    
  }

  public  static String longestCommonPrefix(String[] strs) {
  String ans = "";
  Arrays.sort(strs);
  String first = strs[0];
  String last = strs[strs.length-1];
  int i = 0;
  while(i<first.length() && i<last.length()){
    if(first.charAt(i)==last.charAt(i)){
      ans += first.charAt(i);
    }else{
      break;
    }
    i++;
  }
  return ans;
}

}
