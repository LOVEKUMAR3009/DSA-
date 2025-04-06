package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWords {
  public static void main(String[] args) {
    String[]  strs = {""};
    // System.out.println(reverseWords("a good   example"));
    System.out.println(LongestcommonPrefix.longestCommonPrefix(strs));
  }
  public static String reverseWords(String s) {
    int n = s.length();
    
    int i = 0;
    String ans = "";
    String word = "";
    while(i<n){

      if(s.charAt(i)==' '){
        i++;
        continue;
      }
      else{
        while(i<n && s.charAt(i)!=' '){
          word += s.charAt(i);
          i++;
        }
      }
      if(ans == ""){
        ans = word;
        word = "";
      }
      else{
        ans = word + " " + ans;
        word = "";
      }
   
    }
    return ans;
  }

  

}
