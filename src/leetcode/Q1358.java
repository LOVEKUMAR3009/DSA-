package leetcode;

public class Q1358 {
    public static void main(String[] args) {
      String s = "ccabcabc";
      System.out.println(numberOfSubstrings1(s));
    }
    public static int numberOfSubstrings(String s) {
        int ans = 0;
        int previous = 0;
        for(int i =0;i<=s.length()-3;i++){
            int count = 0;
            if(i==0){
               count = findalloccurance(s,i);
              previous = count;
            }
            else{
              if(s.charAt(i) == s.charAt(i-1)){
                  count = previous;
                  // previous = count;
              }
              else{
                count = findalloccurance(s,i);
                previous = count;
              }
            }
            
            ans +=count;
        }
        return ans;
        
    }
   
   
   
   
    public static int numberOfSubstrings1(String s) {
      int ans = 0;
      int i = 0;
      int start = 0;
      while(i<=s.length()-3){
          while(i< s.length()-3 && s.charAt(i) == s.charAt(i+1)){
            i++;
          }
          int count = findalloccurance(s,i);
          int temp = (i-start-1)*count;
          ans +=temp;
          start = i+1;
          i++;
      }
      return ans;
      
  }
    public static int findalloccurance(String s,int start){
        int ans = 0;
        int i = start;
        int counta = 0;
        int countb = 0;
        int countc = 0;
        while(i<s.length()){
            char a = s.charAt(i);
            if(ans ==0){
              if(a=='a'){
                counta++;
              }
              else if(a=='b'){
                countb++;
              }
              else{
                countc++;
              }
              if(counta>=1 && countb >=1 && countc>=1){
                ans++;
              }
            }
            else{
              ans += s.length()-i;
              break;
            }
            i++;
        }
        return ans;
    }
}

