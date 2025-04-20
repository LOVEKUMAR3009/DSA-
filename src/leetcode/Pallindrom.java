package leetcode;

import java.util.Arrays;

public class Pallindrom {
    public static void main(String[] args) {
      System.out.println(smallestPalindrome("daccad"));
    }
    public static String smallestPalindrome(String s) {
        char [] a = s.toCharArray();
        Arrays.sort(a);
        String sorted = new String(a);
        int n = sorted.length();
        boolean flag = false;
        String res = "";
        for(int i = 0;i<n;i=i+2){
          res+=sorted.charAt(i);
        }
        if(n%2==0){

          for(int i = n;n>0;i=i-2){
            res+=sorted.charAt(i);
          }
        }
        return res;
    }
}

